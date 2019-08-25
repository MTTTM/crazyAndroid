package com.second.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crazyandroid.R;

import java.io.BufferedReader;

public class Second2_10 extends AppCompatActivity {
    // 定义字体大小菜单项的标识
    final int FONT_10 = 0x111;
    final int FONT_12 = 0x112;
    final int FONT_14 = 0x113;
    final int FONT_16 = 0x114;
    final int FONT_18 = 0x115;
    // 定义普通菜单项的标识
    final int PLAIN_ITEM = 0x11b;
    // 定义字体颜色菜单项的标识
    final int FONT_RED = 0x116;
    final int FONT_BLUE = 0x117;
    final int FONT_GREEN = 0x118;
    private EditText edit;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_10);
        edit = (EditText) findViewById(R.id.txt);
    }
    // 当用户单击MENU键时触发该方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // -------------向menu中添加字体大小的子菜单-------------
        SubMenu fontMenu = menu.addSubMenu("字体大小");
        // 设置菜单的图标
        fontMenu.setIcon(R.drawable.font);
        // 设置菜单头的图标
        fontMenu.setHeaderIcon(R.drawable.font);
        // 设置菜单头的标题
        fontMenu.setHeaderTitle("选择字体大小");
        fontMenu.add(0, FONT_10, 0, "10号字体");
        fontMenu.add(0, FONT_12, 0, "12号字体");
        fontMenu.add(0, FONT_14, 0, "14号字体");
        fontMenu.add(0, FONT_16, 0, "16号字体");
        fontMenu.add(0, FONT_18, 0, "18号字体");
        // -------------向menu中添加普通菜单项-------------
        menu.add(0, PLAIN_ITEM, 0, "普通菜单项");
        // -------------向menu中添加文字颜色的子菜单-------------
        SubMenu colorMenu = menu.addSubMenu("字体颜色");
        colorMenu.setIcon(R.drawable.color);
        // 设置菜单头的图标
        colorMenu.setHeaderIcon(R.drawable.color);
        // 设置菜单头的标题
        colorMenu.setHeaderTitle("选择文字颜色");
        colorMenu.add(0, FONT_RED, 0, "红色");
        colorMenu.add(0, FONT_GREEN, 0, "绿色");
        colorMenu.add(0, FONT_BLUE, 0, "蓝色");

        //设置Activity管理menu
        // -------------向menu中添加子菜单-------------
        SubMenu prog = menu.addSubMenu("启动程序");
        // 设置菜单头的图标
        prog.setHeaderIcon(R.drawable.tools);
        // 设置菜单头的标题
        prog.setHeaderTitle("选择您要启动的程序");
        // 添加菜单项
        MenuItem item = prog.add("查看Swift");
        //为菜单项设置关联的Activity
       // item.setIntent(new Intent(Second2_10.this,com.second.demo.Second2_9_5.class));
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent=new Intent(Second2_10.this,Second2_9_5.class);
                startActivity(intent);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);



    }
    @Override
    // 选项菜单的菜单项被单击后的回调方法
    public boolean onOptionsItemSelected(MenuItem mi)
    {
        //判断单击的是哪个菜单项，并有针对性地作出响应
        switch (mi.getItemId())
        {
            case FONT_10:
                edit.setTextSize(10 * 2);
                break;
            case FONT_12:
                edit.setTextSize(12 * 2);
                break;
            case FONT_14:
                edit.setTextSize(14 * 2);
                break;
            case FONT_16:
                edit.setTextSize(16 * 2);
                break;
            case FONT_18:
                edit.setTextSize(18 * 2);
                break;
            case FONT_RED:
                edit.setTextColor(Color.RED);
                break;
            case FONT_GREEN:
                edit.setTextColor(Color.GREEN);
                break;
            case FONT_BLUE:
                edit.setTextColor(Color.BLUE);
                break;
            case PLAIN_ITEM:
                Toast toast = Toast.makeText(Second2_10.this
                        , "您单击了普通菜单项" , Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
        return true;
    }
}
