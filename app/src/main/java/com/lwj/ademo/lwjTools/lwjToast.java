package com.lwj.ademo.lwjTools;

import android.content.Context;
import android.widget.Toast;

import com.lwj.ademo.R;

/**
 * Created by lwj_t on 2017/8/7.
 */

public class lwjToast {
    public static void showToast(Context context,String str){
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
    }


}
