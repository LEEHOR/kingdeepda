package com.kingdee.ah.pda.ui.activity.warehouseOutApplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
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
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.OutStockApplyDetailBean;
import com.kingdee.ah.pda.bean.ProcessReportDetailBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.activity.processReport.ProcessReportDetailActivity;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;
import com.kingdee.ah.pda.util.GsonUtils;
import com.kingdee.ah.pda.volley.HTTPUtils;
import com.kingdee.ah.pda.volley.VolleyListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity.WarehouseOutApplication
 * @ClassName: WarehousOutApplicationActivity
 * @Description: java类作用描述
 * 出库申请列表
 * @Author: 作者名
 * @CreateDate: 2020/10/23 13:38
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 13:38
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class WarehouseOutApplicationDetailActivity extends BaseActivity {


    @BindView(R.id.warehose_out_detail_title)
    TitleTopOrdersView outDetailTitle;
    @BindView(R.id.tv_ownerTypeIdHead)
    EditText tvOwnerTypeIdHead;
    @BindView(R.id.tv_stockOrgName)
    EditText tvStockOrgName;
    @BindView(R.id.tv_date)
    EditText tvDate;
    @BindView(R.id.tv_billTypeName)
    EditText tvBillTypeName;
    @BindView(R.id.tv_departName)
    EditText tvDepartName;
    @BindView(R.id.outStock_detail_table)
    SmartTable<OutStockApplyDetailBean.DataEntity.EntitysEntity> outStockDetailTable;
    private int fid;

    @Override
    protected int getContentResId() {
        return R.layout.activity_waresehousing_out_detail;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, WarehouseOutApplicationDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (getIntent() != null) {
            fid = getIntent().getIntExtra("fid", 0);
        }
        outDetailTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = outDetailTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("出库申请详情页");
    }

    @Override
    protected void initfun() {
        createTable();
        getDetail();
    }

    private void getDetail() {
        String outstockapplydetail = Constance.getOUTSTOCKAPPLYDETAIL();
        ShowProgress(this, "正在加载...", false);
        HTTPUtils.getInstance(this).get(outstockapplydetail + fid, new VolleyListener<String>() {
            @Override
            public void requestComplete() {
                CancelProgress();
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onResponse(String response) {
                OutStockApplyDetailBean outStockApplyDetailBean = GsonUtils.parseJSON(response, OutStockApplyDetailBean.class);
                int code = outStockApplyDetailBean.getCode();
                if (code == 0) {
                    OutStockApplyDetailBean.DataEntity data = outStockApplyDetailBean.getData();
                    tvStockOrgName.setText(data.getStockOrgName());
                    tvOwnerTypeIdHead.setText(data.getOwnerTypeIdHead());
                    tvBillTypeName.setText(data.getBillTypeName());
                    tvDate.setText(data.getDate());
                    tvDepartName.setText(data.getDeptName());
                    List<OutStockApplyDetailBean.DataEntity.EntitysEntity> entitys = data.getEntitys();
                    outStockDetailTable.addData(entitys,true);
                }
            }
        });
    }

    //创建表格
    private void createTable() {
        outStockDetailTable.getConfig().setShowYSequence(false);
        outStockDetailTable.getConfig().setShowXSequence(false);
        outStockDetailTable.getConfig().setShowTableTitle(false);
        outStockDetailTable.getConfig().setVerticalPadding(24);
        outStockDetailTable.getConfig().setContentStyle(new FontStyle(45, Color.BLUE));
        outStockDetailTable.getConfig().setColumnTitleStyle(new FontStyle(45, Color.WHITE));
        outStockDetailTable.getConfig().setColumnTitleBackground(new BaseBackgroundFormat(getResources().getColor(R.color.titlebar_color)));
        outStockDetailTable.getConfig().setContentCellBackgroundFormat(new BaseCellBackgroundFormat<CellInfo>() {
            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                if (cellInfo.row % 2 == 0) {
                    return ContextCompat.getColor(WarehouseOutApplicationDetailActivity.this, R.color.actions_background_light);
                } else {
                    return ContextCompat.getColor(WarehouseOutApplicationDetailActivity.this, R.color.yellowF23757);
                    // return TableConfig.INVALID_COLOR; //返回无效颜色，不会绘制
                }
            }
        });
        Column<String> c1 = new Column<>("项目编码", "paezProject");

        Column<String> c2 = new Column<>("项目名称", "paezProjectName");
        Column<String> c3 = new Column<>("物料编码", "materialId");
        Column<String> c4 = new Column<>("物料名称", "materialName");
        Column<String> c5 = new Column<>("单位", "unitName");
        Column<Integer> c6 = new Column<>("申请数量", "qty");
        Column<String> c7 = new Column<>("库存组织", "stockOrgName");
        TableData<OutStockApplyDetailBean.DataEntity.EntitysEntity> tableData=new TableData<OutStockApplyDetailBean.DataEntity.EntitysEntity>("出库申请",new ArrayList<OutStockApplyDetailBean.DataEntity.EntitysEntity>()
        ,c1, c2, c3, c4, c5, c6,c7);
        outStockDetailTable.setTableData(tableData);
    }

}
