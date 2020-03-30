package com.example.edwin.javalib.design_pattern.constructor.decorator;

public class Decorator {

    private BaseProduct product = null;

    public Decorator(BaseProduct product) {
        this.product = product;
    }

    public void doSomeThing() {
        product.doSomeThing();
    }
}
