package com.kingdee.ah.pda.ui.activity.warehouseOutApplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.ajguan.library.EasyRefreshLayout;
import com.android.volley.VolleyError;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.OutStockApplyBean;
import com.kingdee.ah.pda.bean.OutStockPushBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.activity.otherStockOut.OtherStockOutDetailActivity;
import com.kingdee.ah.pda.ui.adapter.OutStockAdapter;
import com.kingdee.ah.pda.ui.dialog.MsgShowDialog;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;
import com.kingdee.ah.pda.util.GsonUtils;
import com.kingdee.ah.pda.util.KeyboardUtils;
import com.kingdee.ah.pda.util.LocalDisplay;
import com.kingdee.ah.pda.util.ToastUtil;
import com.kingdee.ah.pda.util.decoration.SpacesItemDecoration;
import com.kingdee.ah.pda.volley.HTTPUtils;
import com.kingdee.ah.pda.volley.VolleyListener;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity.WarehouseOutApplication
 * @ClassName: WarehousOutApplicationActivity
 * @Description: java类作用描述
 * 出库申请列表
 * @Author: 作者名
 * @CreateDate: 2020/10/23 13:38
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 13:38
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class WarehouseOutApplicationActivity extends BaseActivity {
    @BindView(R.id.out_title)
    TitleTopOrdersView outTitle;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.app_search)
    SearchView appSearch;
    @BindView(R.id.outStock_recycler)
    RecyclerView outStockRecycler;
    @BindView(R.id.outStock_refresh)
    EasyRefreshLayout outStockRefresh;
    private int PAGE = 1;
    private int LIMIT = 10;
    private Map<String, String> map = new HashMap<>();
    private OutStockAdapter stockAdapter;

    @Override
    protected int getContentResId() {
        return R.layout.activity_warehouse_out_application;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, WarehouseOutApplicationActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ivAdd.setVisibility(View.GONE);
        outTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = outTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("出库申请列表");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        stockAdapter = new OutStockAdapter(R.layout.item_warehousing_out);
        outStockRecycler.setLayoutManager(linearLayoutManager);
        outStockRecycler.setAdapter(stockAdapter);
        outStockRecycler.addItemDecoration(new SpacesItemDecoration(LocalDisplay.designedDP2px(8), LocalDisplay.designedDP2px(8), getResources().getColor(R.color.transparent)));
        stockAdapter.setEmptyView(R.layout.view_loading2, outStockRecycler);
    }

    @Override
    protected void initfun() {
        getData(0);
        outStockRefresh.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                getData(1);
            }

            @Override
            public void onRefreshing() {
                map.clear();
                getData(0);
            }
        });

        stockAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                int id = view.getId();
                OutStockApplyBean.DataEntity outStockApplyBean = (OutStockApplyBean.DataEntity) adapter.getItem(position);

                switch (id) {
                    case R.id.btn_detail:
                        Intent intent = new Intent(WarehouseOutApplicationActivity.this, WarehouseOutApplicationDetailActivity.class);
                        intent.putExtra("fid", outStockApplyBean.getId());
                        startActivity(intent);
                        break;
                    case R.id.btn_push:
                        push(outStockApplyBean.getId());
                        break;
                }
            }
        });
        //recyclerview滚动监听
        outStockRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        // appSearch.clearFocus();
                        KeyboardUtils.hideKeyboard(appSearch);
                        break;
                }
            }
        });

    }

    //获取数据
    private void getData(final int type) {
        if (type == 0) {
            this.PAGE = 1;
            stockAdapter.getData().clear();
            stockAdapter.notifyDataSetChanged();
        }
        map.put("limit", String.valueOf(LIMIT));
        map.put("page",String.valueOf(PAGE));
        String outstockapply = Constance.getOUTSTOCKAPPLY();
        HTTPUtils.getInstance(this).postByJson(outstockapply, OutStockApplyBean.class, map, new VolleyListener<OutStockApplyBean>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                if (stockAdapter == null && outStockRecycler == null) {
                    return;
                }
                if (type == 0) {
                    outStockRefresh.refreshComplete();
                } else {
                    outStockRefresh.loadMoreFail();
                }
                stockAdapter.setEmptyView(R.layout.view_error, outStockRecycler);
            }

            @Override
            public void onResponse(OutStockApplyBean response) {
                if (stockAdapter == null && outStockRecycler == null) {
                    return;
                }
                int code = response.getCode();
                if (code == 0) {
                    PAGE++;
                    List<OutStockApplyBean.DataEntity> data = response.getData();
                    if (type == 0) {
                        stockAdapter.setNewData(data);
                        outStockRefresh.refreshComplete();
                    } else {
                        if (data.size() > 0) {
                            stockAdapter.addData(data);
                            outStockRefresh.loadMoreComplete();
                        } else {
                            outStockRefresh.loadNothing();
                        }
                    }
                    stockAdapter.setEmptyView(R.layout.view_empt, outStockRecycler);
                } else {
                    if (type == 0) {
                        outStockRefresh.refreshComplete();
                    } else {
                        outStockRefresh.loadMoreFail();
                    }
                    stockAdapter.setEmptyView(R.layout.view_error, outStockRecycler);
                }


            }
        });
    }

    //下推
    private void push(int id) {
        final String outstockpush = Constance.getOUTSTOCKPUSH();
        HTTPUtils.getInstance(this).get(outstockpush + id, new VolleyListener<String>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onResponse(String response) {
                OutStockPushBean outStockPushBean = GsonUtils.parseJSON(response, OutStockPushBean.class);
                int code = outStockPushBean.getCode();
                if (code == 0) {
                    Intent intent = new Intent(WarehouseOutApplicationActivity.this, OtherStockOutDetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("outstock", outStockPushBean);
                    intent.putExtra("pageType",1);
                    intent.putExtra("outDetail", bundle);
                    startActivity(intent);
                } else if (code == 500) {
                    MsgShowDialog msgShowDialog = MsgShowDialog.newInstance(outStockPushBean.getMsg());
                    msgShowDialog.show(getSupportFragmentManager(), "msg");
                } else {
                    ToastUtil.show(WarehouseOutApplicationActivity.this, outStockPushBean.getMsg());
                }
            }
        });
    }


    @OnClick(R.id.iv_scan)
    public void onViewClicked() {

    }
}
