package com.lwj.ademo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.orieange.bdlibrary.BDAPI;

public class MainActivity extends AppCompatActivity {
     TextView connDevicesBtn;//蓝牙连接入口的那个按钮，先写成textView
     TextView SOSBtn;//报警按钮

    TextView conBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        connDevicesBtn = (TextView) findViewById(R.id.connDecices);
        SOSBtn = (TextView) findViewById(R.id.SOSReport);
        SOSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "长按报警，点击无效！！！", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        SOSBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //长按出现报警弹窗
                SOSDialog();
                return false;
            }
        });


    }

    public void initView(){
        conBT = (TextView) findViewById(R.id.connDecices);
    }

    public void goToConnDevices(View view) {
        //判断蓝牙是否打开
        if(BDAPI.api().isBlueToothOpen()){
            Intent intent = new Intent(this,ConnDevices.class);
            startActivity(intent);
//            startActivityForResult(intent, 10086);
        }else{
            //弹窗打开
            BlueToothDialog();
        }



    }
//activity onresume的时候判断下连接状态，再做点该改变
    @Override
    protected void onResume() {
        super.onResume();
//        TextView conBT = (TextView) findViewById(R.id.connDecices);
        if(DataPresenter.getInstance().getBTConnect()){
            conBT.setText("已连接");
        }
//        else {
//            conBT.setBackgroundColor(Color.parseColor("#BDBDBD")); //java中设置颜色的一种方法
//        }


    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 123456 && resultCode == Activity.RESULT_OK){
//            TextView conBT = (TextView) findViewById(R.id.connDecices);
//            if(DataPresenter.getInstance().getBTConnect()){
//                conBT.setText("已连接");
//            }
//        }
//    }

    public void sendBDMsg(View view) {
        Toast.makeText(MainActivity.this,"还没有做哦，，，尽情期待",Toast.LENGTH_SHORT).show();

    }
    /**
     * 蓝牙没打开时候的弹窗打开蓝牙
     */
    private void BlueToothDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);  //先得到构造器
        builder.setTitle("蓝牙没有打开"); //设置标题
        builder.setMessage("蓝牙没有打开，是否要打开?"); //设置内容
        builder.setPositiveButton("打开", new DialogInterface.OnClickListener() { //设置【打开】按钮
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); //关闭dialog
               BDAPI.api().openBlueTooth();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { //设置取消按钮
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "不打开蓝牙不能用，再见！！" + which, Toast.LENGTH_SHORT).show();
            }
        });


        //参数都设置完成了，创建并显示出来
        builder.create().show();
    }
    /**
     * 蓝牙没打开时候的弹窗打开蓝牙
     */
    private void SOSDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);  //先得到构造器
        builder.setTitle("SOS报警"); //设置标题
        builder.setMessage("确认要报警吗?"); //设置内容
        builder.setPositiveButton("报警", new DialogInterface.OnClickListener() { //设置【报警】按钮
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); //关闭dialog
                //这里加上执行报警的语句
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { //设置取消按钮
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        //参数都设置完成了，创建并显示出来
        builder.create().show();
    }
    /*
    点击首页id为eg1（线性布局）的响应
    */
    public void goToEg1(View view) {
       Intent intent = new Intent(this,Eg1LinearLayout.class);
        startActivity(intent);
    }

    /*
    点击首页id为eg2（框架布局）的响应
     */
    public void goToEg2(View view) {
        Intent intent = new Intent(this,Eg2FrameLayout.class);
        startActivity(intent);
    }
    /*
点击首页id为eg3（绝对布局）的响应
 */
    public void goToEg3(View view) {
        Intent intent = new Intent(this,Eg3AbsoluteLayout.class);
        startActivity(intent);
    }
    /*
点击首页id为eg4（相对布局）的响应
*/
    public void goToEg4(View view) {
        Intent intent = new Intent(this,Eg4RelativeLayout.class);
        startActivity(intent);
    }

    /*
点击首页id为eg5（相对布局）的响应
*/
    public void goToEg5(View view) {
        Intent intent = new Intent(this,Eg5TableLayout.class);
        startActivity(intent);
    }
    /*
点击首页id为eg6（get请求）的响应
*/
    public void goToEg6(View view) {
        Intent intent = new Intent(this,Eg6GetRequest.class);
        startActivity(intent);
    }
    /*
点击首页id为eg7（post请求）的响应
*/
    public void goToEg7(View view) {
        Intent intent = new Intent(this,Eg7PostRequest.class);
        startActivity(intent);
    }
    /*
点击首页id为eg8（地图）的响应
*/
    public void goToEg8(View view) {
        Intent intent = new Intent(this,Eg8Map.class);
        startActivity(intent);
    }

    public void goToEg9(View view) {
        Intent intent = new Intent(this,Eg9QRScanner.class);
        startActivity(intent);
    }

    public void goToEg10(View view) {
        Intent intent = new Intent(this,Eg10File.class);
        startActivity(intent);
    }
}
