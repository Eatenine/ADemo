package com.lwj.ademo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Eg10File extends AppCompatActivity {
    String dirName;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg10_file);
        dirName = getApplicationContext().getFilesDir().toString();
        textView = (TextView) findViewById(R.id.eg10textView);
        textView.setText(dirName);

        button = (Button) findViewById(R.id.eg10Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newFile();

            }
        });


    }
    private  void  newFile(){
        File file = new File(getApplicationContext().getFilesDir(),"lwjFile1");
        String str = "hello world";
        FileOutputStream outputStream ;
        try {
            outputStream = openFileOutput("lwjFile1", Context.MODE_PRIVATE);
            outputStream.write(str.getBytes());
            outputStream.close();
            Log.i("lwj---------","新建文件的代码是跑了");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
