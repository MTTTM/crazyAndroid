package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.example.crazyandroid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Second2_5_64 extends AppCompatActivity {
    GridView grid;
    ImageView imageView;
    int[] imageIds=new int[]{
      R.drawable.smartservice_press,
      R.drawable.menu_arr_select,
      R.drawable.newscenter_press,
      R.drawable.setting_press,
    R.drawable.smartservice_press,
    R.drawable.menu_arr_select,
    R.drawable.newscenter_press,
    R.drawable.setting_press,
    R.drawable.smartservice_press,
    R.drawable.menu_arr_select,
    R.drawable.newscenter_press,
    R.drawable.setting_press
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_5_64);
        //创建一个List对象，List对象的元素是map
        List<Map<String,Object>> listItems=new ArrayList<Map<String, Object>>();
        for(int i=0;i<imageIds.length;i++){
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }
        //获取显示图片的ImageView
        imageView=(ImageView) findViewById(R.id.imageVAIEW);
        //创建一个SimpleAdapter
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.cell,new String[]{"image"},new int[]{R.id.image1});
        grid=(GridView) findViewById(R.id.grid01);
        //为GirdView设置Adapter
        grid.setAdapter(simpleAdapter);
        //添加列表项被选中的监听器
        grid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setImageResource(imageIds[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //添加列表项被单击的监听器
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setImageResource(imageIds[i]);
            }
        });
    }
}
