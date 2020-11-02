package com.kingdee.ah.pda.ui.activity.mine;

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
 * @ClassName: ServeraddressConfigActivity
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/12 9:18
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/12 9:18
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ServerAddressConfigActivity extends BaseActivity {
    @BindView(R.id.server_config_title)
    TitleTopOrdersView titleTopOrdersView;
    @BindView(R.id.printer_tv)
    TextView printerTv;
    @BindView(R.id.setting_printer)
    RelativeLayout settingPrinter;
    @BindView(R.id.server_tv)
    TextView serverTv;
    @BindView(R.id.setting_server)
    RelativeLayout settingServer;

    @Override
    protected int getContentResId() {
        return R.layout.activity_server_address_config;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleTopOrdersView.setViewVisibility(View.VISIBLE,View.VISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE);
        titleTopOrdersView.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        titleTopOrdersView.getTex_item().setText(getResources().getText(R.string.setting_6));
    }

    @Override
    protected void initfun() {

    }


    @OnClick({R.id.setting_printer, R.id.setting_server})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_printer:
                Intent intent=new Intent(ServerAddressConfigActivity.this,BluetoothSettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_server:
                Intent intent1=new Intent(ServerAddressConfigActivity.this,ChangeIpActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
