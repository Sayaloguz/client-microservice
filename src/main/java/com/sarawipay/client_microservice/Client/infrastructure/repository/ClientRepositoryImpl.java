package com.sarawipay.client_microservice.Client.infrastructure.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.MerchantResponseDTO;
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
    public Client findById(String id) {
        // REVISAR: Dado que el id es único, no necesitamos filtrar por el PK, pero quizás sería bueno hacerlo

        String pkGsi = "gIndex2Pk"; // PK de GSI

        Map<String, String> expressionAttributeNames = new HashMap<>();
        expressionAttributeNames.put("#pkAttr", pkGsi);
        expressionAttributeNames.put("#idAttr", "id");

        Map<String, AttributeValue> expressionAtributeValues = new HashMap<>();
        expressionAtributeValues.put(":pkVal", new AttributeValue().withS("entityClient")); // Solo buscamos clientes
        expressionAtributeValues.put(":id", new AttributeValue().withS(id));


        DynamoDBQueryExpression<Client> query = new DynamoDBQueryExpression<Client>()
                .withIndexName("gIndex2Pk")
                .withConsistentRead(false)
                .withKeyConditionExpression("#pkAttr = :pkVal")
                .withFilterExpression("#idAttr = :id")
                // Asignación de nombres y valores
                .withExpressionAttributeNames(expressionAttributeNames)
                .withExpressionAttributeValues(expressionAtributeValues);

        List<Client> res = dynamoDBMapper.query(Client.class, query);

        return res.get(0);
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


    @Override
    public List<Client> findByEmail(String email) {
        // Vamos a suponer que pueden haber varios clientes con el mismo correo

        String pkGsi = "gIndex2Pk"; // PK de GSI

        Map<String, String> expressionAttributeNames = new HashMap<>();
        expressionAttributeNames.put("#pkAttr", pkGsi);
        expressionAttributeNames.put("#emailAttr", "email");

        Map<String, AttributeValue> expressionAtributeValues = new HashMap<>();
        expressionAtributeValues.put(":pkVal", new AttributeValue().withS("entityClient")); // Solo buscamos clientes
        expressionAtributeValues.put(":email", new AttributeValue().withS(email));


        DynamoDBQueryExpression<Client> query = new DynamoDBQueryExpression<Client>()
                .withIndexName("gIndex2Pk")
                .withConsistentRead(false)
                .withKeyConditionExpression("#pkAttr = :pkVal")
                .withFilterExpression("#emailAttr = :email")
                // Asignación de nombres y valores
                .withExpressionAttributeNames(expressionAttributeNames)
                .withExpressionAttributeValues(expressionAtributeValues);

        List<Client> res = dynamoDBMapper.query(Client.class, query);

        return res;
    }


    @Override
    public Client update(ClientInputDTO clientInputDTO, String pk, String sk) {

        Client existingClient = dynamoDBMapper.load(Client.class, pk, sk);

        if (existingClient != null) {

            existingClient.setCifNifNie(clientInputDTO.getCifNifNie());
            existingClient.setName(clientInputDTO.getName());
            existingClient.setSurname(clientInputDTO.getSurname());
            existingClient.setPhone(clientInputDTO.getPhone());
            existingClient.setEmail(clientInputDTO.getEmail());

            dynamoDBMapper.save(existingClient);

        }

        return existingClient;
    }


    // A partir de aquí son placeholders

    @Override
    public MerchantResponseDTO merchantClient(String id) {

        MerchantResponseDTO response = new MerchantResponseDTO();

        return response;
    }
}
