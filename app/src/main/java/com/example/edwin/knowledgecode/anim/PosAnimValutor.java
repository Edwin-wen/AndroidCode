package com.example.edwin.knowledgecode.anim;

import android.animation.TypeEvaluator;

public class PosAnimValutor implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int index = (int) ((endValue - startValue) * fraction);
        return index;
    }
}
