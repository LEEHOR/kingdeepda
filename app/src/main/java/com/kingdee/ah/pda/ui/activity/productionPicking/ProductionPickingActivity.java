package com.kingdee.ah.pda.ui.activity.productionPicking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
public class ProductionPickingActivity extends BaseActivity {
    @BindView(R.id.production_pick_title)
    TitleTopOrdersView productionPickTitle;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_scan)
    ImageView ivScan;

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
        ivAdd.setVisibility(View.GONE);
        productionPickTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
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

    @OnClick({R.id.iv_add, R.id.iv_scan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_add:
             //   ProductionPickingActivity.show(this);
                break;
            case R.id.iv_scan:
                break;
        }
    }
}
