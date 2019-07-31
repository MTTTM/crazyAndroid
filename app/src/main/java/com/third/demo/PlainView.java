package com.third.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.Image;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.crazyandroid.R;

public class PlainView extends View {
    public  float currentX=10;
    public  float currentY=100;
    Bitmap plane;
    private  int speed=10;
    public PlainView(Context context){
        super(context);
        //定义飞机图片
        plane = BitmapFactory.decodeResource(context.getResources(),R.drawable.menu_arr_select);
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建画笔
        Paint p=new Paint();
        canvas.drawBitmap(plane,currentX,currentY,p);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
//        if(event.getY()>currentY){
//            currentY+=speed;
//        }
//        else{
//            currentY-=speed;
//        }
//        if(event.getX()>currentX){
//            currentX+=speed;
//        }
//        else{ currentX-=speed;
//        }
        currentY=event.getY();
        currentX=event.getX();
        this.invalidate();//很重要
        System.out.println("姓名：李明");
        return true;
    }


}
