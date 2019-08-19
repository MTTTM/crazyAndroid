package com.second.demo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.crazyandroid.R;
public class Second2_9_1 extends AppCompatActivity {
    Button simple;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_9_1);
        simple=(Button) findViewById(R.id.simple);
    }
    public  void  simple(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("简单对话框")
                .setIcon(R.drawable.hand)
                .setMessage("对话框测试内容\n 第二行内容");
        setPositiveButton(builder,simple);
        setNegativeButton(builder,simple).create().show();


    }
    private  AlertDialog.Builder setPositiveButton(final AlertDialog.Builder builder, final Button btn){
        //调用setPositionveBUTTION方法添加 确定按钮
        return  builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                     // builder.setTitle("点击了确认按钮");
                btn.setText("点击了确定");
            }
        });
    }
    private  AlertDialog.Builder setNegativeButton(final AlertDialog.Builder builder,final  Button btn){
        //调用 setNegativeButtion 方法添加取消按钮
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
           // builder.setTitle("点击了取消按钮");
                btn.setText("点击了取消");
            }
        });
    }
}
