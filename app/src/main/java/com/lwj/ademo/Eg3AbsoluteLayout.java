package com.lwj.ademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Eg3AbsoluteLayout extends AppCompatActivity {
    private Button Btn1,Btn2;
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg3_absolute_layout);
    }

    public void eg3Btn1(View view) {
        webView = (WebView) findViewById(R.id.eg3webView);
        webView.loadUrl("http://www.orieange.com/skin/images/logo.png");
    }
    public void eg3Btn2(View view) {
        webView = (WebView) findViewById(R.id.eg3webView);
        webView.loadUrl("http://www.orieange.com/skin/images/xcbd.jpg");
    }
}
