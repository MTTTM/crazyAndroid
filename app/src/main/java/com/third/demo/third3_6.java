package com.third.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.crazyandroid.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class third3_6 extends AppCompatActivity {
    private TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third3_6);
        show=(TextView) findViewById(R.id.show);

    }
    //重写该方法，并未界面上的按钮提供事件享有方法
    public  void  download(View source) throws MalformedURLException{
        DownTask task=new DownTask(this);
        task.execute(new URL("http://www.crazyit.org/ethos.php"));
    }
    class DownTask extends AsyncTask<URL,Integer,String>{
        //可变长的输入参数，与AsyncTask.excute()对应
        ProgressDialog pdialog;
        int haRead=0;
        Context mContext;
        int hasRead=0;
        public  DownTask(Context ctx){
            mContext=ctx;
        }

        @Override
        protected String doInBackground(URL... urls) {
            StringBuilder sb=new StringBuilder();
            try{
                URLConnection conn=urls[0].openConnection();
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
                String line=null;
                while ((line=br.readLine())!=null){
                    sb.append(line+"\n");
                    hasRead++;
                    publishProgress(hasRead);
                }
                return sb.toString();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
        protected  void onPostExecute(String result){
            //返回hTML里面的内容
            show.setText(result);
            pdialog.dismiss();
        }
        protected void  onPreExecute(){
            pdialog=new ProgressDialog(mContext);
            //设置对话框的标题
            pdialog.setTitle("任务正在执行中...");
            //设置对户口显示的内容
            pdialog.setMessage("正在执行任务，敬请等待..");
            //设置对户口不能用消失关闭
            pdialog.setCancelable(false);
            //设置改精度的最大进度条
            pdialog.setMax(202);
            //设置对话框的进度条风格
            pdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            //设置对话框是否显示进度
            pdialog.setIndeterminate(false);
            pdialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //更新进度
            show.setText("已经读取了"+values[0]+"行");
        }

    }
}
