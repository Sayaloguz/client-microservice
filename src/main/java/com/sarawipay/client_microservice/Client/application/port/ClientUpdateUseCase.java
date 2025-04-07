package com.sarawipay.client_microservice.Client.application.port;

import com.sarawipay.client_microservice.Client.application.ClientGenericModel;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;

public interface ClientUpdateUseCase {

    //ClientOutputDTO update(ClientInputDTO clientInputDTO, String pk, String sk);
    void update(ClientGenericModel generic);

}
