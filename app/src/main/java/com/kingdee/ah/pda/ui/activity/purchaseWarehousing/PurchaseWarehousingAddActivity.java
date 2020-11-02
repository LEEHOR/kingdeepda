package com.kingdee.ah.pda.ui.activity.purchaseWarehousing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

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
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.InStockEntryBean;
import com.kingdee.ah.pda.bean.InStockHeadBean;
import com.kingdee.ah.pda.bean.UpdatePwd;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.dialog.DepartmentDialog;
import com.kingdee.ah.pda.ui.dialog.OrganizationsDialog;
import com.kingdee.ah.pda.ui.dialog.PurchaseOrderAddDialog;
import com.kingdee.ah.pda.ui.dialog.SupplierDialog;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;
import com.kingdee.ah.pda.util.Logutil;
import com.kingdee.ah.pda.volley.HTTPUtils;
import com.kingdee.ah.pda.volley.VolleyListener;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
public class PurchaseWarehousingAddActivity extends BaseActivity {
    @BindView(R.id.purchase_warehousing_add_title)
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
    private InStockHeadBean.DataEntity TableHeadData=new InStockHeadBean.DataEntity();
    private List<InStockEntryBean.DataEntity> TableBodyDate = new ArrayList<>();
    //选择记录
   private int organization=9999;
    private int department=9999;
    private int supplier=9999;
    private OrganizationsDialog organizationsDialog;
    private DepartmentDialog departmentDialog;
    private SupplierDialog supplierDialog;

