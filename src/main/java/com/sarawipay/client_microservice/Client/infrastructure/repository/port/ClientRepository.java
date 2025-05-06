package com.sarawipay.client_microservice.Client.infrastructure.repository.port;

import com.sarawipay.client_microservice.Client.application.ClientGenericModel;
import com.sarawipay.client_microservice.Client.application.MerchantGenericModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository {

    void create(ClientGenericModel clientGenericModel);

    ClientGenericModel findById(String id);

    List<ClientGenericModel> findByName(String name);

    List<ClientGenericModel> findByEmail(String email);

    void update(ClientGenericModel clientGenericModel);

    List<ClientGenericModel> findAllClients();

    void delete(String idClient);


}

// Nota: Los tres métodos "findBy" son muy parecidos entre ellos, una posible mejora sería hacer una función genérica para los tres