package com.kingdee.ah.pda.ui.activity.productionPicking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ajguan.library.EasyRefreshLayout;
import com.android.volley.VolleyError;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.ProductionPickHeadBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.adapter.ProductionPickAdapter;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;
import com.kingdee.ah.pda.util.KeyboardUtils;
import com.kingdee.ah.pda.util.LocalDisplay;
import com.kingdee.ah.pda.util.ToastUtil;
import com.kingdee.ah.pda.util.decoration.SpacesItemDecoration;
import com.kingdee.ah.pda.volley.HTTPUtils;
import com.kingdee.ah.pda.volley.VolleyListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity.productionPicking
 * @ClassName: ProductionPickingActivity
 * @Description: java类作用描述
 * 生产领料
 * @Author: 作者名
 * @CreateDate: 2020/10/23 14:21
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 14:21
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ProductionPickingActivity extends BaseActivity {
    @BindView(R.id.production_pick_title)
    TitleTopOrdersView productionPickTitle;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.app_search)
    SearchView appSearch;
    @BindView(R.id.productionpick_recycler)
    RecyclerView productionpickRecycler;
    @BindView(R.id.productionpick_refresh)
    EasyRefreshLayout productionpickRefresh;

    private int PAGE = 1;
    private int LIMIT = 10;
    private ProductionPickAdapter pickAdapter;
    private Map<String,String> mapParams=new HashMap<>();

    @Override
    protected int getContentResId() {
        return R.layout.activity_production_picking;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, ProductionPickingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ivAdd.setVisibility(View.GONE);
        productionPickTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = productionPickTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("生产领料列表");
    }

    @Override
    protected void initfun() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        pickAdapter = new ProductionPickAdapter(R.layout.item_production_picking);
        productionpickRecycler.setLayoutManager(linearLayoutManager);
        productionpickRecycler.setAdapter(pickAdapter);
        productionpickRecycler.addItemDecoration(new SpacesItemDecoration(LocalDisplay.designedDP2px(8), LocalDisplay.designedDP2px(8), getResources().getColor(R.color.transparent)));
        pickAdapter.setEmptyView(R.layout.view_loading2,productionpickRecycler);

        productionpickRefresh.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                getDate(1);
            }

            @Override
            public void onRefreshing() {
                mapParams.clear();
                getDate(0);
            }
        });

        pickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ProductionPickHeadBean.DataEntity dataEntity = (ProductionPickHeadBean.DataEntity) adapter.getItem(position);
                Intent intent=new Intent(ProductionPickingActivity.this,ProductionPickingDetailActivity.class);
                intent.putExtra("fid",dataEntity.getFid());
                intent.putExtra("pageType",0);
                startActivity(intent);
            }
        });

        //recyclerview滚动监听
        productionpickRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
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

        getDate(0);
    }

    private void getDate(final int loadType){
        if (loadType == 0) {
            this.PAGE = 1;
            this.LIMIT = 10;
            pickAdapter.getData().clear();
            pickAdapter.notifyDataSetChanged();
        }
        mapParams.put("page", String.valueOf(PAGE));
        mapParams.put("limit", String.valueOf(LIMIT));
        String getPickMtrl = Constance.getGetPickMtrl();
        HTTPUtils.getInstance(this).postByJson(getPickMtrl, ProductionPickHeadBean.class, mapParams, new VolleyListener<ProductionPickHeadBean>() {

            @Override
            public void requestComplete() {
            }

            @Override
            public void onResponse(ProductionPickHeadBean response) {
                if (pickAdapter == null && productionpickRecycler ==null) {
                    return;
                }
                if (response.getCode() == 0) {
                    PAGE++;
                    List<ProductionPickHeadBean.DataEntity> data = response.getData();
                    if (loadType == 0) {
                        pickAdapter.setNewData(data);
                        productionpickRefresh.refreshComplete();
                    } else {
                        if (data.size() > 0) {
                            pickAdapter.addData(data);
                            productionpickRefresh.loadMoreComplete();
                        } else {
                            productionpickRefresh.loadNothing();
                        }
                    }
                    pickAdapter.setEmptyView(R.layout.view_empt,productionpickRecycler);
                } else {
                    pickAdapter.setEmptyView(R.layout.view_error,productionpickRecycler);
                    ToastUtil.show(ProductionPickingActivity.this,response.getMsg());
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                if (pickAdapter == null && productionpickRecycler ==null) {
                    return;
                }
                pickAdapter.setEmptyView(R.layout.view_error,productionpickRecycler);
                if (loadType == 0) {
                    productionpickRefresh.refreshComplete();
                } else {
                    productionpickRefresh.loadMoreFail();
                }
            }
        });
    }


    @OnClick({R.id.iv_add, R.id.iv_scan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_scan:
                break;
        }
    }
}
