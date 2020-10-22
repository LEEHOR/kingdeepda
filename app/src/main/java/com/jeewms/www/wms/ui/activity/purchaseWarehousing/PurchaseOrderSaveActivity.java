package com.jeewms.www.wms.ui.activity.purchaseWarehousing;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
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
import com.google.gson.JsonObject;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity1;
import com.jeewms.www.wms.bean.InStockEntryBean;
import com.jeewms.www.wms.bean.InStockHeadBean;
import com.jeewms.www.wms.bean.MaterialListBean;
import com.jeewms.www.wms.bean.ProjectListBean;
import com.jeewms.www.wms.bean.PurchaseOrderAddBean;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.dialog.PurchaseOrderAddDialog;
import com.jeewms.www.wms.ui.view.TitleTopOrdersView;
import com.jeewms.www.wms.util.Logutil;
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
 * @Package: com.jeewms.www.wms.ui.activity.receiving
 * @ClassName: ReceivingPushDown
 * @Description: java类作用描述
 * 采购入库保存---收料通知跳转
 * @Author: 作者名
 * @CreateDate: 2020/10/19 19:10
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/19 19:10
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class PurchaseOrderSaveActivity extends BaseActivity1 {
    @BindView(R.id.receiving_detail_title)
    TitleTopOrdersView receivingDetailTitle;
    @BindView(R.id.add_table)
    SmartTable addTable;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.btn_push)
    Button btnPush;
    @BindView(R.id.tv_fbillTypeName)
    EditText tvFbillTypeName;
    @BindView(R.id.tv_fstockOrgNamee)
    EditText tvFstockOrgNamee;
    @BindView(R.id.tv_fpurchaseOrgName)
    EditText tvFpurchaseOrgName;
    @BindView(R.id.tv_fbusinessType)
    EditText tvFbusinessType;
    @BindView(R.id.tv_fstockDeptName)
    EditText tvFstockDeptName;
    @BindView(R.id.tv_fpurchaseDeptName)
    EditText tvFpurchaseDeptName;
    @BindView(R.id.tv_fbillNo)
    EditText tvFbillNo;
    @BindView(R.id.tv_fstockerGroupName)
    EditText tvFstockerGroupName;
    @BindView(R.id.tv_fpurchaserGroupName)
    EditText tvFpurchaserGroupName;
    @BindView(R.id.tv_fdate)
    EditText tvFdate;
    @BindView(R.id.tv_fstockerName)
    EditText tvFstockerName;
    @BindView(R.id.tv_fpurchaserName)
    EditText tvFpurchaserName;
    @BindView(R.id.tv_fdocumentStatus)
    EditText tvFdocumentStatus;
    @BindView(R.id.tv_fsupplierName)
    EditText tvFsupplierName;
    @BindView(R.id.tv_fdemandOrgName)
    EditText tvFdemandOrgName;
    @BindView(R.id.tv_fsettleName)
    EditText tvFsettleName;
    @BindView(R.id.tv_fsupplyName)
    EditText tvFsupplyName;
    @BindView(R.id.tv_fproviderContactName)
    EditText tvFproviderContactName;
    @BindView(R.id.tv_fsupplyAddress)
    EditText tvFsupplyAddress;
    @BindView(R.id.tv_fchargeName)
    EditText tvFchargeName;

    private int fid = 0;
    private String key_fid = "fid";
    //传参
    private PurchaseOrderAddBean bean = new PurchaseOrderAddBean();
    PurchaseOrderAddBean.ModelEntity modelEntity = new PurchaseOrderAddBean.ModelEntity();
    //明细
    private List<PurchaseOrderAddBean.ModelEntity.FInStockEntryEntity> fInStockEntryEntityList = new ArrayList<>();

    @Override
    protected int getContentResId() {
        return R.layout.activity_receiving_notice_add;
    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        receivingDetailTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        receivingDetailTitle.getTex_item().setVisibility(View.VISIBLE);
        receivingDetailTitle.getTex_item().setText("采购入库页");

        TextView tv_right2 = receivingDetailTitle.getTv_right2();
        tv_right2.setVisibility(View.INVISIBLE);
        tv_right2.setText("保存");
        tv_right2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        TextView tv_right = receivingDetailTitle.getTv_right();
        tv_right.setVisibility(View.INVISIBLE);
        tv_right.setText("提交");
        tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void initfun() {
        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                fid = extras.getInt("fid");
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
                    return ContextCompat.getColor(PurchaseOrderSaveActivity.this, R.color.black_f5f5f5);
                } else {
                    return TableConfig.INVALID_COLOR; //返回无效颜色，不会绘制
                }
            }
        });
        createTab();
        if (fid != 0) {
            getTableHead(String.valueOf(fid));
        }
        if (fid != 0) {
            getTableBodyDate(String.valueOf(fid));
        }
    }

    //获取单据头数据
    private void getTableHead(String fid) {
        Map<String, String> params = new HashMap<>();
        params.put(key_fid, fid);
        String getstkInStock = Constance.getGetstkInStock();
        HTTPUtils.postByJson(this, getstkInStock, InStockHeadBean.class, params, new VolleyListener<InStockHeadBean>() {
            @Override
            public void onResponse(InStockHeadBean response) {
                if (response.getCode() == 0) {
                    List<InStockHeadBean.DataEntity> datas = response.getData();
                    InStockHeadBean.DataEntity dataEntity = datas.get(0);
                    tvFbillTypeName.setText(dataEntity.getFbillTypeName());
                    tvFstockOrgNamee.setText(dataEntity.getFstockOrgName());
                    tvFpurchaseOrgName.setText(dataEntity.getFpurchaseOrgName());
                    tvFstockDeptName.setText(dataEntity.getFstockDeptName());
                    tvFpurchaseDeptName.setText(dataEntity.getFpurchaseDeptName());
                    tvFbillNo.setText(dataEntity.getFbillNo());
                    tvFstockerGroupName.setText(dataEntity.getFstockerGroupName());
                    tvFpurchaserGroupName.setText(dataEntity.getFpurchaserGroupName());
                    String fdate = dataEntity.getFdate();
                    String str1 = fdate.substring(0, fdate.indexOf("T"));
                    tvFdate.setText(str1);
                    tvFstockerName.setText(dataEntity.getFstockerName());
                    tvFpurchaserName.setText(dataEntity.getFpurchaserName());
                    tvFdocumentStatus.setText(dataEntity.getFdocumentStatus());
                    tvFsettleName.setText(dataEntity.getFsettleName());
                    tvFsupplyName.setText(dataEntity.getFsupplyName());
                    tvFproviderContactName.setText(dataEntity.getFproviderContactName());
                    tvFsupplyAddress.setText(dataEntity.getFsupplyAddress());
                    tvFchargeName.setText(dataEntity.getFchargeName());
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void requestComplete() {

            }
        });
    }

    //获取单据体数据(从收料通知页跳转)
    private void getTableBodyDate(String fid) {
        Map<String, String> params = new HashMap<>();
        params.put(key_fid, fid);
        String getstkInStockEntry = Constance.getGetstkInStockEntry();
        HTTPUtils.postByJson(this, getstkInStockEntry, InStockEntryBean.class, params, new VolleyListener<InStockEntryBean>() {
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
                    addTable.addData(data, false);
                    //  dataEntities.addAll(data);
                } else {
                }

            }
        });
    }

    private void createTab() {
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
        c6.setTextAlign(Paint.Align.LEFT);
        Column<String> c7 = new Column<>("所属项目", "ff100001Mame");
        c7.setTextAlign(Paint.Align.LEFT);
        Column<BigDecimal> c8 = new Column<>("应收数量", "fmustQty");
        c8.setTextAlign(Paint.Align.LEFT);
        //frealQty
        Column<BigDecimal> c9 = new Column<>("实收数量", "frealQty");
        c9.setTextAlign(Paint.Align.LEFT);
        //fpriceUnitName
        Column<String> c10 = new Column<>("计价单位", "fpriceUnitName");
        c10.setTextAlign(Paint.Align.LEFT);
        //fpriceUnitQty
        Column<BigDecimal> c11 = new Column<>("计价数量", "fpriceUnitQty");
        c11.setTextAlign(Paint.Align.LEFT);
        //flotName
        Column<String> c12 = new Column<>("批号", "flotName");
        c12.setTextAlign(Paint.Align.LEFT);
        //FStockName
        Column<String> c13 = new Column<>("仓库", "fstockName");
        c13.setTextAlign(Paint.Align.LEFT);
        //fgiveAway
        Column<String> c14 = new Column<>("是否赠品", "fgiveAway");
        c14.setTextAlign(Paint.Align.LEFT);
        //FNote
        Column<String> c15 = new Column<>("备注", "fnote");
        c15.setTextAlign(Paint.Align.LEFT);
        //FRemainInStockUnitName;
        Column<String> c16 = new Column<>("采购单位", "fremainInStockUnitName");
        c16.setTextAlign(Paint.Align.LEFT);
        //fremainInStockQty
        Column<BigDecimal> c17 = new Column<>("采购数量", "fremainInStockQty");
        c17.setTextAlign(Paint.Align.LEFT);
        //ftaxNetPrice
        Column<BigDecimal> c18 = new Column<>("净价", "ftaxNetPrice");
        c18.setTextAlign(Paint.Align.LEFT);
        //fwwinType
        Column<BigDecimal> c19 = new Column<>("入库类型", "fwwinType");
        c19.setTextAlign(Paint.Align.LEFT);
        //fstockStatusName
        Column<BigDecimal> c20 = new Column<>("库存状态", "fstockStatusName");
        c20.setTextAlign(Paint.Align.LEFT);
        TableData<InStockEntryBean.DataEntity> listTableData = new TableData<>("收料通知订单详情列表", new ArrayList<InStockEntryBean.DataEntity>()
                , c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20);
        addTable.setTableData(listTableData);
    }

    @OnClick({R.id.iv_add, R.id.iv_scan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_add:
                AddOrderDialog("手动添加明细", 1);
                break;
            case R.id.iv_scan:
                AddOrderDialog("扫码添加明细", 2);
                break;
        }
    }

    @OnClick(R.id.btn_push)
    public void onViewClicked() {

    }

    private void SetDate() {
        modelEntity.setFID(fid);
        //    modelEntity.setFBillNo(billNo);
        //收料组织 必填
        PurchaseOrderAddBean.ModelEntity.FStockOrgIdEntity fStockOrgIdEntity = new PurchaseOrderAddBean.ModelEntity.FStockOrgIdEntity();
        fStockOrgIdEntity.setFNumber("");
        modelEntity.setFStockOrgId(fStockOrgIdEntity);
        //日期 必填
        //    modelEntity.setFDate(date);
        // 单据类型 必填
        PurchaseOrderAddBean.ModelEntity.FBillTypeIDEntity fBillTypeIDEntity = new PurchaseOrderAddBean.ModelEntity.FBillTypeIDEntity();
        fBillTypeIDEntity.setFNUMBER("");
        modelEntity.setFBillTypeID(fBillTypeIDEntity);
        //货主类型 必填
        modelEntity.setFOwnerTypeIdHead("");
        //货主  必填
        PurchaseOrderAddBean.ModelEntity.FOwnerIdHeadEntity fOwnerIdHeadEntity = new PurchaseOrderAddBean.ModelEntity.FOwnerIdHeadEntity();
        fOwnerIdHeadEntity.setFNumber("");
        modelEntity.setFOwnerIdHead(fOwnerIdHeadEntity);
        // 需求组织：FDemandOrgId
        PurchaseOrderAddBean.ModelEntity.FDemandOrgIdEntity fDemandOrgIdEntity = new PurchaseOrderAddBean.ModelEntity.FDemandOrgIdEntity();
        fDemandOrgIdEntity.setFNumber("");
        modelEntity.setFDemandOrgId(fDemandOrgIdEntity);
        // 采购组织：FPurchaseOrgId  (必填项)
        PurchaseOrderAddBean.ModelEntity.FPurchaseOrgIdEntity fPurchaseOrgIdEntity = new PurchaseOrderAddBean.ModelEntity.FPurchaseOrgIdEntity();
        fPurchaseOrgIdEntity.setFNumber("");
        modelEntity.setFPurchaseOrgId(fPurchaseOrgIdEntity);
        //供应商：FSupplierId  (必填项)
        PurchaseOrderAddBean.ModelEntity.FSupplierIdEntity fSupplierIdEntity = new PurchaseOrderAddBean.ModelEntity.FSupplierIdEntity();
        fSupplierIdEntity.setFNumber("");
        modelEntity.setFSupplierId(fSupplierIdEntity);
        // 库存组
        PurchaseOrderAddBean.ModelEntity.FStockerGroupIdEntity fStockerGroupIdEntity = new PurchaseOrderAddBean.ModelEntity.FStockerGroupIdEntity();
        //收料部门
        PurchaseOrderAddBean.ModelEntity.FStockDeptIdEntity fStockDeptIdEntity = new PurchaseOrderAddBean.ModelEntity.FStockDeptIdEntity();
        fStockDeptIdEntity.setFNumber("");
        modelEntity.setFStockDeptId(fStockDeptIdEntity);
        //采购部门：FPurchaseDeptId
        PurchaseOrderAddBean.ModelEntity.FPurchaseDeptIdEntity fPurchaseDeptIdEntity = new PurchaseOrderAddBean.ModelEntity.FPurchaseDeptIdEntity();
        fPurchaseDeptIdEntity.setFNumber("");
        modelEntity.setFPurchaseDeptId(fPurchaseDeptIdEntity);

        // 仓管员：FStockerId
        //PurchaseOrderAddBean.ModelEntity.FStockerIdEntity fStockerIdEntity=new  PurchaseOrderAddBean.ModelEntity.FStockerIdEntity();
        // 对应组织：FCorrespondOrgId
        // PurchaseOrderAddBean.ModelEntity.FCorrespondOrgIdEntity fCorrespondOrgIdEntity=new  PurchaseOrderAddBean.ModelEntity.FCorrespondOrgIdEntity();
        // 采购组：FPurchaserGroupId
        //  PurchaseOrderAddBean.ModelEntity.FPurchaserGroupIdEntity fPurchaserGroupIdEntity=new PurchaseOrderAddBean.ModelEntity.FPurchaserGroupIdEntity();
        // 采购员：FPurchaserId
        modelEntity.setFInStockEntry(fInStockEntryEntityList);
        bean.setModel(modelEntity);
        JsonObject jsonObject = new Gson().toJsonTree(bean).getAsJsonObject();
        Logutil.print("数据", jsonObject.toString());
    }

    private void AddOrderDialog(String title, int type) {
        final PurchaseOrderAddDialog purchaseOrderAddDialog = PurchaseOrderAddDialog.newInstance(title, type);
        purchaseOrderAddDialog.setOnAddOrderListener(new PurchaseOrderAddDialog.OnAddOrderListener() {
            @Override
            public void onConfirm(MaterialListBean.DataEntity materialDate, ProjectListBean.DataEntity projectDate) {

            }

            @Override
            public void onClose() {
                purchaseOrderAddDialog.Close();
            }
        });
        purchaseOrderAddDialog.show(getSupportFragmentManager(), "addorder");
    }
}
