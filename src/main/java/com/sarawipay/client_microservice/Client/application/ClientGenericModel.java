package com.sarawipay.client_microservice.Client.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientGenericModel {
    private String pk;
    private String sk;
    private String id;
    private String status;
    private String createTime;
    private String gIndex2Pk;
    private String cifNifNie;
    private String name;
    private String surname;
    private String phone;
    private String email;
}
