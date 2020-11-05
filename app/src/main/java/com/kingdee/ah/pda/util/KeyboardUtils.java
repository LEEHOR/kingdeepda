package com.kingdee.ah.pda.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.util
 * @ClassName: KeyboardUtils
 * @Description: java类作用描述
 * 软键盘控制
 * @Author: 李浩
 * @CreateDate: 2020/11/5 16:22
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/5 16:22
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class KeyboardUtils {
    public static void showKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            view.requestFocus();
            imm.showSoftInput(view, 0);
        }
    }

    public static void hideKeyboard(View view){
        InputMethodManager imm = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        view.clearFocus();
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

    public static void  toggleSoftInput(View view){
        InputMethodManager imm = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.toggleSoftInput(0,0);
        }
    }
}
