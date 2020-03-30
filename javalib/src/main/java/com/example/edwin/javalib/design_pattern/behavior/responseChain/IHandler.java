package com.example.edwin.javalib.design_pattern.behavior.responseChain;

public abstract class IHandler {

    private IHandler next;

    public IHandler getNext() {
        return next;
    }

    public void setNext(IHandler next) {
        this.next = next;
    }

    abstract public void handlerRequst(String request);

    abstract public void doThing();
}
