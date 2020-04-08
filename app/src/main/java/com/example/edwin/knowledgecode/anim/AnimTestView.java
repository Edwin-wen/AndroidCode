package com.example.edwin.knowledgecode.anim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class AnimTestView extends View {

    private final static float POINT_COUNT = 50f;

    public AnimTestView(Context context) {
        super(context);
    }

    public AnimTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private Path mPath;
    private PointF startPoint = new PointF(0, 0);
    private PointF controlPoint = new PointF();
    private PointF endPoint = new PointF();
    private PointF bezierPoint = new PointF();
    private Paint mPaint  = new Paint(Paint.ANTI_ALIAS_FLAG);

    private int index = 0;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPath == null) {
            mPath = new Path();
            mPath.moveTo(0, 0);
            controlPoint.set(0, getWidth());
            endPoint.set(getWidth(), getHeight());
            mPath.quadTo(controlPoint.x, controlPoint.y, endPoint.x, endPoint.y);
            mPaint.setColor(Color.RED);
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(mPath, mPaint);
        }
        float progress = index / POINT_COUNT;
        PointF pointF = getBezierPoint(startPoint, endPoint, controlPoint, progress);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(pointF.x, pointF.y, 50, mPaint);
    }

    private PointF getBezierPoint(PointF start, PointF end, PointF control, float t) {
        bezierPoint.x = (1 - t) * (1 - t) * start.x + 2 * t * (1 - t) * control.x + t * t * end.x;
        bezierPoint.y = (1 - t) * (1 - t) * start.y + 2 * t * (1 - t) * control.y + t * t * end.y;
        return bezierPoint;
    }
}
