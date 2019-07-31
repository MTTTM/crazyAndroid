package com.third.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crazyandroid.R;

import java.util.ArrayList;
import java.util.List;

public class third3_5_2 extends Activity {
    static  final  String UPPER_NUM="upper";
    EditText etNum;
    CalThread calThread;
    //定义一个线程类
    class CalThread extends  Thread{
        public Handler mHandler;
        public void  run(){
            Looper.prepare();
            mHandler=new Handler(){
              //定义处理消息的方法

                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    if (msg.what == 0x123){
                        int uper=msg.getData().getInt(UPPER_NUM);
                        List<Integer> nums=new ArrayList<Integer>();
                        //计算从2开始，到upper的所有质数
                        outer:
                        for (int i=2;i<=uper;i++){
                            //用i除以2开始，到I的平方根的所有书
                            for(int j=2;j<=Math.sqrt(i);j++){
                                //如果可以整除，则表明这个数不少质数
                                if(i!=2&&i%j==0){
                                    continue  outer;
                                }
                                nums.add(i);
                            }
                        }
                        //使用Toast显示统计出来的所有质数
                        Toast.makeText(third3_5_2.this,nums.toString(),Toast.LENGTH_LONG).show();
                    }
                }
            };
            Looper.loop();
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third3_5_2);
        etNum=(EditText) findViewById(R.id.etNum);
        calThread=new CalThread();
        //启动新线程
        calThread.start();
    }
    //为按钮的点击事件提供方法
    public  void calFunc(View source){
        //创建新消息
        Message msg=new Message();
        msg.what=0x123;
        Bundle bundle=new Bundle();
        bundle.putInt(UPPER_NUM, Integer.parseInt(etNum.getText().toString()));
        msg.setData(bundle);
        //向新线程中的Handler发送消息
        calThread.mHandler.sendMessage(msg);
    }

}
