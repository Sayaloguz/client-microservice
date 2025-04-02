package com.sarawipay.client_microservice.Client.domain.mappers;


import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ClientMappers {
    Client inputToClient(ClientInputDTO clientInputDTO);
    ClientOutputDTO clientToOutput(Client client);
}