package com.kingdee.ah.pda.ui.activity.deliverNotice;

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
 * 发货通知详情
 * @Author: 作者名
 * @CreateDate: 2020/10/23 13:51
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 13:51
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class DeliveryNoticeDetailActivity extends BaseActivity {
    @BindView(R.id.delivery_notice_detail_title)
    TitleTopOrdersView deliveryNoticeDetailTitle;

    @Override
    protected int getContentResId() {
        return R.layout.activity_delivery_notice_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        deliveryNoticeDetailTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = deliveryNoticeDetailTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("发货通知详情页");
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
