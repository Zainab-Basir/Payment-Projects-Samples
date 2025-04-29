package com.example.payment.controller;

import com.example.payment.model.Transaction;
import com.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/pay")
    public Transaction makePayment(@RequestBody Transaction transaction) {
        return paymentService.createTransaction(transaction);
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return paymentService.fetchAllTransactionsFromDB();
    }
}
