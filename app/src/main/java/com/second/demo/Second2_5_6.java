package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.example.crazyandroid.R;

import java.lang.reflect.Array;

public class Second2_5_6 extends AppCompatActivity {
    AutoCompleteTextView actv;
    MultiAutoCompleteTextView mauto;
    //定义字符数组作为提示的文本
    String[] books=new String[]{
      "疯狂Java讲义",
      "疯狂AJAX讲义",
      "疯狂XML讲义",
      "疯狂WorkFlow讲义"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_5_6);
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,books);
        actv=(AutoCompleteTextView) findViewById(R.id.auto);
        //设置Adapter
        actv.setAdapter(aa);
        mauto=(MultiAutoCompleteTextView) findViewById(R.id.mauto);
        mauto.setAdapter(aa);
        //为MuliAutoCompleteTextView设置分隔符
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}
