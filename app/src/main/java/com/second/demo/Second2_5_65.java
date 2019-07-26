package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.crazyandroid.R;
public class Second2_5_65 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_5_65);
        //创建一个BaseExpandableListAdapter对象
        ExpandableListAdapter adapter=new BaseExpandableListAdapter() {
            int[] logos=new int[]{
                    R.drawable.setting_press,
                    R.drawable.newscenter_press,
                    R.drawable.xsearch_loading
            };
            private  String[] armTypes=new String[]{"神族兵种","虫族兵种","人族冰种"};
            private  String[][] arms=new String[][]{
                    {"狂战士","龙骑士","黑暗圣堂","电冰"},
                    {"小狗","刺蛇","飞龙","自爆飞机"},
                    {"机枪兵","护士MM","幽灵"}

            };

            @Override
            public int getGroupCount() {
                return armTypes.length;
            }

            @Override
            public int getChildrenCount(int i) {
                return arms[i].length;
            }
            //获取指定组位置的组数据
            @Override
            public Object getGroup(int i) {

                return armTypes[i];
            }
            //获取指定组位置，指定子列表项的子列表数据
            @Override
            public Object getChild(int i, int i1) {
                return arms[i][i1];
            }

            @Override
            public long getGroupId(int i) {
                return i;
            }

            @Override
            public long getChildId(int i, int i1) {
                return i1;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }
            //该方法觉得每一个组选项的外观
            @Override
            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                LinearLayout l1 =new LinearLayout(Second2_5_65.this);
                l1.setOrientation(LinearLayout.VERTICAL);
                ImageView logo=new ImageView(Second2_5_65.this);
                logo.setImageResource(logos[i]);
                l1.addView(logo);
                TextView textView=getTextView();
                textView.setText(getGroup(i).toString());
                l1.addView(textView);


                return l1;
            }
            //该方法觉得每一个子选项外观
            @Override
            public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                TextView textView=getTextView();
                textView.setText(getChild(i,i1).toString());
                return textView;
            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return true;
            }
            private TextView getTextView(){
                AbsListView.LayoutParams lp=new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,64);
                TextView textView=new TextView(Second2_5_65.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
                textView.setPadding(36,0,0,0);
                textView.setTextSize(20);
                return textView;
            }
        };
        ExpandableListView expandListView=(ExpandableListView) findViewById(R.id.list);
        expandListView.setAdapter(adapter);
    }
}
