package com.mockbank.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class HoldingBalanceService {

    /**
     *
     * @return
     */
    @PreAuthorize("hasAuthority('ACCOUNT_BALANCE')")
    public String getHoldingBalance() {
        return "Account Balance";
    }
}
