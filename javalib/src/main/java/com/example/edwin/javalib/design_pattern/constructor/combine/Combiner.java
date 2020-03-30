package com.example.edwin.javalib.design_pattern.constructor.combine;

import java.util.ArrayList;

public class Combiner implements IProduct{

    ArrayList<IProduct> products = new ArrayList<>();

    public void add(IProduct compoent) {
        products.add(compoent);
    }

    public void remove(IProduct compoent) {
        products.remove(compoent);
    }

    @Override
    public void doThing() {
        for (IProduct iProduct : products) {
            iProduct.doThing();
        }
    }
}
