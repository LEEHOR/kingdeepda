package com.kingdee.ah.pda.ui.activity.deliverNotice;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
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
import com.kingdee.ah.pda.bean.ReceiveBillBean;
import com.kingdee.ah.pda.bean.SalDeliverynoticeBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.activity.receive.ReceiveNoticeActivity;
import com.kingdee.ah.pda.ui.adapter.SalDeliverNoticeAdapter;
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
import java.util.function.Predicate;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity.deliverNotice
 * @ClassName: DeliveryNoticeActivity
 * @Description: java类作用描述
 * 发货通知
 * @Author: 作者名
 * @CreateDate: 2020/10/23 13:51
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 13:51
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class DeliveryNoticeActivity extends BaseActivity {
    @BindView(R.id.delivery_notice_title)
    TitleTopOrdersView deliveryNoticeTitle;
    @BindView(R.id.app_search)
    SearchView appSearch;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.salDeliverNotice_recycler)
    RecyclerView salDeliverNoticeRecycler;
    @BindView(R.id.salDeliverNotice_refresh)
    EasyRefreshLayout salDeliverNoticeRefresh;
    private SalDeliverNoticeAdapter noticeAdapter;

    private int PAGE = 1;
    private int LIMIT = 10;

    //条件参数
    private Map<String, String> mapParam = new HashMap<>();

    @Override
    protected int getContentResId() {
        return R.layout.activity_delivery_notice;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, DeliveryNoticeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ivAdd.setVisibility(View.GONE);
        deliveryNoticeTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = deliveryNoticeTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("发货通知列表");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        noticeAdapter = new SalDeliverNoticeAdapter(R.layout.item_sales_deliver_notice);
        salDeliverNoticeRecycler.setLayoutManager(linearLayoutManager);
        salDeliverNoticeRecycler.setAdapter(noticeAdapter);
        noticeAdapter.setEmptyView(R.layout.view_loading2, salDeliverNoticeRecycler);
        salDeliverNoticeRecycler.addItemDecoration(new SpacesItemDecoration(LocalDisplay.designedDP2px(8), LocalDisplay.designedDP2px(8), getResources().getColor(R.color.transparent)));
    }

    @Override
    protected void initfun() {
        mapParam.clear();
        getData(0);
        salDeliverNoticeRefresh.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                getData(1);
            }

            @Override
            public void onRefreshing() {
                mapParam.clear();
                getData(0);
            }
        });
        noticeAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                int id = view.getId();
                switch (id){
                    case R.id.btn_detail:
                        break;
                    case R.id.btn_push:
                        break;
                }
            }
        });

        //recyclerview滚动监听
        salDeliverNoticeRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
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

    //获取发货通知列表数据
    private void getData(final int loadType) {
        if (loadType == 0) {
            this.PAGE = 1;
            this.LIMIT = 10;
            noticeAdapter.getData().clear();
            noticeAdapter.notifyDataSetChanged();
        }
        mapParam.put("page", String.valueOf(PAGE));
        mapParam.put("limit", String.valueOf(LIMIT));
        String salDeliverynotice = Constance.getSalDeliverynotice();
        HTTPUtils.getInstance(this).postByJson(salDeliverynotice, SalDeliverynoticeBean.class, mapParam, new VolleyListener<SalDeliverynoticeBean>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                if (noticeAdapter == null && salDeliverNoticeRecycler == null) {
                    return;
                }
                if (loadType == 0) {
                    salDeliverNoticeRefresh.refreshComplete();
                } else {
                    salDeliverNoticeRefresh.loadMoreFail();
                }
                noticeAdapter.setEmptyView(R.layout.view_error, salDeliverNoticeRecycler);
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(SalDeliverynoticeBean response) {
                if (noticeAdapter == null && salDeliverNoticeRecycler == null) {
                    return;
                }
                int code = response.getCode();
                if (code == 0) {
                    PAGE++;
                    List<SalDeliverynoticeBean.DataEntity> data = response.getData();
                    if (loadType == 0) {
                        noticeAdapter.setNewData(data);
                        salDeliverNoticeRefresh.refreshComplete();
                    } else {
                        if (data.size() > 0) {
                            salDeliverNoticeRefresh.loadMoreComplete();
                            noticeAdapter.addData(data);
                        } else {
                            salDeliverNoticeRefresh.loadNothing();
                        }

                    }
                    noticeAdapter.setEmptyView(R.layout.view_empt, salDeliverNoticeRecycler);
                } else {
                    if (loadType == 0) {
                        salDeliverNoticeRefresh.refreshComplete();
                    } else {
                        salDeliverNoticeRefresh.loadMoreFail();
                    }
                    noticeAdapter.setEmptyView(R.layout.view_error, salDeliverNoticeRecycler);
                    ToastUtil.show(DeliveryNoticeActivity.this, response.getMsg());
                }
            }
        });

    }


    @OnClick(R.id.iv_scan)
    public void onViewClicked() {

    }
}
