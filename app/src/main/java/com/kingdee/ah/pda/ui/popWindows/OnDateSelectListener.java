package com.kingdee.ah.pda.ui.popWindows;

/**
 * Author： hengzwd on 2018/7/27.
 * Email：hengzwdhengzwd@qq.com
 */
public interface OnDateSelectListener {
    void ondismiss();

    void onSpread();

    void onSelectDayWeekMonth(String startTime,String endTime, int time2);

    void onSelectTime(long startTime, long endTime,String startTimel,String endTimel);
}
