package com.kingdee.ah.pda.ui.activity.purchaseWarehousing;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.bin.david.form.core.SmartTable;
import com.bin.david.form.core.TableConfig;
import com.bin.david.form.data.CellInfo;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.format.bg.BaseBackgroundFormat;
import com.bin.david.form.data.format.bg.BaseCellBackgroundFormat;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.table.TableData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.zxing.activity.CaptureActivity;
import com.google.zxing.util.Constant;
import com.kingdee.ah.pda.App;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.InStockEntryBean;
import com.kingdee.ah.pda.bean.InStockHeadBean;
import com.kingdee.ah.pda.bean.PurchaseAddBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.activity.ScanCodeCheckInventoryActivity;
import com.kingdee.ah.pda.ui.activity.processReport.ProcessReportDetailActivity;
import com.kingdee.ah.pda.ui.activity.receive.ReceiveNoticeDetailActivity;
import com.kingdee.ah.pda.ui.dialog.PurchaseOrderAddDialog;
import com.kingdee.ah.pda.ui.dialog.PurchaseOrderModifyDialog;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;
import com.kingdee.ah.pda.util.LoadingUtil;
import com.kingdee.ah.pda.util.Logutil;
import com.kingdee.ah.pda.util.ToastUtil;
import com.kingdee.ah.pda.volley.HTTPUtils;
import com.kingdee.ah.pda.volley.VolleyListener;
import com.yxp.permission.util.lib.PermissionUtil;
import com.yxp.permission.util.lib.callback.PermissionResultCallBack;

