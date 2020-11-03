package com.kingdee.ah.pda.ui.activity.otherStockOut;

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
 * @Package: com.jeewms.www.wms.ui.activity.otherStockOut
 * @ClassName: OtherStockOutActivity
 * @Description: java类作用描述
 * 其它出库新增
 * @Author: 作者名
 * @CreateDate: 2020/10/23 14:22
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 14:22
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class OtherStockOutAddActivity extends BaseActivity {
    @BindView(R.id.other_stock_out_add_title)
    TitleTopOrdersView otherStockOutTitle;

    @Override
    protected int getContentResId() {
        return R.layout.activity_other_stock_out_add;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, OtherStockOutAddActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        otherStockOutTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = otherStockOutTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("其他出库新增");
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
