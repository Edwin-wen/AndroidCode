package com.example.edwin.javalib.design_pattern.behavior.iterator;

import java.util.List;

public class ListIterator<T> implements Iterator<T> {

    private List<T> list;

    public ListIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public T getNext() {
        return null;
    }

    @Override
    public void remove(T item) {

    }

    @Override
    public boolean hasNext() {
        return false;
    }
}
