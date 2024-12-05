package com.company.example10;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        int[] numbers = new int[100_000_000];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
        }

        // ---считаем обычным способом
        long sum = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Сумма элементов: " + sum);
        System.out.println("Время выполнения: " + (endTime - startTime));


        // ---считаем используя ForkJoinPool
        sum = 0;
        startTime = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool(); //количество потоков будет равно количеству ядер
        sum = pool.invoke(new SumTask(numbers, 0, numbers.length));
        endTime = System.currentTimeMillis();

        System.out.println("Сумма элементов: " + sum);
        System.out.println("Время выполнения: " + (endTime - startTime));
    }
}
