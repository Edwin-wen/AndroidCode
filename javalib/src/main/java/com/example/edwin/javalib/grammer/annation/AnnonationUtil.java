package com.example.edwin.javalib.grammer.annation;

import java.lang.annotation.Annotation;

public class AnnonationUtil {

    /**
     *
     * @param className 被注解修饰的类
     * @param annonation 注解类
     */
    public static Annotation dealWithAnnonation(Class<?> className, Class<? extends Annotation> annonation) {
        boolean hasAnnonation = className.isAnnotationPresent(annonation);
        Annotation annotation = null;
        if (hasAnnonation) {
            annotation =  className.getAnnotation(annonation);
        }
        return annotation;
    }
}
