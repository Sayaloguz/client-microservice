package com.sarawipay.client_microservice.Client.infrastructure.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.sarawipay.client_microservice.Client.application.ClientGenericModel;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.domain.mappers.ClientMappers;
import com.sarawipay.client_microservice.Client.infrastructure.repository.port.ClientRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@RequiredArgsConstructor
@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final DynamoDBMapper dynamoDBMapper;
    private final ClientMappers clientMappers;

    @Override
    public ClientGenericModel create(ClientGenericModel model) {
        model.setName(model.getName().toLowerCase());
        Client client = clientMappers.modelToClient(model);
        dynamoDBMapper.save(client);
        return clientMappers.clientToModel(client);
    }

    @Override
    public List<ClientGenericModel> findByName(String name) {
        String lwrCaseName = name.toLowerCase();

        Map<String, String> attrNames = new HashMap<>();
        attrNames.put("#nameAttr", "name"); // Solo para 'name' por ser palabra reservada

        Map<String, AttributeValue> attrValues = new HashMap<>();
        attrValues.put(":pkVal", new AttributeValue().withS("entityClient"));
        attrValues.put(":name", new AttributeValue().withS(lwrCaseName));

        DynamoDBQueryExpression<Client> query = new DynamoDBQueryExpression<Client>()
                .withIndexName("gIndex2Pk")
                .withConsistentRead(false)
                .withKeyConditionExpression("gIndex2Pk = :pkVal")
                .withFilterExpression("contains(#nameAttr, :name)")
                .withExpressionAttributeNames(attrNames)
                .withExpressionAttributeValues(attrValues);

        List<Client> results = dynamoDBMapper.query(Client.class, query);
        return results.stream().map(clientMappers::clientToModel).collect(Collectors.toList());
    }

    @Override
    public List<ClientGenericModel> findByEmail(String email) {
        Map<String, AttributeValue> attrValues = new HashMap<>();
        attrValues.put(":pkVal", new AttributeValue().withS("entityClient"));
        attrValues.put(":email", new AttributeValue().withS(email));

        DynamoDBQueryExpression<Client> query = new DynamoDBQueryExpression<Client>()
                .withIndexName("gIndex2Pk")
                .withConsistentRead(false)
                .withKeyConditionExpression("gIndex2Pk = :pkVal")
                .withFilterExpression("email = :email")
                .withExpressionAttributeValues(attrValues);

        List<Client> results = dynamoDBMapper.query(Client.class, query);
        return results.stream().map(clientMappers::clientToModel).collect(Collectors.toList());
    }

    @Override
    public ClientGenericModel findById(String id) {
        Map<String, AttributeValue> attrValues = new HashMap<>();
        attrValues.put(":pkVal", new AttributeValue().withS("entityClient"));
        attrValues.put(":id", new AttributeValue().withS(id));

        DynamoDBQueryExpression<Client> query = new DynamoDBQueryExpression<Client>()
                .withIndexName("gIndex2Pk")
                .withConsistentRead(false)
                .withKeyConditionExpression("gIndex2Pk = :pkVal")
                .withFilterExpression("id = :id")
                .withExpressionAttributeValues(attrValues);

        List<Client> results = dynamoDBMapper.query(Client.class, query);
        return results.isEmpty() ? null : clientMappers.clientToModel(results.get(0));
    }

    @Override
    public ClientGenericModel update(ClientGenericModel generic) {
        Client existingClient = clientMappers.modelToClient(this.findById(generic.getId()));

        if (existingClient != null) {
            existingClient.setCifNifNie(generic.getCifNifNie());
            existingClient.setName(generic.getName().toLowerCase());
            existingClient.setSurname(generic.getSurname().toLowerCase());
            existingClient.setPhone(generic.getPhone());
            existingClient.setEmail(generic.getEmail());

            dynamoDBMapper.save(existingClient);
        }

        return clientMappers.clientToModel(existingClient);
    }

    @Override
    public List<ClientGenericModel> findAllClients() {
        Map<String, AttributeValue> attrValues = new HashMap<>();
        attrValues.put(":pkVal", new AttributeValue().withS("entityClient"));

        DynamoDBQueryExpression<Client> query = new DynamoDBQueryExpression<Client>()
                .withIndexName("gIndex2Pk")
                .withConsistentRead(false)
                .withKeyConditionExpression("gIndex2Pk = :pkVal")
                .withExpressionAttributeValues(attrValues);

        List<Client> results = dynamoDBMapper.query(Client.class, query);
        return results.stream().map(clientMappers::clientToModel).collect(Collectors.toList());
    }

    @Override
    public ClientGenericModel delete(String id) {
        Map<String, AttributeValue> attrValues = new HashMap<>();
        attrValues.put(":pkVal", new AttributeValue().withS("entityClient"));
        attrValues.put(":id", new AttributeValue().withS(id));

        DynamoDBQueryExpression<Client> query = new DynamoDBQueryExpression<Client>()
                .withIndexName("gIndex2Pk")
                .withConsistentRead(false)
                .withKeyConditionExpression("gIndex2Pk = :pkVal")
                .withFilterExpression("id = :id")
                .withExpressionAttributeValues(attrValues);

        List<Client> results = dynamoDBMapper.query(Client.class, query);
        if (results.isEmpty()) {
            return null;
        }

        Client client = results.get(0);
        dynamoDBMapper.delete(client);
        return clientMappers.clientToModel(client);
    }
}
