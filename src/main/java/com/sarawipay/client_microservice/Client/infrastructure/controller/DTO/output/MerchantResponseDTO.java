package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

        StringBuilder sb = new StringBuilder(name.length());
        sb.append(Character.toUpperCase(name.charAt(0)));
        sb.append(name.substring(1).toLowerCase());

        this.name = sb.toString();
    }


}
