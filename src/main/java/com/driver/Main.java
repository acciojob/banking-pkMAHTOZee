package com.driver;

public class Main {
    public static void main(String[] args) {
        try {
            // Creating a Bank Account
            BankAccount bankAccount = new BankAccount("John Doe", 1000, 100);

            // Depositing money
            bankAccount.deposit(500);
            System.out.println("Balance after deposit: " + bankAccount.balance);

            // Withdrawing money
            bankAccount.withdraw(300);
            System.out.println("Balance after withdrawal: " + bankAccount.balance);

            // Generating an account number
            String accountNumber = bankAccount.generateAccountNumber(8, 25);
            System.out.println("Generated Account Number: " + accountNumber);

            // Creating a Current Account
            CurrentAccount currentAccount = new CurrentAccount("Alice", 6000, "TRADE123");
            System.out.println("Current Account Balance: " + currentAccount.balance);

            // Validating trade license Id
            currentAccount.validateLicenseId();
            System.out.println("Validated License Id: " + currentAccount.tradeLicenseId);

            // Creating a Savings Account
            SavingsAccount savingsAccount = new SavingsAccount("Bob", 2000, 1000, 0.02);

            // Withdrawing from savings account
            savingsAccount.withdraw(500);
            System.out.println("Savings Account Balance: " + savingsAccount.balance);

            // Calculating simple interest
            double simpleInterest = savingsAccount.getSimpleInterest(3);
            System.out.println("Simple Interest after 3 years: " + simpleInterest);

            // Calculating compound interest
            double compoundInterest = savingsAccount.getCompoundInterest(4, 2);
            System.out.println("Compound Interest after 2 years compounded quarterly: " + compoundInterest);

            // Creating a Student Account
            StudentAccount studentAccount = new StudentAccount("Eva", 300, "University XYZ");
            System.out.println("Student Account Balance: " + studentAccount.balance);

        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
