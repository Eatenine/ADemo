package com.lwj.ademo;

import com.alibaba.fastjson.JSON;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.spdy.FrameReader;
import com.lwj.ademo.lwjTools.lwjToast;
import com.lwj.ademo.lwjTools.lwjPostJson;

import java.io.IOException;

public class Eg7PostRequest extends AppCompatActivity {
    private static final String TAG = "lwj-----------";
    private String host = "https://ut-test.cmfun.cn";
    TextView  textView,textView2;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    String result = "";
    String phoneNum;
    private Handler handler = new Handler();
    private Button setting;
    private int itemNum = 0;
    int startRecordNo = 1;//处理加载下一个足迹用的

    public static final String EXTRA = "携带数据用这个";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg7_post_request);
        //启动界面就加载
        textView = (TextView) findViewById(R.id.Eg7TextView);
        new Thread(){
            public void run() {
                lwjPostJson lwjPostJson = new lwjPostJson();
                result = lwjPostJson.getJsonResult(
                        host,                               //参数1，主机地址
                        "/utrip/feeling/getFeelingsPage",   //参数2，接口路径
                        //参数3，Json数据
                        "{\"feelingType\":0,\"loginID\":\"\",\"loginName\":\"\",\"pageSize\":1,\"startRecordNo\":0}"
                );

                handler.post(new Runnable() {//非UI线程不能直接更新UI，用个Handler.post（Runnable)来解决
                    @Override
                    public void run() {
                        textView.setText(result);//页面textView显示服务器返回的json字符串
                        checkGirl(result);
                    }
                });

            }
        }.start();

        //监听设置按钮
        setting = (Button) findViewById(R.id.eg7Setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setting();
            }
        });
    }

    //按钮onclick对应的方法
    public void DoPost(View view) {

        //找到TextView
        textView = (TextView) findViewById(R.id.Eg7TextView);
        new Thread(){
            public void run() {

                postJson(host);//这里发送post请求，使reslut=服务器返回的一串字符
                handler.post(new Runnable() {//非UI线程不能直接更新UI，用个Handler.post（Runnable)来解决
                    @Override
                    public void run() {
                        textView.setText(result);//页面textView显示服务器返回的json字符串
                        checkGirl(result);
                    }
                });

            }
        }.start();


    }

    //下一个足迹加载
    public void nextFeeling(View view) {
        //找到TextView
        textView = (TextView) findViewById(R.id.Eg7TextView);
        new Thread(){
            public void run() {

                postJson(host,startRecordNo);//这里发送post请求，使reslut=服务器返回的一串字符
                handler.post(new Runnable() {//非UI线程不能直接更新UI，用个Handler.post（Runnable)来解决
                    @Override
                    public void run() {
                        textView.setText(result);//页面textView显示服务器返回的json字符串
                        checkGirl(result);
                    }
                });

            }
        }.start();
    }

//加载最新足迹用的
    private void postJson(String host){
        this.host = host;
        this.startRecordNo = 1;

        //创建一个okhttpclient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON,
                "{\"feelingType\":0,\"loginID\":\"\",\"loginName\":\"\",\"pageSize\":1,\"startRecordNo\":0}");

        //创建一个请求对象
        Request request = new Request.Builder()
                .url(host+"/utrip/feeling/getFeelingsPage")
                .post(requestBody)
                .build();
        //发送请求获取响应
        try {
            Response response=okHttpClient.newCall(request).execute();
            //判断请求是否成功
            if(response.isSuccessful()){
                //处理返回结果
                result = response.body().string();
                Log.i(TAG,result);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //加载下一个足迹用这个方法请求post
    private void postJson(String host,int startRecordNo){
        this.startRecordNo = startRecordNo;
        this.startRecordNo++;
        this.host = host;

        //创建一个okhttpclient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON,
                "{\"feelingType\":0,\"loginID\":\"\",\"loginName\":\"\",\"pageSize\":1,\"startRecordNo\":"+startRecordNo+"}");


        //创建一个请求对象
        Request request = new Request.Builder()
                .url(host+"/utrip/feeling/getFeelingsPage")
                .post(requestBody)
                .build();
        //发送请求获取响应
        try {
            Response response=okHttpClient.newCall(request).execute();
            //判断请求是否成功
            if(response.isSuccessful()){
                //处理返回结果
                result = response.body().string();
                Log.i(TAG,result);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    public void setting() {
        new AlertDialog.Builder(this)
                .setTitle("请选择服务器！")
                .setSingleChoiceItems(new String[] { "测试服务器", "开发服务器","生产服务器" }, itemNum,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                switch (which){
                                    case 0:
                                        itemNum = 0;
                                        host = "https://ut-test.cmfun.cn";
                                        lwjToast.showToast(getApplicationContext(),"你选择了测试服务器");
                                        break;
                                    case 1:
                                        itemNum = 1;
                                        host = "https://ut-dev.cmfun.cn";
                                        Toast.makeText(getApplicationContext(),"你选择了开发服务器",Toast.LENGTH_SHORT).show();
                                        break;
                                    case 2:
                                        itemNum =2;
                                        host = "https://ut.cmfun.cn";
                                        Toast.makeText(getApplicationContext(),"你选择了生产服务器",Toast.LENGTH_SHORT).show();
                                        break;
                                }

                            }
                })
                .setNegativeButton("取消", null)
                .show();

    }
    private void checkGirl(String result){
        this.result = result;
        if(result.indexOf("sex\":2")!=-1){
            phoneNum = result.substring(result.indexOf(",\"loginName\":\"")+14,result.indexOf(",\"loginName\":\"")+14+11);
            new AlertDialog.Builder(this)
                    .setTitle("这个用户是女的")
                    .setMessage("电话号码："+phoneNum)
                    .setNegativeButton("取消", null)
                    .setPositiveButton("复制", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                            cm.setText(phoneNum);
                        }
                    })
                    .show();

//            Toast.makeText(getApplicationContext(),
//                    "这个用户是女的，电话是"+result.substring(result.indexOf(",\"loginName\":\"")+14,result.indexOf(",\"loginName\":\"")+14+11)
//                    ,Toast.LENGTH_SHORT).show();
        }
    }


    public void goToFeelingDetail(View view) {
        Intent intent = new Intent(getApplicationContext(),Eg7BrunchFeelingDetail.class);
        intent.putExtra(EXTRA,result);
        startActivity(intent);
    }
}
