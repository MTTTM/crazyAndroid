package com.example.crazyandroid.example.crazyandroid.fourth;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.crazyandroid.R;

public class ExpandableListActivityTest extends ExpandableListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_expandable_list_test);
        setListAdapter(adapter);

    }
    ExpandableListAdapter adapter=new BaseExpandableListAdapter() {
        int[] logos=new int[]{
                R.drawable.xsearch_msg_pull_arrow_down,
                R.drawable.menu_arr_select,
                R.drawable.setting_press
        };
        private  String[] armTypes=new String[]{
          "神族兵种","虫族兵种","人族兵种"
        };
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
            return 0;
        }
        //获取指定组位置处的组数据
        @Override
        public Object getGroup(int i) {
            return armTypes[i];
        }

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
            return false;
        }
        //该方法觉得每一个组选项的外观
        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            LinearLayout ll=new LinearLayout(ExpandableListActivityTest.this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            ImageView logo=new ImageView(ExpandableListActivityTest.this);
            logo.setImageResource(logos[i]);
            ll.addView(logo);
            TextView textView=getTextView();
            textView.setText(getGroup(i).toString());
            ll.addView(textView);
            return ll;
        }
        //该方法觉得每个子选项的外观
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
            TextView textView=new TextView(ExpandableListActivityTest.this);
            textView.setLayoutParams(lp);
            textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
            textView.setPadding(36,0,0,0);
            textView.setTextSize(20);
            return textView;
        }
    };

    @Override
    public void setListAdapter(ExpandableListAdapter adapter) {
        super.setListAdapter(adapter);
    }

}
