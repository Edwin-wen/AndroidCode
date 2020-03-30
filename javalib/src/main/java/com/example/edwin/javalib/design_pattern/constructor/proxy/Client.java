package com.example.edwin.javalib.design_pattern.constructor.proxy;

import java.lang.reflect.Proxy;

public class Client {

    private RealObject object = new RealObject();

    public void useStaticProxy() {
        IFunction proxy = new StaticProxy(object);
        proxy.doOne();
        proxy.doTwo();
    }

    public void useDynaticProxy() {
        ClassLoader loader = object.getClass().getClassLoader();        // 类加载器
        Class<?>[] interfaces = object.getClass().getInterfaces();      // 代理接口
        DynaticProxy proxyHandler = new DynaticProxy(object);           // 反射调用接口方法的handler类
        IFunction runtimeProxy = (RealObject) Proxy.newProxyInstance(loader, interfaces, proxyHandler);
        runtimeProxy.doTwo();
        runtimeProxy.doOne();
    }
}
