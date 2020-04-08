package com.example.edwin.knowledgecode.anim;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;

import com.example.edwin.androidlib.BaseTestActivity;

public class AnimTestActivity extends BaseTestActivity implements BaseTestActivity.IClickProxy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] strings = {"属性动画", "值动画"};
        initFunc(strings, this);
        addTestView();
    }

    private AnimTestView mView;

    private void addTestView() {
        mView= new AnimTestView(this);
        addView(mView);
    }

    private void startObjectAnim() {
        ObjectAnimator animator = ObjectAnimator.ofInt(mView, "index", 0, 50);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(1000);
        animator.start();
    }

    private void startValueAnim() {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new PosAnimValutor(), 0, 50);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.setDuration(3000);
//        valueAnimator.setTarget(mView);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int index = (int) animation.getAnimatedValue();
                mView.setIndex(index);
            }
        });
        valueAnimator.start();
    }

    @Override
    public void handleFunc1() {
        startObjectAnim();
    }

    @Override
    public void handleFunc2() {
        startValueAnim();
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
