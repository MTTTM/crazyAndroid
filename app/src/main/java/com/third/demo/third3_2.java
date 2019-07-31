package com.third.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.crazyandroid.R;
public class third3_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third3_2);
        Button bn=(Button) findViewById(R.id.bn);
        bn.setOnClickListener(new MyClickListener());
    }
    class MyClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            EditText txt=(EditText) findViewById(R.id.txt);
            txt.setText("btn被点击了");
        }
    }
}
