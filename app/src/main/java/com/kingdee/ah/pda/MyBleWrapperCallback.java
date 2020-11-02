package com.kingdee.ah.pda;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.util.Log;

import cn.com.heaton.blelibrary.ble.callback.wrapper.BleWrapperCallback;
import cn.com.heaton.blelibrary.ble.model.BleDevice;
import cn.com.heaton.blelibrary.ble.utils.ByteUtils;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms
 * @ClassName: MyBleWrapperCallback
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/20 19:41
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/20 19:41
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MyBleWrapperCallback extends BleWrapperCallback<BleDevice>  {
    private static final String TAG = "MyBleWrapperCallback";

    @Override
    public void onChanged(BleDevice device, BluetoothGattCharacteristic characteristic) {
        super.onChanged(device, characteristic);
        Log.d(TAG, "onChanged: "+ ByteUtils.toHexString(characteristic.getValue()));
    }

    @Override
    public void onServicesDiscovered(BleDevice device, BluetoothGatt gatt) {
        super.onServicesDiscovered(device, gatt);
        Log.d(TAG, "onServicesDiscovered: ");
    }

    @Override
    public void onWriteSuccess(BleDevice device, BluetoothGattCharacteristic characteristic) {
        super.onWriteSuccess(device, characteristic);
        Log.d(TAG, "onWriteSuccess: ");
    }

    @Override
    public void onConnectionChanged(BleDevice device) {
        super.onConnectionChanged(device);
        Log.d(TAG, "onConnectionChanged: "+device.toString());
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    public void onLeScan(BleDevice device, int rssi, byte[] scanRecord) {
        super.onLeScan(device, rssi, scanRecord);
        Log.d(TAG, "onLeScan: "+device.toString());
    }

    @Override
    public void onNotifySuccess(BleDevice device) {
        super.onNotifySuccess(device);
        Log.d(TAG, "onNotifySuccess: ");
    }

    @Override
    public void onNotifyCanceled(BleDevice device) {
        super.onNotifyCanceled(device);
        Log.d(TAG, "onNotifyCanceled: ");
    }

    @Override
    public void onReady(BleDevice device) {
        super.onReady(device);
        Log.d(TAG, "onReady: ");
    }

    @Override
    public void onDescWriteSuccess(BleDevice device, BluetoothGattDescriptor descriptor) {
        super.onDescWriteSuccess(device, descriptor);
    }

    @Override
    public void onDescWriteFailed(BleDevice device, int failedCode) {
        super.onDescWriteFailed(device, failedCode);
    }

    @Override
    public void onDescReadFailed(BleDevice device, int failedCode) {
        super.onDescReadFailed(device, failedCode);
    }

    @Override
    public void onDescReadSuccess(BleDevice device, BluetoothGattDescriptor descriptor) {
        super.onDescReadSuccess(device, descriptor);
    }

    @Override
    public void onMtuChanged(BleDevice device, int mtu, int status) {
        super.onMtuChanged(device, mtu, status);
    }

    @Override
    public void onReadSuccess(BleDevice device, BluetoothGattCharacteristic characteristic) {
        super.onReadSuccess(device, characteristic);
    }
}
