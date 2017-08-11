package com.lwj.ademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class Eg1LinearLayout extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg1_linear_layout);
        Toast.makeText(Eg1LinearLayout.this,"eg1页面启动",Toast.LENGTH_SHORT).show();
        WebView webView = (WebView) findViewById(R.id.webview1);
        webView.loadUrl("http://12.15.0.105:8002/");
        WebSettings wbset = webView.getSettings();
        wbset.setJavaScriptEnabled(true);
    }
}
