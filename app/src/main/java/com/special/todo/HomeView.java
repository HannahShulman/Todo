package com.special.todo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class HomeView extends View {

    private ArrayList<PointF> points = new ArrayList<>();
    Paint paint = new Paint();

    public HomeView(Context context) {
        super(context);
        init();
    }


    public HomeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HomeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (points.size() > 1){
            for (int i = 1; i < points.size(); i++) {
                PointF from = points.get(i-1);
                PointF to = points.get(i);
                canvas.drawLine(from.x, from.y, to.x, to.y, paint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            return  true;
        } else if(event.getAction() == MotionEvent.ACTION_UP) {
            points.add(new PointF(event.getX(), event.getY()));
            invalidate();
        }
        return  true;
    }

    public void clean() {
        points.clear();
        invalidate();
    }
    private void init() {
        paint.setStrokeWidth(4);
        paint.setColor(Color.BLACK);
    }

}