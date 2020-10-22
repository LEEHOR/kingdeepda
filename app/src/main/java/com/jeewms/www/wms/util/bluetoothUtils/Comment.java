package com.jeewms.www.wms.util.bluetoothUtils;


import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.util.UUID;

import cn.com.heaton.blelibrary.ble.model.BleDevice;

public class Comment {

    /**
     * 蓝牙UUID
     */
    public static UUID SPP_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    /**
     * 选择配对后的设备，保持与应用生命周期相同
     */
    public static  BluetoothDevice bluetoothDevice;

    /**
     * 选择配对后的设备，保持与应用生命周期相同
     */
    public static BleDevice bleDevice;

    /**
     * 不管是蓝牙连接方还是服务器方，得到socket对象后都传入
     */
    public static BluetoothSocket bluetoothSocket;

    /**
     * 蓝牙开关
     */
    public static final int SWITCH = 101;

    /**
     * 蓝牙搜索未连接的
     */
    public static final int FOUND = 102;

    /**
     * 蓝牙搜索已连接的
     */
    public static final int FOUND2 = 110;

    /**
     * 蓝牙搜索完毕
     */
    public static final int DISCOVERY_STARTED = 109;

    /**
     * 蓝牙搜索完毕
     */
    public static final int FINISHED = 103;

    /**
     * 蓝牙配对
     */
    public static final int BOND =104;
    /**
     * 蓝牙连接
     */
    public static final int CONNECT =105;

    /**
     * 选择图片后的请求码
     */
    public static final int IMAGE_CODE = 106;

    /**
     * 修改蓝牙名的请求码
     */
    public static final int NAME_CODE = 107;

    /**
     * 修改蓝牙名的请求码
     */
    public static final int OPEN_BLE = 108;



}
