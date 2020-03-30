package com.example.edwin.javalib.design_pattern.behavior.template;

/**
 * 有个模板类定义了一些流程，外面可以继承这个模板类实现相关流程
 */
public abstract class Template {

    public void template() {
        step0();
        step1();
        step2();
    }

    abstract void step0();
    abstract void step1();
    abstract void step2();
}
