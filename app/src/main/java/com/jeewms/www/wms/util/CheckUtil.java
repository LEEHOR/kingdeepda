package com.jeewms.www.wms.util;

import android.content.Context;
import android.widget.EditText;

import com.jeewms.www.wms.ui.view.dialog.SyDialogHelper;

/**
 * Created by 13799 on 2018/6/14.
 */

public class CheckUtil {

    public static boolean checkText(Context context, EditText... editText) {
        for (EditText et : editText) {
            if (StringUtil.isEmpty(et.getText().toString())) {
                SyDialogHelper.showAlertDlg(context, et.getHint().toString());
                return false;
            }
        }
        return true;
    }
    public static boolean checkText(Context context, EditText editText,String msg) {
            if (StringUtil.isEmpty(editText.getText().toString())) {
                SyDialogHelper.showAlertDlg(context, msg);
                return false;

        }
        return true;
    }
}
