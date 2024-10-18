package com.company.example5;

import java.util.concurrent.Semaphore;

public class DemoThread extends Thread {

    private final Semaphore semaphore;

    public DemoThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            runWork();
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted");
        }
    }

    private void runWork() throws InterruptedException {
        for (;;) {
            semaphore.acquire(); //захват симафора
            try {
                //Полезная работа
                System.out.println(getName() + " acquired semaphore");
                Thread.sleep(3000);
            } finally {
                System.out.println(getName() + " releasing semaphore");
                semaphore.release(); //освобождение симафора
            }
        }
    }
}
