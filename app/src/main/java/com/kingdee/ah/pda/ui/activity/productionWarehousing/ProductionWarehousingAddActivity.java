package com.kingdee.ah.pda.ui.activity.productionWarehousing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;

import butterknife.BindView;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity.productionWarehousing
 * @ClassName: ProductionWarehousingActivity
 * @Description: java类作用描述
 * 首页跳转进来的生产入库
 * @Author: 作者名
 * @CreateDate: 2020/10/23 11:26
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 11:26
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ProductionWarehousingAddActivity extends BaseActivity {
    @BindView(R.id.production_warehousing_add_title)
    TitleTopOrdersView processDetailTitle;

    @Override
    protected int getContentResId() {
        return R.layout.activity_production_wares_add;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, ProductionWarehousingAddActivity.class);
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
        tex_item.setText("生产入库新增");
    }

    @Override
    protected void initfun() {

    }

}