import java.math.BigDecimal;
import java.util.ArrayList;
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
 * 采购入库
 * @Author: 作者名
 * @CreateDate: 2020/10/19 19:10
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/19 19:10
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class PurchaseWarehousingDetailActivity extends BaseActivity {
    @BindView(R.id.purchase_warehousing_detail_title)
    TitleTopOrdersView receivingDetailTitle;
    @BindView(R.id.add_table)
    SmartTable<InStockEntryBean.DataEntity> addTable;
    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.btn_push)
    Button btnPush;
    @BindView(R.id.tv_fbillTypeName)
    EditText tvFbillTypeName;
    @BindView(R.id.tv_Purchasing_organization)
    EditText tvPurchasingOrganization;
    @BindView(R.id.tv_Receiving_organization)
    EditText tvReceivingOrganization;
    @BindView(R.id.tv_fstockDeptName)
    EditText tvFstockDeptName;
    @BindView(R.id.tv_fdate)
    EditText tvFdate;
    @BindView(R.id.tv_fsupplierName)
    EditText tvFsupplierName;
    @BindView(R.id.tv_fSupplier)
    EditText tvFSupplier;
    @BindView(R.id.tv_fParty_settlement)
    EditText tvFPartySettlement;
    @BindView(R.id.tv_fPayee)
    EditText tvFPayee;

    private InStockHeadBean.DataEntity TableHeadData;
    private int fid = 0;
    private String key_fid = "fid";

    @Override
    protected int getContentResId() {
        return R.layout.activity_purchase_warehousing_detail;
    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        receivingDetailTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        receivingDetailTitle.getTex_item().setVisibility(View.VISIBLE);
        receivingDetailTitle.getTex_item().setText("采购入库详情页");
    }

    @Override
    protected void initfun() {
        if (getIntent() != null) {
            fid = getIntent().getIntExtra("fid", 0);
        }
        createTab();

        if (fid != 0) {
            getTableHead(String.valueOf(fid));
        }
    }


    //获取单据头数据
    private void getTableHead(String id) {
        Map<String, String> params = new HashMap<>();
        params.put(key_fid, id);
        ShowProgress(PurchaseWarehousingDetailActivity.this, "正在加载...", false);
        String getstkInStock = Constance.getGetstkInStock();
        HTTPUtils.getInstance(this).postByJson(getstkInStock, InStockHeadBean.class, params, new VolleyListener<InStockHeadBean>() {
            @Override
            public void onResponse(InStockHeadBean response) {
                int code = response.getCode();
                if (code == 0) {
                    List<InStockHeadBean.DataEntity> datas = response.getData();
                    TableHeadData = datas.get(0);
                    tvPurchasingOrganization.setText(TableHeadData.getFpurchaseOrgName()); //采购组织
                    tvReceivingOrganization.setText(TableHeadData.getFstockOrgName()); //收料组织
                    //  tvFstockDeptName.setText(TableHeadData.get);    //收料仓库
                    tvFdate.setText(TableHeadData.getFdate().substring(0, TableHeadData.getFdate().indexOf("T"))); //收料日期
                    tvFsupplierName.setText(TableHeadData.getFsupplierName()); //供营商
                    tvFSupplier.setText(TableHeadData.getFsupplyName()); //供货方
                    tvFPartySettlement.setText(TableHeadData.getFsettleName()); //结算方
                    tvFPayee.setText(TableHeadData.getFchargeName()); //收款方
                } else {
                    ToastUtil.show(PurchaseWarehousingDetailActivity.this, response.getMsg());
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtil.show(PurchaseWarehousingDetailActivity.this, error.getMessage());
            }

            @Override
            public void requestComplete() {
                if (fid != 0) {
                    getTableBodyDate(String.valueOf(fid));
                }
            }
        });
    }


    //获取单据体数据(从收料通知页跳转)
    private void getTableBodyDate(String fid) {
        Map<String, String> params = new HashMap<>();
        params.put(key_fid, fid);
        String getstkInStockEntry = Constance.getGetstkInStockEntry();
        HTTPUtils.getInstance(this).postByJson(getstkInStockEntry, InStockEntryBean.class, params, new VolleyListener<InStockEntryBean>() {
            @Override
            public void requestComplete() {
                CancelProgress();
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onResponse(InStockEntryBean response) {

                int code = response.getCode();
                if (code == 0) {
                    addTable.addData(response.getData(), false);
                } else {
                    ToastUtil.show(PurchaseWarehousingDetailActivity.this, response.getMsg());
                }

            }
        });
    }


    //创建表格
    private void createTab() {
        addTable.getConfig().setShowYSequence(true);
        addTable.getConfig().setShowXSequence(false);
        addTable.getConfig().setShowTableTitle(false);
        addTable.getConfig().setVerticalPadding(24);
        addTable.getConfig().setContentStyle(new FontStyle(45, Color.BLUE));
        addTable.getConfig().setColumnTitleStyle(new FontStyle(45, Color.WHITE));
        addTable.getConfig().setColumnTitleBackground(new BaseBackgroundFormat(getResources().getColor(R.color.titlebar_color)));
        addTable.getConfig().setContentCellBackgroundFormat(new BaseCellBackgroundFormat<CellInfo>() {
            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                if (cellInfo.row % 2 == 0) {
                    return ContextCompat.getColor(PurchaseWarehousingDetailActivity.this, R.color.actions_background_light);
                } else {
                    return ContextCompat.getColor(PurchaseWarehousingDetailActivity.this, R.color.yellowF23757);
                    // return TableConfig.INVALID_COLOR; //返回无效颜色，不会绘制
                }
            }
        });

        Column<String> c1 = new Column<>("项目编码", "projectNumber");
        c1.setTextAlign(Paint.Align.LEFT);
        Column<String> c2 = new Column<>("项目名称", "projectName");
        c2.setTextAlign(Paint.Align.LEFT);
        Column<String> c3 = new Column<>("物料名称", "fmaterialName");
        c3.setTextAlign(Paint.Align.LEFT);
        Column<String> c4 = new Column<>("物料编码", "fmaterialNumber");
        c4.setTextAlign(Paint.Align.LEFT);
        Column<String> c5 = new Column<>("规格型号", "fspecification");
        c5.setTextAlign(Paint.Align.LEFT);
        Column<String> c6 = new Column<>("库存单位", "funitName");
        c6.setTextAlign(Paint.Align.CENTER);
        //   Column<String> c7 = new Column<>("所属项目", "ff100001Mame");
        //  c7.setTextAlign(Paint.Align.LEFT);
        Column<BigDecimal> c8 = new Column<>("应收数量", "fmustQty");
        c8.setTextAlign(Paint.Align.CENTER);
        //frealQty
        Column<BigDecimal> c9 = new Column<>("实收数量", "frealQty");
        c9.setTextAlign(Paint.Align.CENTER);
        //fpriceUnitName
        Column<String> c10 = new Column<>("计价单位", "fpriceUnitName");
        c10.setTextAlign(Paint.Align.CENTER);
        //fpriceUnitQty
        Column<BigDecimal> c11 = new Column<>("计价数量", "fpriceUnitQty");
        c11.setTextAlign(Paint.Align.CENTER);
        //flotName
        //   Column<String> c12 = new Column<>("批号", "flotName");
        //   c12.setTextAlign(Paint.Align.LEFT);
        //FStockName
        //  Column<String> c13 = new Column<>("仓库", "fstockName");
        //   c13.setTextAlign(Paint.Align.LEFT);
        //fgiveAway
        //  Column<String> c14 = new Column<>("是否赠品", "fgiveAway");
        //   c14.setTextAlign(Paint.Align.LEFT);
        //FNote
        // Column<String> c15 = new Column<>("备注", "fnote");
        // c15.setTextAlign(Paint.Align.LEFT);
        //FRemainInStockUnitName;
        Column<String> c16 = new Column<>("采购单位", "fremainInStockUnitName");
        c16.setTextAlign(Paint.Align.CENTER);
        //fremainInStockQty
        Column<BigDecimal> c17 = new Column<>("采购数量", "fremainInStockQty");
        c17.setTextAlign(Paint.Align.CENTER);
        //ftaxNetPrice
        // Column<BigDecimal> c18 = new Column<>("净价", "ftaxNetPrice");
        //  c18.setTextAlign(Paint.Align.LEFT);
        //fwwinType
        //  Column<BigDecimal> c19 = new Column<>("入库类型", "fwwinType");
        //  c19.setTextAlign(Paint.Align.LEFT);
        //fstockStatusName
        //  Column<BigDecimal> c20 = new Column<>("库存状态", "fstockStatusName");
        //  c20.setTextAlign(Paint.Align.LEFT);
        final TableData<InStockEntryBean.DataEntity> listTableData = new TableData<>("收料通知订单详情列表", new ArrayList<InStockEntryBean.DataEntity>()
                , c1, c2, c3, c4, c5, c6, c8, c9, c10, c11, c16, c17);
        addTable.setTableData(listTableData);
        listTableData.setOnRowClickListener(new TableData.OnRowClickListener<InStockEntryBean.DataEntity>() {
            @Override
            public void onClick(Column column, final InStockEntryBean.DataEntity dataEntity, int col, final int row) {
                 PurchaseOrderModifyDialog modifyDialog=PurchaseOrderModifyDialog.newInstance("修改数量",dataEntity.getProjectName(),dataEntity.getProjectNumber(),
                        dataEntity.getFmustQty(),dataEntity.getFrealQty(),dataEntity.getFpriceUnitQty(),dataEntity.getFremainInStockQty());
                modifyDialog.setOnModifyOrderListener(new PurchaseOrderModifyDialog.OnModifyOrderListener() {
                    @Override
                    public void onConfirm(int fremainInStockQty, int fpriceUnitQty, int fmustQty, int frealQtyint) {
                        dataEntity.setFremainInStockQty(fremainInStockQty);
                        dataEntity.setFpriceUnitQty(fpriceUnitQty);
                        dataEntity.setFmustQty(fmustQty);
                        dataEntity.setFrealQty(frealQtyint);
                        List<InStockEntryBean.DataEntity> t = listTableData.getT();
                        t.remove(row);
                        t.add(row,dataEntity);
                        listTableData.clear();
                        addTable.setData(t);
                    }

                    @Override
                    public void onClose() {
                    }
                });
                modifyDialog.show(getSupportFragmentManager(),"入库");
            }
        });
    }


    @OnClick({R.id.iv_scan, R.id.btn_push})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_scan:
                wantCameraPermission();
                break;
            case R.id.btn_push:
                SaveDate();
                break;
        }
    }


    //保存
    private void SaveDate() {
        List<InStockEntryBean.DataEntity> t = addTable.getTableData().getT();
        TableHeadData.setStkInStockEntryVoList(t);
        Gson gson = new GsonBuilder().serializeNulls().create();
        JsonObject asJsonObject = gson.toJsonTree(TableHeadData).getAsJsonObject();
        //   Logutil.print("数据", asJsonObject.toString());
        String stkInStockAdd = Constance.getStkInStockAdd();
        LoadingUtil.ShowProgress(PurchaseWarehousingDetailActivity.this, "正在保存入库", true);
        HTTPUtils.getInstance(this).postByJson(stkInStockAdd, PurchaseAddBean.class, asJsonObject, new VolleyListener<PurchaseAddBean>() {
            @Override
            public void requestComplete() {
                LoadingUtil.CancelProgress();
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtil.show(PurchaseWarehousingDetailActivity.this, error.getMessage());
            }

            @Override
            public void onResponse(PurchaseAddBean response) {
                int code = response.getCode();
                if (code == 0) {
                    ToastUtil.show(PurchaseWarehousingDetailActivity.this, response.getMsg());
                } else {
                    List<PurchaseAddBean.DataEntity> data = response.getData();
                    StringBuilder stringBuilder = new StringBuilder();
                    if (data != null) {
                        for (PurchaseAddBean.DataEntity d : data) {
                            stringBuilder.append(d.getMessage());
                        }
                    }
                    ToastUtil.showLong(PurchaseWarehousingDetailActivity.this, stringBuilder.toString());
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
                Intent intent = new Intent(PurchaseWarehousingDetailActivity.this, CaptureActivity.class);
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
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }
}
