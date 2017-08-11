package com.lwj.ademo;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.MyLocationStyle;


public class Eg8Map extends AppCompatActivity {
    MapView mapView = null;
    MyLocationStyle myLocationStyle;
    LinearLayout linearLayout ;
    RelativeLayout relativeLayout;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg8_map);
        //获取地图控件
        mapView = (MapView) findViewById(R.id.Map);
        mapView.onCreate(savedInstanceState);


    }


    public void moreData(View view) {
        linearLayout = (LinearLayout) findViewById(R.id.eg8LLayout2);
        linearLayout.setVisibility(View.VISIBLE);
        relativeLayout = (RelativeLayout) findViewById(R.id.eg8lb);
        relativeLayout.setVisibility(View.INVISIBLE);

    }
    public void onBackPressed() {
        linearLayout = (LinearLayout) findViewById(R.id.eg8LLayout2);
        relativeLayout = (RelativeLayout) findViewById(R.id.eg8lb);
       if(linearLayout.getVisibility()==View.VISIBLE){
           linearLayout.setVisibility(View.INVISIBLE);
           relativeLayout.setVisibility(View.VISIBLE);
       }else {
           finish();
       }


    }
}
