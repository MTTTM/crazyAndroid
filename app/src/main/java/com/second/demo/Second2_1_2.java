package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.crazyandroid.R;

public class Second2_1_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_second2_1_2);
        LinearLayout layout=new LinearLayout(this);
        super.setContentView(layout);
        layout.setOrientation(LinearLayout.VERTICAL);
        final TextView show=new TextView(this);
        Button button=new Button(this);
        button.setText("Ok");
        button.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        layout.addView(button);
        layout.addView(show);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show.setText("你好呀");
            }
        });
    }
}
