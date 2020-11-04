package com.kingdee.ah.pda.ui.activity.processReport;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
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
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.ProcessReportDetailBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;
import com.kingdee.ah.pda.util.GsonUtils;
import com.kingdee.ah.pda.volley.HTTPUtils;
import com.kingdee.ah.pda.volley.VolleyListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity.processReport
 * @ClassName: ProcessReportDetail
 * @Description: java类作用描述
 * 工序汇报详情
 * @Author: 作者名
 * @CreateDate: 2020/10/23 9:06
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 9:06
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ProcessReportDetailActivity extends BaseActivity {
    @BindView(R.id.processDetail_title2)
    TitleTopOrdersView processDetailTitle;
    @BindView(R.id.tv_billNo)
    EditText tvBillNo;
    @BindView(R.id.tv_prdOrgName)
    EditText tvPrdOrgName;
    @BindView(R.id.tv_billTypeName)
    EditText tvBillTypeName;
    @BindView(R.id.tv_date)
    EditText tvDate;
    @BindView(R.id.process_detail_table)
    SmartTable<ProcessReportDetailBean.DataEntity.DetailsEntity> processDetailTable;
    private int fid;


    @Override
    protected int getContentResId() {
        return R.layout.activity_process_report_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (getIntent() != null) {
            fid = getIntent().getIntExtra("fid", 0);
        }
        processDetailTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = processDetailTitle.getTex_item();
        tex_item.setVisibility(View.INVISIBLE);
        tex_item.setText("工序汇报详情页");


    }

    @Override
    protected void initfun() {
        createTable();
        getData();
    }


    //创建表格列
    private void createTable() {
        processDetailTable.getConfig().setShowYSequence(true);
        processDetailTable.getConfig().setShowXSequence(false);
        processDetailTable.getConfig().setShowTableTitle(false);
        processDetailTable.getConfig().setVerticalPadding(24);
        processDetailTable.getConfig().setContentStyle(new FontStyle(45, Color.BLUE));
        processDetailTable.getConfig().setColumnTitleStyle(new FontStyle(45, Color.WHITE));
        processDetailTable.getConfig().setColumnTitleBackground(new BaseBackgroundFormat(getResources().getColor(R.color.titlebar_color)));
        processDetailTable.getConfig().setContentCellBackgroundFormat(new BaseCellBackgroundFormat<CellInfo>() {
            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                if (cellInfo.row % 2 == 0) {
                    return ContextCompat.getColor(ProcessReportDetailActivity.this, R.color.actions_background_light);
                } else {
                    return ContextCompat.getColor(ProcessReportDetailActivity.this, R.color.yellowF23757);
                    // return TableConfig.INVALID_COLOR; //返回无效颜色，不会绘制
                }
            }
        });
        Column<String> c1 = new Column<>("moNumber", "moNumber");
        c1.setTextAlign(Paint.Align.LEFT);
        Column<String> c2 = new Column<>("seqNumber", "seqNumber");
        c2.setTextAlign(Paint.Align.CENTER);
        Column<String> c3 = new Column<>("operNumber", "operNumber");
        c3.setTextAlign(Paint.Align.CENTER);
        Column<String> c4 = new Column<>("materialId", "materialId");
        c4.setTextAlign(Paint.Align.LEFT);
        Column<String> c5 = new Column<>("materialName", "materialName");
        c5.setTextAlign(Paint.Align.LEFT);
        Column<String> c6 = new Column<>("unitName", "unitName");
        c6.setTextAlign(Paint.Align.LEFT);
        Column<Integer> c7 = new Column<>("processFailQty", "processFailQty");
        c7.setTextAlign(Paint.Align.CENTER);
        Column<Integer> c8 = new Column<>("finishQty", "finishQty");
        c8.setTextAlign(Paint.Align.CENTER);
        Column<Integer> c9 = new Column<>("quaQty", "quaQty");
        c9.setTextAlign(Paint.Align.CENTER);
        Column<Integer> c10 = new Column<>("finishQty", "finishQty");
        c10.setTextAlign(Paint.Align.CENTER);
        Column<String> c11 = new Column<>("specification", "specification");
        c11.setTextAlign(Paint.Align.LEFT);

        TableData<ProcessReportDetailBean.DataEntity.DetailsEntity> listTableData = new TableData<>("收料通知订单详情列表", new ArrayList<ProcessReportDetailBean.DataEntity.DetailsEntity>()
                , c1, c2, c3, c4, c5, c6, c8, c9, c10, c11);
        processDetailTable.setTableData(listTableData);
    }



    private void getData() {
        ShowProgress(this,"正在加载...",false);
        String processReportDetail = Constance.getProcessReportDetail();
        HTTPUtils.getInstance(this).get(processReportDetail + fid, new VolleyListener<String>() {
            @Override
            public void requestComplete() {
            CancelProgress();
            }

            @Override
            public void onErrorResponse(VolleyError error) {
            }

            @Override
            public void onResponse(String response) {
                ProcessReportDetailBean processReportDetailBean = GsonUtils.parseJSON(response, ProcessReportDetailBean.class);
                int code = processReportDetailBean.getCode();
                if (code == 0) {
                    ProcessReportDetailBean.DataEntity data = processReportDetailBean.getData();
                    tvBillNo.setText(data.getBillNo());
                    tvBillTypeName.setText(data.getBillTypeName());
                    tvDate.setText(data.getDate());
                    tvPrdOrgName.setText(data.getPrdOrgName());
                    List<ProcessReportDetailBean.DataEntity.DetailsEntity> details = data.getDetails();
                    processDetailTable.addData(details,true);
                }
            }
        });
    }

}
