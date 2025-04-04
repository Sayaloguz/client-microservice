package com.sarawipay.client_microservice.Client.domain.mappers;


import com.sarawipay.client_microservice.Client.application.ClientModel;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClientMappers {
    ClientModel inputToModel(ClientInputDTO clientInputDTO);
    ClientOutputDTO modelToOutput(ClientModel clientModel);

    ClientModel clientToModel(Client client);
    Client modelToClient(ClientModel clientModel);

    // Esto no lo vamos a usar nunca porque siempre va a pasar por el servicio, que recibirá y devolverá los modelos genéricos
    Client inputToClient(ClientInputDTO clientInputDTO);
    ClientOutputDTO clientToOutput(Client client);
}