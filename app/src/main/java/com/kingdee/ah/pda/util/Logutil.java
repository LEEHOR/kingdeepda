package com.kingdee.ah.pda.util;

import android.util.Log;

/**
 * Created by chenxiong on 2017/12/7.
 */

public class Logutil {
    private static String TAG="RESULT";

    public static void print(String str){
        getLog(str);
    }
    public static void print(String tag, String str){
        getLog(tag+"="+str);
    }
    public static void print(int str){
        getLog(str+"");
    }
    public static void print(String str, Boolean bol){
        if (bol){
           getLog("ture");
        }else{
           getLog("false");
        }
    }
    //当log超出3400时
    private static void getLog(String i) {
        String str = "";
        if(StringUtil.isEmpty(i))
            return;
        int k = i.length() / 3400;
        for (int j = 0; j <= k; j++) {
            if (j == k) {
                str = i.substring(j * 3400, i.length());
                Log.i(TAG,  str);
            } else {
                str = i.substring(j * 3400, (j + 1) * 3400);
                Log.i(TAG,  str);
            }
        }
    }

    /**
     * edtMianJi.addTextChangedListener(new TextWatcher() {

    @Override
    public void onTextChanged(CharSequence s, int start, int before,
    int count) {
    // TODO Auto-generated method stub

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
    int after) {
    // TODO Auto-generated method stub

    }

    @Override
    public void afterTextChanged(Editable s) {
    // TODO Auto-generated method stub
    String StrMianJi = edtMianJi.getText().toString();
    if (!StringUtils.isEmpty(StrMianJi)) {
    if (StrMianJi.contains(".")&&(StrMianJi.length()-1-StrMianJi.indexOf(".")>2)){
    String newstr =String.format("%.2f",StringUtils.doubleformatFloor(StringUtils.strToDouble(StrMianJi)));
    edtMianJi.setText(newstr);
    edtMianJi.setSelection(newstr.length());
    return;
    }

    double Dmianji = StringUtils.strToDouble(StrMianJi);
    String StrDanJia = edtDanJia.getText().toString();
    if (!StringUtils.isEmpty(StrDanJia)) {
    if (!IsZongJiachange) {
    // if
    // (preZongjia!=StringUtils.strToDouble(StrDanJia)*Dmianji/10000)
    // {
    preZongjia = StringUtils
    .doubleformat((StringUtils
    .strToDouble(StrDanJia) * Dmianji / 10000));
    String text = String.format("%.1f",preZongjia) + "";
    edtZongJia.setText(text);
    edtZongJia.setSelection(text.length());
    }
    }

    }
    }
    });
     */
}
