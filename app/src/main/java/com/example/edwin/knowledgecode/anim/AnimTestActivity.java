package com.example.edwin.knowledgecode.anim;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import com.example.edwin.androidlib.BaseTestActivity;

public class AnimTestActivity extends BaseTestActivity implements BaseTestActivity.IClickProxy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] strings = {"贝塞尔曲线动画测试"};
        initFunc(strings, this);
        addTestView();
    }

    private AnimTestView mView;

    private void addTestView() {
        mView= new AnimTestView(this);
        addView(mView);
    }

    private void startAnim() {
        ObjectAnimator animator = new ObjectAnimator();
        animator.setTarget(mView);
    }

    @Override
    public void handleFunc1() {

    }

    @Override
    public void handleFunc2() {

    }

    @Override
    public void handleFunc3() {

    }

    @Override
    public void handleFunc4() {

    }

    @Override
    public void handleFunc5() {

    }

    @Override
    public void handleFunc6() {

    }

    @Override
    public void handleFunc7() {

    }

    @Override
    public void handleFunc8() {

    }
}
