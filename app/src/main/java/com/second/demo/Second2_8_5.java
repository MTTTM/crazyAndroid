package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.crazyandroid.R;
public class Second2_8_5 extends AppCompatActivity {
    private SearchView sv;
    private ListView lv;
    //自动完成的列表
    private  final  String[] mStrimgs={"aaa","aba","bbbb","cccccc"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_8_5);
        lv=(ListView) findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mStrimgs));
        //设置ListView启用过滤
        lv.setTextFilterEnabled(true);
        sv=(SearchView) findViewById(R.id.sv);
        //设置该searchView默认是否自动缩小为目标
        sv.setIconifiedByDefault(false);
        //设置该SearchView显示为搜索按钮
        sv.setSubmitButtonEnabled(true);
        //设置该SearchView内默认显示的提示文本
        sv.setQueryHint("查找");
        //为该SearchView组件设置事件监听器
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
               // Toast.makeText(Second2_8_5.this,"您的选择是:"+s,Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //如果newText不是长度为0的字符串
                if(TextUtils.isEmpty(s)){
                    //清除ListView的过滤
                    lv.clearTextFilter();
                }
                else{
                    //使用用户输入的内容对ListView的列表进行过滤
                    lv.setFilterText(s);
                }
                return false;
            }
        });


    }
}
