package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.crazyandroid.R;
public class Second2_5_4 extends Activity {
    ListView myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_5_5);
        myList=(ListView) findViewById(R.id.myList);
        BaseAdapter adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                //自定一共包含40个选项
                return 40;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                //创建一个LinerLayout，并先其中添加两个组件
                LinearLayout line=new LinearLayout(Second2_5_4.this);
                line.setOrientation(LinearLayout.HORIZONTAL);
                ImageView image=new ImageView(Second2_5_4.this);
                image.setImageResource(R.drawable.ic_launcher_background);
                TextView text=new TextView(Second2_5_4.this);
                text.setText("第"+(i+1)+"个列表项");
                text.setTextSize(20);
                text.setTextColor(Color.RED);
                line.addView(image);
                line.addView(text);
                //返回
                return line;
            }
        };
        myList.setAdapter(adapter);
    }
}
