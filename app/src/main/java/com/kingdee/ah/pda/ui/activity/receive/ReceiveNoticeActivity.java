package com.kingdee.ah.pda.ui.activity.receive;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
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
import com.kingdee.ah.pda.bean.ReceiveBillBean;
import com.kingdee.ah.pda.bean.ReceivePushBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.activity.purchaseWarehousing.PurchaseWarehousingDetailActivity;
import com.kingdee.ah.pda.ui.adapter.ReceivingAdapter;
import com.kingdee.ah.pda.ui.popWindows.CommonSelectMenu;
import com.kingdee.ah.pda.ui.popWindows.DateSelectMenu;
import com.kingdee.ah.pda.ui.popWindows.OnDateSelectListener;
import com.kingdee.ah.pda.ui.popWindows.OnStateChangeListener;
import com.kingdee.ah.pda.ui.popWindows.SupplierSelectMenu;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;
import com.kingdee.ah.pda.util.LocalDisplay;
import com.kingdee.ah.pda.util.Logutil;
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
import java.util.function.Predicate;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.fragment1
 * @ClassName: ReceivingNoticeFragment
 * @Description: java类作用描述
 * 清单管理首页
 * @Author: 作者名
 * @CreateDate: 2020/10/15 15:18
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/15 15:18
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ReceiveNoticeActivity extends BaseActivity {
    @BindView(R.id.receivingTitle)
    TitleTopOrdersView receivingTitle;
    @BindView(R.id.app_search)
    SearchView appSearch;
    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.receiving_recycler)
    RecyclerView receivingRecycler;
    @BindView(R.id.receiving_refresh)
    EasyRefreshLayout receivingRefresh;
    @BindView(R.id.menu1)
    TextView menu1;
    @BindView(R.id.menu2)
    TextView menu2;
    @BindView(R.id.menu3)
    TextView menu3;
    @BindView(R.id.cts_1)
    LinearLayout cts1;

    //入参
    private String key_fid = "fid";
    private String key_billNo = "billNo";
    private String key_billNoLike = "billNoLike";
    private int PAGE = 1;
    private int LIMIT = 10;

    //条件参数
    private Map<String, String> mapParam = new HashMap<>();
    ;
    private ReceivingAdapter receivingAdapter;
    private CommonSelectMenu commonSelectMenu;
    private SupplierSelectMenu supplierSelectMenu;
    private DateSelectMenu dateSelectMenu;

    @Override
    protected int getContentResId() {
        return R.layout.activity_receving_notice;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, ReceiveNoticeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ivAdd.setVisibility(View.GONE);
        receivingTitle.setViewVisibility(View.VISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE);
        receivingTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  judgeMenu();
                onBackPressed();
            }
        });
        receivingTitle.getTex_item().setText("收料通知单");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ReceiveNoticeActivity.this);
        receivingAdapter = new ReceivingAdapter(R.layout.item_receiving_notice);
        receivingRecycler.setLayoutManager(linearLayoutManager);
        receivingRecycler.setAdapter(receivingAdapter);
        receivingAdapter.setEmptyView(R.layout.view_loading2, receivingRecycler);
        receivingRecycler.addItemDecoration(new SpacesItemDecoration(LocalDisplay.designedDP2px(0), LocalDisplay.designedDP2px(8), getResources().getColor(R.color.transparent)));
    }

    @Override
    protected void initfun() {
        String[] stringArray = getResources().getStringArray(R.array.menu_receive1);
        receivingRefresh.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                getDate(1, mapParam);
            }

            @Override
            public void onRefreshing() {
                appSearch.setQuery("", false);
                mapParam.clear();
                getDate(0, mapParam);
            }
        });
        //搜索框文字变化监听
        appSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                appSearch.clearFocus();  //可以收起键盘
                mapParam.clear();
                mapParam.put(key_billNoLike, s);
                getSearch();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                mapParam.clear();
                mapParam.put(key_billNoLike, s);
                getSearch();
                return false;
            }
        });
        receivingAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                int id = view.getId();
                ReceiveBillBean.DataEntity dataEntity = (ReceiveBillBean.DataEntity) adapter.getData().get(position);
                switch (id) {
                    case R.id.receiving_detail:
                        //跳转到详情
                        Intent intent = new Intent(ReceiveNoticeActivity.this, ReceiveNoticeDetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("date", dataEntity);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                    case R.id.receiving_purchase_warehousing:
                        pushDate(dataEntity.getFid());
                        break;
                }
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
                menu3.setText(name);
                supplierSelectMenu.dismiss();
            }
        });

        getDate(0, mapParam);

    }

    //申请相机权限
    private void wantCameraPermission() {
        PermissionUtil.getInstance().request(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA, Manifest.permission.VIBRATE}, new PermissionResultCallBack() {
            @Override
            public void onPermissionGranted() {
                Intent intent = new Intent(ReceiveNoticeActivity.this, CaptureActivity.class);
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

    private void getSearch() {
        getDate(0, mapParam);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    //获取数据
    private void getDate(final int loadType, Map<String, String> params) {
        if (loadType == 0) {
            this.PAGE = 1;
            this.LIMIT = 10;
            receivingAdapter.getData().clear();
            receivingAdapter.notifyDataSetChanged();
        }
        params.put("page", String.valueOf(PAGE));
        params.put("limit", String.valueOf(LIMIT));
        String receivingBill = Constance.getReceivingBillList();
        HTTPUtils.getInstance(this).postByJson(receivingBill, ReceiveBillBean.class, params, new VolleyListener<ReceiveBillBean>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                if (receivingAdapter == null && receivingRecycler == null) {
                    return;
                }
                if (loadType==0){
                    receivingRefresh.refreshComplete();
                } else {
                    receivingRefresh.loadMoreFail();
                }
                receivingAdapter.setEmptyView(R.layout.view_error, receivingRecycler);
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(ReceiveBillBean response) {
                if (receivingAdapter == null && receivingRecycler == null) {
                    return;
                }
                int code = response.getCode();
                if (code == 0) {
                    PAGE++;
                    List<ReceiveBillBean.DataEntity> data = response.getData();
//                    data.removeIf(new Predicate<ReceiveBillBean.DataEntity>() {  //过滤
//                        @Override
//                        public boolean test(ReceiveBillBean.DataEntity dataEntity) {
//                            return dataEntity.getDocumentStatus().equals("C") || dataEntity.getDocumentStatus().equals("D");
//                        }
//                    });
                        if (loadType == 0) {
                            receivingAdapter.setNewData(data);
                            receivingRefresh.refreshComplete();
                        } else {
                            if (data.size()>0){
                                receivingRefresh.loadMoreComplete();
                                receivingAdapter.addData(data);
                            } else {
                                receivingRefresh.loadNothing();
                            }

                        }
                    receivingAdapter.setEmptyView(R.layout.view_empt, receivingRecycler);
                } else {
                    if (loadType == 0) {
                        receivingRefresh.refreshComplete();
                    } else {
                        receivingRefresh.loadMoreFail();
                    }
                    receivingAdapter.setEmptyView(R.layout.view_error, receivingRecycler);
                    ToastUtil.show(ReceiveNoticeActivity.this, response.getMsg());
                }
            }
        });

    }


    //下推
    private void pushDate(int fid) {
        Map<String, String> map = new HashMap<>();
        map.put("fid", String.valueOf(fid));
        String pushReceiving = Constance.getPushReceiving();
        ShowProgress(this,"正在下推...",false);
        HTTPUtils.getInstance(this).postByJson(pushReceiving, ReceivePushBean.class, map, new VolleyListener<ReceivePushBean>() {
            @Override
            public void onResponse(ReceivePushBean response) {
                int code = response.getCode();
                if (code == 0) {
                    ToastUtil.show(ReceiveNoticeActivity.this, response.getMsg());
                    Logutil.print("下推", response.getData().getId() + "/" + response.getData().getNumber());
                    //跳转到采购入库详情
                    Intent intent1 = new Intent(ReceiveNoticeActivity.this, PurchaseWarehousingDetailActivity.class);
                    Bundle bundle1 = new Bundle();
                    bundle1.putInt("fid", response.getData().getId());
                    bundle1.putString("fnumber", response.getData().getNumber());
                    intent1.putExtras(bundle1);
                    startActivity(intent1);
                } else {
                    ToastUtil.show(ReceiveNoticeActivity.this, response.getMsg());
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtil.show(ReceiveNoticeActivity.this, error.getMessage());
            }

            @Override
            public void requestComplete() {
                CancelProgress();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //扫描结果回调
        if (requestCode == Constant.REQ_QR_CODE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            assert bundle != null;
            String scanResult = bundle.getString(Constant.INTENT_EXTRA_KEY_QR_SCAN);
            //将扫描出的信息显示出来并搜索
            appSearch.setQuery(scanResult, false);
            mapParam.clear();
            mapParam.put(key_billNo, scanResult);

            getDate(0, mapParam);
        }
    }


    @OnClick({R.id.menu1, R.id.menu2, R.id.menu3, R.id.iv_scan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
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
}

