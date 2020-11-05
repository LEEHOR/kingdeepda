package com.kingdee.ah.pda.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kingdee.ah.pda.LoginActivity;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.util.Logutil;
import com.kingdee.ah.pda.util.ToastUtil;
import com.kingdee.ah.pda.volley.HTTPUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.base
 * @ClassName: BaseActivity1
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/9/28 10:54
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/9/28 10:54
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder bind;

    private AlertDialog.Builder builder;
    private boolean isKeyUp;

    protected abstract int getContentResId();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initfun();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(getContentResId());
        bind = ButterKnife.bind(this);
        initView(savedInstanceState);
        initfun();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
        HTTPUtils.getInstance(this).cancelAllRequest();
    }
    private  void LoginDialog(final Context context, String msg){
        builder = new AlertDialog.Builder(context).setIcon(R.mipmap.ic_launcher).setTitle("提示")
                .setMessage(msg).setPositiveButton("重新登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        LoginActivity.show(context);
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
    }

    public AlertDialog CreateDialog(Context context, String msg){
        if (builder ==null){
            LoginDialog( context, msg);
        }
       return builder.create();
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

    /**
     * 移除searView焦点问题
     * @param v
     * @param mSearchView
     * @param activity
     */
    @Deprecated
  public void regeKeyListener(final View v, final SearchView mSearchView, final Activity activity) {
        // 注册根View布局监听，监听布局大小改变
        v.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // 获取当前焦点所在View
                View currentFocus = activity.getCurrentFocus();
                String name = currentFocus.getClass().getSimpleName();
                Rect outRect = new Rect();
                v.getWindowVisibleDisplayFrame(outRect);
                // 计算比例，从而判断软键盘是否弹起
                double dl = 1.0 * outRect.bottom / v.getMeasuredHeight();
                if (dl < 0.8 && name.equals("android.widget.SearchView$SearchAutoComplete")) {
                    if (!isKeyUp) {
                        isKeyUp = true;
                    }
                } else if (isKeyUp) {
                    currentFocus.clearFocus();
                    mSearchView.clearFocus();
                    isKeyUp = false;
                }

            }
        });
    }
}
