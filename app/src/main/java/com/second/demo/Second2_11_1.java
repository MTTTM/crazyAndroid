package com.second.demo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.crazyandroid.R;
public class Second2_11_1 extends AppCompatActivity {
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_11_1);
        //获取该Activity的actionBar
        actionBar=getSupportActionBar();
    }
    public  void  showActionBar(View sourse){
        actionBar.show();
    }
    public  void  hideActionBar(View sourse){
        actionBar.hide();
    }
}
