package com.example.edwin.javalib.design_pattern.create.builder;

public class Builder extends IBuilder {
    @Override
    public IBuilder buildPartA() {
        return this;
    }

    @Override
    public IBuilder buildPartB() {
        return this;
    }

    @Override
    public IBuilder buildPartC() {
        return this;
    }
}
