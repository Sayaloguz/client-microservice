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


    // Convertir el nombre a minúsculas
    // Podríamos haber tratado estos datos en el servicio, y seguramente fuera más apropiado
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


}