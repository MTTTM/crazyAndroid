package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import com.example.crazyandroid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Second2_7_2 extends AppCompatActivity {
    int[] imageIds=new int[]{
            R.drawable.xsearch_loading,
            R.drawable.newscenter_press,
            R.drawable.setting_press,
            R.drawable.xsearch_loading,
            R.drawable.newscenter_press,
            R.drawable.setting_press,
            R.drawable.xsearch_loading,
            R.drawable.newscenter_press,
            R.drawable.setting_press,
            R.drawable.xsearch_loading,
            R.drawable.newscenter_press,
            R.drawable.setting_press,
    };
    ImageSwitcher switcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_7_2);
        //穿件一个List对象，List对象的元素是Map
        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for (int i=0;i<imageIds.length;i++){
            Map<String,Object> listItem=new HashMap<String, Object>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }
        //获取显示图片的ImageSwitcher
        switcher=(ImageSwitcher) findViewById(R.id.viewSwitcher);
        //为ImageSwitcher设置图片切换的动画效果
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                //创建ImageView
                ImageView imageView=new ImageView(Second2_7_2.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        //创建一个SImpleAdapter
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.cell,new String[]{"image"},new int[]{R.id.image1});
        //为GridView设置Adapter
        GridView gird=(GridView) findViewById(R.id.grid01);
        //为GridView设置Adapter
        gird.setAdapter(simpleAdapter);
        //添加列表项中的监听器
        gird.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //显示被点击的图片
                switcher.setImageResource(imageIds[i]);
            }
        });


    }
}
