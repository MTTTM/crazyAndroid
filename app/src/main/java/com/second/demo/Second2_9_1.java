package com.second.demo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.crazyandroid.R;

import java.util.Arrays;

public class Second2_9_1 extends AppCompatActivity {
    Button simple;
    TextView  show;
    String[] items = new String[] {
            "疯狂Java讲义", "疯狂Ajax讲义",
            "轻量级Java EE企业应用实战",
            "疯狂Android讲义" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2_9_1);
        simple=(Button) findViewById(R.id.simple);
        show=(TextView) findViewById(R.id.show);
    }
    public  void  simple(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("简单对话框")
                .setIcon(R.drawable.hand)
                .setMessage("对话框测试内容\n 第二行内容");
        setPositiveButton(builder);
        setNegativeButton(builder).create().show();


    }
    private  AlertDialog.Builder setPositiveButton(final AlertDialog.Builder builder){
        //调用setPositionveBUTTION方法添加 确定按钮
        return  builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                     // builder.setTitle("点击了确认按钮");
                show.setText("点击了确定"+i);
            }
        });
    }
    private  AlertDialog.Builder setNegativeButton(final AlertDialog.Builder builder){
        //调用 setNegativeButtion 方法添加取消按钮
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
           // builder.setTitle("点击了取消按钮");
                show.setText("点击了取消");
            }
        });
    }
    public  void  singleChoice(View source){
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                //设置对话框标题
        .setTitle("单选列表对话框")
                .setIcon(R.drawable.menu_arr_select)
                //设置单选项列表，默认选中第二项(索引为1)
                .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Button btn=(Button) findViewById(R.id.singleChoice);
                        btn.setText("您选中<"+items[i]+">");
                    }
                });
        setPositiveButton(builder);
        setNegativeButton(builder).create().show();


    }
    public  void  multiChoice(View Cource){
       final boolean[] bools= new boolean[]{false, true, false, true};
            AlertDialog.Builder builder=new AlertDialog.Builder(this)
                    .setTitle("多选对话框")
                    .setMultiChoiceItems(items, bools, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            Button btn=(Button) findViewById(R.id.multiChoice);
                            btn.setText("您选中<"+i+">"+ Arrays.toString(bools));
                        }
                    });
            //为AlertDialog.Builder添加确认按钮
        setPositiveButton(builder);
        setNegativeButton(builder).create().show();
    }
    public  void  customList(View sourse){
        AlertDialog.Builder builder=new AlertDialog.Builder(this)
                .setTitle("自定义列表对话框")
                .setIcon(R.drawable.menu_arr_select)
                //设置自定义列表项
                .setAdapter(new ArrayAdapter<String>(this,R.layout.array_item,items),null);
        setPositiveButton(builder);
        setNegativeButton(builder).create().show();;
    }
    public  void customView(View source){
        TableLayout loginForm=(TableLayout) getLayoutInflater().inflate(R.layout.login,null);
       final EditText  u=(EditText) loginForm.findViewById(R.id.username);
       final EditText p=(EditText) loginForm.findViewById(R.id.pwd);
        final EditText phone=(EditText) loginForm.findViewById(R.id.phone);
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.setting_press)
                .setTitle("自定义View对话框")
                .setView(loginForm)
                //为对话框设置确认按钮
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //登录操作
                        show.setText(u.getText()+"密码:"+p.getText()+"手机号:"+phone.getText());
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //取消登录
                    }
                }).create().show();
    }
}
