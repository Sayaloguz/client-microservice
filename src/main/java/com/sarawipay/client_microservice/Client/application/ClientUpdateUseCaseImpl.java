package com.sarawipay.client_microservice.Client.application;

import com.sarawipay.client_microservice.Client.application.port.ClientUpdateUseCase;
import com.sarawipay.client_microservice.Client.domain.mappers.ClientMappers;
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
    public void update(ClientGenericModel generic) {

        clientRepository.update(generic);

    }

}
