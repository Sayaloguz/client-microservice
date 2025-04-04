package com.sarawipay.client_microservice.Client.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientModel {
    private String cifNifNie;
    private String name;
    private String surname;
    private String phone;
    private String email;
}