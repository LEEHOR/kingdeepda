package com.jeewms.www.wms.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.util.SparseArray;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by 13799 on 2018/6/17.
 */

public class UpdataUiUtil {


    public static UpdataUiUtil getDefaul() {
        return new UpdataUiUtil();
    }

    public static void setText(String str, TextView... textViews) {
        for (TextView textView : textViews) {
            textView.setText(StringUtil.subZeroAndDot(str));
        }
    }

    public static void clearText(TextView... textViews) {
        setText("", textViews);
    }

    public static void setEdit(String str, EditText... editTexts) {
        for (EditText editText : editTexts) {
            editText.setText(str);
        }
    }

    public static void clearEdit(EditText... editTexts) {
        setText("", editTexts);
    }

    public UpdataUiUtil setText(String str, TextView textView) {
        if (!StringUtil.isEmpty(str)) {
            textView.setText(StringUtil.subZeroAndDot(str));
        } else
            textView.setText("");
        return this;
    }

    public UpdataUiUtil setTextId(int str, TextView textView) {
        if (str != -1) {
            textView.setText(str);
        } else
            textView.setText("");
        return this;
    }

    public UpdataUiUtil setText(double str, TextView textView) {
        textView.setText(StringUtil.subZeroAndDot(str + ""));
        return this;
    }

    public UpdataUiUtil setText(String str, EditText textView) {
        if (!StringUtil.isEmpty(str))
            textView.setText(StringUtil.subZeroAndDot(str));
        else
            textView.setText("");
        return this;
    }
    public UpdataUiUtil setText(String str, Button textView) {
        if (!StringUtil.isEmpty(str))
            textView.setText(StringUtil.subZeroAndDot(str));
        else
            textView.setText("");
        return this;
    }

    public UpdataUiUtil setText(double str, EditText textView) {
        textView.setText(StringUtil.subZeroAndDot(str + ""));
        return this;
    }

//    public static void setStart(StarView star, double progress) {
//        star.setStarCount(5);//星星总数
//        star.setRating(progress);//设置星星亮的颗数
//        star.setChange(true);//设置星星是否可以点击和滑动改变
//        star.setStar(R.drawable.ic_ystar_t, R.drawable.ic_ystar_d);// 设置星星的样式
//        star.getRating();//获取亮星星的颗数
//    }

    public UpdataUiUtil setDrawTop(Context context, int drawableR, int whith, int height, RadioButton rbs) {
        Drawable drawable=context.getResources().getDrawable(drawableR);
        drawable.setBounds(0,0,whith,height);
        rbs.setCompoundDrawables(null,drawable,null,null);
        return this;
    }
    public UpdataUiUtil setTime(SparseArray<CountDownTimer> countDownCounters, String startTime, final TextView textView){
        CountDownTimer countDownTimer = countDownCounters.get(textView.hashCode());
        if (countDownTimer != null) {
            //将复用的倒计时清除
            countDownTimer.cancel();
        }
        long timer = StringUtil.str2time(startTime).getTime();
        timer = timer - System.currentTimeMillis();
        //expirationTime 与系统时间做比较，timer 小于零，则此时倒计时已经结束。
        if (timer > 0) {
            countDownTimer = new CountDownTimer(timer, 1000) {
                public void onTick(long millisUntilFinished) {
                    textView.setText(StringUtil.formatSeconds(millisUntilFinished/1000));
                }
                public void onFinish() {
                    textView.setText("00:00:00");
                }
            }.start(); //将此 countDownTimer 放入list.
            countDownCounters.put(textView.hashCode(), countDownTimer);
        } else {
            textView.setText("00:00:00");
        }
        return this;
    }
}
