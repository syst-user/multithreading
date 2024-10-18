package com.company.example7;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(0);
        System.out.println("Begin balance = " + account.getBalance());

        new DepositThread(account).start();
        System.out.println("Calling waitAndWithdraw...");
        account.waitAndWithdraw(10_000_000);
        System.out.println("waitAndWithdraw finished");

        System.out.println("End balance = " + account.getBalance());
    }
}
