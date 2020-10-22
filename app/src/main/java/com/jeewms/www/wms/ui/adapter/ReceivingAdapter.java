package com.jeewms.www.wms.ui.adapter;

import android.support.annotation.NonNull;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.ReceiveBillBean;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.adapter
 * @ClassName: ReceivingAdapter
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/16 15:12
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/16 15:12
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ReceivingAdapter extends BaseQuickAdapter<ReceiveBillBean.DataEntity, BaseViewHolder> {
    public ReceivingAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ReceiveBillBean.DataEntity item) {
        helper.setText(R.id.tv_receiving_orderNumber, item.getBillNo())
                .setText(R.id.tv_receiving_time,item.getDate())
                .setText(R.id.tv_receiving_fbillType,item.getFbillType())
                .setText(R.id.tv_receiving_fbusinessType,item.getFbusinessType())
                .setText(R.id.tv_receiving_fstockOrgName,item.getFstockOrgName())
                .setText(R.id.tv_receiving_fdemandOrgName,item.getFdemandOrgName())
                .setText(R.id.tv_receiving_fpurOrgName,item.getFpurOrgName())
                .setText(R.id.tv_receiving_fsupplierName,item.getFsupplierName())
                .setText(R.id.tv_receiving_freceiveDeptName,item.getFreceiveDeptName()==null?"未知":item.getFreceiveDeptName())
                .addOnClickListener(R.id.receiving_detail,R.id.receiving_purchase_warehousing);
        String documentStatus = item.getDocumentStatus();
        TextView textView = helper.getView(R.id.tv_receiving_supplier);
        switch (documentStatus) {
            case "Z":
                textView.setText("暂存");
                break;
            case "A":
                textView.setText("创建");
                break;
            case "B":
                textView.setText("审核中");
                break;
            case "C":
                textView.setText("已审核");
                break;
            case "D":
                textView.setText("重新审核");
                break;

        }

    }
}
