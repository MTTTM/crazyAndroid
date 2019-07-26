package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.crazyandroid.R;
public class Second2_3_5 extends AppCompatActivity {
  RadioGroup rg;
  TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_3_5);
        rg=(RadioGroup) findViewById(R.id.rg);
        show=(TextView) findViewById(R.id.show);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String tip=i==R.id.male?"您的性别是男":"您的性别是女";
                show.setText(tip);
            }
        });
    }
}
