package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.crazyandroid.R;
public class Second2_7_3 extends AppCompatActivity {
    TextSwitcher textSwitcher;
    TextSwitcher textSwitcher2;
    String[] str=new String[]{
            "疯狂java讲义",
            "轻量级JAVA 额EQIYESHI",
            "疯狂Android",
            "疯狂Ajax"
    };
    int CurStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_7_3);
        textSwitcher=(TextSwitcher) findViewById(R.id.textSwitcher);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView tv=new TextView(Second2_7_3.this);
                tv.setTextSize(40);
                tv.setTextColor(Color.MAGENTA);
                return tv;
            }
        });
        //调用next方法显示下一个字符串
        next(null);

        textSwitcher2=(TextSwitcher) findViewById(R.id.textSwitcher2);
        textSwitcher2.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView tv=new TextView(Second2_7_3.this);
                tv.setTextSize(40);
                tv.setTextColor(Color.RED);
                return tv;
            }
        });
        next2(null);
    }
    public  void  next(View source){
        textSwitcher.setText(str[CurStr++%str.length]);
    }
    public  void  next2(View source){
        textSwitcher2.setText(str[CurStr++%str.length]);
    }
}
