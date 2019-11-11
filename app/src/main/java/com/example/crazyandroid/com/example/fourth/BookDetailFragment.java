package com.example.crazyandroid.com.example.fourth;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.crazyandroid.R;


import org.w3c.dom.Text;

public class BookDetailFragment extends Fragment {
    public  static  final String ITEM_ID="item_id";
    private static final String TAG = "BookDetailFragment";
    //保存该Fragment显示的Booke对象
    BookContent.Book book;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //如果启动该Frament时包含ITEM_ID参数
        if(getArguments().containsKey(ITEM_ID)){
            book=BookContent.ITEM_MAP.get(getArguments().getInt(ITEM_ID));
            Log.d(TAG, getArguments().toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //加载/res/layout目录下的fragment_book_detail.xml布局文件
        View rootView=inflater.inflate(R.layout.fragment_book_detail,container,false);
        if(book!=null){
            //让book_title文本框显示book对象的title属性
            ((TextView) rootView.findViewById(R.id.book_title)).setText(book.title);
            //让book_desc文本框显示book对象的desc属性
            ((TextView) rootView.findViewById(R.id.book_desc)).setText(book.desc);
        }
        return rootView;
    }
}
