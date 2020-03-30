package com.example.edwin.javalib.design_pattern.behavior.iterator;

public class Client {
    public void main() {
        DataList<Integer> dataList = new DataList<>();
        dataList.add(100);
        dataList.add(200);
        dataList.add(500);
        Iterator<Integer> iterator = dataList.getIterator();
        while (iterator.hasNext()) {
            iterator.getNext();
        }
    }
}
