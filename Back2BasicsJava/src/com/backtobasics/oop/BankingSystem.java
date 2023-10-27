package com.backtobasics.oop;

public class BankingSystem {
    public enum possibleAccountStatus {
        active, dormant, blocked
    }

    private int accountNumber = 0;
    private String userName = "N/A";
    private double balance = 0.00;
    private static boolean isBankClosed = true;
    private possibleAccountStatus accountStatus = possibleAccountStatus.blocked;

    public BankingSystem(int accountNumber, String userName, double balance) {
        this.accountNumber = accountNumber;
        this.userName = userName.toUpperCase();
        this.balance = balance;
    }

    public String getUserDetails() {
        return String.format("Account User: %s of Account Number: %d - Has Balance of %.2f", userName,
                accountNumber, balance);
    }

    public double getAccountBalance() {
        return this.balance;
    }

    public boolean doWithdraw(double withdrawAmount) {
        if (isBankClosed) {
            System.out.println("Bank is Closed");
            return false;
        }
        if (withdrawAmount <= this.balance) {
            this.balance -= withdrawAmount;
            return true;
        } else {
            return false;
        }
    }

    public boolean doDepost(double depositAmount) {
        if (isBankClosed) {
            System.out.println("Bank is Closed");
            return false;
        }
        this.balance += depositAmount;
        return true;
    }

    public static boolean isBankClosed() {
        return isBankClosed;
    }

    public static void setBankOpen(boolean isBankClosed) {
        BankingSystem.isBankClosed = isBankClosed;
    }

    public possibleAccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(possibleAccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

}
