package com.example.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Service
public class BankingService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public double getBalance(String accountId) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("get_balance")
                .declareParameters(
                    new org.springframework.jdbc.core.SqlParameter("p_account_id", Types.VARCHAR),
                    new org.springframework.jdbc.core.SqlOutParameter("p_balance", Types.NUMERIC)
                );

        Map<String, Object> params = new HashMap<>();
        params.put("p_account_id", accountId);

        Map<String, Object> out = jdbcCall.execute(params);
        return ((BigDecimal) out.get("p_balance")).doubleValue();
    }

    public String transferFunds(String fromAccount, String toAccount, double amount) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("transfer_funds");

        Map<String, Object> params = new HashMap<>();
        params.put("p_from_account", fromAccount);
        params.put("p_to_account", toAccount);
        params.put("p_amount", amount);

        jdbcCall.execute(params);
        return "Transfer Successful";
    }
}
