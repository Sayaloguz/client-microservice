package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FullClientOutputDTO {

    private String id;
    private String status;
    private String createTime;
    private String cifNifNie;
    private String name;
    private String surname;
    private String phone;
    private String email;

}
