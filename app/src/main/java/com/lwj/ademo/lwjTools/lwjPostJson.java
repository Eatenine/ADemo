package com.lwj.ademo.lwjTools;

import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by lwj_t on 2017/8/7.
 */

public class lwjPostJson {

    private static final String TAG = "lwjTAG-----------";
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public String getJsonResult(String host, String dir, String json){
        String result="";

        //创建一个okhttpclient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON,json);

        //创建一个请求对象
        Request request = new Request.Builder()
                .url(host+dir)
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
            }else {
                result = "请求失败，请检查！";
            }
        } catch (IOException e) {
            e.printStackTrace();
            result = "出现异常，请检查！";
        }
        return result;

    }
}
