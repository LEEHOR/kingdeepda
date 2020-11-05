package com.kingdee.ah.pda.ui.activity.productionWarehousing;

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
import com.kingdee.ah.pda.bean.ProductionWareHeadBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.adapter.ProductionWarehosingAdapter;
import com.kingdee.ah.pda.ui.popWindows.DateSelectMenu;
import com.kingdee.ah.pda.ui.popWindows.OnDateSelectListener;
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
 * @Package: com.jeewms.www.wms.ui.activity.productionWarehousing
 * @ClassName: ProductionWarehousingActivity
 * @Description: java类作用描述
 * 生产入库
 * @Author: 作者名
 * @CreateDate: 2020/10/23 11:26
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 11:26
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ProductionWarehousingActivity extends BaseActivity {

    @BindView(R.id.production_warehousing_title)
    TitleTopOrdersView productionWarehousingTitle;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.app_search)
    SearchView appSearch;
    @BindView(R.id.production_recycler)
    RecyclerView productionRecycler;
    @BindView(R.id.production_refresh)
    EasyRefreshLayout productionRefresh;
    @BindView(R.id.menu1)
    TextView menu1;
    @BindView(R.id.menu2)
    TextView menu2;
    private int PAGE = 1;
    private int LIMIT = 10;
    private ProductionWarehosingAdapter warehosingAdapter;
    private Map<String,String> mapParam =new HashMap<>();
    private DateSelectMenu dateSelectMenu;

    @Override
    protected int getContentResId() {
        return R.layout.activity_production_wares;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, ProductionWarehousingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mapParam.clear();
        ivAdd.setVisibility(View.GONE);
        productionWarehousingTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = productionWarehousingTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("生产入库列表");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        warehosingAdapter = new ProductionWarehosingAdapter(R.layout.item_production_warse);
        productionRecycler.setLayoutManager(linearLayoutManager);
        productionRecycler.setAdapter(warehosingAdapter);
        warehosingAdapter.setEmptyView(R.layout.view_error, productionRecycler);
        productionRecycler.addItemDecoration(new SpacesItemDecoration(LocalDisplay.designedDP2px(8), LocalDisplay.designedDP2px(8), getResources().getColor(R.color.transparent)));
    }

    @Override
    protected void initfun() {
        getData(0);
        productionRefresh.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                getData(1);
            }

            @Override
            public void onRefreshing() {
                getData(0);
            }
        });
        warehosingAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
              ProductionWareHeadBean.DataEntity dataEntity= (ProductionWareHeadBean.DataEntity) adapter.getItem(position);

              Intent intent=new Intent(ProductionWarehousingActivity.this,ProductionWarehousingDetailActivity.class);
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
        productionRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
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

        //时间
        dateSelectMenu = new DateSelectMenu(this);
        dateSelectMenu.setOnDateSelectListener(new OnDateSelectListener() {
            @Override
            public void ondismiss() {

            }

            @Override
            public void onSpread() {

            }

            @Override
            public void onSelectDayWeekMonth(String startTime,String endTime, int time2) {
                menu2.setText(startTime);
                dateSelectMenu.dismiss();
            }

            @Override
            public void onSelectTime(long startTime, long endTime, String startTimel, String endTimel) {
                menu2.setText(String.format("%s到%s", startTimel, endTimel));
                dateSelectMenu.dismiss();
            }
        });

    }

        //获取数据
        private void getData(final int type) {
            String prdInstockPage = Constance.getPrdInstockPage();
            if (type == 0) {
                PAGE=1;
                warehosingAdapter.getData().clear();
                warehosingAdapter.notifyDataSetChanged();
            }
            mapParam.put("page",String.valueOf(PAGE));
            mapParam.put("limit",String.valueOf(LIMIT));
            HTTPUtils.getInstance(ProductionWarehousingActivity.this).postByJson(prdInstockPage,
                    ProductionWareHeadBean.class, mapParam, new VolleyListener<ProductionWareHeadBean>() {
                        @Override
                        public void requestComplete() {

                        }

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if (productionRefresh == null && productionRecycler == null) {
                                return;
                            }
                            warehosingAdapter.setEmptyView(R.layout.view_error, productionRecycler);
                            if (type == 0) {
                                productionRefresh.refreshComplete();
                            } else {
                                productionRefresh.loadMoreFail();
                            }
                        }

                        @Override
                        public void onResponse(ProductionWareHeadBean response) {
                            if (productionRefresh == null && productionRecycler == null) {
                                return;
                            }
                            int code = response.getCode();
                            if (code == 0) {
                                PAGE++;
                                List<ProductionWareHeadBean.DataEntity> data = response.getData();
                                if (type == 0) {
                                    warehosingAdapter.setNewData(data);
                                    productionRefresh.refreshComplete();
                                } else {
                                    if (data.size() > 0) {
                                        warehosingAdapter.addData(data);
                                        productionRefresh.loadMoreComplete();
                                    } else {
                                        productionRefresh.loadNothing();
                                    }
                                }
                                warehosingAdapter.setEmptyView(R.layout.view_empt, productionRecycler);
                            } else {
                                warehosingAdapter.setEmptyView(R.layout.view_error, productionRecycler);
                                ToastUtil.show(ProductionWarehousingActivity.this,response.getMsg());
                                if (type == 0) {
                                    productionRefresh.refreshComplete();
                                } else {
                                    productionRefresh.loadMoreFail();
                                }
                            }

                        }
                    });

        }

    @OnClick({R.id.menu1, R.id.menu2,R.id.iv_scan})
    public void onViewClicked(View view) {
        KeyboardUtils.hideKeyboard(appSearch);
        switch (view.getId()) {
            case R.id.menu2:
                break;
            case R.id.iv_scan:
                break;
        }
    }
}
