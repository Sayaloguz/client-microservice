package com.sarawipay.client_microservice.Client.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Client extends MainTable {

    @DynamoDBAttribute(attributeName = "cifNifNie")
    private String cifNifNie;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "surname")
    private String surname;

    @DynamoDBAttribute(attributeName = "phone")
    private String phone;

    @DynamoDBAttribute(attributeName = "email")
    private String email;


}
