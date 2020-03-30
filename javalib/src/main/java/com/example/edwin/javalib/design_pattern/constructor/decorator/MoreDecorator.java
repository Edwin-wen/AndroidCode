package com.example.edwin.javalib.design_pattern.constructor.decorator;

public class MoreDecorator extends Decorator {

    public MoreDecorator(BaseProduct product) {
        super(product);
    }

    @Override
    public void doSomeThing() {
        super.doSomeThing();
        addDecoratorFunc();
    }

    private void addDecoratorFunc() {

    }
}
