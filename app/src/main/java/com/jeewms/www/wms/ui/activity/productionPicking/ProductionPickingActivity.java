package com.jeewms.www.wms.ui.activity.productionPicking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity1;
import com.jeewms.www.wms.ui.view.TitleTopOrdersView;

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
public class ProductionPickingActivity extends BaseActivity1 {
    @BindView(R.id.production_pick_title)
    TitleTopOrdersView productionPickTitle;

    @Override
    protected int getContentResId() {
        return R.layout.activity_production_picking;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, ProductionPickingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        productionPickTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TextView tex_item = productionPickTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("生产领料");
    }

    @Override
    protected void initfun() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
