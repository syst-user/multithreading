package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Queue<Person> queue = new LinkedList<>();
        int numWindows = 3;
        Thread[] windows = new Thread[numWindows];
        for (int i = 0; i < numWindows; i++) {
            windows[i] = new Thread(new Window(queue), "Окно " + (i + 1));
            windows[i].start();
        }

        int numPerson = 100;
        for (int i = 0; i < numPerson; i++) {
            Person person = new Person("Человек " + (i + 1));
            queue.add(person);
            System.out.println("Добавлен человек " + (i + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
