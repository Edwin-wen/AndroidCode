package com.example.edwin.javalib.design_pattern.constructor.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynaticProxy implements InvocationHandler {

    private RealObject realObject;

    public DynaticProxy(RealObject realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        pre();
        // 反射调用被代理类的方法
        method.invoke(realObject, objects);
        after();
        return null;
    }

    private void pre() {

    }

    private void after() {

    }
}
