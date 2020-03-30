package com.example.edwin.javalib.design_pattern.behavior.responseChain;

public class Handler2 extends IHandler {

    @Override
    public void handlerRequst(String request) {
        if (request.equals("two")) {
            doThing();
        } else {
            if (getNext() != null) {
                getNext().handlerRequst(request);
            } else {
                System.out.println("no handler about this request in the chain");
            }
        }
    }

    @Override
    public void doThing() {

    }
}
