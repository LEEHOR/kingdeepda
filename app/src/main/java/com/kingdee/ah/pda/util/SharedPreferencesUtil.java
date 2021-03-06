package com.kingdee.ah.pda.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.kingdee.ah.pda.constance.Constance;

/**
 * Created by 13799 on 2018/6/2.
 */

public class SharedPreferencesUtil {
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    private static volatile SharedPreferencesUtil instance = null;

    public static SharedPreferencesUtil getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesUtil(context);
        }
        return instance;
    }


    public SharedPreferencesUtil(Context context) {
        sp = context.getSharedPreferences(Constance.SHAREP.SHAREDSAVE, context.MODE_PRIVATE);
        editor = sp.edit();
    }

    //设置值
    public void setKeyValue(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }
    //设置值
    public void setKeyValue(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    //设置值
    public void setKeyValue(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    //获取值
    public String getKeyValue(String key) {
        return sp.getString(key, "");
    }


    /**
     * 可以设置默认值得
     * @param key
     * key
     * @param daf
     * 默认值
     * @return
     */
    public String getKeyValue(String key,String daf) {
        return sp.getString(key, daf);
    }

    public int getIntKeyValue(String key) {
        return sp.getInt(key,0);
    }

    public boolean getBooleanKeyValue(String key) {
        return sp.getBoolean(key,false);
    }

    public void remove(String key){
        editor.remove(key);
        editor.commit();
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }
}
