package com.sarawipay.client_microservice.Client.infrastructure.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
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

    // Esto debería de recibir DTO y no Client ??????
    @Override
    public Client create(Client client) {
        dynamoDBMapper.save(client);
        return client;
    }

    // Controller (EPs con DTO) <-> Servicio  <-> Repositorio con llamadas "puras a la DB"



    // A partir de aquí son placeholders
    @Override
    public Client findById(String id) {
        return null;
    }

    @Override
    public List<Client> findByName(String name) {
        return Collections.emptyList();
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
