package com.jeewms.www.wms.ui.activity.purchaseWarehousing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ajguan.library.EasyRefreshLayout;
import com.android.volley.VolleyError;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity;
import com.jeewms.www.wms.bean.InStockHeadBean;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.activity.receive.ReceiveNoticeActivity;
import com.jeewms.www.wms.ui.adapter.PurchaseWarehousingAdapter;
import com.jeewms.www.wms.ui.view.TitleTopOrdersView;
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
 * @Package: com.jeewms.www.wms.ui.activity.receiving
 * @ClassName: ReceivingPushDown
 * @Description: java类作用描述
 * 采购入库列表页
 * @Author: 作者名
 * @CreateDate: 2020/10/19 19:10
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/19 19:10
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class PurchaseWarehousingActivity extends BaseActivity {

    @BindView(R.id.purchase_warehousing_title)
    TitleTopOrdersView purchaseWarehousingTitle;
    @BindView(R.id.purchase_recycler)
    RecyclerView purchaseRecycler;
    @BindView(R.id.purchase_order_refresh)
    EasyRefreshLayout purchaseOrderRefresh;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_scan)
    ImageView ivScan;
    private PurchaseWarehousingAdapter adapter;
    //条件参数
    private Map<String, String> mapParam = new HashMap<>();
    ;
    private int PAGE = 1;
    private int LIMIT = 10;

    @Override
    protected int getContentResId() {
        return R.layout.activity_purchase_warehousing;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, PurchaseWarehousingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        purchaseWarehousingTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TextView tex_item = purchaseWarehousingTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("采购入库列表");
    }

    @Override
    protected void initfun() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        adapter = new PurchaseWarehousingAdapter(R.layout.item_purchase_order_list);
        purchaseRecycler.setLayoutManager(linearLayoutManager);
        purchaseRecycler.setAdapter(adapter);
        purchaseRecycler.addItemDecoration(new SpacesItemDecoration(LocalDisplay.designedDP2px(8), LocalDisplay.designedDP2px(8), getResources().getColor(R.color.transparent)));
        purchaseOrderRefresh.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                getDate(1, mapParam);
            }

            @Override
            public void onRefreshing() {
                getDate(0, mapParam);
            }
        });


        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                InStockHeadBean.DataEntity item = (InStockHeadBean.DataEntity) adapter.getItem(position);
                Intent intent1 = new Intent(PurchaseWarehousingActivity.this, PurchaseWarehousingDetailActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putInt("fid", item.getFid());
                bundle1.putString("fnumber", item.getFbillNo());
                intent1.putExtras(bundle1);
                startActivity(intent1);
            }
        });
        getDate(0, mapParam);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    //获取数据
    private void getDate(final int loadType, Map<String, String> params) {
        if (loadType == 0) {
            this.PAGE = 0;
            this.LIMIT = 10;
            adapter.getData().clear();
            adapter.notifyDataSetChanged();
        }
        params.put("page", String.valueOf(PAGE));
        params.put("limit", String.valueOf(LIMIT));
        String getstkInStock = Constance.getGetstkInStock();
        HTTPUtils.getInstance(this).postByJson(PurchaseWarehousingActivity.this, getstkInStock, InStockHeadBean.class, params, new VolleyListener<InStockHeadBean>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                if (loadType == 0) {
                    purchaseOrderRefresh.refreshComplete();
                } else {
                    purchaseOrderRefresh.loadMoreFail();
                }

            }

            @Override
            public void onResponse(InStockHeadBean response) {
                if (response.getCode() == 0) {
                    PAGE++;
                    List<InStockHeadBean.DataEntity> data = response.getData();
                    if (loadType == 0) {
                        adapter.setNewData(data);
                        purchaseOrderRefresh.refreshComplete();
                    } else {
                        if (data.size() > 0) {
                            adapter.addData(data);
                        }
                        purchaseOrderRefresh.loadMoreComplete();
                    }
                } else {
                    if (loadType == 0) {
                        purchaseOrderRefresh.refreshComplete();
                    } else {
                        purchaseOrderRefresh.loadMoreComplete();
                    }
                }

            }
        });
//        HTTPUtils.postByJson(PurchaseWarehousingActivity.this, getstkInStock, InStockHeadBean.class, params, new VolleyListener<InStockHeadBean>() {
//            @Override
//            public void requestComplete() {
//
//            }
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                if (loadType == 0) {
//                    purchaseOrderRefresh.refreshComplete();
//                } else {
//                    purchaseOrderRefresh.loadMoreFail();
//                }
//
//            }
//
//            @Override
//            public void onResponse(InStockHeadBean response) {
//                if (response.getCode() == 0) {
//                    PAGE++;
//                    List<InStockHeadBean.DataEntity> data = response.getData();
//                    if (loadType == 0) {
//                        adapter.setNewData(data);
//                        purchaseOrderRefresh.refreshComplete();
//                    } else {
//                        if (data.size() > 0) {
//                            adapter.addData(data);
//                        }
//                        purchaseOrderRefresh.loadMoreComplete();
//                    }
//                } else {
//                    if (loadType == 0) {
//                        purchaseOrderRefresh.refreshComplete();
//                    } else {
//                        purchaseOrderRefresh.loadMoreComplete();
//                    }
//                }
//
//            }
//        });
    }
    @OnClick({R.id.iv_add, R.id.iv_scan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_add:
                PurchaseWarehousingAddActivity.show(this);
                break;
            case R.id.iv_scan:
                break;
        }
    }
}
