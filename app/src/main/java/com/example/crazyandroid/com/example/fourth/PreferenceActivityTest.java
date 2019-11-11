package com.example.crazyandroid.com.example.fourth;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Button;
import android.widget.Toast;

import com.example.crazyandroid.R;

import java.util.List;

public class PreferenceActivityTest extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_preference_test);
        //该方法用于为该节目设置一个标题按钮
        if(hasHeaders()){
            Button button=new Button(this);
            button.setText("设置操作");
            setListFooter(button);
        }
    }
    //重写该方法，负责加载界面布局文件

    @Override
    public void onBuildHeaders(List<Header> target) {
        super.onBuildHeaders(target);
        //加载选项设置列表的布局文件
        loadHeadersFromResource(R.xml.preference_headers,target);
    }
    //重写该方法，验证各PreferenceFragment

    @Override
    protected boolean isValidFragment(String fragmentName) {
        //return super.isValidFragment(fragmentName);
        return true;
    }
    public  static  class Prefs1Fragment extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }
    public  static  class Prefs2Fragment extends  PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.display_prefs);
            //获取传入该Fragment的参数
            String website =getArguments().getString("webSite");
            Toast.makeText(getActivity(),"网站的域名是:"+website,Toast.LENGTH_LONG).show();
        }
    }
}
