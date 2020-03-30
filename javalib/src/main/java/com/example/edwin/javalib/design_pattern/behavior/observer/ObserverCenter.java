package com.example.edwin.javalib.design_pattern.behavior.observer;

public class ObserverCenter extends IObserverCenter {

    @Override
    void notifyObserver() {
        for (IRegister register : list) {
            register.doAction();
        }
    }
}