    @Override
    protected int getContentResId() {
        return R.layout.activity_purchase_warehousing_add;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, PurchaseWarehousingAddActivity.class);
        context.startActivity(intent);
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
        receivingDetailTitle.getTex_item().setText("采购入库新增");

    }

    @Override
    protected void initfun() {
        addTable.getConfig().setShowYSequence(false);
        addTable.getConfig().setShowXSequence(false);
        addTable.getConfig().setShowTableTitle(false);
        addTable.getConfig().setContentStyle(new FontStyle(38, Color.BLUE));
        addTable.getConfig().setColumnTitleStyle(new FontStyle(45, Color.WHITE));
        addTable.getConfig().setColumnTitleBackground(new BaseBackgroundFormat(getResources().getColor(R.color.titlebar_color)));
        addTable.getConfig().setContentCellBackgroundFormat(new BaseCellBackgroundFormat<CellInfo>() {
            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                if (cellInfo.row % 2 == 0) {
                    return ContextCompat.getColor(PurchaseWarehousingAddActivity.this, R.color.actions_background_light);
                } else {
                    return TableConfig.INVALID_COLOR; //返回无效颜色，不会绘制
                }
            }
        });
        createTab();
        Dialog();
    }
    private void Dialog(){
        //组织
        organizationsDialog = OrganizationsDialog.newInstance(organization);
        organizationsDialog.setListener(new OrganizationsDialog.OrganizationSelectListener() {
            @Override
            public void onConfirm(String name, String number, int position) {
                organization=position;
                tvFpurchaseOrgName.setText(name);
                TableHeadData.setFpurchaseOrgNumber(number);
            }

            @Override
            public void onClose() {
                organizationsDialog.Close();
               // organizationsDialog.Close();
            }
        });
        //部门
        departmentDialog = DepartmentDialog.newInstance(department);
        departmentDialog.setListener(new DepartmentDialog.DepartmentSelectListener() {
            @Override
            public void onConfirm(String name, String number, int position) {
                department=position;
                tvFstockDeptName.setText(name);
                TableHeadData.setFstockDeptNumber(number);
            }

            @Override
            public void onClose() {
                departmentDialog.Close();
            }
        });
        //供应商
        supplierDialog = SupplierDialog.newInstance(supplier);
        supplierDialog.setListener(new SupplierDialog.SupplierSelectListener() {
            @Override
            public void onConfirm(String name, String number,int position) {
                supplier=position;
                tvFsupplierName.setText(name);
                TableHeadData.setFsupplierNumber(number);
            }

            @Override
            public void onClose() {
                supplierDialog.Close();
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
        addTable.getTableData().setOnRowClickListener(new TableData.OnRowClickListener() {
            @Override
            public void onClick(Column column, Object o, int col, int row) {
                List<InStockEntryBean.DataEntity> t = addTable.getTableData().getT();
                if (t != null) {
                    InStockEntryBean.DataEntity dataEntity = t.get(row);
                    Logutil.print("打印",dataEntity.getProjectNumber());
                }
            }
        });
    }

    @OnClick(R.id.btn_push)
    public void onViewClicked() {
       // SaveDate();
    }

    //保存
    private void SaveDate() {
        Gson gson = new GsonBuilder().serializeNulls().create();
//        String s = gson.toJson(TableHeadData);
//        JSONObject jsonObject = null;
//        try {
//            jsonObject = new JSONObject(s);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        Logutil.print("数据11", jsonObject.toString());
        JsonObject asJsonObject = gson.toJsonTree(TableHeadData).getAsJsonObject();
    //    Logutil.print("数据", asJsonObject.toString());
        String stkInStockAdd = Constance.getStkInStockAdd();
        HTTPUtils.getInstance(this).postByJson(stkInStockAdd, UpdatePwd.class, asJsonObject, new VolleyListener<UpdatePwd>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onResponse(UpdatePwd response) {

            }
        });
    }

    private void AddOrderDialog(String title, int type) {
        TableBodyDate.clear();
        final PurchaseOrderAddDialog purchaseOrderAddDialog = PurchaseOrderAddDialog.newInstance(title, type);
        purchaseOrderAddDialog.setOnAddOrderListener(new PurchaseOrderAddDialog.OnAddOrderListener() {
            @Override
            public void onConfirm(InStockEntryBean.DataEntity body) {
                TableBodyDate.add(body);
                addTable.addData(TableBodyDate,true);
            }
            @Override
            public void onClose() {
                purchaseOrderAddDialog.Close();
            }
        });
        purchaseOrderAddDialog.show(getFragmentManager(), "addorder");
    }

    @OnClick({R.id.iv_add, R.id.iv_scan,R.id.tv_fbillTypeName, R.id.tv_fstockOrgNamee, R.id.tv_fpurchaseOrgName, R.id.tv_fbusinessType, R.id.tv_fstockDeptName, R.id.tv_fpurchaseDeptName, R.id.tv_fbillNo, R.id.tv_fstockerGroupName, R.id.tv_fpurchaserGroupName, R.id.tv_fdate, R.id.tv_fstockerName, R.id.tv_fpurchaserName, R.id.tv_fdocumentStatus, R.id.tv_fsupplierName, R.id.tv_fdemandOrgName, R.id.tv_fsettleName, R.id.tv_fsupplyName, R.id.tv_fproviderContactName, R.id.tv_fsupplyAddress, R.id.tv_fchargeName})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_add:
                AddOrderDialog("手动添加明细", 1);
                break;
            case R.id.iv_scan:
                AddOrderDialog("扫码添加明细", 2);
                break;
            case R.id.tv_fbillTypeName:
                break;
            case R.id.tv_fstockOrgNamee:
                break;
            case R.id.tv_fpurchaseOrgName://组织
                organizationsDialog.setPosition(organization);
                organizationsDialog.show(getFragmentManager(),"组织");
                break;
            case R.id.tv_fbusinessType:
                break;
            case R.id.tv_fstockDeptName: //采购部门
                departmentDialog.show(getFragmentManager(),"部门");
                break;
            case R.id.tv_fpurchaseDeptName:
                break;
            case R.id.tv_fbillNo:
                break;
            case R.id.tv_fstockerGroupName:
                break;
            case R.id.tv_fpurchaserGroupName:
                break;
            case R.id.tv_fdate:
                break;
            case R.id.tv_fstockerName:
                break;
            case R.id.tv_fpurchaserName:
                break;
            case R.id.tv_fdocumentStatus:
                break;
            case R.id.tv_fsupplierName: //供应商
                supplierDialog.show(getFragmentManager(),"供应商");
                break;
            case R.id.tv_fdemandOrgName:
                break;
            case R.id.tv_fsettleName:
                break;
            case R.id.tv_fsupplyName:
                break;
            case R.id.tv_fproviderContactName:
                break;
            case R.id.tv_fsupplyAddress:
                break;
            case R.id.tv_fchargeName:
                break;
        }
    }
}
