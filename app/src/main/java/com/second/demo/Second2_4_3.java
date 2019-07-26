package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.QuickContactBadge;

import com.example.crazyandroid.R;
public class Second2_4_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_4_3);
        QuickContactBadge badge=(QuickContactBadge) findViewById(R.id.search_badge);
        badge.assignContactFromPhone("18927649419",true);
    }
}
