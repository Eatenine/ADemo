package com.lwj.ademo;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.orieange.bdlibrary.BDAPI;
import com.orieange.bdlibrary.conn.bluetooth.SearchRequest;
import com.orieange.bdlibrary.conn.listener.BDBTSearchListener;
import com.orieange.bdlibrary.conn.listener.BDConnListener;

import java.util.ArrayList;
import java.util.List;

public class ConnDevices extends AppCompatActivity
    implements BDConnListener,BDBTSearchListener,View.OnClickListener {

    private LinearLayout devicesLL;
    private List<BluetoothDevice> list= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conn_devices);
        devicesLL = (LinearLayout) findViewById(R.id.item_layout);


        //动态的请求权限
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, 0x11);
    }


    public void searchDevicesBtn(View v){
        SearchRequest searchRequest = new SearchRequest(0,10*1000);
        BDAPI.api().search(searchRequest,this);
    }

    //用了SDK中BDConnListener,BDBTSearchListener接口，就要重写重写下面一堆方法，继续观望

    //开始搜索蓝牙设备
    @Override
    public void startSearch() {
        Log.v("-----00---", "startSearch");
        Toast.makeText(ConnDevices.this,"开始搜索设备...",Toast.LENGTH_SHORT).show();


    }

    @Override
    public void stopSearch() {

        Toast.makeText(ConnDevices.this,"搜索设备结束",Toast.LENGTH_SHORT).show();

        Log.v("-----00---", "stopSearch");
    }

    @Override
    public void cancelSearch() {

    }

    @Override
    public void findDevice(BluetoothDevice bluetoothDevice) {

        if(!list.contains(bluetoothDevice)){
            list.add(bluetoothDevice);

            TextView textView = new TextView(this);
            textView.setText("设备:"+bluetoothDevice.getName()+"--"+bluetoothDevice.getAddress());
            textView.setPadding(10,40,10,10);
            textView.setTextSize(20);
            textView.setTag(bluetoothDevice);
            devicesLL.addView(textView);
            //监听点击
            textView.setOnClickListener(this);
        }







        Log.v("-----00---", "findDevice:" + bluetoothDevice.getAddress());
        //下文是晓宇写的，搜索到某个设备（5C:F8:21:9D:67:E7）后自动连接
//        if ("5C:F8:21:9D:67:E7".equals(bluetoothDevice.getAddress())){
//            BDAPI.api().stopSearch();
//            BDAPI.api().connectDevice(bluetoothDevice, this);
//        }

        //搜索到设备后需要干点什么，比如把他们放在列表里，还有很多重复的，先不去重


    }
//---------------------------------------------------------------------------搜索蓝牙结束，




    @Override
    public void startConnDevice() {
        Log.v("-----00---", "startConnDevice:" );
    }

    @Override
    //连接成功后，就当做连接状态OK了，回到首页
    public void connSuccess() {
        Toast.makeText(ConnDevices.this,"连接成功",Toast.LENGTH_SHORT).show();
        Log.v("-----00---", "connSuccess:" );


        DataPresenter.getInstance().setBTConnect(true);
        setResult(Activity.RESULT_OK);
        finish();

       // finish();
    }

    @Override
    public void connException(String s) {
        Log.v("-----00---", "connException:" );
    }

    @Override
    public void connBreak() {
        Log.v("-----00---", "connBreak");
    }


    @Override
    public void onClick(View v) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) v.getTag();
        BDAPI.api().connectDevice(bluetoothDevice,this);
        Toast.makeText(ConnDevices.this,"开始连接....",Toast.LENGTH_SHORT).show();

    }

}
