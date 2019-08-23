package com.second.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.example.crazyandroid.R;
public class Second2_9_5 extends AppCompatActivity {
    final static  int MAX_PROGESS=100;
    //该程序模拟填充长度为100的数组
    private  int[] data=new int[50];
    //记录进度对话框的完成百分比
    int progressStatus=0;
    int hasData=0;
    ProgressDialog pd1,pd2;
    //定义一个辅助更新进度的Handler
    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //表明消息是由小程序发送的
            if(msg.what==0x123){
                pd2.setProgress(progressStatus);
            }
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_9_5);

    }
    public  void  showSpinner(View source){
        //调用静态方法，显示环形精度条
        ProgressDialog.show(this,"任务执行中","任务执行中，请等待",false,true);
    }
    public  void showIndeterminate(View source){
        pd1=new ProgressDialog(Second2_9_5.this);
        pd1.setTitle("任务正在执行中");
        //设置对话框显示的内容
        pd1.setMessage("任务正在执行中，敬请期待。。");
        //设置对话框能用"取消" 按钮关闭
        pd1.setCancelable(true);
        // 设置对户口的精度条风格
        pd1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //设置对话框的精度条是否显示进度
        pd1.setIndeterminate(true);
        pd1.show();
    }
    public  void  showProgress(View source){
        //将精度条的完成进度重设为0
        progressStatus=0;
        //重新开始充填数组
        hasData=0;
        pd2=new ProgressDialog(Second2_9_5.this);
        pd2.setMax(MAX_PROGESS);
        //设置对话框标题
        pd2.setMessage("好事任务的完成百分比");
        //设置对话框不能用取消按钮关闭
        pd2.setCancelable(false);
        //设置对话框进度条的风格
        pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //设置对话框的精度条是否显示进度条
        pd2.setIndeterminate(false);
        pd2.show();
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (progressStatus<MAX_PROGESS){
                    //获取耗时操作的完成百分比
                    progressStatus=MAX_PROGESS*doWork()/data.length;
                    //发送空消息到Handle
                    handler.sendEmptyMessage(0x123);
                }
                //如果任务已经完成
                if(progressStatus>=MAX_PROGESS){
                    //关闭对话框
                    pd2.dismiss();
                }
            }
        }.start();
    }
    public  int doWork(){
        //为数组元素赋值
        data[hasData++]=(int)(Math.random()*100);
        try{
            Thread.sleep(100);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return  hasData;
    }


}
