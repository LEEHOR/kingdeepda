package com.jeewms.www.wms.ui.activity.purchaseWarehousing;

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
 * @Package: com.jeewms.www.wms.ui.activity.receiving
 * @ClassName: ReceivingPushDown
 * @Description: java类作用描述
 * 采购入库列表页
 * @Author: 作者名
 * @CreateDate: 2020/10/19 19:10
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/19 19:10
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class PurchaseWarehousingActivity extends BaseActivity1 {

    @BindView(R.id.purchase_warehousing_title)
    TitleTopOrdersView purchaseWarehousingTitle;

    @Override
    protected int getContentResId() {
        return R.layout.activity_purchase_warehousing;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, PurchaseWarehousingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        purchaseWarehousingTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TextView tex_item = purchaseWarehousingTitle.getTex_item();
        tex_item.setVisibility(View.INVISIBLE);
        tex_item.setText("采购入库列表");
    }

    @Override
    protected void initfun() {

    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}
