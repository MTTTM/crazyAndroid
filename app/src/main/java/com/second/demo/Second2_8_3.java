package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.crazyandroid.R;

import java.util.Calendar;
import java.util.Date;

public class Second2_8_3 extends AppCompatActivity {
    private  int year;
    private  int month;
    private  int day;
    private  int hour;
    private  int minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_8_3);
        DatePicker datePicker=(DatePicker) findViewById(R.id.datePicker);
        //隐藏节点
        datePicker.setVisibility(View.INVISIBLE);
        TimePicker timePicker=(TimePicker) findViewById(R.id.timePicker);
        //获取当前的年、月、日、小时、分钟
        Calendar c=Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);
        hour=c.get(Calendar.HOUR);
        minute=c.get(Calendar.MINUTE);
        //初始化DatePicker组件，初始化时指定监听器
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                Second2_8_3.this.year=year;
                Second2_8_3.this.month=month;
                Second2_8_3.this.day=day;
                //显示日期、时间
                showDate(year,month,day,hour,minute);

            }
        });
        //为TimerPicker指定监听器
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                Second2_8_3.this.hour=i;
                Second2_8_3.this.minute=i1;
                //显示当前日期、时间
                showDate(year,month,day,hour,minute);
            }
        });


    }
    //定义在EditText 中显示当前日期，时间的方法
    private  void  showDate(int year,int month,int day,int hour,int minute){
        EditText show=(EditText) findViewById(R.id.show);
        show.setText("您的购买日期为:"+year+"年"+(month+1)+"月"+day+"日"+hour+"时"+minute+"分");
    }
}
