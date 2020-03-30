package com.example.edwin.javalib.grammer.fan;

public class IntFan extends Fan<Integer>{

    public <T> void showData(T data) {
        System.out.println(data);
    }

    public static <T> T showStaticData(T data) {
        System.out.println(data);
        return data;
    }
}
