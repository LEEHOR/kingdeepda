package com.jeewms.www.wms.ui.activity.otherStockOut;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity;
import com.jeewms.www.wms.ui.view.TitleTopOrdersView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity.otherStockOut
 * @ClassName: OtherStockOutActivity
 * @Description: java类作用描述
 * 其它出库
 * @Author: 作者名
 * @CreateDate: 2020/10/23 14:22
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 14:22
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class OtherStockOutDetailActivity extends BaseActivity {
    @BindView(R.id.other_stock_out_Detail_title2)
    TitleTopOrdersView otherStockOutTitle;

    @Override
    protected int getContentResId() {
        return R.layout.activity_other_stock_out_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        otherStockOutTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TextView tex_item = otherStockOutTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("其他出库");
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
