package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.input;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@RequiredArgsConstructor
public class ClientInputDTO {
    @NotBlank(message = "El documento de identidad es obligatorio")
    private String cifNifNie;

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "Los apellidos son obligatorios")
    private String surname;

    @Pattern(regexp = "^[0-9]{9}$", message = "Teléfono inválido")
    private String phone;

    // Esto creo que no funciona??
    // @NotBlank(message = "El email es obligatorio")
    @Pattern(
            regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
            message = "El email debe ser válido (ej: usuario@dominio.com)"
    )
    private String email;
}