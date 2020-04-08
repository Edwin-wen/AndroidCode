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

    private class NonStaicClass {
        /**
         * 内部类是不允许有静态成员的，因为静态的定义就是要在类加载时去初始化，而内部类是要实例化时才生成的，所以不行
         * 这种问题要从类的生命周期入手分析
         */
//        private static int i = 100;
    }

    private class PriClass {
        private int priIndex = 2;
        public int get() {
            return outIndex;
        }
        private void set() {

        }
    }

    public static class MyStaticClass {
        private static int staticIndex = 3;
        public int get() {
            return staticIndex;
        }
    }

    /**
     * 外部类访问内部元素，通过编译期生成的assess函数实现的
     * 内部类访问外部类袁术，是通过保存的外部类的this指针实现的
     * @return
     */
    public int get() {
        // 这里编译期阶段会生成个，访问静态内部类字段，的静态方法，这个静态方法放到外部类的方法表里，所以可以访问静态内部类的字段表
        PriClass priClass = new PriClass();
        int priIndex = priClass.priIndex;
        priClass.set();
        return MyStaticClass.staticIndex;
    }

}
