package com.jeewms.www.wms;

import cn.com.heaton.blelibrary.ble.model.BleDevice;
import cn.com.heaton.blelibrary.ble.model.ScanRecord;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms
 * @ClassName: BleRssiDevice
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/20 19:47
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/20 19:47
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class BleRssiDevice extends BleDevice {
    private ScanRecord scanRecord;
    private int rssi;
    private long rssiUpdateTime;

    public BleRssiDevice(String address, String name) {
        super(address, name);
    }

    /*public BleRssiDevice(BleDevice device, ScanRecord scanRecord, int rssi) {
        this.device = device;
        this.scanRecord = scanRecord;
        this.rssi = rssi;
    }*/

    public ScanRecord getScanRecord() {
        return scanRecord;
    }

    public void setScanRecord(ScanRecord scanRecord) {
        this.scanRecord = scanRecord;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public long getRssiUpdateTime() {
        return rssiUpdateTime;
    }

    public void setRssiUpdateTime(long rssiUpdateTime) {
        this.rssiUpdateTime = rssiUpdateTime;
    }
}
