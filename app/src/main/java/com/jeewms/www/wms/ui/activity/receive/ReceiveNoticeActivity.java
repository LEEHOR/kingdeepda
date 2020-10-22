package com.jeewms.www.wms.ui.activity.receive;

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
import android.widget.ImageView;

import com.ajguan.library.EasyRefreshLayout;
import com.android.volley.VolleyError;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.zxing.activity.CaptureActivity;
import com.google.zxing.util.Constant;
import com.jeewms.www.wms.App;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity1;
import com.jeewms.www.wms.bean.ReceiveBillBean;
import com.jeewms.www.wms.bean.ReceivePush;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.activity.purchaseWarehousing.PurchaseOrderSaveActivity;
import com.jeewms.www.wms.ui.activity.purchaseWarehousing.PurchaseOrderSave2Activity;
import com.jeewms.www.wms.ui.adapter.ReceivingAdapter;
import com.jeewms.www.wms.ui.view.TitleTopOrdersView;
import com.jeewms.www.wms.util.LocalDisplay;
import com.jeewms.www.wms.util.ToastUtil;
import com.jeewms.www.wms.util.decoration.SpacesItemDecoration;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;
import com.yxp.permission.util.lib.PermissionUtil;
import com.yxp.permission.util.lib.callback.PermissionResultCallBack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class ReceiveNoticeActivity extends BaseActivity1 {
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

    //入参
    private String key_fid="fid";
    private String key_billNo="billNo";
    private String key_billNoLike="billNoLike";
    private int PAGE = 1;
    private int LIMIT = 10;

    //条件参数
    private Map<String, String> mapParam = new HashMap<>();;
    private ReceivingAdapter receivingAdapter;

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
        receivingTitle.setViewVisibility(View.VISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE);
        receivingTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        receivingTitle.getTex_item().setText("收料通知单");
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(ReceiveNoticeActivity.this);
        receivingAdapter = new ReceivingAdapter(R.layout.item_receiving_notice);
        receivingRecycler.setLayoutManager(linearLayoutManager);
        receivingRecycler.setAdapter(receivingAdapter);
        receivingRecycler.addItemDecoration(new SpacesItemDecoration(LocalDisplay.designedDP2px(0), LocalDisplay.designedDP2px(8), getResources().getColor(R.color.transparent)));
    }

    @Override
    protected void initfun() {
        getDate(0,mapParam);
        receivingRefresh.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                getDate(1,mapParam);
            }

            @Override
            public void onRefreshing() {
                appSearch.setQuery("", false);
                mapParam.clear();
                getDate(0,mapParam);
            }
        });
        //搜索框文字变化监听
        appSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                appSearch.clearFocus();  //可以收起键盘
                mapParam.clear();
                mapParam.put(key_billNoLike, s);
                getDate(0, mapParam);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        receivingAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                int id = view.getId();
               ReceiveBillBean.DataEntity dataEntity= (ReceiveBillBean.DataEntity) adapter.getData().get(position);
                switch (id){
                    case R.id.receiving_detail:
                        //跳转到详情
                        Intent intent=new Intent(ReceiveNoticeActivity.this, ReceiveNoticeDetailActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putSerializable("date",dataEntity);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                    case R.id.receiving_purchase_warehousing:
                        pushDate(dataEntity.getFid());
                        break;
                }
            }
        });

    }

    @OnClick({R.id.iv_scan,R.id.iv_add})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.iv_add:
                Intent intent=new Intent(ReceiveNoticeActivity.this, PurchaseOrderSave2Activity.class);
               startActivity(intent);
                break;
            case R.id.iv_scan:
                wantCameraPermission();
                break;
        }

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
                intent.setData(Uri.fromParts("package", App.mContext.getPackageName(), null));
                startActivity(intent);
            }
        });
    }


    //获取数据
    private void getDate(final int loadType, Map<String, String> params) {
        if (loadType == 0) {
            this.PAGE = 0;
            this.LIMIT = 10;
            receivingAdapter.getData().clear();
            receivingAdapter.notifyDataSetChanged();
        }
        params.put("page", String.valueOf(PAGE));
        params.put("limit", String.valueOf(LIMIT));
        String receivingBill = Constance.getReceivingBillList();
        HTTPUtils.postByJson(ReceiveNoticeActivity.this, receivingBill, ReceiveBillBean.class, params, new VolleyListener<ReceiveBillBean>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                if (loadType==0){
                    receivingRefresh.refreshComplete();
                } else {
                    receivingRefresh.loadMoreFail();
                }

            }

            @Override
            public void onResponse(ReceiveBillBean response) {
                if (response.getCode()==0){
                    PAGE++;
                    List<ReceiveBillBean.DataEntity> data = response.getData();
                    if (loadType==0){
                        receivingAdapter.setNewData(data);
                        receivingRefresh.refreshComplete();
                    } else {
                        if (data.size() > 0) {
                            receivingAdapter.addData(data);
                        }
                        receivingRefresh.loadMoreComplete();
                    }
                } else {
                    if (loadType == 0) {
                        receivingRefresh.refreshComplete();
                    } else {
                        receivingRefresh.loadMoreComplete();
                    }
                }

            }
        });
    }


    //下推
    private void pushDate(int fid){
        Map<String,String> map=new HashMap<>();
        map.put("fid",String.valueOf(fid));
        String pushReceiving = Constance.getPushReceiving();
        HTTPUtils.postByJson(ReceiveNoticeActivity.this, pushReceiving, ReceivePush.class, map, new VolleyListener<ReceivePush>() {
            @Override
            public void onResponse(ReceivePush response) {
                if (response.getCode()==0) {
                    ToastUtil.show(ReceiveNoticeActivity.this,"下推成功");
                       //跳转到采购入库详情
                        Intent intent1=new Intent(ReceiveNoticeActivity.this, PurchaseOrderSaveActivity.class);
                        Bundle bundle1=new Bundle();
                        bundle1.putInt("fid",response.getData().getId());
                        bundle1.putString("fnumber",response.getData().getNumber());
                        intent1.putExtras(bundle1);
                        startActivity(intent1);
                } else {
                    ToastUtil.show(ReceiveNoticeActivity.this,"下推失败");
                    Intent intent1=new Intent(ReceiveNoticeActivity.this, PurchaseOrderSaveActivity.class);
                    Bundle bundle1=new Bundle();
                    bundle1.putInt("fid",100009);
                    bundle1.putString("fnumber","CGRK00004");
                    intent1.putExtras(bundle1);
                    startActivity(intent1);
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtil.show(ReceiveNoticeActivity.this,error.getMessage());
            }

            @Override
            public void requestComplete() {

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
            appSearch.setQuery(scanResult, false);
            mapParam.clear();
            mapParam.put(key_billNo,scanResult);
            getDate(0,mapParam);
        }
    }
}
