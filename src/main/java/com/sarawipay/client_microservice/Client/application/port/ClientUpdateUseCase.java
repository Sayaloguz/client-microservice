package com.sarawipay.client_microservice.Client.application.port;

import com.sarawipay.client_microservice.Client.application.ClientGenericModel;

public interface ClientUpdateUseCase {

    ClientGenericModel update(ClientGenericModel generic);

}
