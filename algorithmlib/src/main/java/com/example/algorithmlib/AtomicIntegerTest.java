package com.example.algorithmlib;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    private static final int THREADS_CONUT = 20;
    public static AtomicInteger count = new AtomicInteger(0);

    public static void increase() {
        count.incrementAndGet();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
            System.out.println("threads[i]=="+threads[i].getName());
        }

        while (Thread.activeCount() > 1) {

            System.out.println("count=="+Thread.activeCount());
            Thread.yield();
        }
        System.out.println(count);
    }
}