package com.backtobasics.oop.interfaces;

public class subBankB implements BankingInterface {
    @Override
    public void enrollAccount() {
        System.out.println("Customer Enrolled under SubBankB");
    }

    @Override
    public void verifyAccount() {
        System.out.println("Customer Enrolled under SubBankB");
    }
}
