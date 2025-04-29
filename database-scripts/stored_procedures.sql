-- Stored Procedure to Get Balance
CREATE OR REPLACE PROCEDURE get_balance(
    p_account_id IN VARCHAR2,
    p_balance OUT NUMBER
)
IS
BEGIN
    SELECT balance
    INTO p_balance
    FROM accounts
    WHERE account_id = p_account_id;
END;
/

-- Stored Procedure to Transfer Funds
CREATE OR REPLACE PROCEDURE transfer_funds(
    p_from_account IN VARCHAR2,
    p_to_account IN VARCHAR2,
    p_amount IN NUMBER
)
IS
BEGIN
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account;

    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account;
END;
/

-- Stored Procedure to List Transactions
CREATE OR REPLACE PROCEDURE list_transactions (
    p_cursor OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN p_cursor FOR
    SELECT transaction_id, amount, currency, status, transaction_date
    FROM transactions;
END;
/
