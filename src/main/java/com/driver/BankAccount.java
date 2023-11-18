package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        // Each digit of an account number can lie between 0 and 9 (both inclusive)
        // Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        // If it is not possible, throw "Account Number can not be generated" exception

        if (digits <= 0 || sum < 0 || sum > 9 * digits) {
            throw new Exception("Account Number can not be generated");
        }

        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();

        for (int i = 0; i < digits - 1; i++) {
            int digit = random.nextInt(10);
            accountNumber.append(digit);
            sum -= digit;
        }

        if (sum < 0 || sum > 9) {
            throw new Exception("Account Number can not be generated");
        }

        accountNumber.append(sum);

        return accountNumber.toString();
    }

    public void deposit(double amount) {
        // add amount to balance
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception,
        // if the remaining amount would be less than the minimum balance
        if (balance - amount < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
    }
}
