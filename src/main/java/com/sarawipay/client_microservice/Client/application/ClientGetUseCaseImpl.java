package com.sarawipay.client_microservice.Client.application;

import com.sarawipay.client_microservice.Client.application.port.ClientGetUseCase;
import com.sarawipay.client_microservice.Client.domain.Client;
import com.sarawipay.client_microservice.Client.domain.mappers.ClientMappers;
import com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output.ClientOutputDTO;
import com.sarawipay.client_microservice.Client.infrastructure.repository.port.ClientRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class ClientGetUseCaseImpl implements ClientGetUseCase {

    private final ClientRepository clientRepository;
    private final ClientMappers clientMappers;

    @Override
    public List<ClientOutputDTO> getByName(String name) {

        List<Client> res = clientRepository.findByName(name);

        // Transformación a DTO
        List<ClientOutputDTO> clientOutputDTOList = res.stream()
                .map(clientMappers::clientToOutput)
                .collect(Collectors.toList());

        return clientOutputDTOList;
    }
}
