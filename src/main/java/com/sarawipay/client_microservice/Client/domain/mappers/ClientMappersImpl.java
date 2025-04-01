package com.sarawipay.client_microservice.Client.domain.mappers;

import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;
import org.mapstruct.Mapper;

import java.util.Date;
import java.util.UUID;

@Mapper
public class ClientMappersImpl implements ClientMappers {
    // Ni caso a esto
    @Override
    public Client outputToClient(ClientInputDTO clientInputDTO) {
        return null;
    }

    @Override
    public Client inputToClient(ClientInputDTO clientInputDTO) {
        if (clientInputDTO == null) {
            return null;
        }
        // Va sin PK/SK/ETC?


        Client client = new Client();

        // Esto no sé si debiera de ser así, en este sitio concreto del código
        String id = UUID.randomUUID().toString();
        client.setId(id);
        client.setPK("client#" + id);
        client.setSK("email#");
        client.setStatus("ACTIVE");
        client.setCreateTime(String.valueOf(new Date()));
        client.setGIndex2Pk("entityClient");


        // Esto sí
        client.setCifNifNie(clientInputDTO.getCifNifNie());
        client.setName(clientInputDTO.getName());
        client.setSurname(clientInputDTO.getSurname());
        client.setEmail(clientInputDTO.getEmail());
        client.setPhone(clientInputDTO.getPhone());

        return client;
    }

    @Override
    public ClientInputDTO clientToInput(Client client) {
        return null;
    }

    // Este sirve de algo???
    @Override
    public ClientInputDTO outputToToInput(ClientOutputDTO clientOutputDTO) {
        return null;
    }

    @Override
    public ClientOutputDTO clientToOutput(Client client) {
        return null;
    }

    // Este sirve de algo???
    @Override
    public ClientOutputDTO inputToOutput(ClientInputDTO clientInputDTO) {
        return null;
    }

    /*
    @Override
    public Client dtoToClient(ClientInputDTO clientInputDTO) {
        if (clientInputDTO == null) {
            return null;
        }
        Client client = new Client();

        /*
        String id = UUID.randomUUID().toString();
        client.setId(id);
        client.setPK("client#" + id);
        client.setSK("email#");
        client.setStatus("ACTIVE");
        client.setCreateTime(String.valueOf(new Date()));


        client.setCifNifNie(clientInputDTO.getCifNifNie());
        client.setName(clientInputDTO.getName());
        client.setSurname(clientInputDTO.getSurname());
        client.setPhone(clientInputDTO.getPhone());
        client.setEmail(clientInputDTO.getEmail());
        return client;

    }

    @Override
    public ClientInputDTO clientToDTO(Client client) {

    }

    */

    /*
    public class SimpleSourceDestinationMapperImpl
  implements SimpleSourceDestinationMapper {
    @Override
    public SimpleDestination sourceToDestination(SimpleSource source) {
        if ( source == null ) {
            return null;
        }
        SimpleDestination simpleDestination = new SimpleDestination();
        simpleDestination.setName( source.getName() );
        simpleDestination.setDescription( source.getDescription() );
        return simpleDestination;
    }
    @Override
    public SimpleSource destinationToSource(SimpleDestination destination){
        if ( destination == null ) {
            return null;
        }
        SimpleSource simpleSource = new SimpleSource();
        simpleSource.setName( destination.getName() );
        simpleSource.setDescription( destination.getDescription() );
        return simpleSource;
    }
}
    * */
}