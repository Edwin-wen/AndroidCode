package com.example.edwin.knowledgecode.anim;

import android.animation.TypeEvaluator;

public class ColorEvaluator implements TypeEvaluator {

    /**
     *   也就说通过这个接口，每xx秒回调这个方法一次，post一个刷新invaildate给Chorographer，16ms回调重刷一下layer
     *   所以这种是单线程（主线程下）的动画实现形式
     * @param fraction       通过这个去算百分比，就是什么百分比下，view应该呈现什么状态
     * @param startValue    开始状态
     * @param endValue      结束状态
     * @return
     */
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        return null;
    }
}
