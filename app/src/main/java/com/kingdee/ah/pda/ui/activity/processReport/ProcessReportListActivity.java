package com.kingdee.ah.pda.ui.activity.processReport;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ajguan.library.EasyRefreshLayout;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;

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
        processTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TextView tex_item = processTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("工序汇报列表页");

    }

    @Override
    protected void initfun() {

    }

    @OnClick(R.id.iv_scan)
    public void onViewClicked() {
        Intent intent=new Intent(ProcessReportListActivity.this,ProcessReportDetail.class);
        startActivity(intent);
    }
}
