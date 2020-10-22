package com.jeewms.www.wms.ui.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.StockScanBean;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.adapter
 * @ClassName: StockAdapter
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/14 13:51
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/14 13:51
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class StockScanAdapter extends BaseQuickAdapter<StockScanBean.DataEntity, BaseViewHolder> {
    public StockScanAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, StockScanBean.DataEntity item) {
        helper.setText(R.id.tv_materialNumber,item.getMaterialNumber())
                .setText(R.id.tv_materialName,item.getMaterialName())
                .setText(R.id.stock_tv_specification,"("+item.getSpecification()+")")
                .setText(R.id.tv_stockName,item.getStockName())
                .setText(R.id.tv_goodBarCode,item.getGoodBarCode()==null?"":item.getGoodBarCode())
                .setText(R.id.tv_qty,String.valueOf(item.getQty()));
    }
}
