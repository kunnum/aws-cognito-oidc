package com.mockbank.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class TransactionHistoryService {

    @PreAuthorize("hasAuthority('TRANSACTION_HISTORY')")
    public String getTransactionHistory() {
        return "Transaction History";
    }
}
