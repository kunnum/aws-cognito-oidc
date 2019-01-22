package com.mockbank.dto.security;

import com.google.gson.Gson;

import java.util.Base64;

public class Serializer {

    public static void main(String[] args) throws Exception {
        System.err.println("Serializing ..");

        AuthInfo authInfo = new AuthInfo();
        authInfo.setDetails("Meeraj Kunnumpurath");
        authInfo.setPrincipal("meeraj@gmail.com");
        authInfo.getRoles().add("ACCOUNT_BALANCE");
        authInfo.getRoles().add("TRANSACTION_HISTORY");

        String json = Base64.getEncoder().encodeToString(new Gson().toJson(authInfo).getBytes("UTF-8"));
        System.err.println(json);
    }
}
