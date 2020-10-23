package com.jeewms.www.wms.ui.activity.processReport;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity1;
import com.jeewms.www.wms.ui.view.TitleTopOrdersView;

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
public class ProcessReportDetail extends BaseActivity1 {
    @BindView(R.id.processDetail_title2)
    TitleTopOrdersView processDetailTitle;

    @Override
    protected int getContentResId() {
        return R.layout.activity_process_report_detail2;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        processDetailTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TextView tex_item = processDetailTitle.getTex_item();
        tex_item.setVisibility(View.INVISIBLE);
        tex_item.setText("工序汇报详情页");
    }

    @Override
    protected void initfun() {

    }

}
