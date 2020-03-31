package com.example.edwin.javalib.thread;

import sun.misc.Unsafe;

public class CASTest {

    private int state = 0;

    /**
     * 这个就是reenterLock的实现原理（CAS + AQS[阻塞队列，unsafe包里的park和unpark]）
     */
    public void getData() {
        // 这里自旋去CAS这个变量，成功的话，其他线程一定是不成功的
        while (!Unsafe.getUnsafe().compareAndSwapInt(this, state, 0 ,1)) {

        }
        //doSth
        // 这里这个线程做完事情后，再CAS改回来这个值，那么其他线程就可以CAS这个值了
        Unsafe.getUnsafe().compareAndSwapInt(this, state, 1 ,0);
    }
}
