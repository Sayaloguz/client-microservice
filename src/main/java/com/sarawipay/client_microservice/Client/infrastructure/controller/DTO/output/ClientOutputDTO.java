package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientOutputDTO {
    private String cifNifNie;
    private String name;
    private String surname;
    private String phone;
    private String email;


    // Necesitamos este setter para poder convertir el nombre a minúsculas
    public void setName(String name) {
        StringBuilder sb = new StringBuilder(name.length());
        sb.append(Character.toUpperCase(name.charAt(0)));
        sb.append(name.substring(1).toLowerCase());

        this.name = sb.toString();
    }

    public void setSurname(String surname){
        StringBuilder sb = new StringBuilder(surname.length());
        sb.append(Character.toUpperCase(surname.charAt(0)));
        sb.append(surname.substring(1).toLowerCase());

        this.surname = sb.toString();
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ClientIdDTO {

        private String id;

    }
}