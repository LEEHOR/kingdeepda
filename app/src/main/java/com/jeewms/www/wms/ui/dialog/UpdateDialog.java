package com.jeewms.www.wms.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseDialogFragment;
import com.jeewms.www.wms.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.dialog
 * @ClassName: UpdateDialog
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/9 10:51
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/9 10:51
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class UpdateDialog extends BaseDialogFragment {
    @BindView(R.id.dialog_tv1)
    TextView dialogTv1;
    @BindView(R.id.update_versionName)
    TextView update_versionName;
    @BindView(R.id.update_detail)
    TextView updateDetail;
    @BindView(R.id.update_download)
    Button updateDownload;
    @BindView(R.id.update_cancel)
    Button updateCancel;
    private String updateRemark;
    private int isForceUpdate;
    private String versionName;

    /**
     *
     * @param versionName  版本号
     * @param isForceUpdate  是否强制更新
     * @param updateRemark   更新说明
     * @return
     */
    public static UpdateDialog newInstance(String versionName,int isForceUpdate,String updateRemark) {
        UpdateDialog updateDialog = new UpdateDialog();
        Bundle bundle=new Bundle();
        bundle.putString("versionName",versionName);
        bundle.putInt("isForceUpdate",isForceUpdate);
        bundle.putString("updateRemark",updateRemark);
        updateDialog.setArguments(bundle);
        return updateDialog;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_mine_update;
    }

    @Override
    protected void initView() {
        if (getArguments() != null) {
            versionName = getArguments().getString("versionName");
            isForceUpdate = getArguments().getInt("isForceUpdate");
            updateRemark = getArguments().getString("updateRemark");
        }
    }

    @Override
    protected void initFunc() {
        update_versionName.setText(versionName);
        if (isForceUpdate==1){
            updateCancel.setVisibility(View.INVISIBLE);
        } else {
            updateCancel.setText(getResources().getText(R.string.mine15));
        }
        if (updateRemark != null) {
            updateDetail.setText(updateRemark);
        }


    }

    @Override
    public void initAnimate() {

    }

    @Override
    public void iniWidow(Dialog dialog) {
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i == KeyEvent.KEYCODE_BACK) {
                        return isForceUpdate==1;
                    }
                    return false;
                }
            });
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            Window window = dialog.getWindow();
            WindowManager.LayoutParams lp=window.getAttributes();
            lp.dimAmount=0.5f;
            window.setAttributes(lp);
            window.setGravity(Gravity.CENTER);
            window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setBackgroundDrawableResource(R.drawable.bg_fff_background);
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            window.setWindowAnimations(R.style.center_in_out_Animation);
        }

    }

    @OnClick({R.id.update_download, R.id.update_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.update_download:
                if (onUpdateListener != null) {
                    onUpdateListener.onConfirm();
                }
                break;
            case R.id.update_cancel:
                this.dismiss();
                break;
        }
    }

    private OnUpdateListener onUpdateListener;

    public void setOnUpdateListener(OnUpdateListener onUpdateListener) {
        this.onUpdateListener = onUpdateListener;
    }

    public interface OnUpdateListener {
        void onConfirm();
    }

}
