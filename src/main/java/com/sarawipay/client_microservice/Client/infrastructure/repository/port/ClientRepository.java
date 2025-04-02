package com.sarawipay.client_microservice.Client.infrastructure.repository.port;

import com.sarawipay.client_microservice.Client.domain.Client;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository {

    Client create(Client client);

    Client findById(String id);

    List<Client> findByName(String name);

    List<Client> findByEmail(String email);

    Optional<Client> merchantClient(Client client);
}