package com.jeewms.www.wms.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 13799 on 2018/6/2.
 */

public class ToastUtil {

    public static void show(Context context,String msg){
        if(context!=null)
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
    public static void showLong(Context context,String msg){
        if(context!=null)
            Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
