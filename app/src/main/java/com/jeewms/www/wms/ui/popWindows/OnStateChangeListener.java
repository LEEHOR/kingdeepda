package com.jeewms.www.wms.ui.popWindows;

/**
 * Author： hengzwd on 2018/7/27.
 * Email：hengzwdhengzwd@qq.com
 */
public interface OnStateChangeListener {
    void ondismiss();

    void onSpread();

    void onSelect(String name,String number);
}
