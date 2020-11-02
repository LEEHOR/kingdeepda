package com.kingdee.ah.pda.ui.activity.productionWarehousing;

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
 * @Package: com.jeewms.www.wms.ui.activity.productionWarehousing
 * @ClassName: ProductionWarehousingActivity
 * @Description: java类作用描述
 * 生产入库
 * @Author: 作者名
 * @CreateDate: 2020/10/23 11:26
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 11:26
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ProductionWarehousingActivity extends BaseActivity {

    @BindView(R.id.production_warehousing_title)
    TitleTopOrdersView productionWarehousingTitle;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_scan)
    ImageView ivScan;

    @Override
    protected int getContentResId() {
        return R.layout.activity_production_wares;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, ProductionWarehousingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        ivAdd.setVisibility(View.GONE);
        productionWarehousingTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TextView tex_item = productionWarehousingTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("生产入库列表页");
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
                break;
            case R.id.iv_scan:
                break;
        }
    }
}
