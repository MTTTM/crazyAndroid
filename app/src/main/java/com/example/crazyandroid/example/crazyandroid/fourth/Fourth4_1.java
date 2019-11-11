package com.example.crazyandroid.example.crazyandroid.fourth;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import com.example.crazyandroid.example.crazyandroid.fourth.Person;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crazyandroid.R;

public class Fourth4_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth4_1);
        Button bn=(Button) findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name=(EditText) findViewById(R.id.name);
                EditText passwd=(EditText) findViewById(R.id.passwd);
                RadioButton male=(RadioButton) findViewById(R.id.male);
                String gender=male.isChecked()?"男":"女";
                Person p= new Person(name.getText().toString(),passwd.getText().toString(),gender);
                //创建一个Bundle对象
                Bundle data=new Bundle();
                data.putSerializable("person",p);

            }
        });


    }

}
