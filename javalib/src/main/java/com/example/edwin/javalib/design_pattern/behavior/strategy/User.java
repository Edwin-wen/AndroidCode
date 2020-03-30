package com.example.edwin.javalib.design_pattern.behavior.strategy;

/**
 * 就是设置进来某个策略，用这个策略做某些事
 */
public class User {

    private Strategy mStrategy;


    public Strategy getStrategy() {
        return mStrategy;
    }

    public void setStrategy(Strategy mStrategy) {
        this.mStrategy = mStrategy;
    }

    public void useStrategyTodo() {
        mStrategy.doStrategyMethod();
    }
}
