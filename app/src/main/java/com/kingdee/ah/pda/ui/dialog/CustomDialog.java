package com.kingdee.ah.pda.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ajguan.library.EasyRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseDialogFragment;
import com.kingdee.ah.pda.dataBase.BdCustomer;
import com.kingdee.ah.pda.ui.dialog.adapter.CustomDialogAdapter;
import com.kingdee.ah.pda.util.LitepalSelect;
import com.kingdee.ah.pda.util.LocalDisplay;
import com.kingdee.ah.pda.util.decoration.SpacesItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.dialog
 * @ClassName: MaterialDialog
 * @Description: java类作用描述\
 * 客户列表弹窗
 * @Author: 作者名
 * @CreateDate: 2020/10/22 9:09
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/22 9:09
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class CustomDialog extends BaseDialogFragment {
    @BindView(R.id.dialog_close)
    TextView dialogClose;
    @BindView(R.id.dialog_recycler)
    RecyclerView dialogRecycler;
    @BindView(R.id.dialog_refresh)
    EasyRefreshLayout dialogRefresh;
    private CustomDialogAdapter adapter;

    private int OFFSET = 0;
    private int SELECTION=9999;

    public static CustomDialog newInstance(int selection) {
        CustomDialog purchaseOrderAddDialog = new CustomDialog();
        Bundle bundle = new Bundle();
        bundle.putInt("select", selection);
        purchaseOrderAddDialog.setArguments(bundle);
        return purchaseOrderAddDialog;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_material;
    }

    @Override
    protected void initView() {
        if (getArguments() != null) {
            SELECTION=getArguments().getInt("select");
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        adapter = new CustomDialogAdapter(R.layout.item_dialog_material_select,getActivity());
        dialogRecycler.setLayoutManager(linearLayoutManager);
        dialogRecycler.setAdapter(adapter);
        LocalDisplay.init(getActivity());
        dialogRecycler.addItemDecoration(new SpacesItemDecoration(LocalDisplay.dp2px(5), LocalDisplay.dp2px(5), getResources().getColor(R.color.actions_background_light)));
    }

    @Override
    protected void initFunc() {
        dialogRefresh.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {

            }

            @Override
            public void onRefreshing() {

            }
        });

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
              BdCustomer dataEntity = (BdCustomer) adapter.getItem(position);
                if (listener != null) {
                    listener.onConfirm(dataEntity.getFName(),dataEntity.getFNumber());
                }
                Close();
            }
        });
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

    @Override
    public void onResume() {
        super.onResume();

    }

    @OnClick(R.id.dialog_close)
    public void onViewClicked() {
        if (listener != null) {
            listener.onClose();
        }
    }

    public void Close() {
        this.dismiss();
    }

    private UnitSelectListener listener;

    public void setListener(UnitSelectListener unitSelectListener) {
        this.listener = unitSelectListener;
    }

    public interface UnitSelectListener {
        //项目编码  物料编码
        void onConfirm(String name, String number);

        void onClose();
    }
}
