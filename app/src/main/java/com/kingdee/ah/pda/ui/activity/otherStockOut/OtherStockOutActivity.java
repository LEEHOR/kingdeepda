package com.kingdee.ah.pda.ui.activity.otherStockOut;

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
import com.kingdee.ah.pda.App;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.OtherStockHeadBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.adapter.OtherStockListAdapter;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;
import com.kingdee.ah.pda.util.KeyboardUtils;
import com.kingdee.ah.pda.util.LocalDisplay;
import com.kingdee.ah.pda.util.ToastUtil;
import com.kingdee.ah.pda.util.decoration.SpacesItemDecoration;
import com.kingdee.ah.pda.volley.NetworkUtil;
import com.kingdee.ah.pda.volley.VolleyListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity.otherStockOut
 * @ClassName: OtherStockOutActivity
 * @Description: java类作用描述
 * 其它出库
 * @Author: 作者名
 * @CreateDate: 2020/10/23 14:22
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 14:22
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class OtherStockOutActivity extends BaseActivity {
    @BindView(R.id.other_stock_out_title)
    TitleTopOrdersView otherStockOutTitle;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.app_search)
    SearchView appSearch;
    @BindView(R.id.other_recycler)
    RecyclerView otherRecycler;
    @BindView(R.id.other_refresh)
    EasyRefreshLayout otherRefresh;
    private OtherStockListAdapter stockListAdapter;
    private Map<String,String> mapParam=new HashMap<>();
    private int PAGE = 1;
    private int LIMIT = 10;

    @Override
    protected int getContentResId() {
        return R.layout.activity_other_stock_out;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, OtherStockOutActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        mapParam.clear();
        otherStockOutTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = otherStockOutTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("其他出库列表");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        stockListAdapter = new OtherStockListAdapter(R.layout.item_other_stock_out);
        otherRecycler.setLayoutManager(linearLayoutManager);
        otherRecycler.setAdapter(stockListAdapter);
        stockListAdapter.setEmptyView(R.layout.view_loading2, otherRecycler);
        otherRecycler.addItemDecoration(new SpacesItemDecoration(LocalDisplay.designedDP2px(8), LocalDisplay.designedDP2px(8), getResources().getColor(R.color.transparent)));
    }

    @Override
    protected void initfun() {
        getData(0);
        otherRefresh.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                getData(1);
            }

            @Override
            public void onRefreshing() {
                getData(0);
            }
        });

        stockListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                OtherStockHeadBean.DataEntity dataEntity= (OtherStockHeadBean.DataEntity) adapter.getItem(position);
                Intent intent=new Intent(OtherStockOutActivity.this, OtherStockOutDetailActivity.class);
                intent.putExtra("fid",dataEntity.getFid());
                intent.putExtra("pageType",1);
                startActivity(intent);
            }
        });

        appSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                mapParam.put("billNo",s);
                getData(0);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                mapParam.put("billNo",s);
                getData(0);
                return false;
            }
        });

        //recyclerview滚动监听
        otherRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        KeyboardUtils.hideKeyboard(appSearch);
                        break;
                }
            }
        });
    }

    //获取数据
    private void getData(final int type) {
        String misdeliveryPage = Constance.getMisdeliveryPage();
        if (type == 0) {
            PAGE=1;
            stockListAdapter.getData().clear();
            stockListAdapter.notifyDataSetChanged();
        }
        mapParam.put("page",String.valueOf(PAGE));
        mapParam.put("limit",String.valueOf(LIMIT));
        NetworkUtil.getInstance().postByJson(OtherStockOutActivity.this,misdeliveryPage,
                OtherStockHeadBean.class, mapParam, new VolleyListener<OtherStockHeadBean>() {
                    @Override
                    public void requestComplete() {

                    }

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        stockListAdapter.setEmptyView(R.layout.view_error, otherRecycler);
                        if (type == 0) {
                            otherRefresh.refreshComplete();
                        } else {
                            otherRefresh.loadMoreFail();
                        }
                    }

                    @Override
                    public void onResponse(OtherStockHeadBean response) {
                        int code = response.getCode();
                        if (code == 0) {
                            PAGE++;
                            List<OtherStockHeadBean.DataEntity> data = response.getData();
                            if (type == 0) {
                                stockListAdapter.setNewData(data);
                                otherRefresh.refreshComplete();
                            } else {
                                if (data.size() > 0) {
                                    stockListAdapter.addData(data);
                                    otherRefresh.loadMoreComplete();
                                } else {
                                    otherRefresh.loadNothing();
                                }
                            }
                            stockListAdapter.setEmptyView(R.layout.view_empt, otherRecycler);
                        } else {
                            stockListAdapter.setEmptyView(R.layout.view_error, otherRecycler);
                            ToastUtil.show(OtherStockOutActivity.this,response.getMsg());
                            if (type == 0) {
                                otherRefresh.refreshComplete();
                            } else {
                                otherRefresh.loadMoreFail();
                            }
                        }

                    }
                });

    }



    @OnClick({R.id.iv_add, R.id.iv_scan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_add:
                OtherStockOutAddActivity.show(this);
                break;
            case R.id.iv_scan:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.sRequestQueue.cancelAll(OtherStockOutActivity.this.getClass().getName());
    }
}
