package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.example.crazyandroid.R;
public class Second2_3_8 extends AppCompatActivity {
    Chronometer ch;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_3_8);
        ch=(Chronometer) findViewById(R.id.test);
        start=(Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch.setBase(SystemClock.elapsedRealtime());
                //启动启动器
                ch.start();
                start.setEnabled(false);
            }
        });
        //为Chronometr绑定监听器
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                //如果从开始计时到现在超过20s
                if(SystemClock.elapsedRealtime()-ch.getBase()>20*1000){
                    ch.stop();
                    start.setEnabled(true);
                }
            }
        });
    }
}
