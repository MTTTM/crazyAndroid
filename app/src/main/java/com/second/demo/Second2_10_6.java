package com.second.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crazyandroid.R;
public class Second2_10_6 extends AppCompatActivity {
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_10_6);
        txt=(TextView) findViewById(R.id.txt);
        //为文本框注册上下菜单
        registerForContextMenu(txt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator=new MenuInflater(this);
        //装填R。menu——my_menu对应的菜单，并添加到menu中
        inflator.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.contxt,menu);
        menu.setHeaderTitle("请选择背景色");
        menu.setHeaderIcon(R.drawable.tools);
    }
    //上下文菜单项被点击出发该方法


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //勾选菜单项
        item.setChecked(true);
        switch (item.getItemId()){
            case R.id.red:
                item.setChecked(true);
                txt.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                item.setChecked(true);
                txt.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue:
                item.setChecked(true);
                txt.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.isChecked()){
            item.setChecked(false);
        }
        else{
            item.setChecked(true);
        }
        //判断单选的是哪个菜单项，并正对性作出响应
        switch (item.getItemId()){
            case R.id.font_10:
                txt.setTextSize(10*2);

                break;
            case R.id.font_12:
                txt.setTextSize(12*2);

                break;
            case R.id.font_14:
                txt.setTextSize(14*2);

                break;
            case R.id.font_16:
                txt.setTextSize(16*2);

                break;
            case R.id.font_18:
                txt.setTextSize(18*2);
                break;
            case R.id.red_font:
                txt.setTextColor(Color.RED);
                break;
            case R.id.green_font:
                txt.setTextColor(Color.GREEN);
                break;
            case R.id.blue_font:
                txt.setTextColor(Color.BLUE);
                break;
            case R.id.plain_item:
                Toast toast=Toast.makeText(Second2_10_6.this,"您点击了普通菜单",Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
        return true;
    }
}
