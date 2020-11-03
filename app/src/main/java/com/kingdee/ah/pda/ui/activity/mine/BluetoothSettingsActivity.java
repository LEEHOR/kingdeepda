package com.kingdee.ah.pda.ui.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity1.mine
 * @ClassName: BluetoothSettingsActivity
 * @Description: java类作用描述
 * 蓝牙设置
 * @Author: 作者名
 * @CreateDate: 2020/10/12 9:38
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/12 9:38
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class BluetoothSettingsActivity extends BaseActivity {
    @BindView(R.id.bluetooth_title)
    TitleTopOrdersView bluetoothTitle;
    @BindView(R.id.bluetooth_switch)
    Switch bluetoothSwitch;
    @BindView(R.id.tv_start_print)
    TextView tvStartPrint;

    @Override
    protected int getContentResId() {
        return R.layout.activity_bluetooth_settings;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        bluetoothTitle.setViewVisibility(View.VISIBLE,View.VISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE,View.VISIBLE);
        bluetoothTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        bluetoothTitle.getTex_item().setText(getResources().getText(R.string.setting_4));
        bluetoothTitle.getTv_right().setText(getResources().getText(R.string.setting_14));
        bluetoothTitle.getTv_right().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BluetoothSettingsActivity.this,BluetoothSettings1Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initfun() {

    }


    @OnClick(R.id.tv_start_print)
    public void onViewClicked() {
    }
}
