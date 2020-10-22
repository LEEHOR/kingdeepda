package com.jeewms.www.wms.ui.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

import com.jeewms.www.wms.R;

/**
 * Created by 13799 on 2018/6/22.
 */

public class LoadingView extends ProgressDialog {

    /* private Loading_view loading;

  public void loding(View v){//点击加载并按钮模仿网络请求
    loading = new Loading_view(this,R.style.CustomDialog);
    loading.show();
    new Handler().postDelayed(new Runnable() {//定义延时任务模仿网络请求
      @Override
      public void run() {
    loading.dismiss();//3秒后调用关闭加载的方法
      }
    }, 3000);
  }*/


    public LoadingView(Context context) {
        super(context);
    }
    public LoadingView(Context context, int theme) {
        super(context, theme);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(getContext());
    }
    private void init(Context context) {
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.loading);//loading的xml文件
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
    }
    @Override
    public void show() {//开启
        super.show();
    }
    @Override
    public void dismiss() {//关闭
        super.dismiss();
    }
}
