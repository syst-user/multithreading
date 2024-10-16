package com.company.example3;

public class Main {

    public static void main(String[] args) {
        Worker worker1 = new Worker("Worker 1");
        Worker worker2 = new Worker("Worker 2");
        Worker worker3 = new Worker("Worker 3");
        worker1.start();
        worker2.start();
        worker3.start();
    }
}
