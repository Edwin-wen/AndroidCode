package com.example.edwin.javalib.design_pattern.singleton;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.ReentrantLock;

public class SingleTon {

    private int i = 2;

    private SingleTon() {

    }

    /**
     * 1.饿汉式，利用类初始化，jvm的线程锁机制，保证线程安全
     */
    private static volatile SingleTon sInstance = new SingleTon();

    public static SingleTon getInstance() {
        return sInstance;
    }

    /**
     * 2.饱汉式，用到时加大锁加载
     */
    private static volatile SingleTon sInstance2 = null;

    public static synchronized SingleTon getInstance2() {
        ReentrantLock
        if (sInstance2 == null) {
            sInstance2 = new SingleTon();
        }
        return sInstance2;
    }

    /**
     * DCL，双重校验锁单例
     */

    private static volatile SingleTon sInstance3 = null;
    public static SingleTon getInstance3() {
        if (sInstance3 == null) {
            synchronized (SingleTon.class) {
                sInstance3 = new SingleTon();
            }
        }
        return sInstance3;
    }

    /**
     * 静态内部类，用时加载，且利用类加载时，jvm锁机制保证的线程安全
     * 外部类是通过内部类隐含的access静态方法来访问其中的private变量的（有编译器去处理）
     *
     * &&& 非静态内部类（不管是匿名还是非匿名），都是默认持有外部类引用的
     *     静态内部类不持有外部类引用
     */
    private static class InternSingleTon {
        private static SingleTon singleTon = new SingleTon();
    }

    public SingleTon getsInstance4() {
        return InternSingleTon.singleTon;
    }


    /**
     * 枚举实现，也是利用了jvm对一个类的构造方法会保证正确的加锁和同步，所以是线程安全的
     * 且枚举的构造方法的private的
     */
    private enum EnumSingleTon {
        SINGLE_TON;
    }

    public EnumSingleTon getInstance5() {
        return EnumSingleTon.SINGLE_TON;
    }

}
