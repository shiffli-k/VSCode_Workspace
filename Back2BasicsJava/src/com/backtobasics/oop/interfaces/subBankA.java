package com.backtobasics.oop.interfaces;

public class subBankA implements BankingInterface {
    @Override
    public void enrollAccount() {
        System.out.println("Account verified under SubBankA");
    }

    @Override
    public void verifyAccount() {
        System.out.println("Account verified under SubBankA");
    }
}
