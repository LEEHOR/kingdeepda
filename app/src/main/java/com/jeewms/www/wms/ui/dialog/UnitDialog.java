package com.jeewms.www.wms.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ajguan.library.EasyRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseDialogFragment;
import com.jeewms.www.wms.dataBase.BdSupplier;
import com.jeewms.www.wms.dataBase.BdUnit;
import com.jeewms.www.wms.ui.dialog.adapter.UnitDialogAdapter;
import com.jeewms.www.wms.util.LitepalSelect;
import com.jeewms.www.wms.util.LocalDisplay;
import com.jeewms.www.wms.util.decoration.SpacesItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.dialog
 * @ClassName: MaterialDialog
 * @Description: java类作用描述\
 * 计量单位列表弹窗
 * @Author: 作者名
 * @CreateDate: 2020/10/22 9:09
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/22 9:09
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class UnitDialog extends BaseDialogFragment {
    @BindView(R.id.dialog_close)
    TextView dialogClose;
    @BindView(R.id.dialog_recycler)
    RecyclerView dialogRecycler;
    @BindView(R.id.dialog_refresh)
    EasyRefreshLayout dialogRefresh;
    @BindView(R.id.dialog_title)
    TextView dialogTitle;
    @BindView(R.id.dialog_search)
    SearchView dialogSearch;
    Unbinder unbinder;
    private UnitDialogAdapter adapter;

    private int OFFSET = 0;
    private int SELECTION = 9999;

    public static UnitDialog newInstance(int selection) {
        UnitDialog purchaseOrderAddDialog = new UnitDialog();
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
            SELECTION = getArguments().getInt("select");
        }
        dialogTitle.setText("计量单位选择");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        adapter = new UnitDialogAdapter(R.layout.item_dialog_material_select);
        dialogRecycler.setLayoutManager(linearLayoutManager);
        dialogRecycler.setAdapter(adapter);
        LocalDisplay.init(getActivity());
        dialogRecycler.addItemDecoration(new SpacesItemDecoration(LocalDisplay.dp2px(5), LocalDisplay.dp2px(5), getResources().getColor(R.color.actions_background_light)));
        dialogSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchLike(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchLike(s);
                return false;
            }
        });

    }

    @Override
    protected void initFunc() {
        dialogRefresh.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                getBdUntil(1);
            }

            @Override
            public void onRefreshing() {
                getBdUntil(0);
            }
        });

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                BdUnit dataEntity = (BdUnit) adapter.getItem(position);
                if (listener != null) {
                    listener.onConfirm(dataEntity.getFname(), dataEntity.getFnumber());
                }
                Close();
            }
        });
    }

    @Override
    public void initAnimate() {

    }

    private void searchLike(String s) {
        adapter.getData().clear();
        adapter.notifyDataSetChanged();
        List<BdUnit> byLike = LitepalSelect.findByLike(BdUnit.class, s);
        if (byLike != null && byLike.size() > 0) {
            adapter.setNewData(byLike);
        }
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
        getBdUntil(0);
    }

    @OnClick(R.id.dialog_close)
    public void onViewClicked() {
        if (listener != null) {
            listener.onClose();
        }
    }

    //获取计量单位
    private void getBdUntil(final int type) {
        if (type == 0) {
            this.OFFSET = 0;
            adapter.getData().clear();
            adapter.notifyDataSetChanged();
        }
        List<BdUnit> byAll = LitepalSelect.findByAll(BdUnit.class, OFFSET);
        if (byAll != null) {
            OFFSET += 10;
            if (type == 0) {
                adapter.setSelect(byAll, SELECTION, type);
                dialogRefresh.refreshComplete();
            } else {
                dialogRefresh.loadMoreComplete();
                if (byAll.size() > 0) {
                    adapter.setSelect(byAll, SELECTION, type);
                }
            }
        } else {
            if (type == 0) {
                dialogRefresh.refreshComplete();
            } else {
                dialogRefresh.loadMoreComplete();
            }
        }

    }

    public void Close() {
        this.dismiss();
    }

    private UnitSelectListener listener;

    public void setListener(UnitSelectListener unitSelectListener) {
        this.listener = unitSelectListener;
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

    public interface UnitSelectListener {
        //项目编码  物料编码
        void onConfirm(String name, String number);

        void onClose();
    }
}
