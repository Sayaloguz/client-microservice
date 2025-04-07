package com.sarawipay.client_microservice.Client.application.port;

import com.sarawipay.client_microservice.Client.application.ClientGenericModel;

public interface ClientAddUseCase {
    //Client addClient(ClientInputDTO client);
    ClientGenericModel addClient(ClientGenericModel model);
}
