package com.jeewms.www.wms;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.jeewms.www.wms.util.Logutil;

import java.util.UUID;
import cn.com.heaton.blelibrary.ble.Ble;
import cn.com.heaton.blelibrary.ble.BleLog;
import cn.com.heaton.blelibrary.ble.model.BleFactory;
import cn.com.heaton.blelibrary.ble.utils.UuidUtils;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms
 * @ClassName: App
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/10 11:58
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/10 11:58
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class App extends Application {
    public static Context mApplicationContext;
    public static final String UPDATE_STATUS_ACTION = "com.cyht.wykc.action.UPDATE_STATUS";
    private static App mApplication;
    private String TAG = App.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext=getApplicationContext();
        mApplication=this;
        initBle();
    }

    private void initBle() {
        Ble.options()
                .setLogBleEnable(true)//设置是否输出打印蓝牙日志
                .setThrowBleException(true)//设置是否抛出蓝牙异常
                .setLogTAG("AndroidBLE")//设置全局蓝牙操作日志TAG
                .setAutoConnect(true)//设置是否自动连接
                .setIgnoreRepeat(true)//设置是否过滤扫描到的设备(已扫描到的不会再次扫描)
                .setConnectFailedRetryCount(3)//连接异常时（如蓝牙协议栈错误）,重新连接次数
                .setConnectTimeout(10 * 1000)//设置连接超时时长
                .setScanPeriod(20 * 1000)//设置扫描时长
                .setMaxConnectNum(7)//最大连接数量
//                .setScanFilter(scanFilter)
                .setUuidService(UUID.fromString(UuidUtils.uuid16To128("fd00")))//设置主服务的uuid
                .setUuidWriteCha(UUID.fromString(UuidUtils.uuid16To128("fd01")))//设置可写特征的uuid
                .setUuidReadCha(UUID.fromString(UuidUtils.uuid16To128("fd02")))//设置可读特征的uuid （选填）
                .setUuidNotifyCha(UUID.fromString(UuidUtils.uuid16To128("fd03")))//设置可通知特征的uuid （选填，库中默认已匹配可通知特征的uuid）
//                .setFactory(new BleFactory() {//实现自定义BleDevice时必须设置
//                    @Override
//                    public BleRssiDevice create(String address, String name) {
//                        return new BleRssiDevice(address, name);//自定义BleDevice的子类
//                    }
//                })
             //   .setBleWrapperCallback(new MyBleWrapperCallback())
                .create(mApplication, new Ble.InitCallback() {
                    @Override
                    public void success() {
                        Logutil.print("蓝牙","蓝牙配置成功");
                    }

                    @Override
                    public void failed(int failedCode) {
                        Logutil.print("蓝牙","蓝牙配置失败");
                    }
                });
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static App getInstance() {
        return mApplication;
    }
    public static Context getmApplicationContext() {
        return mApplicationContext;
    }
}
