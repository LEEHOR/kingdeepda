package com.jeewms.www.wms.ui.dialog.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.dataBase.BdCurrency;

import java.util.List;


/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.adapter
 * @ClassName: MaterialDialogAdapter
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/22 9:20
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/22 9:20
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class CurrencyDialogAdapter extends BaseQuickAdapter<BdCurrency, BaseViewHolder> {
    private  int selectPosition;
    private Context context;
    public CurrencyDialogAdapter(int layoutResId,Context mContext) {
        super(layoutResId);
        this.context=mContext;
    }

    public int getSelectPosition() {
        return selectPosition;
    }

    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, BdCurrency item) {
        TextView textView = helper.getView(R.id.tv_materialdialog);
        textView.setText(String.format("%s(%s)", item.getFname(), item.getFnumber()));
        if (helper.getLayoutPosition()==getSelectPosition()){
            textView.setTextColor(context.getResources().getColor(R.color.titlebar_color));
        } else {
            textView.setTextColor(context.getResources().getColor(R.color.black));
        }
    }

    public void setSelect(List<BdCurrency> currencyList,int type){
        if (type==0){
            setNewData(currencyList);
        } else {
            addData(currencyList);
        }
    }
}
