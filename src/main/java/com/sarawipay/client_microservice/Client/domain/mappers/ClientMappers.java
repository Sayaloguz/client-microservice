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
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ClientMappers {

    Client modelToClient(ClientGenericModel clientGenericModel);

    ClientGenericModel inputToModel(ClientInputDTO clientInputDTO);

    ClientGenericModel updateToModel(ClientUpdateRequestDTO clientUpdateRequestDTO);

    ClientGenericModel clientToModel(Client client);

    ClientIdDTO modelToIdDTO(ClientGenericModel clientGenericModel);

    MerchantOutputDTO modelToMerchantDto(MerchantGenericModel merchantGenericModel);

    MerchantGenericModel merchantDtoToModel(MerchantOutputDTO merchantOutputDTO);

    @Mapping(target = "name", source = "name", qualifiedByName = "capitalizeName")
    ClientOutputDTO modelToOutput(ClientGenericModel clientGenericModel);

    @Mapping(target = "name", source = "name", qualifiedByName = "capitalizeName")
    FullClientOutputDTO modelToFullOutput(ClientGenericModel clientGenericModel);

    
    @Named("capitalizeName")
    public static String capitalizeName(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
    }
}