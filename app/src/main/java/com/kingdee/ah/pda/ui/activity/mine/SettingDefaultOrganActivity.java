package com.kingdee.ah.pda.ui.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity1
 * @ClassName: SettingDefaultOrgan
 * @Description: java类作用描述
 *    设置默认的组织
 * @Author: 作者名
 * @CreateDate: 2020/10/10 18:36
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/10 18:36
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class SettingDefaultOrganActivity extends BaseActivity {
    @BindView(R.id.organ_title)
    TitleTopOrdersView organTitle;
    @BindView(R.id.warehouse_tv)
    TextView warehouseTv;
    @BindView(R.id.setting_warehouse)
    RelativeLayout settingWarehouse;
    @BindView(R.id.deliver_tv)
    TextView deliverTv;
    @BindView(R.id.setting_deliver)
    RelativeLayout settingDeliver;

    public static void show(Context context) {
        Intent intent = new Intent(context, SettingDefaultOrganActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_setting_default_organization;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        organTitle.setViewVisibility(View.VISIBLE,View.VISIBLE,View.GONE,View.GONE,View.GONE,View.GONE,View.GONE);
        organTitle.getTex_item().setText(getResources().getText(R.string.setting_1));
        organTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initfun() {

    }


    @OnClick({R.id.setting_warehouse, R.id.setting_deliver})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_warehouse:
                break;
            case R.id.setting_deliver:
                break;
        }
    }
}
