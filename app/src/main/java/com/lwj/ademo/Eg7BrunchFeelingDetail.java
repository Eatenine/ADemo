package com.lwj.ademo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Eg7BrunchFeelingDetail extends AppCompatActivity {
    TextView feelingDedail;
    String feeling = "看到这个就失败了";

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //从上一个界面获取到信息
        Intent intent = getIntent();
        feeling = intent.getStringExtra(Eg7PostRequest.EXTRA);
        feelingDedail = (TextView) findViewById(R.id.feelingDetail);
        feelingDedail.setText(feeling);
    }

}
