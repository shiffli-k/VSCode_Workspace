package com.backtobasics.oop;

public class BankingSystemEcomm extends BankingSystem {

    public BankingSystemEcomm(int accountNumber, String userName, double balance) {
        super(accountNumber, userName, balance);

    }

    public boolean ecommDebit(double purchaseAmount) {
        super.doWithdraw(purchaseAmount);
        return false;
    }

}
