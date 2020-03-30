package com.example.edwin.javalib.design_pattern.constructor.adapter;

public class ProductAdapter {

    private Object object;

    public ProductAdapter(Object object) {
        this.object = object;
    }

    public void tranform() {
        object.toString();
    }
}
