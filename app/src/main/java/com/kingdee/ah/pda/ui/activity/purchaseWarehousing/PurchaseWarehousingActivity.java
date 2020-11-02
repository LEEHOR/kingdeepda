package com.kingdee.ah.pda.ui.activity.purchaseWarehousing;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
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
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.zxing.activity.CaptureActivity;
import com.google.zxing.util.Constant;
import com.kingdee.ah.pda.App;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.InStockHeadBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.adapter.PurchaseWarehousingAdapter;
import com.kingdee.ah.pda.ui.popWindows.CommonSelectMenu;
import com.kingdee.ah.pda.ui.popWindows.DateSelectMenu;
import com.kingdee.ah.pda.ui.popWindows.OnDateSelectListener;
import com.kingdee.ah.pda.ui.popWindows.OnStateChangeListener;
import com.kingdee.ah.pda.ui.popWindows.SupplierSelectMenu;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;
import com.kingdee.ah.pda.util.LocalDisplay;
import com.kingdee.ah.pda.util.ToastUtil;
import com.kingdee.ah.pda.util.decoration.SpacesItemDecoration;
import com.kingdee.ah.pda.volley.HTTPUtils;
import com.kingdee.ah.pda.volley.VolleyListener;
import com.yxp.permission.util.lib.PermissionUtil;
import com.yxp.permission.util.lib.callback.PermissionResultCallBack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    @BindView(R.id.app_search)
    SearchView appSearch;
    @BindView(R.id.menu1)
    TextView menu1;
    @BindView(R.id.menu2)
    TextView menu2;
    @BindView(R.id.cts_1)
    LinearLayout cts1;
    @BindView(R.id.menu3)
    TextView menu3;
    private PurchaseWarehousingAdapter adapter;
    //条件参数
    private Map<String, String> mapParam = new HashMap<>();
    ;
    private int PAGE = 1;
    private int LIMIT = 10;
    private CommonSelectMenu commonSelectMenu;
    private SupplierSelectMenu supplierSelectMenu;
    private DateSelectMenu dateSelectMenu;

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
                judgeMenu();
                finish();
            }
        });
        TextView tex_item = purchaseWarehousingTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("采购入库列表");
        ivAdd.setVisibility(View.GONE);
    }

    @Override
    protected void initfun() {
        String[] stringArray = getResources().getStringArray(R.array.menu_receive1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        adapter = new PurchaseWarehousingAdapter(R.layout.item_purchase_order_list);
        purchaseRecycler.setLayoutManager(linearLayoutManager);
        purchaseRecycler.setAdapter(adapter);
        adapter.setEmptyView(R.layout.view_loading2, purchaseRecycler);
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

        appSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                onSearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                onSearch(s);
                return false;
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

        //单据状态
        commonSelectMenu = new CommonSelectMenu(this, Arrays.asList(stringArray));
        commonSelectMenu.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void ondismiss() {

            }

            @Override
            public void onSpread() {

            }

            @Override
            public void onSelect(String name, String number) {
                menu1.setText(name);
                commonSelectMenu.dismiss();
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
            public void onSelectDayWeekMonth(String time1, int time2) {
                menu2.setText(time1);
                dateSelectMenu.dismiss();
            }

            @Override
            public void onSelectTime(long startTime, long endTime, String startTimel, String endTimel) {
                menu2.setText(String.format("%s到%s", startTimel, endTimel));
                dateSelectMenu.dismiss();
            }
        });
        //供应商
        supplierSelectMenu = new SupplierSelectMenu(this);
        supplierSelectMenu.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void ondismiss() {

            }

            @Override
            public void onSpread() {

            }

            @Override
            public void onSelect(String name, String number) {
                menu2.setText(name);
                supplierSelectMenu.dismiss();
            }
        });

        getDate(0, mapParam);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void onSearch(String s) {
        mapParam.clear();
        mapParam.put("billNoLike", s);
        getDate(0, mapParam);
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
        HTTPUtils.getInstance(this).postByJson(getstkInStock, InStockHeadBean.class, params, new VolleyListener<InStockHeadBean>() {
            @Override
            public void requestComplete() {
                if (purchaseOrderRefresh != null) {
                    if (loadType == 0) {
                        purchaseOrderRefresh.refreshComplete();
                    } else {
                        purchaseOrderRefresh.loadMoreFail();
                    }
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                if (adapter != null && purchaseRecycler != null) {
                    adapter.setEmptyView(R.layout.view_error, purchaseRecycler);
                }
            }

            @Override
            public void onResponse(InStockHeadBean response) {
                if (adapter != null && purchaseOrderRefresh != null) {
                    int code = response.getCode();
                    if (code == 0) {
                        PAGE++;
                        List<InStockHeadBean.DataEntity> data = response.getData();
                        if (data != null) {
                            if (loadType == 0) {
                                adapter.setNewData(data);
                            } else {
                                if (data.size() > 0) {
                                    adapter.addData(data);
                                }
                            }
                        } else {
                            adapter.setEmptyView(R.layout.view_empt, purchaseRecycler);
                        }

                    } else {
                        adapter.setEmptyView(R.layout.view_error, purchaseRecycler);
                        ToastUtil.show(PurchaseWarehousingActivity.this, response.getMsg());
                    }
                }
            }
        });
    }


    //申请相机权限
    private void wantCameraPermission() {
        PermissionUtil.getInstance().request(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA, Manifest.permission.VIBRATE}, new PermissionResultCallBack() {
            @Override
            public void onPermissionGranted() {
                Intent intent = new Intent(PurchaseWarehousingActivity.this, CaptureActivity.class);
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
            //搜索
            mapParam.clear();
            mapParam.put("billNo", scanResult);
            getDate(0, mapParam);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.menu1, R.id.menu2, R.id.menu3, R.id.iv_add, R.id.iv_scan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_add:
                PurchaseWarehousingAddActivity.show(this);
                break;
            case R.id.iv_scan:
                wantCameraPermission();
                break;
            case R.id.menu1:
                if (commonSelectMenu != null) {
                    commonSelectMenu.showAsDropDown(cts1);
                }
                break;
            case R.id.menu2:
                if (dateSelectMenu != null) {
                    dateSelectMenu.showAsDropDown(cts1);
                }
                break;
            case R.id.menu3:
                if (supplierSelectMenu != null) {
                    supplierSelectMenu.showAsDropDown(cts1);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        judgeMenu();
        HTTPUtils.getInstance(this).cancelAllRequest();
        finish();
    }

    private void judgeMenu() {
        if (commonSelectMenu != null && commonSelectMenu.isMenuOpen()) {
            commonSelectMenu.dismiss();
        }
        if (dateSelectMenu != null && dateSelectMenu.isMenuOpen()) {
            dateSelectMenu.dismiss();
        }
        if (supplierSelectMenu != null && supplierSelectMenu.isMenuOpen()) {
            supplierSelectMenu.dismiss();
        }
    }
}
