package com.mockbank.dto.security;

import com.google.gson.Gson;

import java.util.Base64;
import java.util.HashSet;

/**
 *
 */
public class Serializer {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.err.println("Serializing ..");

        AuthInfo authInfo = AuthInfo.builder().principal("meeraj@gmail.com").roles(new HashSet<>()).build();
        authInfo.getRoles().add("ACCOUNT_BALANCE");
        authInfo.getRoles().add("TRANSACTION_HISTORY");

        String json = Base64.getEncoder().encodeToString(new Gson().toJson(authInfo).getBytes("UTF-8"));
        System.err.println(json);
    }
}
