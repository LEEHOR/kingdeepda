package com.jeewms.www.wms.ui.activity.purchaseWarehousing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.bin.david.form.core.SmartTable;
import com.bin.david.form.core.TableConfig;
import com.bin.david.form.data.CellInfo;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.format.IFormat;
import com.bin.david.form.data.format.bg.BaseBackgroundFormat;
import com.bin.david.form.data.format.bg.BaseCellBackgroundFormat;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.table.TableData;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity1;
import com.jeewms.www.wms.bean.InStockEntryBean;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.view.TitleTopOrdersView;
import com.jeewms.www.wms.util.ToastUtil;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

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
 * 采购入库保存---新的
 * @Author: 作者名
 * @CreateDate: 2020/10/19 19:10
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/19 19:10
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class PurchaseOrderSave2Activity extends BaseActivity1 {
    @BindView(R.id.receiving_detail_title)
    TitleTopOrdersView receivingDetailTitle;
    @BindView(R.id.add_table)
    SmartTable addTable;
    @BindView(R.id.tv_fbillType)
    EditText tvFbillType;
    @BindView(R.id.tv_freceiveDeptName)
    EditText tvFreceiveDeptName;
    @BindView(R.id.tv_fstockOrgName)
    EditText tvFstockOrgName;
    @BindView(R.id.tv_fdemandOrgName)
    EditText tvFdemandOrgName;
    @BindView(R.id.tv_fpurOrgName)
    EditText tvFpurOrgName;
    @BindView(R.id.tv_fsupplierName)
    EditText tvFsupplierName;
    @BindView(R.id.tv_fbusinessType)
    EditText tvFbusinessType;
    @BindView(R.id.tv_billNo)
    EditText tvBillNo;
    @BindView(R.id.tv_documentStatus)
    EditText tvDocumentStatus;
    @BindView(R.id.tv_date)
    EditText tvDate;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_scan)
    ImageView ivScan;

    private int fid = 0;
    private String key_fid = "fid";
    private List<InStockEntryBean.DataEntity> dataEntities = new ArrayList<>();

    @Override
    protected int getContentResId() {
        return R.layout.activity_receiving_notice_add;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, PurchaseOrderSave2Activity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        dataEntities.clear();
        //  receivingDetailTitle.setViewVisibility(View.VISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.VISIBLE);
        receivingDetailTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        receivingDetailTitle.getTex_item().setVisibility(View.VISIBLE);
        receivingDetailTitle.getTex_item().setText("采购入库详情页");

        TextView tv_right2 = receivingDetailTitle.getTv_right2();
        tv_right2.setVisibility(View.VISIBLE);
        tv_right2.setText("保存");
        tv_right2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        TextView tv_right = receivingDetailTitle.getTv_right();
        tv_right.setVisibility(View.VISIBLE);
        tv_right.setText("提交");
        tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        tvFbillType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.show(PurchaseOrderSave2Activity.this, "点击了");
            }
        });
    }

    @Override
    protected void initfun() {
        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                String fbillType = extras.getString("fbillType");
                String freceiveDeptName = extras.getString("freceiveDeptName");
                String fstockOrgName = extras.getString("fstockOrgName");
                String fdemandOrgName = extras.getString("fdemandOrgName");
                String fpurOrgName = extras.getString("fpurOrgName");
                String fsupplierName = extras.getString("fsupplierName");
                String fbusinessType = extras.getString("fbusinessType");
                String documentStatus = extras.getString("documentStatus");
                String date = extras.getString("date");
                String billNo = extras.getString("billNo");
                fid = extras.getInt("fid");
                tvFbillType.setText(fbillType);
                if (freceiveDeptName != null) {
                    tvFreceiveDeptName.setText(freceiveDeptName);
                } else {
                    tvFreceiveDeptName.setText("");
                }

                tvFstockOrgName.setText(fstockOrgName);
                tvFdemandOrgName.setText(fdemandOrgName);
                tvFpurOrgName.setText(fpurOrgName);
                tvFsupplierName.setText(fsupplierName);
                tvFbusinessType.setText(fbusinessType);
                if (documentStatus.equals("Z")) {
                    tvDocumentStatus.setText("暂存");
                } else if (documentStatus.equals("A")) {
                    tvDocumentStatus.setText("创建");
                } else if (documentStatus.equals("B")) {
                    tvDocumentStatus.setText("审核中");
                } else if (documentStatus.equals("C")) {
                    tvDocumentStatus.setText("已审核");
                } else if (documentStatus.equals("D")) {
                    tvDocumentStatus.setText("重新审核");
                } else {
                    tvDocumentStatus.setText("");
                }
                tvDate.setText(date.substring(0, date.indexOf("T")));
                tvBillNo.setText(billNo);
            }
        }
        addTable.getConfig().setShowYSequence(false);
        addTable.getConfig().setShowXSequence(false);
        addTable.getConfig().setShowTableTitle(false);
        addTable.getConfig().setContentStyle(new FontStyle(30, Color.BLUE));
        addTable.getConfig().setColumnTitleStyle(new FontStyle(35, Color.WHITE));
        addTable.getConfig().setColumnTitleBackground(new BaseBackgroundFormat(getResources().getColor(R.color.titlebar_color)));
        addTable.getConfig().setContentCellBackgroundFormat(new BaseCellBackgroundFormat<CellInfo>() {
            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                if (cellInfo.row % 2 == 0) {
                    return ContextCompat.getColor(PurchaseOrderSave2Activity.this, R.color.black_f5f5f5);
                } else {
                    return TableConfig.INVALID_COLOR; //返回无效颜色，不会绘制
                }
            }
        });
        createTab();
        if (fid != 0) {
            getDate(String.valueOf(fid));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    //获取订单详情(从收料通知页跳转)
    private void getDate(String fid) {
        Map<String, String> params = new HashMap<>();
        params.put(key_fid, fid);
        String billDetail = Constance.getGetReceivingBillDetail();
        HTTPUtils.postByJson(this, billDetail, InStockEntryBean.class, params, new VolleyListener<InStockEntryBean>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onResponse(InStockEntryBean response) {
                if (response.getCode() == 0) {
                    List<InStockEntryBean.DataEntity> data = response.getData();
                    addTable.addData(data,false);
                } else {

                }

            }
        });
    }

    private void createTab() {
        Column<String> c0 = new Column<>("单据编号", "billNo");
        Column<String> c1 = new Column<>("物料编码", "fmaterialNumber");
        c1.setTextAlign(Paint.Align.LEFT);
        Column<String> c2 = new Column<>("物料名称", "fmaterialName");
        c2.setTextAlign(Paint.Align.LEFT);
        Column<String> c3 = new Column<>("规格型号", "fmaterialSpecification");
        c3.setTextAlign(Paint.Align.LEFT);
        Column<String> c4 = new Column<>("项目编码", "projectNumber");
        c4.setTextAlign(Paint.Align.LEFT);
        Column<String> c5 = new Column<>("项目名称", "projectName");
        c5.setTextAlign(Paint.Align.LEFT);
        Column<String> c6 = new Column<>("所属项目", "fauxPropIdProjectName");
        c6.setTextAlign(Paint.Align.LEFT);
        Column<String> c7 = new Column<>("订单所属项目", "fprojectNo");
        c7.setTextAlign(Paint.Align.LEFT);
        Column<String> c8 = new Column<>("采购单位", "fpurorgName");
        c8.setTextAlign(Paint.Align.LEFT);
        Column<String> c9 = new Column<>("仓库名称", "fstockName");
        c9.setTextAlign(Paint.Align.LEFT);
        Column<BigDecimal> c10 = new Column<>("交货数量", "factreceiveQty");
        c10.setTextAlign(Paint.Align.LEFT);
        Column<String> c11 = new Column<>("收料单位", "funitName");
        c11.setTextAlign(Paint.Align.LEFT);
        Column<String> c17 = new Column<>("单据日期", "fdate", new IFormat<String>() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public String format(String s) {
                if (s != null) {
                    String str1 = s.substring(0, s.indexOf("T"));
                    return str1;
                } else {
                    return "";
                }

            }
        });
        c17.setTextAlign(Paint.Align.LEFT);
        Column<String> c12 = new Column<>("预计到货日期", "fpredeliveryDate", new IFormat<String>() {
            @Override
            public String format(String s) {
                if (s != null) {
                    String str1 = s.substring(0, s.indexOf("T"));
                    return str1;
                } else {
                    return "";
                }
            }
        });
        c12.setTextAlign(Paint.Align.LEFT);
        Column<BigDecimal> c13 = new Column<>("供应商交货数量", "fsupdelQty");
        c13.setTextAlign(Paint.Align.LEFT);
        Column<String> c14 = new Column<>("计价单位", "fpriceunitName");
        c14.setTextAlign(Paint.Align.LEFT);
        Column<BigDecimal> c15 = new Column<>("计价数量", "priceUnitQty");
        c15.setTextAlign(Paint.Align.LEFT);
        Column<String> c16 = new Column<>("行状态", "documentStatus", new IFormat<String>() {
            @Override
            public String format(String s) {
                //（Z暂存,A创建,B审核中,C已审核,D重新审核）
                if (s != null) {
                    if (s.equals("Z")) {
                        return "暂存";
                    } else if (s.equals("A")) {
                        return "创建";
                    } else if (s.equals("B")) {
                        return "审核中";
                    } else if (s.equals("C")) {
                        return "已审核";
                    } else if (s.equals("D")) {
                        return "重新审核";
                    } else {
                        return "";
                    }
                } else {
                    return "";
                }

            }
        });
        c16.setTextAlign(Paint.Align.LEFT);
        TableData<InStockEntryBean.DataEntity> listTableData = new TableData<>("收料通知订单详情列表", dataEntities
                , c5, c4, c1, c2, c3, c8, c9, c10, c11, c12, c13, c14, c15, c16);
        addTable.setTableData(listTableData);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_add, R.id.iv_scan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_add:
                break;
            case R.id.iv_scan:
                break;
        }
    }
}
