package com.example.edwin.javalib.design_pattern.behavior.observer;

public class Client {

    public void main() {
        IObserverCenter center = new ObserverCenter();
        IRegister register = new Register1();
        center.register(register);
        center.notifyObserver();
        center.unRegister(register);
    }
}
