package com.second.demo;
import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.example.crazyandroid.R;
public class Second2_3_6 extends Activity {
    ToggleButton toggle;
    Switch switcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_3_6);
        toggle=(ToggleButton) findViewById(R.id.toggle);
        switcher=(Switch) findViewById(R.id.viewSwitcher);
        final LinearLayout test=(LinearLayout) findViewById(R.id.test);
        CompoundButton.OnCheckedChangeListener listener=new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
//                    设置linearLayout垂直布局
                    test.setOrientation(LinearLayout.VERTICAL);
                    toggle.setChecked(true);
                    switcher.setChecked(true);

                }
                else{
                    test.setOrientation(LinearLayout.HORIZONTAL);
                    toggle.setChecked(false);
                    toggle.setChecked(false);
                }

            }
        };
        toggle.setOnCheckedChangeListener(listener);
        switcher.setOnCheckedChangeListener(listener);
    }

}
