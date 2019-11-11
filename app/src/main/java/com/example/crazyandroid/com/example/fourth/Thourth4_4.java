package com.example.crazyandroid.com.example.fourth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import com.example.crazyandroid.R;
public class Thourth4_4 extends Activity implements BookListFragment.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_twopane);
    }
    //实现Callbacks接口必须实现的方法


    @Override
    public void onItemSelected(Integer id) {
        //创建Bundle，准备向Frament传入参数
        Bundle argumnets=new Bundle();
        argumnets.putInt(BookDetailFragment.ITEM_ID,id);
        //创建BookDetailFrament
        BookDetailFragment fragment=new BookDetailFragment();
        //向Fragment传入参数
        fragment.setArguments(argumnets);
        //使用fragment替换book_detail_container容器当前显示的Frament
       getFragmentManager().beginTransaction().replace(R.id.book_detail_container,fragment).commit();


    }
}
