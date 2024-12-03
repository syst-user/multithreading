package com.company.example8;

import java.util.concurrent.Callable;

public class CallableExample implements Callable {

    private String word;

    public CallableExample(String word) {
        this.word = word;
    }

    @Override
    public Integer call() {
        System.out.println(Thread.currentThread().getName() + ": " + word + " : " + word.length());
        return Integer.valueOf(word.length());
    }
}
