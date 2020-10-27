package com.jeewms.www.wms.ui.dialog.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.dataBase.BdProject;

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
public class ProjectDialogAdapter extends BaseQuickAdapter<BdProject, BaseViewHolder> {
    private int selectPosition;
    public ProjectDialogAdapter(int layoutResId) {
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
    protected void convert(@NonNull BaseViewHolder helper, BdProject item) {
        TextView textView = helper.getView(R.id.tv_materialdialog);
        textView.setText(String.format("%s(%s)", item.getFname(), item.getFnumber()));
        if (helper.getAdapterPosition()==selectPosition){
            textView.setTextColor(mContext.getResources().getColor(R.color.titlebar_color));
        } else {
            textView.setTextColor(mContext.getResources().getColor(R.color.black));
        }

    }

    public void setSelect(List<BdProject> currencyList, int position, int type){
        this.selectPosition=position;
        if (type==0){
            setNewData(currencyList);
        } else {
            addData(currencyList);
        }
    }
}
