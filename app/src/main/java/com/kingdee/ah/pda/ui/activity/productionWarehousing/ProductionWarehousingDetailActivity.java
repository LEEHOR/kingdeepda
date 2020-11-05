package com.kingdee.ah.pda.ui.activity.productionWarehousing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.CellInfo;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.format.bg.BaseBackgroundFormat;
import com.bin.david.form.data.format.bg.BaseCellBackgroundFormat;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.table.TableData;
import com.google.gson.JsonObject;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.PurchaseAddBean;
import com.kingdee.ah.pda.bean.PushProcessReportBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.activity.purchaseWarehousing.PurchaseWarehousingDetailActivity;
import com.kingdee.ah.pda.ui.dialog.ProductionWareModifyDialog;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;
import com.kingdee.ah.pda.util.GsonUtils;
import com.kingdee.ah.pda.util.ToastUtil;
import com.kingdee.ah.pda.volley.HTTPUtils;
import com.kingdee.ah.pda.volley.VolleyListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity.productionWarehousing
 * @ClassName: ProductionWarehousingActivity
 * @Description: java类作用描述
 * 生产入库
 * @Author: 作者名
 * @CreateDate: 2020/10/23 11:26
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 11:26
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ProductionWarehousingDetailActivity extends BaseActivity {
    @BindView(R.id.production_warehousing_Detail_title)
    TitleTopOrdersView processDetailTitle;
    @BindView(R.id.tv_stockOrgName)
    EditText tvStockOrgName;
    @BindView(R.id.tv_prdOrgName)
    EditText tvPrdOrgName;
    @BindView(R.id.tv_ownerName)
    EditText tvOwnerName;
    @BindView(R.id.tv_billTypeName)
    EditText tvBillTypeName;
    @BindView(R.id.tv_date)
    EditText tvDate;
    @BindView(R.id.production_table)
    SmartTable<PushProcessReportBean.DataEntity.DetailsEntity> productionTable;
    @BindView(R.id.btn_push)
    Button btnPush;
    private TableData<PushProcessReportBean.DataEntity.DetailsEntity> tableData;
    private PushProcessReportBean.DataEntity reportBeanData;

    @Override
    protected int getContentResId() {
        return R.layout.activity_production_wares_detail;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, ProductionWarehousingDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        processDetailTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        TextView tex_item = processDetailTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        if (getIntent() != null) {
            Bundle process = getIntent().getExtras();
            int pageType = getIntent().getIntExtra("pageType", 0);
            if (pageType ==0){
                btnPush.setVisibility(View.GONE);
                tex_item.setText("生产入库单详情");
            } else {
                tex_item.setText("生产入库单新增");
            }
            if (process != null) {
                PushProcessReportBean reportBean = (PushProcessReportBean) process.get("process");
                reportBeanData = reportBean.getData();
                tvStockOrgName.setText(reportBeanData.getStockOrgName());
                tvPrdOrgName.setText(reportBeanData.getPrdOrgName());
                tvOwnerName.setText(reportBeanData.getOwnerName());
                tvBillTypeName.setText(reportBeanData.getBillTypeName());
                tvDate.setText(reportBeanData.getDate());
                List<PushProcessReportBean.DataEntity.DetailsEntity> details = reportBeanData.getDetails();
                productionTable.addData(details, true);
            }
        }

        createTable();
    }

    @Override
    protected void initfun() {


        tableData.setOnRowClickListener(new TableData.OnRowClickListener<PushProcessReportBean.DataEntity.DetailsEntity>() {
            @Override
            public void onClick(Column column, final PushProcessReportBean.DataEntity.DetailsEntity detailsEntity, int col, final int row) {
                ProductionWareModifyDialog modifyDialog = ProductionWareModifyDialog.newInstance("更改数量", detailsEntity.getMaterialName(), detailsEntity.getSpecification(),
                        detailsEntity.getMustQty(), detailsEntity.getRealQty());
                modifyDialog.setOnModifyOrderListener(new ProductionWareModifyDialog.OnModifyOrderListener() {
                    @Override
                    public void onConfirm(int fmustQty, int frealQtyint) {
                        List<PushProcessReportBean.DataEntity.DetailsEntity> t = tableData.getT();
                        detailsEntity.setMustQty(fmustQty);
                        detailsEntity.setRealQty(frealQtyint);
                        t.remove(row);
                        t.add(row, detailsEntity);
                        tableData.clear();
                        productionTable.setData(t);
                    }

                    @Override
                    public void onClose() {
                    }
                });
                modifyDialog.show(getSupportFragmentManager(), "入库");
            }
        });

    }

    //创建表格
    private void createTable() {
        productionTable.getConfig().setShowYSequence(true);
        productionTable.getConfig().setShowXSequence(false);
        productionTable.getConfig().setShowTableTitle(false);
        productionTable.getConfig().setVerticalPadding(24);
        productionTable.getConfig().setContentStyle(new FontStyle(45, Color.BLUE));
        productionTable.getConfig().setColumnTitleStyle(new FontStyle(45, Color.WHITE));
        productionTable.getConfig().setColumnTitleBackground(new BaseBackgroundFormat(getResources().getColor(R.color.titlebar_color)));
        productionTable.getConfig().setContentCellBackgroundFormat(new BaseCellBackgroundFormat<CellInfo>() {
            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                if (cellInfo.row % 2 == 0) {
                    return ContextCompat.getColor(ProductionWarehousingDetailActivity.this, R.color.black_f5f5f5);
                } else {
                    return ContextCompat.getColor(ProductionWarehousingDetailActivity.this, R.color.yellowF23757);
                    // return TableConfig.INVALID_COLOR; //返回无效颜色，不会绘制
                }
            }
        });
        Column<String> c1 = new Column<>("物料编码", "materialId");
        Column<String> c2 = new Column<>("物料名称", "materialName");
        Column<String> c3 = new Column<>("规格型号", "specification");
        Column<String> c4 = new Column<>("入库类型", "inStockType");
        Column<String> c5 = new Column<>("单位", "unitName");
        Column<Integer> c6 = new Column<>("应收数量", "mustQty");
        Column<Integer> c7 = new Column<>("实收数量", "realQty");
        Column<String> c8 = new Column<>("仓库", "stockName");
        Column<String> c9 = new Column<>("批号", "lot");
        tableData = new TableData<>("生产入库详情", new ArrayList<PushProcessReportBean.DataEntity.DetailsEntity>()
                , c1, c2, c4, c5, c3, c8, c9);
        productionTable.setTableData(tableData);
    }


    //生产入库审核
    private void push() {
        if (reportBeanData != null) {
            reportBeanData.setDetails(tableData.getT());
            JsonObject jsonObject = GsonUtils.parseJsonObject(reportBeanData);
            ShowProgress(this,"正在入库...",false);
            String pushproduction = Constance.getPushProduction();
            HTTPUtils.getInstance(this).postByJson(pushproduction, PurchaseAddBean.class, jsonObject, new VolleyListener<PurchaseAddBean>() {
                @Override
                public void requestComplete() {
                    CancelProgress();
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }

                @Override
                public void onResponse(PurchaseAddBean response) {
                    int code = response.getCode();
                    if (code == 0) {
                        ToastUtil.show(ProductionWarehousingDetailActivity.this, response.getMsg());
                    } else {
                        List<PurchaseAddBean.DataEntity> data = response.getData();
                        StringBuilder stringBuilder = new StringBuilder();
                        if (data != null) {
                            for (PurchaseAddBean.DataEntity d : data) {
                                stringBuilder.append(d.getMessage());
                            }
                        }
                        ToastUtil.showLong(ProductionWarehousingDetailActivity.this, stringBuilder.toString());
                    }
                }
            });
        }
    }
    @OnClick(R.id.btn_push)
    public void onViewClicked() {
        push();
    }
}
