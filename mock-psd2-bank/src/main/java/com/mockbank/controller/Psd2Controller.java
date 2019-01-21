package com.mockbank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Psd2Controller {

    @RequestMapping("/psd2/accountBalance")
    public String getAccountBalance() {
        return "Account Balance";
    }

    @RequestMapping("/psd2/transactionHistory")
    public String getTransactionHistory() {
        return "Transaction History";
    }

    @RequestMapping("/psd2/quote")
    public String quote() {
        return "Quote";
    }

    @RequestMapping("/psd2/pay")
    public String pay() {
        return "Pay";
    }

}
