package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientUpdateRequestDTO {
    private String pk;
    private String sk;
    private String cifNifNie;
    private String name;
    private String surname;
    private String phone;
    private String email;
}
