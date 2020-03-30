package com.example.edwin.javalib.design_pattern.constructor.outlook;

/**
 * 提供个窗口去让外面能访问子系统的功能
 */
public class Facade {

    private SubSystem1 s1 = new SubSystem1();
    private SubSystem2 s2 = new SubSystem2();
    private SubSystem3 s3 = new SubSystem3();

    public void doSth() {
        s1.doSystem1();
        s2.doSystem2();
        s3.doSystem3();
    }
}
