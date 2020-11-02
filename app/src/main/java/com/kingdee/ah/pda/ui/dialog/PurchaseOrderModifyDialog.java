package com.kingdee.ah.pda.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseDialogFragment;
import com.kingdee.ah.pda.ui.view.CommodityCountView;
import com.kingdee.ah.pda.util.Logutil;
import com.kingdee.ah.pda.util.StringUtil;
import com.kingdee.ah.pda.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.dialog
 * @ClassName: PurchaseOrderAddDialog
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/21 9:40
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/21 9:40
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class PurchaseOrderModifyDialog extends BaseDialogFragment {


    @BindView(R.id.purchase_order_add_close)
    TextView purchaseOrderAddClose;
    @BindView(R.id.purchase_order_add_title)
    TextView purchaseOrderAddTitle;
    @BindView(R.id.purchase_order_add_complete)
    TextView purchaseOrderAddComplete;
    @BindView(R.id.tv_projectName)
    EditText tvProjectName;
    @BindView(R.id.tv_projectNum)
    TextView tvProjectNum;
    @BindView(R.id.tv_count1)
    CommodityCountView tvCount1;
    @BindView(R.id.tv_count2)
    CommodityCountView tvCount2;
    @BindView(R.id.tv_count3)
    CommodityCountView tvCount3;
    @BindView(R.id.tv_count4)
    CommodityCountView tvCount4;

    /**
     * @param title
     * @param fmustQty          应收数量
     * @param frealQty          实收数量
     * @param fpriceUnitQty     计价数量
     * @param fremainInStockQty 采购数量
     * @return
     */
    public static PurchaseOrderModifyDialog newInstance(String title, String projectName, String projectNum, int fmustQty, int frealQty, int fpriceUnitQty, int fremainInStockQty) {
        PurchaseOrderModifyDialog purchaseOrderAddDialog = new PurchaseOrderModifyDialog();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("projectName", projectName);
        bundle.putString("projectNum", projectNum);
        bundle.putInt("fmustQty", fmustQty);
        bundle.putInt("frealQty", frealQty);
        bundle.putInt("fpriceUnitQty", fpriceUnitQty);
        bundle.putInt("fremainInStockQty", fremainInStockQty);
        purchaseOrderAddDialog.setArguments(bundle);
        return purchaseOrderAddDialog;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_purchase_order_modify;
    }

    @Override
    protected void initView() {
        if (getArguments() != null) {
            String title = getArguments().getString("title");
            String projectName = getArguments().getString("projectName");
            String projectNum = getArguments().getString("projectNum");
            int fmustQty = getArguments().getInt("fmustQty");
            int frealQty = getArguments().getInt("frealQty");
            int fpriceUnitQty = getArguments().getInt("fpriceUnitQty");
            int fremainInStockQty = getArguments().getInt("fremainInStockQty");
            purchaseOrderAddTitle.setText(title);
            tvProjectName.setText(projectName);
            tvProjectNum.setText(projectNum);
            tvCount1.setCount(fremainInStockQty);
            tvCount2.setCount(fpriceUnitQty);
            tvCount3.setCount(fmustQty);
            tvCount4.setCount(frealQty);
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
            window.setWindowAnimations(R.style.bottom_in_out_animation);
        }
    }


    public void Close() {
        this.dismiss();
    }

    @OnClick({R.id.purchase_order_add_close, R.id.purchase_order_add_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.purchase_order_add_close:
                Close();
                break;
            case R.id.purchase_order_add_complete:
                complete();
                break;
        }
    }

    private void complete() {
        int count = tvCount1.getCount();
        int count1 = tvCount2.getCount();
        int count2 = tvCount3.getCount();
        int count3 = tvCount4.getCount();
        if (count == 0) {
            ToastUtil.show(getActivity(), "采购数量不能为空");
            return;
        }
        if (count1 == 0) {
            ToastUtil.show(getActivity(), "计价数量不能为空");
            return;
        }
        if (count2 == 0) {
            ToastUtil.show(getActivity(), "应收数量不能为空");
            return;
        }
        if (count3 == 0) {
            ToastUtil.show(getActivity(), "实收数量不能为空");
            return;
        }
        Logutil.print(count + "/" + count1 + "/" + count2 + "/" + count3);
        if (onModifyOrderListener != null) {
            onModifyOrderListener.onConfirm(count, count1, count2, count3);
        }
    }

    private OnModifyOrderListener onModifyOrderListener;

    public void setOnModifyOrderListener(OnModifyOrderListener modifyOrderListener) {
        this.onModifyOrderListener = modifyOrderListener;
    }

    public interface OnModifyOrderListener {
        //项目编码  物料编码
        void onConfirm(int fremainInStockQty, int fpriceUnitQty, int fmustQty, int frealQtyint);

        void onClose();
    }
}
