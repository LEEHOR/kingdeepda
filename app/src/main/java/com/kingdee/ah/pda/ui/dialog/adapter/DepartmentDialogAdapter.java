package com.kingdee.ah.pda.ui.dialog.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.dataBase.BdDepartment;

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
public class DepartmentDialogAdapter extends BaseQuickAdapter<BdDepartment, BaseViewHolder> {
    private int selectPosition;
    private Context context;
    public DepartmentDialogAdapter(int layoutResId, Context mcontext) {
        super(layoutResId);
        this.context=mcontext;
    }

    public int getSelectPosition() {
        return selectPosition;
    }

    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void convert(@NonNull BaseViewHolder helper, BdDepartment item) {
        TextView textView = helper.getView(R.id.tv_materialdialog);
        textView.setText(String.format("%s(%s)", item.getFname(), item.getFnumber()));
        if (helper.getLayoutPosition()==selectPosition){
            textView.setTextColor(context.getResources().getColor(R.color.titlebar_color));
        } else {
            textView.setTextColor(context.getResources().getColor(R.color.black));
        }
    }

    public void setSelect(List<BdDepartment> currencyList, int position, int type){
        this.selectPosition=position;
        if (type==0){
            setNewData(currencyList);
        } else {
            addData(currencyList);
        }
    }
}
