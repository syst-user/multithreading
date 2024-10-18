package com.company.example7;

public class DepositThread extends Thread {

    private final Account account;

    public DepositThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000_000; i++) {
            account.deposit(1);
        }
    }
}
