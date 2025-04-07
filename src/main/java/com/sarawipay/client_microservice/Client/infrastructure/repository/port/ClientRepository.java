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

    void create(ClientGenericModel clientGenericModel);

    ClientGenericModel findById(String id);

    List<ClientGenericModel> findByName(String name);

    List<ClientGenericModel> findByEmail(String email);

    void update(ClientGenericModel clientGenericModel);

}

// Nota: Los tres métodos "findBy" son muy parecidos entre ellos, una posible mejora sería hacer una función genérica para los tres