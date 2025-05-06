package com.sarawipay.client_microservice.Client.application;

import com.sarawipay.client_microservice.Client.MerchantClient;
import com.sarawipay.client_microservice.Client.application.port.ClientGetUseCase;
import com.sarawipay.client_microservice.Client.domain.mappers.ClientMappers;
import com.sarawipay.client_microservice.Client.infrastructure.repository.port.ClientRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class ClientGetUseCaseImpl implements ClientGetUseCase {

    private final ClientRepository clientRepository;
    private final ClientMappers clientMappers;
    private final MerchantClient merchantClient;


    @Override
    public List<ClientGenericModel> getByName(String name) {

        return clientRepository.findByName(name);

    }


    @Override
    public List<ClientGenericModel> getByEmail(String email) {

        return clientRepository.findByEmail(email);

    }


    @Override
    public ClientGenericModel getById(String id) {

        return clientRepository.findById(id);

    }

    @Override
    public MerchantGenericModel merchantExists(String idMerchant) {

        return merchantClient.getById(idMerchant);

    }

    @Override
    public List<ClientGenericModel> getAllClients() {
        return clientRepository.findAllClients();
    }

    public List<MerchantGenericModel> getMerchantsByClientId(String clientId) {
        return merchantClient.getMerchantsByClientId(clientId);
    }


}