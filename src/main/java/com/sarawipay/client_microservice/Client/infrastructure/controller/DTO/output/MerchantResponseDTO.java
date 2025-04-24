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

    // Necesitamos este setter para formatear el nombre
    public void setName(String name) {

        this.name = firstLetterToUpperCase(name);
    }


}
