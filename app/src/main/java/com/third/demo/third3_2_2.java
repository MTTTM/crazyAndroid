package com.third.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.crazyandroid.R;
public class third3_2_2 extends Activity {
    private  int speed=10;
    //该demo只能在模拟器上跑
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_third3_2_2);
        //去掉窗口标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //创建PlaneView
        final  PlainView plainView =new PlainView(this);
        setContentView(plainView);
        plainView.setBackgroundResource(R.drawable.ic_launcher_background);
        //获取窗口管理器
        WindowManager windowManager=getWindowManager();
        Display display=windowManager.getDefaultDisplay();
        DisplayMetrics metrics=new DisplayMetrics();
        //获取屏幕宽高
        display.getMetrics(metrics);
        //设置飞机的初始位置
//        plainView.currentX=(float)metrics.widthPixels/2;
//        plainView.currentY=(float)metrics.heightPixels-40;
        plainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //为planevIEW组件的键盘事件绑定监听器
        plainView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                //获取由那个建出发的
                switch (keyEvent.getKeyCode()){
                    //控制飞机下移
                    case KeyEvent.KEYCODE_S:
                        plainView.currentY+=speed;
                        break;
                    case KeyEvent.KEYCODE_W:
                        plainView.currentY-=speed;
                        break;
                    //控制飞机左移
                    case KeyEvent.KEYCODE_A:
                        plainView.currentX-=speed;
                        break;
                    case KeyEvent.KEYCODE_D:
                        plainView.currentX+=speed;
                        break;
                };
                plainView.invalidate();

                return true;
            }
        });
    }
}
