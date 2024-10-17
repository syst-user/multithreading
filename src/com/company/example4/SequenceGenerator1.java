package com.company.example4;

import java.util.ArrayList;
import java.util.List;

public class SequenceGenerator1 {

    private static int counter = 0;

    public static synchronized int nextInt() { //пример с synchronized
        return counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100_000; j++) {
                    nextInt();
                }
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Result: " + counter);
    }
}
