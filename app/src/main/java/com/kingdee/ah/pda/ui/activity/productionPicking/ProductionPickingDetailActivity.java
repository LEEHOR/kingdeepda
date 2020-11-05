package com.kingdee.ah.pda.ui.activity.productionPicking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity.productionPicking
 * @ClassName: ProductionPickingActivity
 * @Description: java类作用描述
 * 生产领料
 * @Author: 作者名
 * @CreateDate: 2020/10/23 14:21
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 14:21
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ProductionPickingDetailActivity extends BaseActivity {
    @BindView(R.id.production_pick_detail_title)
    TitleTopOrdersView titleTopOrdersView;

    @Override
    protected int getContentResId() {
        return R.layout.activity_production_picking_detail;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, ProductionPickingDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleTopOrdersView.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = titleTopOrdersView.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        if (getIntent() != null) {
            int pageType = getIntent().getIntExtra("pageType", 0);
            if (pageType==0){
                tex_item.setText("生产领料详情");
            } else {
                tex_item.setText("生产领料新增");
            }
        }

    }

    @Override
    protected void initfun() {

    }

}
