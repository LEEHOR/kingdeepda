package com.kingdee.ah.pda.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseDialogFragment;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.dialog
 * @ClassName: MaterialDialog
 * @Description: java类作用描述\
 * 更新基础数据
 * @Author: 作者名
 * @CreateDate: 2020/10/22 9:09
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/22 9:09
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class UpdateBaseDataDialog extends BaseDialogFragment {
    @BindView(R.id.tv_msg)
    TextView tvMsg;
    Unbinder unbinder;
    private String msg;

    public static UpdateBaseDataDialog newInstance(String msg) {
        UpdateBaseDataDialog purchaseOrderAddDialog = new UpdateBaseDataDialog();
        Bundle bundle = new Bundle();
        bundle.putString("msg", msg);
        purchaseOrderAddDialog.setArguments(bundle);
        return purchaseOrderAddDialog;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_loading;
    }

    @Override
    protected void initView() {
        if (getArguments() != null) {
            msg = getArguments().getString("msg");
            tvMsg.setText(msg);
        }
    }

    @Override
    protected void initFunc() {
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
                        return true;
                    }
                    return false;
                }
            });
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            Window window = dialog.getWindow();
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.dimAmount = 0.5f;
            window.setAttributes(lp);
            window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setBackgroundDrawableResource(R.drawable.bg_fff_background);
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            // window.setGravity(Gravity.BOTTOM);
            window.setWindowAnimations(R.style.center_in_out_Animation);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void Close() {
        this.dismiss();
    }
}
