package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.crazyandroid.R;

import java.util.ArrayList;

public class Second2_7_1 extends Activity {
    //定义一个产量，用于显示每瓶显示的应用程序数
    public  static final int MUMBER_PER_SCREEN=12;
    public  static class DataItem{
        //应用名称
        public  String dataName;
        public Drawable drawable;
    }
    //保存系统所有应用程序List集合
    private ArrayList<DataItem> items=new ArrayList<DataItem>();
    //记录氮气正在显示地基屏的程序
    private int screenNo=-1;
    //保存程序所占用的总屏数
    private  int screenCount;
    ViewSwitcher switcher;
    //创建layoutInflater对象
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_7_1);
        inflater =LayoutInflater.from(Second2_7_1.this);
        //创建一个包含40个元素deList集合，用于模拟包含40个应用程序
        for (int i=0;i<40;i++){
            String label=""+i;
            Drawable drawable=getResources().getDrawable(R.drawable.ic_launcher_background);
            DataItem item=new DataItem();
            item.dataName=label;
            item.drawable=drawable;
            items.add(item);
        }
        //计算应用程序所占用的总屏数
        //如果应用程序的数量能整除NUMBER_PER_SCREEN，出发的几个就是总屏幕
        //如果不能整除，总评书应该就是出发的结果再加1
        screenCount=items.size()%MUMBER_PER_SCREEN==0?items.size()/MUMBER_PER_SCREEN:items.size()/MUMBER_PER_SCREEN+1;
        switcher=(ViewSwitcher) findViewById(R.id.viewSwitcherbOX);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return inflater.inflate(R.layout.slidelistview,null);
            }
        });
        //先显示第一屏
        next(null);
    }
    public  void next(View v){
        if(screenNo<screenCount-1){
            screenNo++;
            //为ViewSwitcher的足迹显示过程设置动画
            switcher.setInAnimation(this,R.anim.slide_in_right);
            //为ViewSwitcher的组件隐藏过程设置动画
            switcher.setOutAnimation(this,R.anim.slide_out_left);
            //控制下一频将要显示的GridView对应的Adapter
            ((GridView) switcher.getNextView()).setAdapter(adapter);
            //单击右边按钮，显示下一频
            //学习手势后，也可通过手势监察实现显示上一屏
            switcher.showNext();
        }
    }
    public  void prev(View v){
        if(screenNo>0){
            screenNo--;
            //为ViewSwitcher的组件显示过程设置动画
            switcher.setInAnimation(this,android.R.anim.slide_in_left);
            //为ViewSwitche组件赢率过程设置动画
            switcher.setOutAnimation(this,android.R.anim.slide_out_right);
            //控制下一频要显示的GridVide对应的Adaper
            ((GridView) switcher.getNextView()).setAdapter(adapter);
            //单击左边按钮，显示上一屏，当然可以采用手势
            //学习手势检测后，也可以通过手势检测显示上一屏
            switcher.showPrevious();
        }
    }
    //该BaseAdaptr赋值为每瓶显示的Gridiew提供列表项
    private BaseAdapter adapter= new BaseAdapter() {
        @Override
        public int getCount() {
            //如果到了最后一屏，且英语程序的数量不能整除NUMBER_PER_SCREEN
            if(screenCount==screenCount-1&&items.size()%MUMBER_PER_SCREEN!=0){
                //最后一屏显示的程序数、为英语程序的数量对Number_per_screen
                return items.size()%MUMBER_PER_SCREEN;
            }
            //否则
            return MUMBER_PER_SCREEN;
        }

        @Override
        public DataItem getItem(int position) {
            // 根据screenNo计算第position个列表项的数据
            return items.get(screenNo * MUMBER_PER_SCREEN + position);
        }

            @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            View view =convertView;
            if(convertView==null){
                //价值R.layout.labelicon布局文件
                view=inflater.inflate(R.layout.labelicon,null);
            }
            //获取R.layout.labelicon布局文件中的ImageView组件，并为设置图标
            ImageView imageView=(ImageView) view.findViewById(R.id.imageview);
           // imageView.setImageResource(getItem(i).drawable);
            imageView.setImageDrawable(getItem(i).drawable);
            //获取R.layout.labelicon布局文件的TextView组件，并为之设置文本
            TextView textView=(TextView) view.findViewById(R.id.textview);
            textView.setText(getItem(i).dataName);
            return view;
        }
    };

}
