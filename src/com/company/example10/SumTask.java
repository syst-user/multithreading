package com.company.example10;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {

    private final int[] array;
    private final int start;
    private final int end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= 10_000_000) { // Базовый случай: суммируем небольшой участок
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else { // Рекурсивный случай: делим задачу на две подзадачи
            int mid = (start + end) / 2;
            SumTask left = new SumTask(array, start, mid);
            SumTask right = new SumTask(array, mid, end);

            left.fork();  // Запускаем левую подзадачу асинхронно
            long rightSum = right.compute(); // Вычисляем правую подзадачу
            long leftSum = left.join(); // Ждем завершения левой подзадачи и получаем результат

            return leftSum + rightSum;
        }
    }
}
