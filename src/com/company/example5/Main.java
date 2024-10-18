package com.company.example5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Semaphore управляем количеством запущенных потоков (пулл потоков)
        //Количество потоков которые могут захватить симафор
        Semaphore semaphore = new Semaphore(2, true);

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoThread thread = new DemoThread(semaphore);
            threads.add(thread);
            thread.start();
        }

        Thread.sleep(20_000);
        System.out.println("finished");

        for (Thread thread : threads) {
            thread.interrupt(); //прервать поток
        }
    }
}
