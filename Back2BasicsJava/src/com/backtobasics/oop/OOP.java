package com.backtobasics.oop;

import com.backtobasics.oop.BankingSystem.possibleAccountStatus;
import com.backtobasics.oop.interfaces.BankingInterface;
import com.backtobasics.oop.interfaces.subBankA;
import com.backtobasics.oop.interfaces.subBankB;

public class OOP {

    public static void main(String[] args) {
        System.out.println("\n\n");
        // basicClassesAndObjects();
        // basicInheritedClass();
        // tryInterfaces();
        tryingEnums();
    }

    static void basicClassesAndObjects() {
        BankingSystem customerOne = new BankingSystem(1001, "Customer A", 500.00);
        BankingSystem customerTwo = new BankingSystem(1002, "Customer B", 100.70);

        customerOne.doDepost(2700);
        customerTwo.doWithdraw(45);

        System.out.println(customerOne.getUserDetails());
        System.out.println(customerTwo.getUserDetails());

        System.out.println("Bank is Open");
        BankingSystem.setBankOpen(false);

        customerOne.doDepost(2700);
        customerTwo.doWithdraw(45);

        System.out.println(customerOne.getUserDetails());
        System.out.println(customerTwo.getUserDetails());
    }

    static void basicInheritedClass() {
        BankingSystemEcomm customerA = new BankingSystemEcomm(101, "John", 7999);
        BankingSystemEcomm customerB = new BankingSystemEcomm(102, "Adam", 12000);

        System.out.println(customerA.getUserDetails());
        System.out.println(customerB.getUserDetails());

        System.out.println("Bank is Open");
        BankingSystem.setBankOpen(false);

        customerA.doWithdraw(10);
        customerB.ecommDebit(500);

        System.out.println(customerA.getUserDetails());
        System.out.println(customerB.getUserDetails());

    }

    // Trying out interfaces
    static void tryInterfaces() {
        BankingInterface bankA = new subBankA();
        BankingInterface bankb = new subBankB();
        bankA.enrollAccount();
        bankb.verifyAccount();
    }

    static void tryingEnums() {
        BankingSystem accountMain = new BankingSystem(101, "BOB", 900);

        accountMain.setAccountStatus(possibleAccountStatus.active);

        if (accountMain.getAccountStatus() == possibleAccountStatus.active)
            System.out.println(accountMain.getUserDetails());
        else if (accountMain.getAccountStatus() == possibleAccountStatus.blocked)
            System.out.println("Account is blocked");
    }
}
