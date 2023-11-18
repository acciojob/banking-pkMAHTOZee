package com.driver;

public class CurrentAccount extends BankAccount {
    String tradeLicenseId; // consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
        validateBalance();
    }

    private void validateBalance() throws Exception {
        if (balance < minBalance) {
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are the same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        char[] chars = tradeLicenseId.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                // If consecutive characters are the same, rearrange the characters to create a valid license Id
                rearrangeLicenseId(chars, i);
                return;
            }
        }
    }

    // Rearrange characters of the license Id to create a valid license Id
    private void rearrangeLicenseId(char[] chars, int index) throws Exception {
        for (int i = index + 1; i < chars.length; i++) {
            if (chars[i] != chars[index]) {
                // Swap the character at index with the next non-matching character
                char temp = chars[index];
                chars[index] = chars[i];
                chars[i] = temp;

                tradeLicenseId = new String(chars);
                return;
            }
        }

        // If no valid rearrangement is possible, throw an exception
        throw new Exception("Valid License can not be generated");
    }
}

