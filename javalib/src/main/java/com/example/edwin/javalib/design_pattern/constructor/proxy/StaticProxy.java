package com.example.edwin.javalib.design_pattern.constructor.proxy;

public class StaticProxy implements IFunction {

    private RealObject realObject = null;

    public StaticProxy(RealObject object) {
        realObject = object;
    }

    @Override
    public void doOne() {
        pre();
        realObject.doOne();
        after();
    }

    @Override
    public void doTwo() {
        pre();
        realObject.doTwo();
        after();
    }

    private void pre() {

    }

    private void after() {

    }
}
