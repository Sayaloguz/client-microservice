package com.sarawipay.client_microservice.Client.application.port;

import com.sarawipay.client_microservice.Client.application.ClientGenericModel;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;

import java.util.List;

public interface ClientGetUseCase {

    List<ClientGenericModel> getByName(String name);

    List<ClientGenericModel> getByEmail(String email);

    ClientGenericModel getById(String id);

}
