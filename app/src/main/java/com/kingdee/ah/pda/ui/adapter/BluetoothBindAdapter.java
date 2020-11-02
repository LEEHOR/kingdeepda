package com.kingdee.ah.pda.ui.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kingdee.ah.pda.R;

import java.util.List;

import cn.com.heaton.blelibrary.ble.model.BleDevice;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.adapter
 * @ClassName: BluetoothBindAdapter
 * @Description: java类作用描述
 * 蓝牙已绑定的列表
 * @Author: 作者名
 * @CreateDate: 2020/10/12 14:05
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/12 14:05
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class BluetoothBindAdapter extends BaseQuickAdapter<BleDevice,BaseViewHolder> {

    public BluetoothBindAdapter(int layoutResId, @Nullable List<BleDevice> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, BleDevice item) {
        helper.setText(R.id.ble_name, item.getBleName() == null || item.getBleName().length() == 0 ? "未命名设备" : item.getBleName())
                .setText(R.id.ble_mac, item.getBleAddress())
                .addOnClickListener(R.id.connect);
        TextView view = helper.getView(R.id.connect);
        int connectionState = item.getConnectionState();
        switch (connectionState){
            case BleDevice.CONNECTED:
                view.setText("已连接");
                break;
            case BleDevice.CONNECTING:
                view.setText("正在连接");
                break;
            case BleDevice.DISCONNECT:
                view.setText("连接");
                break;
        }
    }
}
