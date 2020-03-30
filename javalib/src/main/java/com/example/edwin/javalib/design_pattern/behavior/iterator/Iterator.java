package com.example.edwin.javalib.design_pattern.behavior.iterator;

/**
 * 定义遍历的接口
 */
public interface Iterator<T> {
    T getNext();
    void remove(T item);
    boolean hasNext();
}
