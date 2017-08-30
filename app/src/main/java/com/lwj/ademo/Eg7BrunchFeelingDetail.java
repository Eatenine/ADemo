package com.lwj.ademo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lwj.ademo.lwjTools.PicFromNet;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Eg7BrunchFeelingDetail extends AppCompatActivity {
    TextView feelingDedail;
    String feeling = "看到这个就失败了";
    ImageView imageView;
    Bitmap tupian;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg7_brunch_feeling_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();


                new Thread(){
                    public void  run(){
                        try {
                            PicFromNet picFromNet = new PicFromNet();
                            tupian = picFromNet.getBitmap("http://www.acc.utrip.orieange.cn/2D06A55C-2F13-4B07-8486-2D1B2603C3AD.png");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                imageView = (ImageView) findViewById(R.id.img1);
                                imageView.setImageBitmap(tupian);
                            }
                        });

                    }
                }.start();


            }
        });

        //从上一个界面获取到信息
        Intent intent = getIntent();
        feeling = intent.getStringExtra(Eg7PostRequest.EXTRA);
        feelingDedail = (TextView) findViewById(R.id.feelingDetail);
        feelingDedail.setText(feeling);
    }





}
