package com.sarawipay.client_microservice.Client.application.port;

import com.sarawipay.client_microservice.Client.application.ClientModel;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;

public interface ClientAddUseCase {
    // Fus
    // Client addClient(ClientInputDTO client);
    ClientModel addClient(ClientModel clientModel);
}
