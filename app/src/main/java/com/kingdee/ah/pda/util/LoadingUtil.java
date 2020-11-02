package com.kingdee.ah.pda.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;

import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.ui.view.LoadingView;

/**
 * Created by 13799 on 2018/6/22.
 */

public class LoadingUtil {

    private static LoadingView loading;

    public static void showLoading(Context context) {
        loading = new LoadingView(context, R.style.CustomDialog);
        loading.show();
    }

    public static void hideLoading() {
        if (null != loading) {
            new Handler().postDelayed(new Runnable() {//定义延时任务模仿网络请求
                @Override
                public void run() {
                    loading.dismiss();//3秒后调用关闭加载的方法
                }
            }, 500);
        }
    }


    private static ProgressDialog progressDialog;

    //进度条
    public static void ShowProgress(Context context, String message, boolean Cancelable) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage(message);
            progressDialog.setCancelable(Cancelable);
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }

    }

    //关闭进度条
    public static void CancelProgress() {
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                progressDialog.cancel();
            }
        }
    }
}
