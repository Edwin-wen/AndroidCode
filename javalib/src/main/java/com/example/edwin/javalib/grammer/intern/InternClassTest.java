package com.example.edwin.javalib.grammer.intern;

import jdk.internal.dynalink.beans.StaticClass;

public class InternClassTest {

    private int outIndex = 100;
    private PubClass pub;
    private PriClass pri;

    public InternClassTest() {
        pub = new PubClass();
        pri = new PriClass();
    }

    public class PubClass {
        private int pubIndex = 1;
        public int get() {
            // 持有外部类的引用
            return outIndex;
        }
    }

    private class PriClass {
        private int priIndex = 2;
        public int get() {
            return outIndex;
        }
    }

    public static class MyStaticClass {
        private static int staticIndex = 3;
        public int get() {
            return staticIndex;
        }
    }

    public int get() {
        // 这里编译期阶段会生成个，访问静态内部类字段，的静态方法，这个静态方法放到外部类的方法表里，所以可以访问静态内部类的字段表
        return MyStaticClass.staticIndex;
    }

}
