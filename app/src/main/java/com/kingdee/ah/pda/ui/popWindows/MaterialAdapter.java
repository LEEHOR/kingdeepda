package com.kingdee.ah.pda.ui.popWindows;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.dataBase.BdMaterial;

import java.util.List;


/**
 * Author： hengzwd on 2018/7/3.
 * Email：hengzwdhengzwd@qq.com
 */
public class MaterialAdapter extends BaseQuickAdapter<BdMaterial, BaseViewHolder> {
    private int selectedPosition=9999;
    private Context context;
    public MaterialAdapter(Context mContext) {
        super(R.layout.item_stock_menu);
        this.context=mContext;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    public int getSelectedPosition() {
        return this.selectedPosition;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void convert(final BaseViewHolder helper, BdMaterial item) {
        TextView view1 = helper.getView(R.id.stock_name);
        TextView view2 = helper.getView(R.id.stock_number);
        view1.setText(item.getFname());
        view2.setText(item.getFspecification());
        if (helper.getLayoutPosition() == getSelectedPosition()) {
            view1.setTextColor(context.getResources().getColor(R.color.titlebar_color));
            view2.setTextColor(context.getResources().getColor(R.color.titlebar_color));
        } else {
            view1.setTextColor(context.getResources().getColor(R.color.black));
            view2.setTextColor(context.getResources().getColor(R.color.black));
        }
    }

    public void setData(List<BdMaterial> data, int type) {
        if (type == 0) {
            setNewData(data);
        } else {
            addData(data);
        }
    }
}
