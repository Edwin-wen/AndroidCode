package com.example.edwin.javalib.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) {
        LockTest test = new LockTest();
        Thread oneThread = new Thread(test.oneTask, "线程1");
        oneThread.start();
        Thread twoThread = new Thread(test.twoTask, "线程2");
        twoThread.start();
        Thread threeThread = new Thread(test.threeTask, "线程3");
        threeThread.start();
    }

    private volatile boolean isQuit = false;
    // 这里可以测试出公平锁和非公平锁的区别
    private ReentrantLock mShareLock = new ReentrantLock(true);

    private Runnable oneTask = new Runnable() {
        @Override
        public void run() {
            try {
                while (!isQuit) {
                    Thread.sleep(3000);
                    mShareLock.lock();
                    System.out.println(Thread.currentThread().getName() + "拿到锁啦");
                    mShareLock.unlock();
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
                    Thread.sleep(100);
                    mShareLock.lock();
                    System.out.println(Thread.currentThread().getName() + "拿到锁啦==");
                    //睡个5秒，确保其他线程都进入阻塞了，就死进入阻塞队列排队了
                    // 如果是非公平锁，下次进来是看谁快调用lock的，如果是公平锁，是看队列头部是谁
                    Thread.sleep(5000);
                    mShareLock.unlock();

                    mShareLock.lock();
                    System.out.println(Thread.currentThread().getName() + "又拿到锁啦啊啊啊啊==");
                    Thread.sleep(2000);
                    mShareLock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };


    private Runnable threeTask = new Runnable() {
        @Override
        public void run() {
            try {
                while (!isQuit) {
                    Thread.sleep(1000);
                    mShareLock.lock();
                    System.out.println(Thread.currentThread().getName() + "拿到锁啦==");
                    mShareLock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}
