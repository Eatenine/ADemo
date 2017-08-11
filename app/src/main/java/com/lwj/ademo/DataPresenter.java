package com.lwj.ademo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences;

/**
 * Created by lwj_t on 2017/7/13.
 */

public class DataPresenter {

    private DataPresenter(){}

    private static DataPresenter instance = new DataPresenter();

    public static DataPresenter getInstance(){
        return instance;
    }






    private Boolean isBTConnect = false;

    public Boolean getBTConnect() {
        return isBTConnect;
    }

    public void setBTConnect(Boolean BTConnect) {
        isBTConnect = BTConnect;
    }




}
