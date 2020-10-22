package com.jeewms.www.wms.ui.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
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
import com.jeewms.www.wms.bean.MaterialListBean;
import com.jeewms.www.wms.bean.ProjectListBean;

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
    @BindView(R.id.tv_fpurorgNum)
    TextView tvFpurorgNum;
    @BindView(R.id.tv_factreceiveQty)
    TextView tvFactreceiveQty;
    @BindView(R.id.tv_fsupdelQty)
    TextView tvFsupdelQty;
    @BindView(R.id.tv_priceUnitQty)
    TextView tvPriceUnitQty;
    @BindView(R.id.tv_fpriceunitName)
    TextView tvFpriceunitName;
    @BindView(R.id.tv_fpurorgName)
    TextView tvFpurorgName;
    private MaterialListBean.DataEntity materialDate;
    private ProjectListBean.DataEntity projectDate;


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
    public void iniWidow(AppCompatDialog dialog) {
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
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            window.setGravity(Gravity.BOTTOM);
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


    @OnClick({R.id.purchase_order_add_close, R.id.purchase_order_add_complete, R.id.tv_projectName, R.id.tv_fmaterialName, R.id.tv_fstockName})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.purchase_order_add_close:
                if (onAddOrderListeners != null) {
                    onAddOrderListeners.onClose();
                }
                break;
            case R.id.purchase_order_add_complete:
                if (onAddOrderListeners != null) {
                    onAddOrderListeners.onConfirm(materialDate, projectDate);
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

                break;
        }
    }

    private void Materialdialog(){
        final MaterialDialog materialDialog = MaterialDialog.newInstance();
        materialDialog.setListener(new MaterialDialog.MaterialSelectListener() {
            @Override
            public void onConfirm(MaterialListBean.DataEntity dataEntity) {
                materialDate=dataEntity;
                tvFmaterialName.setText(dataEntity.getFname());
                tvFmaterialNum.setText(dataEntity.getFnumber());
                tvFmaterialSpecification.setText(dataEntity.getFspecification());
               // tvFmaterialSpecification.setText(dataEntity.getFdescription());
            }

            @Override
            public void onClose() {
                materialDialog.Close();
            }
        });
        materialDialog.show(getActivity().getSupportFragmentManager(),"物料");
    }

    private void Projectdialog(){
        final ProjectDialog projectDialog = ProjectDialog.newInstance();
        projectDialog.setListener(new ProjectDialog.ProjectSelectListener() {
            @Override
            public void onConfirm(ProjectListBean.DataEntity dataEntity) {
                projectDate=dataEntity;
                tvProjectName.setText(dataEntity.getFname());
                tvProjectNum.setText(dataEntity.getFname());
            }

            @Override
            public void onClose() {
                projectDialog.Close();
            }
        });
        projectDialog.show(getActivity().getSupportFragmentManager(),"物料");
    }

    public interface OnAddOrderListener {
        //项目编码  物料编码
        void onConfirm(MaterialListBean.DataEntity materialDate, ProjectListBean.DataEntity projectDate);

        void onClose();
    }
}
