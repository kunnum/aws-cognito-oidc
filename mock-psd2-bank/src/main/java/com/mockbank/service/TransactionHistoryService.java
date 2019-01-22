package com.mockbank.service;

import org.springframework.stereotype.Service;

@Service
public class TransactionHistoryService {

    public String getTransactionHistory() {
        return "Transaction History";
    }
}
