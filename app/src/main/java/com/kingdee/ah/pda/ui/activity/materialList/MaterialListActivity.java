package com.kingdee.ah.pda.ui.activity.materialList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.kingdee.ah.pda.bean.MaterialHeadBean;
import com.kingdee.ah.pda.bean.ReceivePushBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.activity.productionPicking.ProductionPickingDetailActivity;
import com.kingdee.ah.pda.ui.adapter.MaterialListAdapter;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;
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
 * @Package: com.jeewms.www.wms.ui.activity.materialList
 * @ClassName: MaterialListActivity
 * @Description: java类作用描述
 * 用料清单列表页
 * @Author: 作者名
 * @CreateDate: 2020/10/23 14:13
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 14:13
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MaterialListActivity extends BaseActivity {
    @BindView(R.id.material_list_title)
    TitleTopOrdersView materialListTitle;
    @BindView(R.id.app_search)
    SearchView appSearch;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.material_recycler)
    RecyclerView materialRecycler;
    @BindView(R.id.material_refresh)
    EasyRefreshLayout materialRefresh;

    private int PAGE = 1;
    private int LIMIT = 10;
    private Map<String, String> map = new HashMap<>();
    private MaterialListAdapter listAdapter;

    @Override
    protected int getContentResId() {
        return R.layout.activity_material_list;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, MaterialListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ivAdd.setVisibility(View.GONE);
        materialListTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = materialListTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("用料清单列表");
        listAdapter = new MaterialListAdapter(R.layout.item_material);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        materialRecycler.setLayoutManager(linearLayoutManager);
        materialRecycler.setAdapter(listAdapter);
        listAdapter.setEmptyView(R.layout.view_loading2, materialRecycler);
        materialRecycler.addItemDecoration(new SpacesItemDecoration(LocalDisplay.designedDP2px(8), LocalDisplay.designedDP2px(8), getResources().getColor(R.color.transparent)));
    }

    @Override
    protected void initfun() {
        map.clear();
        getData(0);
        materialRefresh.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
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
        listAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                int id = view.getId();
                MaterialHeadBean.DataEntity dataEntity = (MaterialHeadBean.DataEntity) adapter.getItem(position);
                switch (id) {
                    case R.id.btn_detail:
                        Intent intent = new Intent(MaterialListActivity.this, MaterialListDetailActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putSerializable("head",dataEntity);
                        intent.putExtra("materialBundle",bundle);
                        startActivity(intent);
                        break;
                    case R.id.btn_push:
                        pushDate(dataEntity.getFid());
                        break;
                }
            }
        });
    }

    //获取数据
    private void getData(final int type) {
        if (type == 0) {
            this.PAGE = 1;
            listAdapter.getData().clear();
            listAdapter.notifyDataSetChanged();
        }
        map.put("limit", String.valueOf(LIMIT));
        map.put("page", String.valueOf(PAGE));
        String prdPpbomHead = Constance.getPrdPpbomHead();
        HTTPUtils.getInstance(this).postByJson(prdPpbomHead, MaterialHeadBean.class, map, new VolleyListener<MaterialHeadBean>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                if (listAdapter == null && materialRecycler == null) {
                    return;
                }
                if (type == 0) {
                    materialRefresh.refreshComplete();
                } else {
                    materialRefresh.loadMoreFail();
                }
                listAdapter.setEmptyView(R.layout.view_error, materialRecycler);
            }

            @Override
            public void onResponse(MaterialHeadBean response) {
                if (listAdapter == null && materialRecycler == null) {
                    return;
                }
                int code = response.getCode();
                if (code == 0) {
                    PAGE++;
                    List<MaterialHeadBean.DataEntity> data = response.getData();
                    if (type == 0) {
                        listAdapter.setNewData(data);
                        materialRefresh.refreshComplete();
                    } else {
                        if (data.size() > 0) {
                            listAdapter.addData(data);
                            materialRefresh.loadMoreComplete();
                        } else {
                            materialRefresh.loadNothing();
                        }
                    }
                    listAdapter.setEmptyView(R.layout.view_empt, materialRecycler);
                } else {
                    if (type == 0) {
                        materialRefresh.refreshComplete();
                    } else {
                        materialRefresh.loadMoreFail();
                    }
                    listAdapter.setEmptyView(R.layout.view_error, materialRecycler);
                }


            }
        });
    }

    //下推
    private void pushDate(int fid) {
        Map<String, String> map = new HashMap<>();
        map.put("fid", String.valueOf(fid));
        ShowProgress(this, "正在下推...", false);
        String pushReceiving = Constance.getPushReceiving();
        HTTPUtils.getInstance(this).postByJson(pushReceiving, ReceivePushBean.class, map, new VolleyListener<ReceivePushBean>() {
            @Override
            public void onResponse(ReceivePushBean response) {
                int code = response.getCode();
                if (code == 0) {
                    ToastUtil.show(MaterialListActivity.this, response.getMsg());
                    //跳转到采购入库详情
                    Intent intent1 = new Intent(MaterialListActivity.this, ProductionPickingDetailActivity.class);
                    Bundle bundle1 = new Bundle();
                    bundle1.putInt("fid", response.getData().getId());
                    bundle1.putString("fnumber", response.getData().getNumber());
                    intent1.putExtras(bundle1);
                    startActivity(intent1);
                } else {
                    ToastUtil.show(MaterialListActivity.this, response.getMsg());
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtil.show(MaterialListActivity.this, error.getMessage());
            }

            @Override
            public void requestComplete() {
                CancelProgress();
            }
        });
    }

    @OnClick(R.id.iv_scan)
    public void onViewClicked() {
    }
}
