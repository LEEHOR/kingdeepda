package com.kingdee.ah.pda.ui.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.bean.OutStockApplyBean;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.ui.adapter
 * @ClassName: OutStockAdapter
 * @Description: java类作用描述
 * @Author: 李浩
 * @CreateDate: 2020/11/3 17:32
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/3 17:32
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class OutStockAdapter extends BaseQuickAdapter<OutStockApplyBean.DataEntity, BaseViewHolder> {
    public OutStockAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, OutStockApplyBean.DataEntity item) {
                helper.setText(R.id.tv_fbillNo,item.getBillNo())
                        .setText(R.id.tv_ownerTypeIdHead,item.getOwnerTypeIdHead())
                        .setText(R.id.tv_date,item.getDate())
                        .setText(R.id.tv_stockOrgName,item.getStockOrgName())
                        .setText(R.id.tv_billTypeName,item.getBillTypeName())
                        .setText(R.id.tv_deptName,item.getDeptName())
                        .addOnClickListener(R.id.btn_push,R.id.btn_detail);
    }
}
