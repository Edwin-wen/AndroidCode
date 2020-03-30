package com.example.edwin.javalib.design_pattern.behavior.observer;

import java.util.ArrayList;

public abstract class IObserverCenter {

    protected ArrayList<IRegister> list = new ArrayList<>();

    public void register(IRegister register) {
        list.add(register);
    }

    public void unRegister(IRegister register) {
        list.remove(register);
    }

    abstract void notifyObserver();
}
