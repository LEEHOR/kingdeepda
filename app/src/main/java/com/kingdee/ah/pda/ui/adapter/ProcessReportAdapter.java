package com.kingdee.ah.pda.ui.adapter;

import android.support.annotation.NonNull;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.bean.ProcessReportBean;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.ui.adapter
 * @ClassName: ProcessReportAdapter
 * @Description: java类作用描述
 * 工序汇报
 * @Author: 李浩
 * @CreateDate: 2020/11/3 10:46
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/3 10:46
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ProcessReportAdapter extends BaseQuickAdapter<ProcessReportBean.DataEntity, BaseViewHolder> {
    public ProcessReportAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ProcessReportBean.DataEntity item) {
            helper.setText(R.id.tv_fbillNo,item.getBillNo())
                    .setText(R.id.tv_billTypeName,item.getBillTypeName())
                    .setText(R.id.tv_date,item.getDate())
                    .setText(R.id.tv_workShopName,item.getWorkShopName())
                    .setText(R.id.tv_documentStatus,item.getDocumentStatus())
                    .addOnClickListener(R.id.btn_detail,R.id.btn_push);
    }
}
