package com.sarawipay.client_microservice.Client.domain.mappers;


import com.sarawipay.client_microservice.Client.application.ClientGenericModel;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientIdDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientUpdateRequestDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.FullClientOutputDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClientMappers {

    Client inputToClient(ClientInputDTO clientInputDTO);

    ClientOutputDTO clientToOutput(Client client);

    Client modelToClient(ClientGenericModel clientGenericModel);

    ClientGenericModel inputToModel(ClientInputDTO clientInputDTO);

    ClientGenericModel updateToModel(ClientUpdateRequestDTO clientUpdateRequestDTO);

    ClientGenericModel clientToModel(Client client);

    ClientOutputDTO modelToOutput(ClientGenericModel clientGenericModel);

    FullClientOutputDTO modelToFullOutput(ClientGenericModel clientGenericModel);

    ClientIdDTO modelToIdDTO(ClientGenericModel clientGenericModel);
}