package com.sarawipay.client_microservice.Client.application.port;

import com.sarawipay.client_microservice.Client.application.ClientGenericModel;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;

import java.util.List;

public interface ClientGetUseCase {

    //List<ClientOutputDTO> getByName(String name);
    List<ClientGenericModel> getByName(String name);

    //List<ClientOutputDTO> getByEmail(String email);
    List<ClientGenericModel> getByEmail(String email);

    //ClientOutputDTO getById(String id);
    ClientGenericModel getById(String id);

}
