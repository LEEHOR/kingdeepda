package com.kingdee.ah.pda.ui.activity.warehouseOutApplication;

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
 * @Package: com.jeewms.www.wms.ui.activity.WarehouseOutApplication
 * @ClassName: WarehousOutApplicationActivity
 * @Description: java类作用描述
 * 出库申请列表
 * @Author: 作者名
 * @CreateDate: 2020/10/23 13:38
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 13:38
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class WarehouseOutApplicationDetailActivity extends BaseActivity {


    @BindView(R.id.warehose_out_detail_title)
    TitleTopOrdersView outDetailTitle;

    @Override
    protected int getContentResId() {
        return R.layout.activity_waresehousing_out_detail;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, WarehouseOutApplicationDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        outDetailTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = outDetailTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("出库申请详情页");
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
