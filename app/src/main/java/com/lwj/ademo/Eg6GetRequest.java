package com.lwj.ademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Eg6GetRequest extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg6_get_request);
    }
/*
下面方法处理按钮处理逻辑，最终效果是显示get请求后返回的内容

 */
//TODO ------------------------------------------------------------------------2017年7月28日  干，下面没折腾对。重写
    public void eg6Btn(View view) throws IOException {
        textView = (TextView) findViewById(R.id.eg6TextView);
        editText = (EditText) findViewById(R.id.eg6EditText);
        String path = editText.getText().toString();
        if(path==null||path.length()==0){
            textView.setText("请输入地址");
        }else {
            //开始处理请求连接
            //textView.setText(path);

            //创建OkHttpClient对象
            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                //创建一个Request
                final Request request = new Request.Builder().url(path).build();
                //TODO 这是个啥，再了解下new Call
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        //这是请求失败后的东西？？？
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        result=response.body().string();
                    }
                });
                textView.setText(result);
            }catch (IllegalArgumentException e){
                result = "出异常了，请检查地址等等等";
                textView.setText(result);
            }


        }
    }
}
