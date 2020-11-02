package com.kingdee.ah.pda.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.inter.DatePickerListener;

import java.util.Calendar;

public class DatePickerUtil {
    /**
     *
     * @param context
     * @param msg
     * @param listener
     */
    public static void showDataPicker(Activity context, String msg , final TextView textView, final DatePickerListener listener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View  view = (LinearLayout) context.getLayoutInflater().inflate(R.layout.date_picker, null);//layout布局
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
        builder.setTitle(msg);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //日期格式
                String format = String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth());
                textView.setText(format);
                dialog.cancel();
                listener.onSelectTime(format);

            }
        });
        builder.create().show();
    }



}
