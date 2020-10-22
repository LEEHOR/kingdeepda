package com.jeewms.www.wms.receiver;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.jeewms.www.wms.bean.BluetoothDatesEntity;
import com.jeewms.www.wms.util.bluetoothUtils.Comment;

/**
 * 广播
 *
 * （静态广播，接口回调会崩溃）
 * 蓝牙 控制
 */

public class BTBroadcastReceiver extends BroadcastReceiver {
    private BluetoothDevice device;//蓝牙设备
    private Handler mHandler;
    private Message message;


    public BTBroadcastReceiver(Handler mHandler) {
        this.mHandler = mHandler;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action){
            case BluetoothAdapter.ACTION_STATE_CHANGED://蓝牙开关
                int blueState = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, 0);
                message=new Message();
                message.what = Comment.SWITCH;
                message.obj=blueState;
                mHandler.sendMessage(message);
                break;
            case BluetoothDevice.ACTION_FOUND: // 发现设备
                device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (isNewDevice(device)) { // 判断是否配对过
                    message=new Message();
                    message.what = Comment.FOUND;
                    message.obj=device;
                    mHandler.sendMessage(message);
                }
                break;
            case BluetoothAdapter.ACTION_DISCOVERY_FINISHED: //搜索完成
                    mHandler.sendEmptyMessage(Comment.FINISHED);
                break;
            case BluetoothAdapter.ACTION_DISCOVERY_STARTED: //搜索开始
                BluetoothDatesEntity.mBluetoothDevices.clear();
                mHandler.sendEmptyMessage(Comment.DISCOVERY_STARTED);
                break;
            case BluetoothDevice.ACTION_BOND_STATE_CHANGED://配对
                device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                Log.d("aaa","配对监听"+device.getBondState());
                message=new Message();
                message.what = Comment.BOND;
                message.obj=device.getBondState();
                mHandler.sendMessage(message);
                break;
        }

    }

    /**
     * 判断搜索的设备是新蓝牙设备，且不重复
     * @param device
     * @return
     */
    private boolean isNewDevice(BluetoothDevice device){
        boolean repeatFlag = false;
        for (BluetoothDevice d :
                BluetoothDatesEntity.mBluetoothDevices) {
            if (d.getAddress().equals(device.getAddress())){
                repeatFlag=true;
            }
        }
        //不是已绑定状态，且列表中不重复
        return device.getBondState() != BluetoothDevice.BOND_BONDED && !repeatFlag;
    }

}
