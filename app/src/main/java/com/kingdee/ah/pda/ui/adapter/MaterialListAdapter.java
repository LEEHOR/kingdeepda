package com.kingdee.ah.pda.ui.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.bean.MaterialBean;
import com.kingdee.ah.pda.bean.OutStockApplyBean;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.ui.adapter
 * @ClassName: OutStockAdapter
 * @Description: java类作用描述
 * @Author: 李浩
 * @CreateDate: 2020/11/3 17:32
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/3 17:32
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MaterialListAdapter extends BaseQuickAdapter<MaterialBean.DataEntity, BaseViewHolder> {
    public MaterialListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MaterialBean.DataEntity item) {
            helper.setText(R.id.tv_fbillNo,item.getFbillNo())
                    .setText(R.id.tv_fmaterialNumber,item.getFmaterialNumber())
                    .setText(R.id.tv_fmaterialName,item.getFmaterialName())
                    .setText(R.id.tv_fmaterialSpecification,item.getFmaterialSpecification())
                    .setText(R.id.tv_fprdOrgName,item.getFprdOrgName())
                    .setText(R.id.tv_fworkshopName,item.getFworkshopName())
                    .setText(R.id.tv_funitName,item.getFunitName())
                    .setText(R.id.tv_fmobillNO,item.getFmobillNO())
                    .setText(R.id.tv_fdocumentStatus,item.getFdocumentStatus())
                    .addOnClickListener(R.id.btn_detail,R.id.btn_push);
    }
}
