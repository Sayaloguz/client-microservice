package com.sarawipay.client_microservice.Client.infrastructure.repository.port;

import com.sarawipay.client_microservice.Client.application.ClientGenericModel;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository {

    //Client create(Client client);
    void create(ClientGenericModel clientGenericModel);
    Client findById(String id);

    List<Client> findByName(String name);

    List<Client> findByEmail(String email);

    //Client update(ClientInputDTO clientInputDTO, String pk, String sk);
    void update(ClientGenericModel clientGenericModel);

    Optional<Client> merchantClient(Client client);
}

// Nota: Los tres métodos "findBy" son muy parecidos entre ellos, una posible mejora sería hacer una función genérica para los tres