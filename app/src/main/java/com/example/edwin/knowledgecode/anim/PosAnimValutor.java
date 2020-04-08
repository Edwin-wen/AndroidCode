package com.example.edwin.knowledgecode.anim;

import android.animation.TypeEvaluator;

public class PosAnimValutor implements TypeEvaluator<Integer> {

    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        return (int) ((endValue - startValue) * fraction);
    }
}
