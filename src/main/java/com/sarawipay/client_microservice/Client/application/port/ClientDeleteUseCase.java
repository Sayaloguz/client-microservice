package com.sarawipay.client_microservice.Client.application.port;

import com.sarawipay.client_microservice.Client.application.ClientGenericModel;

public interface ClientDeleteUseCase {

    ClientGenericModel delete(String idClient);

}