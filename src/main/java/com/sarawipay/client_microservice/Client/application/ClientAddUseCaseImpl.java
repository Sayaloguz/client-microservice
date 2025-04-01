package com.sarawipay.client_microservice.Client.application;

import com.sarawipay.client_microservice.Client.application.port.ClientAddUseCase;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.repository.port.ClientRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@RequiredArgsConstructor

@Service
public class ClientAddUseCaseImpl implements ClientAddUseCase {

    private final ClientRepository clientRepository;

    @Override
    public Client addClient(ClientInputDTO clientInputDTO) {


        return null;
    }

    // Esto debería de ir en clientInputDTO             ?????????
    /*
    public Client entrada(ClientInputDTO clientInputDTO) {
        Client client = new Client();

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
    */
}