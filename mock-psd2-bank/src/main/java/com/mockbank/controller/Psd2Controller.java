package com.mockbank.controller;

import com.mockbank.service.HoldingBalanceService;
import com.mockbank.service.PaymentService;
import com.mockbank.service.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Psd2Controller {

    @Autowired public HoldingBalanceService holdingBalanceService;
    @Autowired public TransactionHistoryService transactionHistoryService;
    @Autowired public PaymentService paymentService;

    @RequestMapping("/psd2/accountBalance")
    public String getAccountBalance() {
        return holdingBalanceService.getHoldingBalance();
    }

    @RequestMapping("/psd2/transactionHistory")
    public String getTransactionHistory() {
        return transactionHistoryService.getTransactionHistory();
    }

    @RequestMapping("/psd2/quote")
    public String quote() {
        return paymentService.quote();
    }

    @RequestMapping("/psd2/pay")
    public String pay() {
        return paymentService.pay();
    }

}

/**
 curl http://localhost:8080/psd2/accountBalance \
 -H 'X-Endpoint-API-UserInfo: eyJwcmluY2lwYWwiOiJtZWVyYWpAZ21haWwuY29tIiwiZGV0YWlscyI6Ik1lZXJhaiBLdW5udW1wdXJhdGgiLCJyb2xlcyI6WyJBY2NvdW50QmFsYW5jZSIsIlRyYW5zYWN0aW9uSGlzdG9yeSJdfQ=='

 curl http://localhost:8080/psd2/transactionHistory \
 -H 'X-Endpoint-API-UserInfo: eyJwcmluY2lwYWwiOiJtZWVyYWpAZ21haWwuY29tIiwiZGV0YWlscyI6Ik1lZXJhaiBLdW5udW1wdXJhdGgiLCJyb2xlcyI6WyJBY2NvdW50QmFsYW5jZSIsIlRyYW5zYWN0aW9uSGlzdG9yeSJdfQ=='

 curl http://localhost:8080/psd2/quote \
 -H 'X-Endpoint-API-UserInfo: eyJwcmluY2lwYWwiOiJtZWVyYWpAZ21haWwuY29tIiwiZGV0YWlscyI6Ik1lZXJhaiBLdW5udW1wdXJhdGgiLCJyb2xlcyI6WyJBY2NvdW50QmFsYW5jZSIsIlRyYW5zYWN0aW9uSGlzdG9yeSJdfQ=='

 curl http://localhost:8080/psd2/pay \
 -H 'X-Endpoint-API-UserInfo: eyJwcmluY2lwYWwiOiJtZWVyYWpAZ21haWwuY29tIiwiZGV0YWlscyI6Ik1lZXJhaiBLdW5udW1wdXJhdGgiLCJyb2xlcyI6WyJBY2NvdW50QmFsYW5jZSIsIlRyYW5zYWN0aW9uSGlzdG9yeSJdfQ=='
 *
 */
