package com.sarawipay.client_microservice.Client.application;

import com.sarawipay.client_microservice.Client.application.port.ClientUpdateUseCase;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.domain.mappers.ClientMappers;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input.ClientInputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.repository.port.ClientRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class ClientUpdateUseCaseImpl implements ClientUpdateUseCase {

    private final ClientRepository clientRepository;
    private final ClientMappers clientMappers;

    @Override
    public ClientOutputDTO update(ClientInputDTO clientInputDTO, String pk, String sk) {


        Client client = clientRepository.update(clientInputDTO, pk, sk);
        ClientOutputDTO clientOutputDTO = clientMappers.clientToOutput(client);

        return clientOutputDTO;
    }
}
