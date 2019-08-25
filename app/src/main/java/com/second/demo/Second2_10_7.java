package com.second.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.crazyandroid.R;
public class Second2_10_7 extends AppCompatActivity {
    PopupMenu popu=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_10_7);
    }
    public void  onPopuButtonClick(View button){
            popu=new PopupMenu(this,button);
            getMenuInflater().inflate(R.menu.popup_menu,popu.getMenu());

            //为popu猜的的菜单项添加事件监听
            popu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()){
                        case  R.id.hide:
                            popu.dismiss();
                            break;
                            default:
                                Toast.makeText(Second2_10_7.this,"您点击了["+menuItem.getTitle()+"]菜单",Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
            });
            popu.show();
    }
}
