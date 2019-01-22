package com.mockbank.controller;

import com.mockbank.dto.security.AuthInfo;
import com.mockbank.service.HoldingBalanceService;
import com.mockbank.service.PaymentService;
import com.mockbank.service.TransactionHistoryService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CommonsLog
public class Psd2Controller {

    @Autowired public HoldingBalanceService holdingBalanceService;
    @Autowired public TransactionHistoryService transactionHistoryService;
    @Autowired public PaymentService paymentService;

    @RequestMapping("/psd2/accountBalance")
    public String getAccountBalance(@AuthenticationPrincipal Authentication authInfo) {
        log.info("Get account balance by: " + authInfo.getPrincipal());
        return holdingBalanceService.getHoldingBalance();
    }

    @RequestMapping("/psd2/transactionHistory")
    public String getTransactionHistory(@AuthenticationPrincipal Authentication authInfo) {
        log.info("Get transaction history by: " + authInfo.getPrincipal());
        return transactionHistoryService.getTransactionHistory();
    }

    @RequestMapping("/psd2/quote")
    public String quote(@AuthenticationPrincipal Authentication authInfo) {
        log.info("Quote by: " + authInfo.getPrincipal());
        return paymentService.quote();
    }

    @RequestMapping("/psd2/pay")
    public String pay(@AuthenticationPrincipal Authentication authInfo) {
        log.info("Pay by: " + authInfo.getPrincipal());
        return paymentService.pay();
    }

}
