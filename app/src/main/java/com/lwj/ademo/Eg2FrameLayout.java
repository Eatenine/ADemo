package com.lwj.ademo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Eg2FrameLayout extends AppCompatActivity {
    public static Activity Eg2 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg2_frame_layout);
        Eg2 = this;
    }

    public void goToEg2brunch(View view) {
        Intent intent = new Intent(this, Eg2brunch.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("visitTime", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        //        DataPresenter.getInstance().setVisitCount(DataPresenter.getInstance().getVisitCount());
        TextView textView = (TextView) findViewById(R.id.visitCount);
        //textView.setText("访问此页面次数："+DataPresenter.getInstance().getVisitCount());
        textView.setText("此页面resume次数：" + preferences.getInt("time", 1));

        int i = preferences.getInt("time",1);
        i++;
        editor.putInt("time", i);
        editor.commit();


    }


}
