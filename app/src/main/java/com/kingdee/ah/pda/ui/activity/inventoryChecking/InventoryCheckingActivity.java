package com.kingdee.ah.pda.ui.activity.inventoryChecking;

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
 * @Package: com.jeewms.www.wms.ui.activity.InventoryChecking
 * @ClassName: InventoryCheckingActivity
 * @Description: java类作用描述
 * 库存盘点
 * @Author: 作者名
 * @CreateDate: 2020/10/23 13:57
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 13:57
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class InventoryCheckingActivity extends BaseActivity {
    @BindView(R.id.inventory_check_title)
    TitleTopOrdersView inventoryCheckTitle;

    @Override
    protected int getContentResId() {
        return R.layout.activity_inventory_checking;
    }
    public static void show(Context context) {
        Intent intent = new Intent(context, InventoryCheckingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        inventoryCheckTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = inventoryCheckTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("库存盘点页");
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
