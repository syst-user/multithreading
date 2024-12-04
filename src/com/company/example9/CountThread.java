package com.company.example9;

import java.util.concurrent.locks.ReentrantLock;

class CountThread implements Runnable {

    CommonResource resource;
    ReentrantLock locker;

    public CountThread(CommonResource resource, ReentrantLock locker) {
        this.resource = resource;
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock(); //Устанавливаем блокировку
        try {
            resource.x = 0;
            for (int i = 0; i < 5; i++) {
                resource.x++;
                System.out.printf("%s %d \n", Thread.currentThread().getName(), resource.x);
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock(); //Снимаем блокировку
        }
    }
}
