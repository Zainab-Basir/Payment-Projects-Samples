# ✅ UAT Test Cases

| Test Case ID | Description                                 | Steps to Execute                                           | Expected Result                          |
|--------------|---------------------------------------------|------------------------------------------------------------|------------------------------------------|
| TC-PAY-001   | Verify payment creation                     | Send POST to /api/payments/pay with JSON payload           | Returns 201 and transaction with status APPROVED |
| TC-PAY-002   | Retrieve all transactions                   | Send GET to /api/payments/transactions                     | Returns list of transactions             |
| TC-BANK-001  | Check account balance                       | Send GET to /api/banking/balance/{accountId}               | Returns account balance as double        |
| TC-BANK-002  | Transfer funds between accounts             | Send POST to /api/banking/transfer with params             | Returns success message after update     |
