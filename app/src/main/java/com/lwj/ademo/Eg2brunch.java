package com.lwj.ademo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;
import com.zhihu.matisse.filter.Filter;

public class Eg2brunch extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg2brunch);

    }
    public void backToMainActivity(View view) {
        finish();
        Eg2FrameLayout.Eg2.finish();
//        Intent intent = new Intent(this,MainActivity.class);
//        startActivity(intent);
    }


    /*
    图片选择
     */
    public void picSelect(View view) {
//        Matisse.from(Eg2brunch.this)
//                .choose(MimeType.allOf())
//                .countable(true)
//                .maxSelectable(9)
//
//                .gridExpectedSize(100)
//                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
//                .thumbnailScale(0.85f)
//                .imageEngine(new GlideEngine())
//                .forResult(10086);
        Matisse.from(Eg2brunch.this)
                //图片／视频格式
                .choose(MimeType.allOf())
                //设置主题，默认知乎主题
                .theme(R.style.Matisse_Dracula)
                //设置选取数自动增加
                .countable(true)
                //是否带拍照
                .capture(true)
                //设置保存图片权限策略
               .captureStrategy(
                       new CaptureStrategy(true, "com.zhihu.matisse.sample.fileprovider"))
                //图片选取最大数
                .maxSelectable(9)
                //选择item增加过滤器
//                .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                //设置媒体网格的期望大小，以适应不同屏幕大小
//                .gridExpectedSize(
//                        getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                //设置Activity方向
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                //设置图片缩略图
                .thumbnailScale(0.85f)
                //设置图片引擎，默认Glide
                .imageEngine(new GlideEngine())
                //开始选取照片、等待结果
                .forResult(10086);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
