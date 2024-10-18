package com.company.example7;

public class Account {

    private long balance;

    public Account() {
        this(0L);
    }

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(long amount) { //либо весь метод пометить synchronized
        checkAmountNonNegative(amount);
        synchronized (this) {
            balance += amount;
            notifyAll(); //notifyAll() только внутри synchronized
        }
    }

    public void withdraw(long amount) { //либо весь метод пометить synchronized
        checkAmountNonNegative(amount);
        synchronized (this) {
            if (balance < amount) {
                throw new IllegalArgumentException("not enough money");
            }
            balance -= amount;
        }
    }

    public synchronized void waitAndWithdraw(long amount) throws InterruptedException {
        checkAmountNonNegative(amount);
        while (balance < amount) {
            wait(); //wait() только внути synchronized
        }
        balance -= amount;
    }

    private static void checkAmountNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }
}
