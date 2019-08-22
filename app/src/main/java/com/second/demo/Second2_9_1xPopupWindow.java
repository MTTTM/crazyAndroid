package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TimePicker;

import com.example.crazyandroid.R;

import java.util.Calendar;

public class Second2_9_1xPopupWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_9_1x_popup_window);
        //创建简单popup
        createPopup();
        createDateBn();
        createdTimePicker();
    }
    public void  createPopup (){
        //装载R。layout.popup对应的界面布局
        View root=this.getLayoutInflater().inflate(R.layout.popup,null);
        //创建PopupWindiw对象
        final PopupWindow popup=new PopupWindow(root,280,360);
        Button button=(Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ////以下拉的方式显示
                popup.showAsDropDown(view);
                //将Popupwindow显示在指定位置
                popup.showAtLocation(findViewById(R.id.bn), Gravity.CENTER,20,20);

            }
        });
        //获取popup窗口中的关闭按钮
        root.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup.dismiss();
            }
        });
    }
    public  void  createDateBn(){
        Button dateBn=(Button) findViewById(R.id.dateBn);
        dateBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c=Calendar.getInstance();
                //直接创建一个DatePickerDialog
                //然后让他显示出来
                new DatePickerDialog(Second2_9_1xPopupWindow.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        EditText show=(EditText) findViewById(R.id.show);
                        show.setText("您选择了 :"+i+"年"+i1+"月"+i2+"日");
                    }
                },
                        //设置初始日期
                    c.get(Calendar.YEAR),
                        c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }
    public  void createdTimePicker(){
        Button timeBtn =(Button) findViewById(R.id.timeBn);
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c=Calendar.getInstance();
                new TimePickerDialog(Second2_9_1xPopupWindow.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        EditText show=(EditText) findViewById(R.id.show);
                        show.setText("你选择了:"+i+"小时"+i1+"分");
                    }
                },
                        c.get(Calendar.HOUR_OF_DAY),
                        c.get(Calendar.MINUTE),
                        true
                        ).show();
            }
        });
    }
}
