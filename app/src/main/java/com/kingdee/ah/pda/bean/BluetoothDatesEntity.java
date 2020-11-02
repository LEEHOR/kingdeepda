package com.kingdee.ah.pda.bean;

import android.bluetooth.BluetoothDevice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.com.heaton.blelibrary.ble.model.BleDevice;

/**
 * Created by 数据层 on 2017/9/1.
 */

public class BluetoothDatesEntity implements Serializable{


    public static List<BluetoothDevice> mPairedDevices = new ArrayList<>();//已匹配蓝牙

    public static List<BluetoothDevice> mBluetoothDevices = new ArrayList<>(); // 存储蓝牙列表


    public static List<BleDevice> bleDevices = new ArrayList<>();//已匹配蓝牙

    public static List<BleDevice> bleDeviceList = new ArrayList<>(); // 存储蓝牙列表
}
