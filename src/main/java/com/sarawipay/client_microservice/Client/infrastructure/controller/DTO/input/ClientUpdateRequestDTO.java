package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientUpdateRequestDTO {
    private ClientInputDTO clientInputDTO;
    private String pk;
    private String sk;
}
