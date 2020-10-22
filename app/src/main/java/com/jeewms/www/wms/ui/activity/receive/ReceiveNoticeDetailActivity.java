package com.jeewms.www.wms.ui.activity.receive;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.jeewms.www.wms.bean.ReceiveBillBean;
import com.jeewms.www.wms.bean.ReceiveBillEntry;
import com.jeewms.www.wms.bean.ReceivePush;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.activity.purchaseWarehousing.PurchaseOrderSaveActivity;
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
import butterknife.OnClick;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity1.receiving
 * @ClassName: receivingNoticeDetail
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/15 15:09
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/15 15:09
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ReceiveNoticeDetailActivity extends BaseActivity1 {

    @BindView(R.id.receiving_detail_title)
    TitleTopOrdersView detailTitle;
    @BindView(R.id.detail_table)
    SmartTable noticeDetailTab;
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
    @BindView(R.id.details_tv_1)
    TextView detailsTv1;
    @BindView(R.id.details_tv_2)
    TextView detailsTv2;
    @BindView(R.id.tv_fbillType)
    EditText tvFbillType;
    @BindView(R.id.tv_documentStatus)
    EditText tvDocumentStatus;
    @BindView(R.id.tv_date)
    EditText tvDate;
    @BindView(R.id.tv_factreceiveQty)
    TextView tvFactreceiveQty;
    @BindView(R.id.tv_fsupdelQty)
    TextView tvFsupdelQty;
    @BindView(R.id.tv_priceUnitQty)
    TextView tvPriceUnitQty;
    @BindView(R.id.btn_push)
    Button btnPush;

    private String key_fid = "fid";
    private int fid = 0;
    private int count1 = 0;
    private int count2 = 0;
    private int count3 = 0;

    private String date;
    private String billNo;
    @Override
    protected int getContentResId() {
        return R.layout.activity_receiving_notice_details;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        detailTitle.setViewVisibility(View.VISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE);
        detailTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        detailTitle.getTex_item().setText("收料通知详情页面");
    }

    @Override
    protected void initfun() {
        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                ReceiveBillBean.DataEntity dataEntity= (ReceiveBillBean.DataEntity) extras.get("date");
                assert dataEntity != null;
                this.fid = dataEntity.getFid();
                this.date = dataEntity.getDate();
                this.billNo = dataEntity.getBillNo();
                String fbillType = dataEntity.getFbillType();
                String freceiveDeptName = dataEntity.getFreceiveDeptName();
                String fstockOrgName = dataEntity.getFstockOrgName();
                String fdemandOrgName = dataEntity.getFdemandOrgName();
                String fpurOrgName = dataEntity.getFpurOrgName();
                String fsupplierName = dataEntity.getFsupplierName();
                String fbusinessType = dataEntity.getFbusinessType();
                String documentStatus = dataEntity.getDocumentStatus();

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
                tvDate.setText(date.substring(0, this.date.indexOf("T")));
                tvBillNo.setText(billNo);

            }
        }
        noticeDetailTab.getConfig().setShowYSequence(false);
        noticeDetailTab.getConfig().setShowXSequence(false);
        noticeDetailTab.getConfig().setShowTableTitle(false);
        noticeDetailTab.getConfig().setContentStyle(new FontStyle(45, Color.BLUE));
        noticeDetailTab.getConfig().setColumnTitleStyle(new FontStyle(50, Color.WHITE));
        noticeDetailTab.getConfig().setColumnTitleBackground(new BaseBackgroundFormat(getResources().getColor(R.color.titlebar_color)));
        noticeDetailTab.getConfig().setContentCellBackgroundFormat(new BaseCellBackgroundFormat<CellInfo>() {
            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                if (cellInfo.row % 2 == 0) {
                    return ContextCompat.getColor(ReceiveNoticeDetailActivity.this, R.color.black_f5f5f5);
                } else {
                    return TableConfig.INVALID_COLOR; //返回无效颜色，不会绘制
                }
            }
        });
        createTable();
        getTableBodyDate(String.valueOf(fid));
    }



    //获取表体数据
    private void getTableBodyDate(String fid) {
        Map<String, String> params = new HashMap<>();
        params.put(key_fid, fid);
        String billDetail = Constance.getGetReceivingBillDetail();
        HTTPUtils.postByJson(this, billDetail, ReceiveBillEntry.class, params, new VolleyListener<ReceiveBillEntry>() {
            @Override
            public void requestComplete() {
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onResponse(ReceiveBillEntry response) {
                if (response.getCode() == 0) {
                    List<ReceiveBillEntry.DataEntity> data = response.getData();
                    for (int i = 0; i < data.size(); i++) {
                        count1 += data.get(i).getFactreceiveQty();
                        count2 += data.get(i).getFsupdelQty();
                        count3 += data.get(i).getPriceUnitQty();
                    }
                    tvFactreceiveQty.setText(String.valueOf(count1));
                    tvFsupdelQty.setText(String.valueOf(count2));
                    tvPriceUnitQty.setText(String.valueOf(count3));
                    noticeDetailTab.addData(data, false);
                } else {
                    tvFactreceiveQty.setText(String.valueOf(0));
                    tvFsupdelQty.setText(String.valueOf(0));
                    tvPriceUnitQty.setText(String.valueOf(0));
                }

            }
        });
    }

    //创建表格
    private void createTable() {
        // Column<String> c0 = new Column<>("单据编号", "billNo");
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
        TableData<ReceiveBillEntry.DataEntity> tableData = new TableData<>("收料通知订单详情列表", new ArrayList<ReceiveBillEntry.DataEntity>()
                , c5, c4, c1, c2, c3, c8, c9, c10, c11, c12, c13, c14, c15, c16);
        noticeDetailTab.setTableData(tableData);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.btn_push)
    public void onViewClicked() {
        if (fid !=0){
            pushDate(fid);
        }
    }

    private void pushDate(int fid){
        Map<String,String> map=new HashMap<>();
        map.put("fid",String.valueOf(fid));
        String pushReceiving = Constance.getPushReceiving();
        HTTPUtils.postByJson(ReceiveNoticeDetailActivity.this, pushReceiving, ReceivePush.class, map, new VolleyListener<ReceivePush>() {
            @Override
            public void onResponse(ReceivePush response) {
                if (response.getCode()==0) {
                    ToastUtil.show(ReceiveNoticeDetailActivity.this,"下推成功");
                    //跳转到采购入库详情
                    Intent intent1=new Intent(ReceiveNoticeDetailActivity.this, PurchaseOrderSaveActivity.class);
                    Bundle bundle1=new Bundle();
                    bundle1.putInt("fid",response.getData().getId());
                    bundle1.putString("fnumber",response.getData().getNumber());
                    intent1.putExtras(bundle1);
                    startActivity(intent1);
                } else {
                    ToastUtil.show(ReceiveNoticeDetailActivity.this,"下推失败");
                    Intent intent1=new Intent(ReceiveNoticeDetailActivity.this, PurchaseOrderSaveActivity.class);
                    Bundle bundle1=new Bundle();
                    bundle1.putInt("fid",100009);
                    bundle1.putString("fnumber","CGRK00004");
                    intent1.putExtras(bundle1);
                    startActivity(intent1);
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtil.show(ReceiveNoticeDetailActivity.this,error.getMessage());
            }

            @Override
            public void requestComplete() {

            }
        });
    }
}
