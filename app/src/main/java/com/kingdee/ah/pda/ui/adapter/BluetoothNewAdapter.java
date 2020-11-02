package com.kingdee.ah.pda.ui.adapter;

import android.bluetooth.BluetoothDevice;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kingdee.ah.pda.R;

import java.util.List;

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
public class BluetoothNewAdapter extends BaseQuickAdapter<BluetoothDevice,BaseViewHolder> {

    public BluetoothNewAdapter(int layoutResId, @Nullable List<BluetoothDevice> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, BluetoothDevice item) {
        helper.setText(R.id.ble_name, item.getName() == null || item.getName().length() == 0 ? "未命名设备" : item.getName())
                .setText(R.id.ble_mac, item.getAddress()==null || item.getAddress().length()==0?"位置mac地址":item.getAddress())
                .setText(R.id.connect,"连接")
                .addOnClickListener(R.id.connect);
    }
}
