package com.sarawipay.client_microservice.Client.infrastructure.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.repository.port.ClientRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.*;

@Getter
@Setter
@RequiredArgsConstructor
@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final DynamoDBMapper dynamoDBMapper;

    @Override
    public Client create(Client client) {
        dynamoDBMapper.save(client);
        return client;
    }


    @Override
    public List<Client> findByName(String name) {
        String pkGsi = "gIndex2Pk"; // PK de GSI
        String lwrCaseName = name.toLowerCase(); // Comparación en minúsculas

        Map<String, String> expressionAttributeNames = new HashMap<>(); // Evita posibles conflictos con palabras reservadas
        expressionAttributeNames.put("#pkAttr", pkGsi);
        expressionAttributeNames.put("#nameAttr", "name");

        Map<String, AttributeValue> expressionAtributeValues = new HashMap<>();
        expressionAtributeValues.put(":pkVal", new AttributeValue().withS("entityClient")); // Solo buscamos clientes
        expressionAtributeValues.put(":name", new AttributeValue().withS(lwrCaseName));


        DynamoDBQueryExpression<Client> query = new DynamoDBQueryExpression<Client>()
                .withIndexName("gIndex2Pk")
                .withConsistentRead(false)
                .withKeyConditionExpression("#pkAttr = :pkVal")
                .withFilterExpression("contains(#nameAttr, :name)")
                // Asignación de nombres y valores
                .withExpressionAttributeNames(expressionAttributeNames)
                .withExpressionAttributeValues(expressionAtributeValues);

        List<Client> res = dynamoDBMapper.query(Client.class, query);

        return res;
    }


    // A partir de aquí son placeholders

    @Override
    public Client findById(String id) {
        return null;
    }


    @Override
    public List<Client> findByEmail(String email) {
        return Collections.emptyList();
    }

    @Override
    public Optional<Client> merchantClient(Client client) {
        return Optional.empty();
    }
}
