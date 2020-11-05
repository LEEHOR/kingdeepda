package com.kingdee.ah.pda.ui.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.bean.OtherStockHeadBean;
import com.kingdee.ah.pda.bean.ProductionWareHeadBean;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.ui.adapter
 * @ClassName: ProductionWarehosingAdapter
 * @Description: java类作用描述
 * @Author: 李浩
 * @CreateDate: 2020/11/5 14:04
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/5 14:04
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class OtherStockListAdapter extends BaseQuickAdapter<OtherStockHeadBean.DataEntity, BaseViewHolder> {
    public OtherStockListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, OtherStockHeadBean.DataEntity item) {
        helper.setText(R.id.tv_fbillNo,item.getFbillno())
                .setText(R.id.tv_stockOrgName,item.getFstockdirect())
                .setText(R.id.tv_stockDirect,item.getFstockdirect())
                .setText(R.id.tv_bizType,item.getFbiztype())
                .setText(R.id.tv_billTypeName,item.getFbiztype())
                .setText(R.id.tv_date,item.getFdate())
                .setText(R.id.tv_ownerTypeIdHead,item.getFowneridhead())
                .setText(R.id.tv_documentStatus,item.getFdocumentstatus());

    }
}
