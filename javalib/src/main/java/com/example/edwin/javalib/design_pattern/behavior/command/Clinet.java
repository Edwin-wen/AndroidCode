package com.example.edwin.javalib.design_pattern.behavior.command;

public class Clinet {

    /**
     * 有3个角色：命令，调用命令者，执行具体命令者
     */
    public void main() {
        Command command = new Command1();
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.call();
    }
}
