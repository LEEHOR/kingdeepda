package com.jeewms.www.wms.ui.activity.processReport;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity1;
import com.jeewms.www.wms.ui.view.TitleTopOrdersView;

import butterknife.BindView;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity.productionWarehousing
 * @ClassName: ProductionWarehousingActivity
 * @Description: java类作用描述
 * 工序汇报页跳转的生产入库
 * @Author: 作者名
 * @CreateDate: 2020/10/23 11:26
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 11:26
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ProductionWarehousing2Activity extends BaseActivity1 {
    @BindView(R.id.processDetail_title)
    TitleTopOrdersView processDetailTitle;

    @Override
    protected int getContentResId() {
        return R.layout.activity_process_report_detail;
    }
    public static void show(Context context) {
        Intent intent = new Intent(context, ProductionWarehousing2Activity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        processDetailTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TextView tex_item = processDetailTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("生产入库");
    }

    @Override
    protected void initfun() {

    }

}
