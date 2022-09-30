package com.example.algorithmlib;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class QCLog {
        // //通过JDK5中的锁来保证线程的访问的互斥
        private static Lock lock = new ReentrantLock();

        private static int state = 0;// 用state来判断轮到谁执行

        private static final int RUN_NUMBER=100;//表示循环的次数

    public static void e(String s) {
       System.out.print(s);
    }


    //A线程
        static class ThreadA extends Thread {

            @Override
            public void run() {
                for (int i = 0; i < RUN_NUMBER;) {
                    lock.lock();//获取锁定
                    if (state % 3 == 0) {
                        System.out.println("第"+(i+1)+"次:");
                        System.out.println("A");
                        state++;
                        i++;
                    }
                    lock.unlock();//释放锁定,不释放锁定，会被该线程一直保持
                }
            }
        }
        //B线程
        static class ThreadB extends Thread {

            @Override
            public void run() {
                for (int i = 0; i < RUN_NUMBER;) {
                    lock.lock();
                    if (state % 3 ==1) {
                        System.out.println("B");
                        state++;
                        i++;
                    }
                    lock.unlock();
                }
            }
        }
        //C线程
        static class ThreadC extends Thread {

            @Override
            public void run() {
                for (int i = 0; i < RUN_NUMBER;) {
                    lock.lock();
                    if (state % 3 == 2) {
                        System.out.println("C");
                        state++;
                        i++;
                    }
                    lock.unlock();
                }
            }
        }
        public static void main (String[] args){
            new ThreadA().start();
            new ThreadB().start();
            new ThreadC().start();
        }

}
