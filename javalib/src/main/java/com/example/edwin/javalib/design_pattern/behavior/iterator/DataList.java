package com.example.edwin.javalib.design_pattern.behavior.iterator;

import java.util.ArrayList;
import java.util.List;

public class DataList<T> implements IList<T>{

    private List<T> mdataList;
    private ListIterator<T> iterator;

    public DataList() {
        this.mdataList = new ArrayList<T>();
    }

    @Override
    public void add(T item) {
        mdataList.add(item);
    }

    @Override
    public void remove(T item) {
        mdataList.remove(item);
    }

    @Override
    public ListIterator<T> getIterator() {
        if(iterator == null) {
            iterator = new ListIterator<T>(mdataList);
        }
        return iterator;
    }
}
