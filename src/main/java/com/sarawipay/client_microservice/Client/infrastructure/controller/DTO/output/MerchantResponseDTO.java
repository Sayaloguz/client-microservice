package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.utils.DataNormalization.firstLetterToUpperCase;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantResponseDTO {

    private String name;

    private String address;

    private String merchantType;

    // TODO: (Consejo César) Crear un atributo de Merchant para tener el nombre para búsqueda (todo minúsculas) y el nombre para mostrar
    // TODO: Hacer esto en los mapper en caso de no crear un segundo atributo
    public void setName(String name) {
        this.name = firstLetterToUpperCase(name);
    }


}
