package com.example.edwin.javalib.design_pattern.behavior.command;

public class Command1 implements Command {

    private RealExcutor excutor = new RealExcutor();

    @Override
    public void excute() {
        excutor.doAction();
    }
}
