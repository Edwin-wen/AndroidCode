package com.example.edwin.javalib.design_pattern.behavior.responseChain;

public class Client {

    /**
     * 设置好责任链的组成元素，然后调用链头将请求通过链传下去，直到找到处理这个请求的责任人
     * Android里的事件传递，okhttp处理网络请求
     */
    public void main() {
        Handler1 handler1 = new Handler1();
        Handler2 handler2 = new Handler2();
        handler1.setNext(handler2);
        handler1.handlerRequst("two");
    }

}
