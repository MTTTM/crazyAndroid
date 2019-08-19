package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.example.crazyandroid.R;
import com.google.android.material.tabs.TabLayout;

public class Second2_8_6 extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_8_6);
        //设置Active里面的TabHost组件
        TabHost tabHost=getTabHost();
        //创建第一个Tab页面
        TabHost.TabSpec tab1=tabHost.newTabSpec("tab1").setIndicator("已接电话")//设置标题
        .setContent(R.id.tab01);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2=tabHost.newTabSpec("tab2").setIndicator("呼出电话",
                getResources().getDrawable(R.drawable.hand)).setContent(R.id.tab02);
        tabHost.addTab(tab2);
        TabHost.TabSpec tab3=tabHost.newTabSpec("tab3").setIndicator("未接电话").setContent(R.id.tab03);
        tabHost.addTab(tab3);


    }
}
