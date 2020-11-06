package com.kingdee.ah.pda.util;

import android.util.Log;

/**
 * Created by chenxiong on 2017/12/7.
 */

public class Logutil {
    public static String TAG = "RESULT";
    public static boolean DEBUG = Log.isLoggable(TAG, Log.VERBOSE);

    public static void setTag(String tag) {
        TAG = tag;
        DEBUG = Log.isLoggable(TAG, Log.VERBOSE);
    }
    public static void print(String str) {
        if (DEBUG){
            getLog(str);
        }
    }

    //当log超出3400时
    private static void getLog(String i) {
        String str = "";
        if (StringUtil.isEmpty(i))
            return;
        int k = i.length() / 3400;
        for (int j = 0; j <= k; j++) {
            if (j == k) {
                str = i.substring(j * 3400, i.length());
                Log.i(TAG, str);
            } else {
                str = i.substring(j * 3400, (j + 1) * 3400);
                Log.i(TAG, str);
            }
        }
    }
}
