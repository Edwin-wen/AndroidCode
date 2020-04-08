package com.example.edwin.javalib.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueueTest test = new BlockingQueueTest();
        test.setQueue(new LinkedBlockingQueue<Integer>(10));
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        executor.execute(test.oneTask);
        executor.execute(test.twoTask);
    }

    private BlockingQueue<Integer> queue;
    private volatile boolean isQuit = false;

    public synchronized void setQuit(boolean quit) {
        isQuit = quit;
    }

    public void setQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    private Runnable oneTask = new Runnable() {
        @Override
        public void run() {
            try {
                while (!isQuit) {
                    int index = 0;
                    while (index < 100) {
                        Thread.sleep(1000);
                        index++;
                        queue.offer(index);
                        System.out.println(index + "==" + Thread.currentThread().toString());
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private Runnable twoTask = new Runnable() {
        @Override
        public void run() {
            try {
                while (!isQuit) {
                    Thread.sleep(1000);
                    int index = queue.take();
                    System.out.println(index + "==" + Thread.currentThread().toString());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

}
