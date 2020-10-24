package com.jeewms.www.wms.ui.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.InStockHeadBean;


/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.adapter
 * @ClassName: PurchaseWarehousingAdapter
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/24 9:40
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/24 9:40
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class PurchaseWarehousingAdapter extends BaseQuickAdapter<InStockHeadBean.DataEntity, BaseViewHolder> {
    public PurchaseWarehousingAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, InStockHeadBean.DataEntity item) {
            helper.setText(R.id.tv_fbillNo,item.getFbillNo())
                    .setText(R.id.tv_fdate,item.getFdate())
                    .setText(R.id.tv_fsupplierName,item.getFsupplierName())
                    .setText(R.id.tv_fdocumentStatus,item.getFdocumentStatus());
    }
}
