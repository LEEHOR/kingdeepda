package com.kingdee.ah.pda.ui.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.bean.ProcessReportBean;
import com.kingdee.ah.pda.bean.SalDeliverynoticeBean;

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
public class SalDeliverNoticeAdapter extends BaseQuickAdapter<SalDeliverynoticeBean.DataEntity, BaseViewHolder> {
    public SalDeliverNoticeAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, SalDeliverynoticeBean.DataEntity item) {
        helper.setText(R.id.tv_fbillNo, item.getBillNo())
                .setText(R.id.tv_date, item.getDate().substring(0, item.getDate().indexOf("T")))
                .addOnClickListener(R.id.btn_detail, R.id.btn_push);
    }
}
