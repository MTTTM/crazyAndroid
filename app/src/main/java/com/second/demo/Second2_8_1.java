package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crazyandroid.MainActivity;
import com.example.crazyandroid.R;
public class Second2_8_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_8_1);
        Button simple =(Button) findViewById(R.id.simple);
        //为按钮的单击事件板顶监听器
        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast=Toast.makeText(Second2_8_1.this,"简单的提示信息",Toast.LENGTH_LONG);
                toast.show();
            }
        });
        Button bn=(Button) findViewById(R.id.btn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建一个Toast提示信息
                Toast toast=new Toast(Second2_8_1.this);
                //设置Toast的显示位置
                toast.setGravity(Gravity.CENTER,0,0);
                //创建一个ImageView
                ImageView image=new ImageView(Second2_8_1.this);
                image.setImageResource(R.drawable.hand);
                //创建一个LinerLayout容器
                LinearLayout li=new LinearLayout(Second2_8_1.this);
                li.addView(image);
                //创建一个TextView
                TextView textView=new TextView(Second2_8_1.this);
                textView.setText("带图片的提示");
                //设置文本框内的大小和字体颜色
                textView.setTextSize(24);
                textView.setTextColor(Color.MAGENTA);
                li.addView(textView);
                //设置Toast的显示时间
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(li);
                toast.show();
            }
        });
    }
}
