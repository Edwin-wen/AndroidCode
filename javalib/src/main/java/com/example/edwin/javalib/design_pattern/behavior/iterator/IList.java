package com.example.edwin.javalib.design_pattern.behavior.iterator;

public interface IList<T> {
    void add(T item);
    void remove(T item);
    ListIterator<T> getIterator();
}
