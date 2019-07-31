package com.third.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.example.crazyandroid.R;

import java.util.Timer;
import java.util.TimerTask;

public class third3_5 extends AppCompatActivity {
    int[] imageIds=new int[]{
      R.drawable.newscenter_press,
            R.drawable.xsearch_loading,
            R.drawable.smartservice_press,
            R.drawable.menu_arr_select,
            R.drawable.progress_dialog_bg,
            R.drawable.xsearch_msg_pull_arrow_down
    };
    int currentImageId=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third3_5);
        final ImageView show=(ImageView) findViewById(R.id.image);
        final Handler myHandler=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                //如果该消息是本程序发生的
                if(msg.what==0x1233){
                    //动态修改所显示的图片
                    show.setImageResource(imageIds[currentImageId++%imageIds.length]);
                }
            }
        };
        //定义一个定时器，让该定时器周期的执行指定任务
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myHandler.sendEmptyMessage(0x1233);
            }
        },0,1200);
    }

}
