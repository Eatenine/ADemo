package com.lwj.ademo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import static com.tencent.mars.comm.PlatformComm.context;

public class Eg9QRScanner extends AppCompatActivity {
    private static final String TAG = "lwj-----------";
    String packageName = "mark.qrcode";

    String scanResult = "";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg9_qrscanner);
        if(isAvilible(packageName)){
            init();
        }else {
            textView = (TextView) findViewById(R.id.eg9scanResult);
            textView.setText("没有安装二维码扫描");
        }

    }
    public void init(){


        // 启动扫码
        Intent intent = new Intent("mark.qrcode.SCAN");
        intent.setClassName("mark.qrcode", "mark.qrcode.CaptureActivity");
//        startActivity(intent);
        try { this.startActivityForResult(intent, 0); } catch (Exception ignored) { }
    }
    // 获取扫码结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (intent != null && intent.hasExtra("data")) {
                scanResult = intent.getStringExtra("data"); // 扫码结果
                Log.i(TAG,scanResult);
                textView = (TextView) findViewById(R.id.eg9scanResult);
                textView.setText(scanResult);
            }
            return;
        }
    }

    //判断二维码扫描是否安装了
    private boolean isAvilible(String packageName ) {
        this.packageName = packageName;
        final PackageManager packageManager = getApplicationContext().getPackageManager();
        // 获取所有已安装程序的包信息
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        for ( int i = 0; i < pinfo.size(); i++ )
        {
            if(pinfo.get(i).packageName.equalsIgnoreCase(packageName))
                return true;
        }
        return false;
    }


}
