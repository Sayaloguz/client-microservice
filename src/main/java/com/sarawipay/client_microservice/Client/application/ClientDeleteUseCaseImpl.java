package com.sarawipay.client_microservice.Client.application;

import com.sarawipay.client_microservice.Client.application.port.ClientDeleteUseCase;
import com.sarawipay.client_microservice.Client.infrastructure.repository.port.ClientRepository;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class ClientDeleteUseCaseImpl implements ClientDeleteUseCase {

    private final ClientRepository clientRepository;


    @Override
    public ClientGenericModel delete(String idClient) {
        // Usar el método que tengo, comprobar que existe y ya se lo pasamos directamente para borrar
        return clientRepository.delete(idClient);

    }

}
