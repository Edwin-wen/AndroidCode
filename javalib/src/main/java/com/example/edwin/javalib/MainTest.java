package com.example.edwin.javalib;

import com.example.edwin.javalib.grammer.annation.AnnonationUtil;
import com.example.edwin.javalib.grammer.annation.ClassByAnnotation;
import com.example.edwin.javalib.grammer.annation.MyAnnotation;

public class MainTest {

    public static void main(String[] args) {

    }

    private static void testAnnotation() {
        MyAnnotation annotation = (MyAnnotation) AnnonationUtil.dealWithAnnonation(ClassByAnnotation.class, MyAnnotation.class);
        System.out.println(annotation.getString());
        System.out.println(annotation.value().toString());
    }

 }
