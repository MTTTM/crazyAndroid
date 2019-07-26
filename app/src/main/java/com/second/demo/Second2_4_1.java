package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.crazyandroid.R;

public class Second2_4_1 extends AppCompatActivity {
    //定义一个访问图片的数组
    int[] images=new int[]{
            R.drawable.guide_1,
            R.drawable.smartservice_press,
            R.drawable.newscenter_press,
            R.drawable.progress_dialog_bg,
            R.drawable.ic_launcher_foreground,
            R.drawable.setting_press
    };
    //定义默认显示的图片
    int currentImg=2;
    //定义图片的初始透明度
    private int alpah=255;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_4_1);
        final Button plus=(Button) findViewById(R.id.plus);
        final Button minus=(Button) findViewById(R.id.mius);
        final ImageView image1=(ImageView) findViewById(R.id.image1);
        final  ImageView image2=(ImageView) findViewById(R.id.image2);
        final Button next=(Button) findViewById(R.id.next);
        //定义查看下一张图片的监听
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image1.setImageResource(images[++currentImg%images.length]);
            }
        });
        //定义改变图片透明度的方法
        View.OnClickListener listener=new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(view==plus){
                    alpah+=20;
                }
                if(view==minus){
                    alpah-=20;
                }
                if (alpah>=255){
                    alpah=255;
                }
                if (alpah<=0) {
                    alpah=0;
                }
                //改变图片的透明度
                image1.setImageAlpha(alpah);
            }
        };
        //为两个按钮添加监听器
        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        image1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BitmapDrawable bitmapDrawable=(BitmapDrawable) image1.getDrawable();
                //获取第一个图片显示框的位图
                Bitmap bitmap=(Bitmap)bitmapDrawable.getBitmap();
                //bitmap图片实际大小与第一个ImageView的缩放比例
                double scale=0.1*bitmap.getHeight()/image1.getHeight();
                //获取需要显示的图片开始点
                int x=(int) (motionEvent.getX()*scale);
                int y=(int)(motionEvent.getY()*scale);
                if(x+120>bitmap.getWidth()){
                    x=bitmap.getWidth()-120;
                }
                if (y+120>bitmap.getHeight()){
                    y=bitmap.getHeight();
                }
                image2.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,120,120));
                image2.setImageAlpha(alpah);
                return false;
            }
        });

    }
}
