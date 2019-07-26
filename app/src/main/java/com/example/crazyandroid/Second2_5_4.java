package com.example.crazyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.crazyandroid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Second2_5_4 extends Activity {
   private  String[]names=new String[]{"虎头","弄玉","李清照","李白"};
   private  String[] descs=new String[]{"可爱的小孩","一个擅长音乐的女孩","一个擅长问下的女性","浪漫主义诗人"};
   private  int[] imageIds= new int[]{
     R.drawable.setting_press,
     R.drawable.newscenter_press,
     R.drawable.menu_arr_select,
     R.drawable.smartservice_press
   };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_5_4);
        List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
        for (int i=0;i<names.length;i++){
            Map<String,Object> listItem=new HashMap<String, Object>();
            listItem.put("header",imageIds[i]);
            listItem.put("personName",names[i]);
            listItem.put("desc",descs[i]);
            listItems.add(listItem);
        }
        //创建一个simpleAdater
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.simple_item,
                new String[] {"personName","header","desc"},
                new int[]{R.id.name,R.id.header,R.id.desc});
        ListView list=(ListView) findViewById(R.id.myList);
        list.setAdapter(simpleAdapter);


    }
}
