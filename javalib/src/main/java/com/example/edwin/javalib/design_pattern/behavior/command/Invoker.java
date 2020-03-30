package com.example.edwin.javalib.design_pattern.behavior.command;

public class Invoker {

    private Command command = null;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        command.excute();
    }
}
