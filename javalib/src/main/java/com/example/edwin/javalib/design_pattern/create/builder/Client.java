package com.example.edwin.javalib.design_pattern.create.builder;

public class Client {

    private IBuilder builder = new Builder();

    private Product createProduct() {
        return builder.buildPartA().buildPartB().buildPartC().commit();
    }
}
