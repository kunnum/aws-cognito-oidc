package com.mockbank.dto.security;

import com.google.gson.Gson;
import one.util.streamex.StreamEx;
import org.springframework.util.Base64Utils;

import java.util.Base64;
import java.util.Collections;

public class Serializer {

    public static void main(String[] args) throws Exception {
        System.err.println("Serializing ..");

        AuthInfo authInfo = new AuthInfo();
        authInfo.setDetails("Meeraj Kunnumpurath");
        authInfo.setPrincipal("meeraj@gmail.com");
        authInfo.getRoles().add("AccountBalance");
        authInfo.getRoles().add("TransactionHistory");

        String json = Base64.getEncoder().encodeToString(new Gson().toJson(authInfo).getBytes("UTF-8"));
        System.err.println(json);
    }
}