package com.example.edwin.javalib.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

public class ConsumerAndProducter {

    public static void main(String[] args) {
//        ConsumerAndProducter cs = new ConsumerAndProducter();
//        cs.startTask();
        Thread thread = new Thread();
        thread.setName("myThread");
        thread.start();
        thread.getName();
    }

    private volatile boolean isInterput = false;
    private volatile int index = 0;
    private Object lock = new Object();

    public void startTask() {
        Consumer consumer = new Consumer();
        Producter producter = new Producter();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        executor.execute(consumer);
        executor.execute(producter);
    }

    private class Consumer implements Runnable {

        @Override
        public void run() {
            while (!isInterput) {
                synchronized (lock) {
                    while ((index & 1) != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    index++;
                    System.out.println(index + " " + Thread.currentThread().toString());
                    lock.notify();
                }
            }
        }
    }

    private class Producter implements Runnable {

        @Override
        public void run() {
            while (!isInterput) {
                synchronized (lock) {
                    while ((index & 1) != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    index++;
                    System.out.println(index + " " + Thread.currentThread().toString());
                    lock.notify();
                }
            }
        }
    }


}
