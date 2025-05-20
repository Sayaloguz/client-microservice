package com.sarawipay.client_microservice.Client.infrastructure.repository.port;

import com.sarawipay.client_microservice.Client.application.ClientGenericModel;
import com.sarawipay.client_microservice.Client.application.MerchantGenericModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository {

    ClientGenericModel create(ClientGenericModel clientGenericModel);

    ClientGenericModel findById(String id);

    List<ClientGenericModel> findByName(String name);

    List<ClientGenericModel> findByEmail(String email);

    ClientGenericModel update(ClientGenericModel clientGenericModel);

    List<ClientGenericModel> findAllClients();

    ClientGenericModel delete(String idClient);


}

// TODO: (Consejo Guille) Los tres métodos "findBy" son muy parecidos entre ellos, una posible mejora sería hacer una función genérica para los tres