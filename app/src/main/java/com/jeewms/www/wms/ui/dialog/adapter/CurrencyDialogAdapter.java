package com.jeewms.www.wms.ui.dialog.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.CurrencyBean;
import com.jeewms.www.wms.bean.ProjectListBean;


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
public class CurrencyDialogAdapter extends BaseQuickAdapter<CurrencyBean.DataEntity, BaseViewHolder> {
    public CurrencyDialogAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CurrencyBean.DataEntity item) {
                helper.setText(R.id.tv_materialdialog,item.getFname()+"("+item.getFnumber()+")");
    }
}
