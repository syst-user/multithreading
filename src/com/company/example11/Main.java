package com.company.example11;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        //Задача которая выполняется каждые 2 секунды
        Runnable task = () -> System.out.println("Выполняется задача в " + System.currentTimeMillis());
        scheduler.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        //Задача которая выполняется 1 раз
        Runnable oneTimeTask = () -> System.out.println("Одноразовая задача в " + System.currentTimeMillis());
        scheduler.schedule(oneTimeTask, 5, TimeUnit.SECONDS);

        Thread.sleep(10_000);
        scheduler.shutdown(); //завершаем планировщик
    }
}
