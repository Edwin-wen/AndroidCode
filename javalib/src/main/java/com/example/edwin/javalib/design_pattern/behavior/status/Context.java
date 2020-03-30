package com.example.edwin.javalib.design_pattern.behavior.status;

public class Context {

    private AbstactState curState;

    //初始状态
    public Context(AbstactState curState) {
        this.curState = curState;
    }

    public AbstactState getCurState() {
        return curState;
    }

    private void setCurState(AbstactState curState) {
        this.curState = curState;
    }

    public void changeStateByEnvir(int score) {
        if (score < 0) {
            setCurState(new LowState());
        } else if (score < 100 && score > 0){
            setCurState(new MidState());
        } else {
            setCurState(new HighState());
        }
    }
}
