package com.jeewms.www.wms.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ajguan.library.EasyRefreshLayout;
import com.android.volley.VolleyError;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseDialogFragment;
import com.jeewms.www.wms.bean.MaterialListBean;
import com.jeewms.www.wms.bean.SupplierBean;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.dialog.adapter.MaterialDialogAdapter;
import com.jeewms.www.wms.ui.dialog.adapter.SupplierDialogAdapter;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.LocalDisplay;
import com.jeewms.www.wms.util.decoration.SpacesItemDecoration;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.dialog
 * @ClassName: MaterialDialog
 * @Description: java类作用描述\
 * 供应商列表弹窗
 * @Author: 作者名
 * @CreateDate: 2020/10/22 9:09
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/22 9:09
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class SupplierDialog extends BaseDialogFragment {
    @BindView(R.id.dialog_close)
    TextView dialogClose;
    @BindView(R.id.dialog_recycler)
    RecyclerView dialogRecycler;
    @BindView(R.id.dialog_refresh)
    EasyRefreshLayout dialogRefresh;
    private SupplierDialogAdapter adapter;
    private int PAGE = 1;
    private int LIMIT = 10;

    public static SupplierDialog newInstance() {
        SupplierDialog purchaseOrderAddDialog = new SupplierDialog();
        return purchaseOrderAddDialog;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.dialog_material;
    }

    @Override
    protected void initView() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        adapter = new SupplierDialogAdapter(R.layout.item_dialog_material_select);
        dialogRecycler.setLayoutManager(linearLayoutManager);
        dialogRecycler.setAdapter(adapter);
        LocalDisplay.init(getActivity());
        dialogRecycler.addItemDecoration(new SpacesItemDecoration(LocalDisplay.dp2px(5),LocalDisplay.dp2px(5),getResources().getColor(R.color.actions_background_light)));
    }

    @Override
    protected void initFunc() {
        dialogRefresh.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                getMaterialList(1);
            }

            @Override
            public void onRefreshing() {
                getMaterialList(0);
            }
        });

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SupplierBean.DataEntity dataEntity= (SupplierBean.DataEntity) adapter.getItem(position);
                if (listener != null) {
                    listener.onConfirm(dataEntity);
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
        getMaterialList(0);
    }
    @OnClick(R.id.dialog_close)
    public void onViewClicked() {
        if (listener != null) {
            listener.onClose();
        }
    }

    private void getMaterialList(final int type){
        if (type==0) {
            this.PAGE=1;
            adapter.getData().clear();
            adapter.notifyDataSetChanged();
        }
        String supplier = Constance.getSupplier();
        String s = supplier + "?" + "page=" + PAGE + "&limit=" + LIMIT;
        HTTPUtils.get(getActivity(), s, new VolleyListener<String>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                if (type == 1) {
                    dialogRefresh.refreshComplete();
                } else {
                    dialogRefresh.loadMoreFail();
                }
            }

            @Override
            public void onResponse(String response) {
                SupplierBean vm = GsonUtils.parseJSON(response, SupplierBean.class);
                if (vm.getCode()==0){
                    PAGE++;
                    List<SupplierBean.DataEntity> data = vm.getData();
                    if (type==0){
                        adapter.setNewData(vm.getData());
                        dialogRefresh.refreshComplete();
                    } else {
                        dialogRefresh.loadMoreComplete();
                        if (data.size() > 0) {
                            adapter.addData(data);
                        }
                    }
                } else {
                    if (type==0){
                        dialogRefresh.refreshComplete();
                    } else {
                        dialogRefresh.loadMoreComplete();
                    }
                }
            }
        });
    }

    public void Close() {
        this.dismiss();
    }
    private SupplierSelectListener listener;

    public void setListener(SupplierSelectListener supplierSelectListener) {
        this.listener = supplierSelectListener;
    }

    public interface SupplierSelectListener {
        //项目编码  物料编码
        void onConfirm(SupplierBean.DataEntity dataEntity);

        void onClose();
    }
}
