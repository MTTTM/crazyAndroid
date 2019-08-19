package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.crazyandroid.R;
public class Second2_8_8 extends AppCompatActivity {
    static final int NOTIFICATION_ID = 0x123;
    NotificationManager nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_8_8);
        //获取系统的NotificationManager服务
        nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }
    // 为发送通知的按钮的点击事件定义事件处理方法
    public void send(View source)
    {
//        // 创建一个启动其他Activity的Intent
        Intent intent = new Intent(Second2_8_8.this
                , Second2_8_7.class);
        PendingIntent pi = PendingIntent.getActivity(
                Second2_8_8.this, 0, intent, 0);
//        Notification notify = new Notification.Builder(this)
//                // 设置打开该通知，该通知自动消失
//                .setAutoCancel(true)
//                // 设置显示在状态栏的通知提示信息
//                .setTicker("有新消息")
//                // 设置通知的图标
//                .setSmallIcon(R.drawable.hand)
//                // 设置通知内容的标题
//                .setContentTitle("一条新通知")
//                // 设置通知内容
//                .setContentText("恭喜你，您加薪了，工资增加20%!")
//                // 设置使用系统默认的声音、默认LED灯
//                 .setDefaults(Notification.DEFAULT_SOUND)
//                // |Notification.DEFAULT_LIGHTS)
//                // 设置通知的自定义声音
//    //            .setSound(Uri.parse("android.resource://com.example.crazyandroid/"
////                        + R.raw.msg))
//                .setWhen(System.currentTimeMillis())
//                // 设改通知将要启动程序的Intent
//                .setContentIntent(pi)  // ①
//                .build();
//        // 发送通知
//        nm.notify(NOTIFICATION_ID, notify);
        String id = "my_channel_01";
        String name="我是渠道名字";
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_LOW);
            Toast.makeText(this, mChannel.toString(), Toast.LENGTH_SHORT).show();
//            Log.i(TAG, mChannel.toString());
            notificationManager.createNotificationChannel(mChannel);
            notification = new Notification.Builder(this)
                    .setChannelId(id)
                    .setAutoCancel(true)
                    .setContentTitle("5 new messages")
                    .setContentText("hahaha")
                    .setDefaults(Notification.DEFAULT_SOUND)
                    .setContentIntent(pi)  // ①
                    .setSmallIcon(R.mipmap.ic_launcher).build();
        } else {
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setContentTitle("5 new messages")
                    .setContentText("hahaha")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setOngoing(true);
                   // .setChannel(id);//无效
            notification = notificationBuilder.build();
        }
        notificationManager.notify(111123, notification);
    }
    // 为删除通知的按钮的点击事件定义事件处理方法
    public void del(View v)
    {
        // 取消通知
        nm.cancel(NOTIFICATION_ID);
    }
}
