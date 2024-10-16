package com.company.example1;

import java.util.Queue;
import java.util.Random;

public class Window implements Runnable {
    private Queue<Person> queue;
    private Random random = new Random();

    public Window(Queue<Person> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    Person person = queue.poll();
                    System.out.println(Thread.currentThread().getName() + " обслуживает: " + person.getName());
                }
            }
            try {
                Thread.currentThread().sleep(random.nextInt(3000) + 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
