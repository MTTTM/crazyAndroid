package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.crazyandroid.R;
public class Second2_1_4 extends AppCompatActivity {
    int [] images=new int[]{
      R.drawable.menu_arr_select,
      R.drawable.newscenter_press,
      R.drawable.progress_dialog_bg,
      R.drawable.smartservice_press,
      R.drawable.xsearch_loading
    };
    int currentImg=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_1_4);
        LinearLayout main=(LinearLayout) findViewById(R.id.layoutLnear);
        final ImageView image=new ImageView(this);
        main.addView(image);
        image.setImageResource((images[0]));
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(images[++currentImg%images.length]);
            }
        });
    }
}
