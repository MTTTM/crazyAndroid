package com.example.crazyandroid.example.crazyandroid.fourth;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Thourth4_1 extends LauncherActivity {
    //定义两个Active的名称
    String[] names={"设计程序参数","查看星际兵种"};
    //设置两个Activity对应的实现类
    Class<?>[] clazzs={PreferenceActivityTest.class, ExpandableListActivityTest.class};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_thourth4_1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        //设置该窗口显示的的列表所需要的Adapter
        setListAdapter(adapter);
    }
    //根据列表放回指定Activity对应的intent
    @Override
    protected Intent intentForPosition(int position) {
        return new Intent(Thourth4_1.this,clazzs[position]);
    }
}
