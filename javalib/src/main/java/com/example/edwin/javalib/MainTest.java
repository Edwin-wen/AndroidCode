package com.example.edwin.javalib;

import com.example.edwin.javalib.grammer.annation.AnnonationUtil;
import com.example.edwin.javalib.grammer.annation.ClassByAnnotation;
import com.example.edwin.javalib.grammer.annation.MyAnnotation;
import com.example.edwin.javalib.grammer.intern.InternClassTest;

import java.nio.ByteBuffer;


public class MainTest {

    public static void main(String[] args) {
        InternClassTest test = new InternClassTest();
        InternClassTest.MyStaticClass staticClass = new InternClassTest.MyStaticClass();
        staticClass.toString();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
    }

    private static void testAnnotation() {
        MyAnnotation annotation = (MyAnnotation) AnnonationUtil.dealWithAnnonation(ClassByAnnotation.class, MyAnnotation.class);
        System.out.println(annotation.getString());
        System.out.println(annotation.value().toString());
    }

 }
