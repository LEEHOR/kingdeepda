package com.kingdee.ah.pda.ui.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kingdee.ah.pda.R;
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
public class ProductionWarehosingAdapter extends BaseQuickAdapter<ProductionWareHeadBean.DataEntity, BaseViewHolder> {
    public ProductionWarehosingAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ProductionWareHeadBean.DataEntity item) {
            helper.setText(R.id.tv_fbillNo,item.getFbillno())
                    .setText(R.id.tv_billTypeName,item.getFbilltype())
                    .setText(R.id.tv_date,item.getFdate())
                    .setText(R.id.tv_stockOrgName,item.getFstockid0())
                    .setText(R.id.tv_prdOrgName,item.getFpaezproject())
                    .setText(R.id.tv_ownerName,item.getFownerid0())
                    .setText(R.id.tv_documentStatus,item.getFdocumentstatus());
    }
}
