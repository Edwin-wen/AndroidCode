package com.example.edwin.javalib.design_pattern.create.builder;

public abstract class IBuilder {

    protected Product mProduct = new Product();

    abstract public IBuilder buildPartA();
    abstract public IBuilder buildPartB();
    abstract public IBuilder buildPartC();

    public Product commit() {
        return mProduct;
    }
}
