package com.mockbank.service;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class PaymentService {

    /**
     *
     * @return
     */
    @PreAuthorize("hasAuthority('MAKE_PAYMENT')")
    public String quote() {
        return "quote";
    }

    /**
     *
     * @return
     */
    @PreAuthorize("hasAuthority('MAKE_PAYMENT')")
    public String pay() {
        return "pay";
    }

}
