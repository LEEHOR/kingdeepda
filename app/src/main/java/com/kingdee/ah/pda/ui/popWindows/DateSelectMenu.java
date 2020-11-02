package com.kingdee.ah.pda.ui.popWindows;

import android.app.Activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.inter.DatePickerListener;
import com.kingdee.ah.pda.util.DatePickerUtil;
import com.kingdee.ah.pda.util.LocalDisplay;
import com.kingdee.ah.pda.util.StringUtil;
import com.kingdee.ah.pda.util.ToastUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.popWindows
 * @ClassName: DateSelectMenu
 * @Description: java类作用描述
 * 时间选择菜单
 * @Author: 李浩
 * @CreateDate: 2020/10/30 13:52
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/30 13:52
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class DateSelectMenu {
    private View contentView;
    private PopupWindow mPopupWindow;
    private static final int DEFAULT_HEIGHT = RecyclerView.LayoutParams.WRAP_CONTENT;
    private int popHeight = DEFAULT_HEIGHT;
    private static final int DEFAULT_ANIM_STYLE = R.style.pop_animation;
    private OnDateSelectListener onDateSelectListener;
    private Activity mcontext;
    private boolean isMenuOpen;
    private RelativeLayout btn_all, btn_day,btn_week,btn_month;
    private ImageView iv_time_start,iv_time_end;
    private TextView btn_time,tv_time_start,tv_time_end;
    public DateSelectMenu(Activity context) {
        mcontext = context;
        init();
        getPopupWindow();
    }

    private void init() {
        contentView = LayoutInflater.from(mcontext).inflate(R.layout.pop_date_slecet, null);
        btn_all = contentView.findViewById(R.id.line_all);
        btn_day = contentView.findViewById(R.id.line_day);
        btn_week = contentView.findViewById(R.id.line_week);
        btn_month = contentView.findViewById(R.id.line_month);
        btn_time = contentView.findViewById(R.id.btn_time);

        tv_time_start = contentView.findViewById(R.id.tv_time_start);
        tv_time_end = contentView.findViewById(R.id.tv_time_end);

        iv_time_start = contentView.findViewById(R.id.iv_time_start);
        iv_time_end = contentView.findViewById(R.id.iv_time_end);
        initfun();

    }

    private void initfun() {
        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onDateSelectListener != null) {
                    onDateSelectListener.onSelectDayWeekMonth("全部", 0);
                }
            }
        });
        btn_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onDateSelectListener != null) {
                    onDateSelectListener.onSelectDayWeekMonth("本日", 1);
                }
            }
        });
        btn_week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onDateSelectListener != null) {
                    onDateSelectListener.onSelectDayWeekMonth("本周", 2);
                }
            }
        });
        btn_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onDateSelectListener != null) {
                    onDateSelectListener.onSelectDayWeekMonth("本月", 3);
                }
            }
        });

        iv_time_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerUtil.showDataPicker(mcontext, "设置开始时间",tv_time_start, new DatePickerListener() {
                    @Override
                    public void onSelectTime(String time) {

                    }
                });
            }
        });
        iv_time_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerUtil.showDataPicker(mcontext, "设置结束时间",tv_time_end, new DatePickerListener() {
                    @Override
                    public void onSelectTime(String time) {

                    }
                });
            }
        });
        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = tv_time_start.getText().toString().trim();
                String trim1 = tv_time_end.getText().toString().trim();
                if (StringUtil.isEmpty(trim)){
                    ToastUtil.show(mcontext,"开始时间不能为空");
                    return;
                }
                if (StringUtil.isEmpty(trim1)){
                    ToastUtil.show(mcontext,"结束时间不能为空");
                    return;
                }
                if (judeTime(trim,trim1)){
                    ToastUtil.show(mcontext,"开始时间不能大于结束时间");
                    return;
                }
                if (onDateSelectListener != null) {
                    onDateSelectListener.onSelectTime(formatTime(trim),formatTime(trim1),trim,trim1);
                }
            }
        });
    }

    private PopupWindow getPopupWindow() {
        popHeight = (int) mcontext.getResources().getDimension(R.dimen.condition_popuwindow_height);
        mPopupWindow = new PopupWindow(mcontext);
        mPopupWindow.setContentView(contentView);
        mPopupWindow.setWidth(LocalDisplay.getScreenWidth(mcontext));
        //  mPopupWindow.setHeight(popHeight);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPopupWindow.setElevation(3.0f);
        }
        mPopupWindow.setAnimationStyle(DEFAULT_ANIM_STYLE);
        mPopupWindow.setFocusable(true);//外部view在popuwindow show的时候能响应事件
        mPopupWindow.setOutsideTouchable(true);
        ColorDrawable dw = new ColorDrawable(mcontext.getResources().getColor(R.color.transparent));
        mPopupWindow.setBackgroundDrawable(dw);
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                if (onDateSelectListener != null) {
                    onDateSelectListener.ondismiss();
                }
                isMenuOpen = false;
            }
        });
        return mPopupWindow;
    }


    public void showAsDropDown(View anchor) {//以类似dropdown形式展示
        if (mPopupWindow != null && !mPopupWindow.isShowing()) {
            int[] location = new int[2];
            anchor.getLocationInWindow(location);
            int y = location[1];
            int height = anchor.getHeight();
            int bottom = anchor.getBottom();
            //获取屏幕高度
            int screenHeight = LocalDisplay.getScreenHeight(mcontext);
            int maxHeight = screenHeight - bottom;
            mPopupWindow.setHeight(maxHeight);
            mPopupWindow.update();
            if (onDateSelectListener != null) {
                onDateSelectListener.onSpread();
            }
            //往下偏移
            mPopupWindow.showAtLocation(anchor, Gravity.BOTTOM, 0, 0);
            isMenuOpen = true;
        }
    }

    private long formatTime(String time)  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long times=0;
        try {
           times = sdf.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return times;
    }

    private boolean judeTime(String startTime,String endTime){
        long l = formatTime(startTime);
        long l1 = formatTime(endTime);
        return l>l1;
    }

    public void setOnDateSelectListener(OnDateSelectListener onDateSelectListener) {
        this.onDateSelectListener = onDateSelectListener;
    }

    public boolean isMenuOpen() {
        return isMenuOpen;
    }

    public void dismiss() {
        if (isMenuOpen) {
            mPopupWindow.dismiss();
        }
    }
}
