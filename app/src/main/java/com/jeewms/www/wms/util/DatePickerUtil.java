package com.jeewms.www.wms.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.jeewms.www.wms.R;
import com.jeewms.www.wms.inter.DatePickerListener;

import java.util.Calendar;

public class DatePickerUtil {






    public static void showDataPicker(Activity context, View view, final TextView tv, final DatePickerListener listener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        view = (LinearLayout) context.getLayoutInflater().inflate(R.layout.date_picker, null);//layout布局
        final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);//布局中的控件
        //设置日期简略显示 否则详细显示 包括:星期\周
        datePicker.setCalendarViewShown(false);
        //初始化当前日期
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        datePicker.init(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), null);
        //设置date布局
        builder.setView(view);
        builder.setTitle("设置日期信息");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override



            public void onClick(DialogInterface dialog, int which) {
                //日期格式
                StringBuffer sb = new StringBuffer();
                sb.append(String.format("%d-%02d-%02d",

                        datePicker.getYear(),

                        datePicker.getMonth() + 1,

                        datePicker.getDayOfMonth()));
                tv.setText(sb);
                dialog.cancel();
                listener.update();

            }


        });
        builder.create().show();
    }



}
