package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientUpdateRequestDTO {

    private ClientInputDTO clientInputDTO;

    private String pk;

    private String sk;

}
