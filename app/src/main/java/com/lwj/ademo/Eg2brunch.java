package com.lwj.ademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Eg2brunch extends AppCompatActivity {

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
}
