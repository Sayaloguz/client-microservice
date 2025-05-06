package com.sarawipay.client_microservice.Client.application.port;

import com.sarawipay.client_microservice.Client.application.ClientGenericModel;
import com.sarawipay.client_microservice.Client.application.MerchantGenericModel;


import java.util.List;

public interface ClientGetUseCase {

    List<ClientGenericModel> getByName(String name);

    List<ClientGenericModel> getByEmail(String email);

    ClientGenericModel getById(String id);

    MerchantGenericModel merchantExists(String idMerchant);

    List<ClientGenericModel> getAllClients();

    List<MerchantGenericModel> getMerchantsByClientId(String clientId);

}
