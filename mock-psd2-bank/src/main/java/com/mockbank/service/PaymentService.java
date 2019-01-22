package com.mockbank.service;


import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String quote() {
        return "quote";
    }

    public String pay() {
        return "pay";
    }

}
