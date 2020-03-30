package com.example.edwin.javalib.grammer.fan;

public class Fan<T> implements IFan<T>{

    private T data;

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }
}
