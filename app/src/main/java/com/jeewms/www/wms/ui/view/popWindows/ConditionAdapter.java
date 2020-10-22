package com.jeewms.www.wms.ui.view.popWindows;

import android.annotation.SuppressLint;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.StockClass;

import java.util.List;



/**
 * Author： hengzwd on 2018/7/3.
 * Email：hengzwdhengzwd@qq.com
 */
public class ConditionAdapter extends BaseQuickAdapter<StockClass.StockEntity, BaseViewHolder> {
    private int selectedPosition;

    public ConditionAdapter() {
        super(R.layout.item_stock_menu, null);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void convert(final BaseViewHolder helper, StockClass.StockEntity item) {
        helper.setText(R.id.stock_name,item.getFname())
                .setText(R.id.stock_number,item.getFnumber());
        if (helper.getAdapterPosition()==selectedPosition){
            helper.setBackgroundColor(R.id.stock_item,R.color.titlebar_color)
                    .setTextColor(R.id.stock_name,R.color.white)
                    .setTextColor(R.id.stock_number,R.color.white);
        }
    }
    public void setData(List<StockClass.StockEntity> data, int selectedPosition) {
        this.selectedPosition = selectedPosition;
        setNewData(data);
    }
}
