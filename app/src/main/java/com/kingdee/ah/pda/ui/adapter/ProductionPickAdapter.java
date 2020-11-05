package com.kingdee.ah.pda.ui.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.bean.ProductionPickHeadBean;

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
public class ProductionPickAdapter extends BaseQuickAdapter<ProductionPickHeadBean.DataEntity, BaseViewHolder> {
    public ProductionPickAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ProductionPickHeadBean.DataEntity item) {
            helper.setText(R.id.tv_fbillNo,item.getFbillNo())
                    .setText(R.id.tv_fbillTypeName,item.getFbillTypeName())
                    .setText(R.id.tv_date,item.getFdate().substring(0,item.getFdate().indexOf("T")))
                    .setText(R.id.tv_fdocumentStatusName,item.getFdocumentStatusName())
                    .setText(R.id.tv_fstockOrgName,item.getFstockOrgName())
                    .setText(R.id.tv_fprdOrgName,item.getFprdOrgName())
                    .setText(R.id.tv_fpickerName,item.getFpickerName())
                    .setText(R.id.tv_fstockername,item.getFstockername());
    }
}
