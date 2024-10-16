package com.company.example2;

public class Main {

    public static void main(String[] args) {
        Thread worker1 = new Thread(new Worker(), "Worker 1");
        Thread worker2 = new Thread(new Worker(), "Worker 2");
        Thread worker3 = new Thread(new Worker(), "Worker 3");

        worker1.start();
        worker2.start();
        worker3.start();

        try {
            worker1.join();
            worker2.join();
            worker3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
