package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.crazyandroid.R;
public class Second2_8_2 extends AppCompatActivity {
    CalendarView cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_8_2);
        cv=(CalendarView) findViewById(R.id.calendarView);
        //为CalendarView组件的日期改变添加事件监听器
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                //使用Toast显示用于选择的日期
                Toast.makeText(Second2_8_2.this,"你生日是"+i+"年"+i1+"月"+i2+"日",Toast.LENGTH_LONG).show();
            }
        });
    }
}
