package com.sarawipay.client_microservice.Client.application.port;

import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;

public interface ClientAddUseCase {
    Client addClient(ClientInputDTO clientInputDTO);
}
