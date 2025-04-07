package com.sarawipay.client_microservice.Client.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MerchantGenericModel {

    private String id;
    private String name;
    private String address;
    private String merchantType;

}
