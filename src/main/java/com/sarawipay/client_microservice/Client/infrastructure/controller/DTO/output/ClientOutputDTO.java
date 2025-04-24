package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.utils.DataNormalization.*;
import static com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.utils.DataNormalization.normalizeEmail;


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


    public void setCifNifNie(String cifNifNie){
        this.cifNifNie = normalizeCifNifNie(cifNifNie);
    }

    public void setName(String name){
        this.name = firstLetterToUpperCase(name);
    }

    public void setSurname(String surname){
        this.surname = firstLetterToUpperCase(surname);
    }

    public void setPhone(String phone){
        this.phone = normalizePhone(phone);
    }

    public void setEmail(String email){
        this.email = normalizeEmail(email);
    }



}