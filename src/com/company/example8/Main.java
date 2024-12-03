package com.company.example8;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        int countThreads = words.length;
        ExecutorService threadPool = Executors.newFixedThreadPool(countThreads);
        Set<Future<Integer>> futureThreads = new HashSet<>();

        for (String word : words) {
            Callable<Integer> callable = new CallableExample(word);
            Future<Integer> future = threadPool.submit(callable);
            futureThreads.add(future);
        }

        int sum = 0;
        for (Future<Integer> future : futureThreads) {
            sum += future.get(); //вызов get ждет завершение потока
        }
        threadPool.shutdown();
        System.out.printf("Общая сумма: %s", sum);
    }
}
