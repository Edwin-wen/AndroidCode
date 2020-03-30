package com.example.edwin.javalib.design_pattern.create.factory;

public class Factory1 implements IFactory {
    @Override
    public IProduct createProduct() {
        return new Product1();
    }
}
