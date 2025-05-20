package com.sarawipay.client_microservice.Client.infrastructure.controller.DTO.utils;

public class DataNormalization {
    public static String normalizeCifNifNie(String cifNifNie) {
        if (cifNifNie == null || cifNifNie.isEmpty()) {
            return null;
        }
        return cifNifNie.replaceAll("[^A-Za-z0-9]", "").toUpperCase();
    }

    public static String normalizeEmail(String email) {
        if (email == null || email.isEmpty()) {
            return null;
        }
        return email.toLowerCase();
    }

    public static String normalizePhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            return null;
        }
        /*
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < phone.length(); i++) {
            result.append(phone.charAt(i));
            if ((i + 1) % 3 == 0 && i != phone.length() - 1) {
                result.append(" ");
            }
        }

        return result.toString();
        */
        return phone;
    }
    public static String firstLetterToUpperCase(String name) {
        StringBuilder sb = new StringBuilder(name.length());
        sb.append(Character.toUpperCase(name.charAt(0)));
        sb.append(name.substring(1).toLowerCase());

        return sb.toString();
    }
}
