package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.crazyandroid.R;

public class Second2_5_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_5_2);
        ListView list1=(ListView) findViewById(R.id.list1);
        String[] arr1={"孙悟空","猪八戒","牛魔王"};
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,R.layout.array_item,arr1);
        //为listView设置Adapter
        list1.setAdapter(adapter1);
        ListView list2=(ListView) findViewById(R.id.list2);
        String[] arr2={"JAVA","HIBERNATE","SPRING","ANDROID"};
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,R.layout.checked_item,arr2);
        list2.setAdapter(adapter2);

    }
}
