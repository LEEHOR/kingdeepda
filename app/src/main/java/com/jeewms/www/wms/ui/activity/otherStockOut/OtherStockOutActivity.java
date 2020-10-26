package com.jeewms.www.wms.ui.activity.otherStockOut;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity;
import com.jeewms.www.wms.ui.view.TitleTopOrdersView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
public class OtherStockOutActivity extends BaseActivity {
    @BindView(R.id.other_stock_out_title)
    TitleTopOrdersView otherStockOutTitle;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.iv_scan)
    ImageView ivScan;

    @Override
    protected int getContentResId() {
        return R.layout.activity_other_stock_out;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, OtherStockOutActivity.class);
        context.startActivity(intent);
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

    @OnClick({R.id.iv_add, R.id.iv_scan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_add:
                OtherStockOutAddActivity.show(this);
                break;
            case R.id.iv_scan:
                break;
        }
    }
}
