package com.second.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.crazyandroid.R;
public class Second2_10_5 extends AppCompatActivity {
    //为每个菜单定义一个标记
    final  int MENU1=0x111;
    final  int MENU2=0x112;
    final  int MENU3=0x113;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_10_5);
        txt=(TextView) findViewById(R.id.txt);
        //为文本框注册上下文菜单
        registerForContextMenu(txt);
    }
    //创建上下菜单出发方法


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,MENU1,0,"红色");
        menu.add(0,MENU2,0,"绿色");
        menu.add(0,MENU3,0,"蓝色").setChecked(true);
        //将三个菜单设置为单选项
        menu.setGroupCheckable(0,true,true);
        menu.add(0,MENU3,0,"紫色");
        //设置上下文菜单的标题，图标
        menu.setHeaderIcon(R.drawable.tools);
        menu.setHeaderTitle("选择北京颜色");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  MENU1:
                item.setChecked(true);
                txt.setBackgroundColor(Color.RED);
                break;
            case MENU2:
                item.setChecked(true);
                txt.setBackgroundColor(Color.GREEN);
                break;
            case MENU3:
                item.setChecked(true);
                txt.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }
}
