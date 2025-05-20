package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientUpdateRequestDTO {

    @NotBlank
    private String id;

    @NotBlank
    private String cifNifNie;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @Pattern(regexp = "^[0-9]{9}$", message = "Teléfono inválido")
    private String phone;

    @Pattern(
            regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
            message = "El email es obligatorio y debe ser válido (ej: usuario@dominio.com)"
    )
    private String email;

}
