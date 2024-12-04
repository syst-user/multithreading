package com.company.example9;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource(); //общий ресурс
        ReentrantLock locker = new ReentrantLock();           //общий локер. Lock альтернатива synchronized
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(new CountThread(commonResource, locker));
            thread.setName("Thread " + i);
            thread.start();
        }
    }
}
