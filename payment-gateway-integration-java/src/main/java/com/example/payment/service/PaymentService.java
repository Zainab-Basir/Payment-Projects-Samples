package com.example.payment.service;

import com.example.payment.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private List<Transaction> transactions = new ArrayList<>();

    public Transaction createTransaction(Transaction transaction) {
        transaction.setId(transactions.size() + 1);
        transaction.setStatus("APPROVED");
        transactions.add(transaction);
        return transaction;
    }

    public List<Transaction> fetchAllTransactionsFromDB() {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("list_transactions");
        Map<String, Object> result = jdbcCall.execute();
        return transactions; // simulate real DB call
    }
}
