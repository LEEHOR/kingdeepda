package com.kingdee.ah.pda.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ajguan.library.EasyRefreshLayout;
import com.android.volley.VolleyError;
import com.google.zxing.activity.CaptureActivity;
import com.google.zxing.util.Constant;
import com.kingdee.ah.pda.App;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.StockScanBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.adapter.StockScanAdapter;
import com.kingdee.ah.pda.ui.popWindows.MaterialSelectMenu;
import com.kingdee.ah.pda.ui.popWindows.OnStateChangeListener;
import com.kingdee.ah.pda.ui.popWindows.StockSelectMenu;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;
import com.kingdee.ah.pda.util.KeyboardUtils;
import com.kingdee.ah.pda.util.LoadingUtil;
import com.kingdee.ah.pda.util.LocalDisplay;
import com.kingdee.ah.pda.util.ToastUtil;
import com.kingdee.ah.pda.util.decoration.SpacesItemDecoration;
import com.kingdee.ah.pda.volley.HTTPUtils;
import com.kingdee.ah.pda.volley.VolleyListener;
import com.yxp.permission.util.lib.PermissionUtil;
import com.yxp.permission.util.lib.callback.PermissionResultCallBack;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.fragment1
 * @ClassName: StockFragment
 * @Description: java类作用描述
 * 扫码查库存
 * @Author: 作者名
 * @CreateDate: 2020/10/13 10:45
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/13 10:45
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ScanCodeCheckInventoryActivity extends BaseActivity {
    @BindView(R.id.stock_scan_search)
    SearchView stockSearch;
    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.tv_classification)
    TextView tvClassification;
    @BindView(R.id.tv_stock)
    TextView tvStock;
    @BindView(R.id.stock_scan_recycler)
    RecyclerView stockRecycler;
    @BindView(R.id.stock_scan_refresh)
    EasyRefreshLayout stockRefresh;
    @BindView(R.id.stock_scan_title)
    TitleTopOrdersView stockScanTitle;
    @BindView(R.id.cts)
    ConstraintLayout cts;
    @BindView(R.id.cts_1)
    LinearLayout cts1;
    private int PAGE = 1;
    private int LIMIT = 10;
    //精确查询
    private String KEY_MATERIALNUMBER = "materialNumber";
    private String KEY_STOCKNUMBER = "stockNumber";
    private String KEY_GOODBARCODE = "goodBarCode";
    //模糊搜索
    private String key_goodBarCodeLike = "goodBarCodeLike";
    private String key_stockNumberLike = "stockNumberLike";
    private String key_materialNumberLike = "materialNumberLike";
    private StockScanAdapter stockScanAdapter;
    //条件参数
    private Map<String, String> mapParam = new HashMap<>();
    ;
    private StockSelectMenu stockSelectMenu;
    private MaterialSelectMenu materialSelectMenu;

    //
    public static void show(Context context) {
        Intent intent = new Intent(context, ScanCodeCheckInventoryActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_stock_scan_search;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        stockSelectMenu = new StockSelectMenu(this);
        materialSelectMenu = new MaterialSelectMenu(this);
        delete_plate();
        //搜索框文字变化监听
        stockSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                stockSearch.clearFocus();  //可以收起键盘
                mapParam.clear();
                mapParam.put(key_goodBarCodeLike, s);
                mapParam.put(key_stockNumberLike, s);
                mapParam.put(key_materialNumberLike, s);
                getSearch(0, mapParam);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                mapParam.clear();
                mapParam.put(key_goodBarCodeLike, s);
                mapParam.put(key_stockNumberLike, s);
                mapParam.put(key_materialNumberLike, s);
                getSearch(0, mapParam);
                return false;
            }
        });

        stockScanTitle.setViewVisibility(View.VISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE);
        stockScanTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onBackPressed();
            }
        });
        stockScanTitle.getTex_item().setText(getResources().getText(R.string.stock_9));
    }

    @Override
    protected void initfun() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        stockScanAdapter = new StockScanAdapter(R.layout.item_stock_list);
        stockRecycler.setLayoutManager(layoutManager);
        stockRecycler.setAdapter(stockScanAdapter);
        stockRecycler.addItemDecoration(new SpacesItemDecoration(LocalDisplay.designedDP2px(0), LocalDisplay.designedDP2px(8), getResources().getColor(R.color.transparent)));
        stockScanAdapter.setEmptyView(R.layout.view_loading2, stockRecycler);

        stockRefresh.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                getSearch(1, mapParam);

            }

            @Override
            public void onRefreshing() {
                stockSearch.setQuery("", false);
                mapParam.clear();
                getSearch(0, mapParam);
            }
        });

        //recyclerview滚动监听
        stockRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        // appSearch.clearFocus();
                        KeyboardUtils.hideKeyboard(stockSearch);
                        break;
                }
            }
        });

        //仓库分类点击
        stockSelectMenu.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void ondismiss() {

            }

            @Override
            public void onSpread() {
                materialSelectMenu.dismiss();
            }

            @Override
            public void onSelect(String name, String number) {
                stockSelectMenu.dismiss();
                if ("全部".equals(name)) {
                    mapParam.remove(key_stockNumberLike);
                } else {
                    mapParam.put(key_stockNumberLike, number);
                }
                tvStock.setText(name);
                getSearch(0, mapParam);
            }
        });
        //商品分类
        materialSelectMenu.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void ondismiss() {

            }

            @Override
            public void onSpread() {
                stockSelectMenu.dismiss();
            }

            @Override
            public void onSelect(String name, String number) {
                materialSelectMenu.dismiss();
                if ("全部".equals(name)) {
                    mapParam.remove(key_materialNumberLike);
                } else {
                    mapParam.put(key_materialNumberLike, number);
                }
                tvClassification.setText(name);
                getSearch(0, mapParam);
            }
        });
        getSearch(0,mapParam);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    //消除searchView下划线
    private void delete_plate() {
        //去掉searchview下划线 方法二
        try {        //--拿到字节码
            Class<?> argClass = stockSearch.getClass();
            //--指定某个私有属性,mSearchPlate是搜索框父布局的名字
            Field ownField = argClass.getDeclaredField("mSearchPlate");
            //--暴力反射,只有暴力反射才能拿到私有属性
            ownField.setAccessible(true);
            View mView = (View) ownField.get(stockSearch);
            //--设置背景
            mView.setBackgroundColor(Color.TRANSPARENT);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    /**
     * 查询\扫描获取数据的方法
     *
     * @param loadType
     * @param params   查询参数
     */
    private void getSearch(final int loadType, Map<String, String> params) {
        //   LoadingUtil.ShowProgress(getActivity(),"正在加载数据...");
        if (loadType == 0) {
            this.PAGE = 1;
            this.LIMIT = 10;
            stockScanAdapter.getData().clear();
            stockScanAdapter.notifyDataSetChanged();
        }
        params.put("page", String.valueOf(PAGE));
        params.put("limit", String.valueOf(LIMIT));
        String inventoryUrl = Constance.getInventory();
        HTTPUtils.getInstance(this).postByJson(inventoryUrl, StockScanBean.class, params, new VolleyListener<StockScanBean>() {

            @Override
            public void requestComplete() {
            }

            @Override
            public void onResponse(StockScanBean response) {
                if (stockScanAdapter == null && stockRecycler ==null) {
                    return;
                }
                    if (response.getCode() == 0) {
                        PAGE++;
                        List<StockScanBean.DataEntity> data = response.getData();
                            if (loadType == 0) {
                                stockScanAdapter.setNewData(data);
                                stockRefresh.refreshComplete();
                            } else {
                                if (data.size() > 0) {
                                    stockScanAdapter.addData(data);
                                    stockRefresh.loadMoreComplete();
                                } else {
                                    stockRefresh.loadNothing();
                                }
                            }
                            stockScanAdapter.setEmptyView(R.layout.view_empt,stockRecycler);
                    } else {
                        stockScanAdapter.setEmptyView(R.layout.view_error,stockRecycler);
                        ToastUtil.show(ScanCodeCheckInventoryActivity.this,response.getMsg());
                    }
                }

            @Override
            public void onErrorResponse(VolleyError error) {
                if (stockScanAdapter == null && stockRecycler ==null) {
                    return;
                }
                stockScanAdapter.setEmptyView(R.layout.view_error,stockRecycler);
                if (loadType == 0) {
                    stockRefresh.refreshComplete();
                } else {
                    stockRefresh.loadMoreFail();
                }
            }
        });
    }

    @OnClick(R.id.iv_scan)
    public void onViewClicked() {
        wantCameraPermission();
    }

    //申请相机权限
    private void wantCameraPermission() {
        PermissionUtil.getInstance().request(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA, Manifest.permission.VIBRATE}, new PermissionResultCallBack() {
            @Override
            public void onPermissionGranted() {
                Intent intent = new Intent(ScanCodeCheckInventoryActivity.this, CaptureActivity.class);
                startActivityForResult(intent, Constant.REQ_QR_CODE);
            }

            @Override
            public void onPermissionGranted(String... strings) {

            }

            @Override
            public void onPermissionDenied(String... strings) {

            }

            @Override
            public void onRationalShow(String... strings) {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.fromParts("package", App.getmApplicationContext().getPackageName(), null));
                startActivity(intent);
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //扫描结果回调
        if (requestCode == Constant.REQ_QR_CODE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString(Constant.INTENT_EXTRA_KEY_QR_SCAN);
            //将扫描出的信息显示出来并搜索
            stockSearch.setQuery(scanResult, false);
            //搜索
            mapParam.clear();
            mapParam.put(KEY_STOCKNUMBER, scanResult);
            getSearch(0, mapParam);
        }
    }


    @OnClick({R.id.tv_classification, R.id.tv_stock})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_classification:
                KeyboardUtils.hideKeyboard(stockSearch);
                if (materialSelectMenu != null && !materialSelectMenu.isMenuOpen()) {
                    materialSelectMenu.showAsDropDown(cts1);
                }
                break;
            case R.id.tv_stock:
                KeyboardUtils.hideKeyboard(stockSearch);
                if (stockSelectMenu != null && !stockSelectMenu.isMenuOpen()) {
                    stockSelectMenu.showAsDropDown(cts1);
                }
                break;
        }
    }
}

