package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

import com.example.crazyandroid.R;
public class Second2_7_4 extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_7_4);
        viewFlipper=(ViewFlipper) findViewById(R.id.details);

    }
    public  void  prev(View source){
        viewFlipper.setInAnimation(this,R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this,R.anim.slide_out_left);
        //停止自动播放
        viewFlipper.stopFlipping();
        //显示上一个组件
        viewFlipper.showPrevious();

    }
    public  void  next(View source){
        viewFlipper.setInAnimation(this,R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this,R.anim.slide_out_left);
        //停止自动播放
        viewFlipper.stopFlipping();
       viewFlipper.showNext();

    }
    public void  auto(View sourse){
        viewFlipper.setInAnimation(this,R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this,R.anim.slide_out_left);
        //开启自动播放
        viewFlipper.startFlipping();
    }
}
