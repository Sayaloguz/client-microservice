package com.sarawipay.client_microservice.Client.application;


import com.sarawipay.client_microservice.Client.application.port.ClientAddUseCase;
import com.sarawipay.client_microservice.Client.domain.mappers.ClientMappers;
import com.sarawipay.client_microservice.Client.infrastructure.repository.port.ClientRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class ClientAddUseCaseImpl implements ClientAddUseCase {

    private final ClientRepository clientRepository;
    private final ClientMappers clientMappers;

    public void addClient (ClientGenericModel model) {

        // Agregamos los atributos que nos faltan para poder crear el nuevo cliente

        String id = UUID.randomUUID().toString();
        model.setId(id);
        model.setPk("client#" + id);
        model.setSk(UUID.randomUUID().toString()); // Previamente era "document#" + el cifNifNie, pero ese atributo es sensible a cambios
        model.setStatus("ACTIVE");
        model.setCreateTime(String.valueOf(new Date()));
        model.setGIndex2Pk("entityClient");

        clientRepository.create(model);

    }

}
