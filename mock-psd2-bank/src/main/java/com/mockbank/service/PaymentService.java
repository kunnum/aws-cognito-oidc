package com.mockbank.service;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @PreAuthorize("hasAuthority('MAKE_PAYMENT')")
    public String quote() {
        return "quote";
    }

    @PreAuthorize("hasAuthority('MAKE_PAYMENT')")
    public String pay() {
        return "pay";
    }

}
