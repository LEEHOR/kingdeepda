package com.kingdee.ah.pda.ui.activity.processReport;

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
import android.widget.TextView;

import com.ajguan.library.EasyRefreshLayout;
import com.android.volley.VolleyError;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.zxing.activity.CaptureActivity;
import com.google.zxing.util.Constant;
import com.kingdee.ah.pda.App;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.ProcessReportBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.activity.receive.ReceiveNoticeActivity;
import com.kingdee.ah.pda.ui.adapter.ProcessReportAdapter;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;
import com.kingdee.ah.pda.util.LocalDisplay;
import com.kingdee.ah.pda.util.ToastUtil;
import com.kingdee.ah.pda.util.decoration.SpacesItemDecoration;
import com.kingdee.ah.pda.volley.HTTPUtils;
import com.kingdee.ah.pda.volley.VolleyListener;
import com.yxp.permission.util.lib.PermissionUtil;
import com.yxp.permission.util.lib.callback.PermissionResultCallBack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity.processReport
 * @ClassName: ProcessReportActivity
 * @Description: java类作用描述
 * 工序汇报列表
 * @Author: 作者名
 * @CreateDate: 2020/10/23 9:03
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 9:03
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ProcessReportListActivity extends BaseActivity {
    @BindView(R.id.process_title)
    TitleTopOrdersView processTitle;
    @BindView(R.id.app_search)
    SearchView appSearch;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.process_recycler)
    RecyclerView processRecycler;
    @BindView(R.id.process_refresh)
    EasyRefreshLayout processRefresh;
    private ProcessReportAdapter reportAdapter;
    private Map<String, String> mapParams = new HashMap<>();

    @Override
    protected int getContentResId() {
        return R.layout.activity_process_report;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, ProcessReportListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ivAdd.setVisibility(View.GONE);
        mapParams.clear();
        processTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = processTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("工序汇报列表页");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        reportAdapter = new ProcessReportAdapter(R.layout.item_process_report);
        processRecycler.setLayoutManager(linearLayoutManager);
        processRecycler.setAdapter(reportAdapter);
        reportAdapter.setEmptyView(R.layout.view_loading2, processRecycler);
        processRecycler.addItemDecoration(new SpacesItemDecoration(LocalDisplay.designedDP2px(8), LocalDisplay.designedDP2px(8), getResources().getColor(R.color.transparent)));

    }

    @Override
    protected void initfun() {
        getData(0);
        processRefresh.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                getData(1);
            }

            @Override
            public void onRefreshing() {
                mapParams.clear();
                getData(0);
            }
        });
        reportAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                int id = view.getId();
                ProcessReportBean.DataEntity dataEntity = (ProcessReportBean.DataEntity) adapter.getItem(position);
                assert dataEntity != null;
                switch (id){
                    case R.id.btn_detail:
                        Intent intent=new Intent(ProcessReportListActivity.this, ProcessReportDetailActivity.class);
                        intent.putExtra("fid",dataEntity.getId());
                        startActivity(intent);
                        break;
                    case R.id.btn_push:
                        push(dataEntity.getId());
                        break;
                }
            }
        });

        appSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                mapParams.clear();
                mapParams.put("billNo",s);
                getData(0);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                mapParams.clear();
                mapParams.put("billNo",s);
                getData(0);
                return false;
            }
        });

    }

    //获取数据
    private void getData(final int type) {
        String processreport = Constance.getProcessreport();
        if (type == 0) {
            reportAdapter.getData().clear();
            reportAdapter.notifyDataSetChanged();
        }
        HTTPUtils.getInstance(ProcessReportListActivity.this).postByJson(processreport,
                ProcessReportBean.class, mapParams, new VolleyListener<ProcessReportBean>() {
                    @Override
                    public void requestComplete() {

                    }

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (processRefresh == null && processRecycler == null) {
                            return;
                        }
                        reportAdapter.setEmptyView(R.layout.view_error, processRecycler);
                        if (type == 0) {
                            processRefresh.refreshComplete();
                        } else {
                            processRefresh.loadMoreFail();
                        }
                    }

                    @Override
                    public void onResponse(ProcessReportBean response) {
                        if (processRefresh == null && processRecycler == null) {
                            return;
                        }
                        int code = response.getCode();
                        if (code == 0) {
                            List<ProcessReportBean.DataEntity> data = response.getData();
                                if (type == 0) {
                                    reportAdapter.setNewData(data);
                                    processRefresh.refreshComplete();
                                } else {
                                    if (data.size() > 0) {
                                        reportAdapter.addData(data);
                                        processRefresh.loadMoreComplete();
                                    } else {
                                        processRefresh.loadNothing();
                                    }
                                }
                                reportAdapter.setEmptyView(R.layout.view_empt, processRecycler);
                        } else {
                            reportAdapter.setEmptyView(R.layout.view_error, processRecycler);
                            ToastUtil.show(ProcessReportListActivity.this,response.getMsg());
                            if (type == 0) {
                                processRefresh.refreshComplete();
                            } else {
                                processRefresh.loadMoreFail();
                            }
                        }

                    }
                });

    }

    //推送到云端
    private void push(int fid){
        String pushProcess = Constance.getPushProcess();
        HTTPUtils.getInstance(this).get(pushProcess + fid, new VolleyListener<String>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onResponse(String response) {

            }
        });
    }

    @OnClick(R.id.iv_scan)
    public void onViewClicked() {
        wantCameraPermission();
    }

    //申请相机权限并打开相机
    private void wantCameraPermission() {
        PermissionUtil.getInstance().request(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA, Manifest.permission.VIBRATE}, new PermissionResultCallBack() {
            @Override
            public void onPermissionGranted() {
                Intent intent = new Intent(ProcessReportListActivity.this, CaptureActivity.class);
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
            assert bundle != null;
            String scanResult = bundle.getString(Constant.INTENT_EXTRA_KEY_QR_SCAN);
            //将扫描出的信息显示出来并搜索
            assert scanResult != null;
            appSearch.setQuery(scanResult, false);
            mapParams.clear();
            mapParams.put("billNo", scanResult);
            getData(0);
        }
    }
}
