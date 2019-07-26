package com.second.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public  class DrawView extends View {
    public  float currentX=40;
    public  float getCurrentY=50;
    Paint p=new Paint();

    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.RED);
        canvas.drawCircle(currentX,getCurrentY,15,p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX=event.getX();
        getCurrentY=event.getY();
        //通知当前租金重绘自己
        invalidate();
        return true;
    }
}