package com.kingdee.ah.pda.ui.activity.otherStockOut;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.CellInfo;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.format.bg.BaseBackgroundFormat;
import com.bin.david.form.data.format.bg.BaseCellBackgroundFormat;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.table.TableData;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.OutStockPushBean;
import com.kingdee.ah.pda.ui.dialog.OtherStockModifyDialog;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity.otherStockOut
 * @ClassName: OtherStockOutActivity
 * @Description: java类作用描述
 * 其它出库
 * @Author: 作者名
 * @CreateDate: 2020/10/23 14:22
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 14:22
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class OtherStockOutDetailActivity extends BaseActivity {
    @BindView(R.id.other_stock_out_Detail_title2)
    TitleTopOrdersView otherStockOutTitle;
    @BindView(R.id.tv_stockOrgName)
    EditText tvStockOrgName;
    @BindView(R.id.tv_stockDirect)
    EditText tvStockDirect;
    @BindView(R.id.tv_bizType)
    EditText tvBizType;
    @BindView(R.id.tv_billTypeName)
    EditText tvBillTypeName;
    @BindView(R.id.tv_date)
    EditText tvDate;
    @BindView(R.id.tv_ownerNameHead)
    EditText tvOwnerNameHead;
    @BindView(R.id.other_stock_table)
    SmartTable<OutStockPushBean.DataEntity.DetailsEntity> otherStockTable;
    private OutStockPushBean outStockPushBean;
    private TableData<OutStockPushBean.DataEntity.DetailsEntity> tableData;

    @Override
    protected int getContentResId() {
        return R.layout.activity_other_stock_out_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        otherStockOutTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = otherStockOutTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        createTable();
        if (getIntent() != null) {
            Bundle outDetail = getIntent().getBundleExtra("outDetail");
            int pageType = getIntent().getIntExtra("pageType", 0);
            if (pageType==0){
                tex_item.setText("其他出库单详情");
            } else {
                tex_item.setText("其他出库单新增");
            }
            outStockPushBean = (OutStockPushBean) outDetail.get("outstock");
            if (outStockPushBean != null) {
                OutStockPushBean.DataEntity data = outStockPushBean.getData();
                tvStockOrgName.setText(data.getStockOrgName());
                tvStockDirect.setText(data.getStockDirect());
                tvBizType.setText(data.getBizType());
                tvBillTypeName.setText(data.getBillTypeName());
                tvDate.setText(data.getDate());
                tvOwnerNameHead.setText(data.getOwnerNameHead());
                List<OutStockPushBean.DataEntity.DetailsEntity> details = data.getDetails();
                otherStockTable.addData(details,true);
            }
        }

    }

    @Override
    protected void initfun() {



    }

    //创建表格
    private void createTable() {
        otherStockTable.getConfig().setShowYSequence(true);
        otherStockTable.getConfig().setShowXSequence(false);
        otherStockTable.getConfig().setShowTableTitle(false);
        otherStockTable.getConfig().setVerticalPadding(24);
        otherStockTable.getConfig().setContentStyle(new FontStyle(45, Color.BLUE));
        otherStockTable.getConfig().setColumnTitleStyle(new FontStyle(45, Color.WHITE));
        otherStockTable.getConfig().setColumnTitleBackground(new BaseBackgroundFormat(getResources().getColor(R.color.titlebar_color)));
        otherStockTable.getConfig().setContentCellBackgroundFormat(new BaseCellBackgroundFormat<CellInfo>() {
            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                if (cellInfo.row % 2 == 0) {
                    return ContextCompat.getColor(OtherStockOutDetailActivity.this, R.color.actions_background_light);
                } else {
                    return ContextCompat.getColor(OtherStockOutDetailActivity.this, R.color.yellowF23757);
                    // return TableConfig.INVALID_COLOR; //返回无效颜色，不会绘制
                }
            }
        });
        Column<String> c1 = new Column<>("物料编码", "materialId");
        Column<String> c2 = new Column<>("项目名称", "paezProjectName");
        Column<String> c3 = new Column<>("物料编码", "materialId");
        Column<String> c4 = new Column<>("物料名称", "materialName");
        Column<String> c5 = new Column<>("单位", "unitName");
        Column<Integer> c6 = new Column<>("实发数量", "qty");
        tableData = new TableData<OutStockPushBean.DataEntity.DetailsEntity>("出库申请", new ArrayList<OutStockPushBean.DataEntity.DetailsEntity>()
                , c1, c2, c3, c4, c5, c6);
        otherStockTable.setTableData(tableData);

        tableData.setOnRowClickListener(new TableData.OnRowClickListener<OutStockPushBean.DataEntity.DetailsEntity>() {
            @Override
            public void onClick(Column column, final OutStockPushBean.DataEntity.DetailsEntity detailsEntity, int col, final int row) {
                OtherStockModifyDialog modifyDialog=OtherStockModifyDialog.newInstance("修改数量",detailsEntity.getPaezProjectName(),detailsEntity.getPaezProject(),
                        detailsEntity.getQty());
                modifyDialog.setOnModifyOrderListener(new OtherStockModifyDialog.OnModifyOrderListener() {
                    @Override
                    public void onConfirm(int qty) {
                        List<OutStockPushBean.DataEntity.DetailsEntity> t = tableData.getT();
                        t.remove(row);
                        t.add(row,detailsEntity);
                        tableData.clear();
                        otherStockTable.setData(t);
                    }

                    @Override
                    public void onClose() {

                    }
                });
                modifyDialog.show(getSupportFragmentManager(),"数量");
            }
        });

    }
}
