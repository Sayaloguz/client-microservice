package com.sarawipay.client_microservice.Client.domain.mappers;

import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;

public interface ClientMappers {
    Client outputToClient(ClientInputDTO clientInputDTO);
    Client inputToClient(ClientInputDTO clientInputDTO);

    ClientInputDTO clientToInput(Client client);
    ClientInputDTO outputToToInput(ClientOutputDTO clientOutputDTO);

    ClientOutputDTO clientToOutput(Client client);
    ClientOutputDTO inputToOutput(ClientInputDTO clientInputDTO);

}
