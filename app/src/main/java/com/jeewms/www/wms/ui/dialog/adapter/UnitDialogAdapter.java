package com.jeewms.www.wms.ui.dialog.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.SupplierBean;
import com.jeewms.www.wms.bean.UnitBean;
import com.jeewms.www.wms.dataBase.BdCustomer;
import com.jeewms.www.wms.dataBase.BdSupplier;
import com.jeewms.www.wms.dataBase.BdUnit;

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
public class UnitDialogAdapter extends BaseQuickAdapter<BdUnit, BaseViewHolder> {
    private int selectPosition;
    public UnitDialogAdapter(int layoutResId) {
        super(layoutResId);
    }

    public int getSelectPosition() {
        return selectPosition;
    }

    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void convert(@NonNull BaseViewHolder helper, BdUnit item) {
        TextView textView = helper.getView(R.id.tv_materialdialog);
        textView.setText(String.format("%s(%s)", item.getFname(), item.getFnumber()));
        if (helper.getAdapterPosition()==getSelectPosition()){
            textView.setTextColor(mContext.getResources().getColor(R.color.titlebar_color));
        } else {
            textView.setTextColor(mContext.getResources().getColor(R.color.black));
        }

    }

    public void setSelect(List<BdUnit> currencyList, int position, int type){
        this.selectPosition=position;
        if (type==0){
            setNewData(currencyList);
        } else {
            addData(currencyList);
        }
    }
}
