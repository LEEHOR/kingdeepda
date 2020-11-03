package com.kingdee.ah.pda.ui.activity.deliverNotice;

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
 * @Package: com.jeewms.www.wms.ui.activity.deliverNotice
 * @ClassName: DeliveryNoticeActivity
 * @Description: java类作用描述
 * 发货通知
 * @Author: 作者名
 * @CreateDate: 2020/10/23 13:51
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 13:51
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class DeliveryNoticeActivity extends BaseActivity {
    @BindView(R.id.delivery_notice_title)
    TitleTopOrdersView deliveryNoticeTitle;

    @Override
    protected int getContentResId() {
        return R.layout.activity_delivery_notice;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, DeliveryNoticeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        deliveryNoticeTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = deliveryNoticeTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("发货通知列表页");
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
