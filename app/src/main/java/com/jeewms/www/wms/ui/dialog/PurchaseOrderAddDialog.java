package com.jeewms.www.wms.ui.dialog;

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

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseDialogFragment;
import com.jeewms.www.wms.bean.InStockEntryBean;
import com.jeewms.www.wms.util.StringUtil;

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
public class PurchaseOrderAddDialog extends BaseDialogFragment {

    @BindView(R.id.purchase_order_add_close)
    TextView purchaseOrderAddClose;
    @BindView(R.id.purchase_order_add_title)
    TextView purchaseOrderAddTitle;
    @BindView(R.id.purchase_order_add_complete)
    TextView purchaseOrderAddComplete;
    @BindView(R.id.tv_projectName)
    EditText tvProjectName;
    @BindView(R.id.tv_projectNum)
    EditText tvProjectNum;
    @BindView(R.id.tv_fmaterialName)
    EditText tvFmaterialName;
    @BindView(R.id.tv_fmaterialNum)
    EditText tvFmaterialNum;
    @BindView(R.id.tv_fmaterialSpecification)
    TextView tvFmaterialSpecification;
    @BindView(R.id.tv_fstockName)
    TextView tvFstockName;
    @BindView(R.id.tv_fpriceunitName)
    TextView tvFpriceunitName;
    @BindView(R.id.tv_fpurorgName)
    TextView tvFpurorgName;
    @BindView(R.id.tv_fremainInStockQty)
    EditText tvFremainInStockQty;
    @BindView(R.id.tv_fpriceUnitQty)
    EditText tvFpriceUnitQty;
    @BindView(R.id.tv_fmustQty)
    EditText tvFmustQty;
    @BindView(R.id.tv_frealQty)
    EditText tvFrealQty;
    Unbinder unbinder;

    private InStockEntryBean.DataEntity body = new InStockEntryBean.DataEntity();
    private int mSelect = 9999;
    private int pSelect = 9999;


    public static PurchaseOrderAddDialog newInstance(String title, int type) {
        PurchaseOrderAddDialog purchaseOrderAddDialog = new PurchaseOrderAddDialog();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putInt("type", type);
        purchaseOrderAddDialog.setArguments(bundle);
        return purchaseOrderAddDialog;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_purchase_order_add;
    }

    @Override
    protected void initView() {

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

    private OnAddOrderListener onAddOrderListeners;

    public void setOnAddOrderListener(OnAddOrderListener addOrderListener) {
        this.onAddOrderListeners = addOrderListener;
    }


    public void Close() {
        this.dismiss();
    }


    @OnClick({R.id.purchase_order_add_close, R.id.purchase_order_add_complete, R.id.tv_projectName, R.id.tv_fmaterialName, R.id.tv_fstockName, R.id.tv_fpriceunitName})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.purchase_order_add_close:
                if (onAddOrderListeners != null) {
                    onAddOrderListeners.onClose();
                }
                break;
            case R.id.purchase_order_add_complete:
                if (onAddOrderListeners != null) {
                    if (StringUtil.isEmpty(tvFremainInStockQty.getText().toString().trim())) {
                        body.setFremainInStockQty(Integer.parseInt(tvFremainInStockQty.getText().toString().trim()));
                    }
                    if (StringUtil.isEmpty(tvFpriceUnitQty.getText().toString().trim())){
                        body.setFpriceUnitQty(Integer.parseInt(tvFpriceUnitQty.getText().toString().trim()));
                    }
                    if (StringUtil.isEmpty(tvFmustQty.getText().toString().trim())){
                        body.setFmustQty(Integer.parseInt(tvFmustQty.getText().toString().trim()));
                    }
                    if (StringUtil.isEmpty(tvFrealQty.getText().toString().trim())){
                        body.setFrealQty(Integer.parseInt(tvFrealQty.getText().toString().trim()));
                    }

                    onAddOrderListeners.onConfirm(body);
                }
                Close();
                break;
            case R.id.tv_projectName:
                Projectdialog();
                break;
            case R.id.tv_fmaterialName:
                Materialdialog();
                break;
            case R.id.tv_fstockName:
                Stock();
                break;
        }
    }

    //物料
    private void Materialdialog() {
        final MaterialDialog materialDialog = MaterialDialog.newInstance(mSelect);
        materialDialog.setListener(new MaterialDialog.MaterialSelectListener() {
            @Override
            public void onConfirm(String name, String number, String specification, int position) {
                mSelect = position;
                tvFmaterialName.setText(name);
                tvFmaterialNum.setText(number);
                tvFmaterialSpecification.setText(specification);
                body.setFmaterialName(name);
                body.setFmaterialNumber(number);
                body.setFspecification(specification);
            }

            @Override
            public void onClose() {
                materialDialog.Close();
            }
        });
        materialDialog.show(getActivity().getFragmentManager(), "物料");
    }

    private void Projectdialog() {
        final ProjectDialog projectDialog = ProjectDialog.newInstance(pSelect);
        projectDialog.setListener(new ProjectDialog.ProjectSelectListener() {
            @Override
            public void onConfirm(String name, String number, int position) {
                pSelect = position;
                tvProjectName.setText(name);
                tvProjectNum.setText(number);
                body.setProjectName(name);
                body.setProjectNumber(number);
            }

            @Override
            public void onClose() {
                projectDialog.Close();
            }
        });
        projectDialog.show(getActivity().getFragmentManager(), "物料");
    }

    //仓库
    private void Stock() {
        final StockDialog stockDialog = StockDialog.newInstance(999);
        stockDialog.setListener(new StockDialog.StockSelectListener() {
            @Override
            public void onConfirm(String name, String number, int position) {
                tvFstockName.setText(name);
                body.setFstockStatusName(name);
                body.setFstockNumber(name);
            }

            @Override
            public void onClose() {
                stockDialog.Close();
            }
        });
        stockDialog.show(getActivity().getFragmentManager(), "仓库");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public interface OnAddOrderListener {
        //项目编码  物料编码
        void onConfirm(InStockEntryBean.DataEntity body);

        void onClose();
    }
}
