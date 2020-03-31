package com.example.edwin.javalib.grammer.annation;

public class Client {

    public void main () {
        MyAnnotation annotation = (MyAnnotation) AnnonationUtil.dealWithAnnonation(ClassByAnnotation.class, MyAnnotation.class);
        annotation.getString();
        annotation.value();
    }
}
