package com.example.banking.controller;

import com.example.banking.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banking")
public class BankingController {

    @Autowired
    private BankingService bankingService;

    @GetMapping("/balance/{accountId}")
    public double getBalance(@PathVariable String accountId) {
        return bankingService.getBalance(accountId);
    }

    @PostMapping("/transfer")
    public String transferFunds(@RequestParam String from, @RequestParam String to, @RequestParam double amount) {
        return bankingService.transferFunds(from, to, amount);
    }
}
