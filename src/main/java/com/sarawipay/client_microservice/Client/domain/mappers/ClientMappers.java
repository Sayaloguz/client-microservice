package com.sarawipay.client_microservice.Client.domain.mappers;


import com.sarawipay.client_microservice.Client.application.ClientGenericModel;
import com.sarawipay.client_microservice.Client.application.MerchantGenericModel;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientUpdateRequestDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientIdDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.FullClientOutputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.MerchantOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

// "Normalizar" los datos aquí, no en el DTO, investigar sobre las anotaciones que hay para MapStruct
// @Mapping con target y source o expression, ver parámetros disponibles
@Mapper(componentModel = "spring")
public interface ClientMappers {

    Client modelToClient(ClientGenericModel clientGenericModel);

    ClientGenericModel inputToModel(ClientInputDTO clientInputDTO);

    ClientGenericModel updateToModel(ClientUpdateRequestDTO clientUpdateRequestDTO);

    ClientGenericModel clientToModel(Client client);

    ClientOutputDTO modelToOutput(ClientGenericModel clientGenericModel);

    FullClientOutputDTO modelToFullOutput(ClientGenericModel clientGenericModel);

    ClientIdDTO modelToIdDTO(ClientGenericModel clientGenericModel);

    MerchantOutputDTO modelToMerchantDto(MerchantGenericModel merchantGenericModel);

    MerchantGenericModel merchantDtoToModel(MerchantOutputDTO merchantOutputDTO);

}