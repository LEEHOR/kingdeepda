package com.jeewms.www.wms.ui.activity.mine;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeewms.www.wms.App;
import com.jeewms.www.wms.BleRssiDevice;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity1;
import com.jeewms.www.wms.bean.BluetoothDatesEntity;
import com.jeewms.www.wms.receiver.BTBroadcastReceiver;
import com.jeewms.www.wms.ui.adapter.BluetoothBindAdapter;
import com.jeewms.www.wms.ui.view.TitleTopOrdersView;
import com.jeewms.www.wms.util.LoadingUtil;
import com.jeewms.www.wms.util.LocalDisplay;
import com.jeewms.www.wms.util.Logutil;
import com.jeewms.www.wms.util.ToastUtil;
import com.jeewms.www.wms.util.bluetoothUtils.BluetoothUtil;
import com.jeewms.www.wms.util.bluetoothUtils.Comment;
import com.jeewms.www.wms.util.decoration.SpacesItemDecoration;
import com.yxp.permission.util.lib.PermissionUtil;
import com.yxp.permission.util.lib.callback.PermissionResultCallBack;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import butterknife.BindView;
import cn.com.heaton.blelibrary.ble.Ble;
import cn.com.heaton.blelibrary.ble.BleLog;
import cn.com.heaton.blelibrary.ble.callback.BleConnectCallback;
import cn.com.heaton.blelibrary.ble.callback.BleNotifyCallback;
import cn.com.heaton.blelibrary.ble.callback.BleScanCallback;
import cn.com.heaton.blelibrary.ble.callback.BleStatusCallback;
import cn.com.heaton.blelibrary.ble.model.BleDevice;
import cn.com.heaton.blelibrary.ble.utils.ByteUtils;

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
public class BluetoothSettings1Activity extends BaseActivity1 {


    @BindView(R.id.bluetooth_title)
    TitleTopOrdersView bluetoothTitle;
    @BindView(R.id.option_recyclerView)
    RecyclerView optionRecyclerView;
    @BindView(R.id.un_option_recyclerView)
    RecyclerView unOptionRecyclerView;
    @BindView(R.id.pro1)
    ProgressBar progressBar;
    private List<BluetoothDevice> bluetoothNewDeviceList = new ArrayList<>();
    private final int REQUEST_ENBLE_BT = 600; //蓝牙开启状态码
    private final int REQUEST_ENABLE_VISIBILITY = 100; //蓝牙可检测
    private BluetoothBindAdapter bluetoothBindAdapter;
    private BluetoothBindAdapter bluetoothNewAdapter;
    private Handler mHandler = new MyHandler(this);
    private BTBroadcastReceiver btBroadcastReceiver;
    private Ble<BleDevice> ble;
    private Message message;

    @Override
    protected int getContentResId() {
        return R.layout.activity_bluetooth_settings1;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        bluetoothTitle.setViewVisibility(View.VISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE, View.VISIBLE, View.VISIBLE, View.INVISIBLE);
        bluetoothTitle.getBtn_back().setImageDrawable(getResources().getDrawable(R.drawable.ic_close));
        bluetoothTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ImageButton iv3 = bluetoothTitle.getBtn_orders_3();
        iv3.setImageDrawable(getResources().getDrawable(R.drawable.ic_menu));
        registerForContextMenu(iv3);
        ImageButton iv2 = bluetoothTitle.getBtn_orders_2();
        iv2.setImageDrawable(getResources().getDrawable(R.drawable.ic_refresh));
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wantBluetoothPermission();
            }
        });
    }

    @Override
    protected void initfun() {
        ble = Ble.getInstance();
        initBleStatus();
        LocalDisplay.init(App.getmApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        bluetoothBindAdapter = new BluetoothBindAdapter(R.layout.item_bluetooth, BluetoothDatesEntity.bleDevices);
        optionRecyclerView.setLayoutManager(linearLayoutManager);
        optionRecyclerView.addItemDecoration(new SpacesItemDecoration(LocalDisplay.designedDP2px(1), LocalDisplay.designedDP2px(1), getResources().getColor(R.color.actions_background_light)));
        optionRecyclerView.setAdapter(bluetoothBindAdapter);
        bluetoothBindAdapter.setEmptyView(R.layout.view_empt, optionRecyclerView);
        //已配对的直接连接
        bluetoothBindAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtil.show(BluetoothSettings1Activity.this, position + "");
                Comment.bleDevice = (BleDevice) adapter.getItem(position);
                //  Comment.bluetoothDevice = (BluetoothDevice) adapter.getItem(position);
                // BluetoothUtil.connectSocket(mHandler);
                assert Comment.bleDevice != null;
                ble.connect(Comment.bleDevice.getBleAddress(), connectCallback);
            }
        });

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        bluetoothNewAdapter = new BluetoothBindAdapter(R.layout.item_bluetooth, BluetoothDatesEntity.bleDeviceList);
        unOptionRecyclerView.setLayoutManager(linearLayoutManager1);
        unOptionRecyclerView.addItemDecoration(new SpacesItemDecoration(LocalDisplay.designedDP2px(1), LocalDisplay.designedDP2px(1), getResources().getColor(R.color.actions_background_light)));
        unOptionRecyclerView.setAdapter(bluetoothNewAdapter);
        bluetoothNewAdapter.setEmptyView(R.layout.view_empt, unOptionRecyclerView);
        //未配对的配对在连接
        bluetoothNewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtil.show(BluetoothSettings1Activity.this, position + "");
                Comment.bleDevice = (BleDevice) adapter.getItem(position);
                assert Comment.bleDevice != null;
                ble.connect(Comment.bleDevice.getBleAddress(), connectCallback);
                //   Comment.bluetoothDevice = (BluetoothDevice) adapter.getItem(position);
                //   BluetoothUtil.connectBound();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_bluetooth, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //上下文菜单被点击是触发该方法
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_open:
                wantBluetoothPermission();
                break;
            case R.id.action_close:
                Cancel();
                ble.turnOffBlueTooth();
                break;
        }
        return true;
    }

    private class MyHandler extends Handler {
        private final WeakReference<BluetoothSettings1Activity> mTarget;

        public MyHandler(BluetoothSettings1Activity activity) {
            mTarget = new WeakReference<BluetoothSettings1Activity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Comment.SWITCH: //蓝牙
                    switch ((int) msg.obj) {
                        case BluetoothAdapter.STATE_OFF:
                            break;
                        case BluetoothAdapter.STATE_ON:
                            break;
                    }
                    break;
                case Comment.FOUND:
                    //  BluetoothDatesEntity.mBluetoothDevices.add((BluetoothDevice) msg.obj); // 添加到列表
                    BluetoothDatesEntity.bleDeviceList.add((BleDevice) msg.obj);
                    bluetoothNewAdapter.notifyDataSetChanged();
                    break;
                case Comment.FOUND2:
                    //   BluetoothDatesEntity.mBluetoothDevices.add((BluetoothDevice) msg.obj); // 添加到列表
                    BluetoothDatesEntity.bleDevices.add((BleDevice) msg.obj);
                    bluetoothBindAdapter.notifyDataSetChanged();
                    break;
                case Comment.DISCOVERY_STARTED:
                    progressBar.setVisibility(View.VISIBLE);
                    ToastUtil.show(BluetoothSettings1Activity.this, "开始搜索");
                    break;
                case Comment.FINISHED:
                    progressBar.setVisibility(View.INVISIBLE);
                    ToastUtil.show(BluetoothSettings1Activity.this, "结束搜索");
                    break;
                case Comment.BOND:
                    switch ((int) msg.obj) {
                        case BluetoothDevice.BOND_BONDING://正在配对
                            LoadingUtil.ShowProgress(BluetoothSettings1Activity.this, "配对中...");
                            break;
                        case BluetoothDevice.BOND_BONDED://配对结束
                            LoadingUtil.CancelProgress();
                            //连接
                            BluetoothUtil.connectSocket(mHandler);
                            showBondDevice();
                            showSearchDevice();
                            break;
                        case BluetoothDevice.BOND_NONE://取消配对/未配对
                            LoadingUtil.CancelProgress();
                            ToastUtil.show(BluetoothSettings1Activity.this, "已取消配对");
                            break;
                    }
                    break;
                case Comment.CONNECT:
                    ToastUtil.show(BluetoothSettings1Activity.this, "连接成功!");
                    break;
            }
        }
    }

    //申请蓝牙权限
    private void wantBluetoothPermission() {
        PermissionUtil.getInstance().request(new String[]{Manifest.permission.BLUETOOTH, Manifest.permission.BLUETOOTH_ADMIN, Manifest.permission.ACCESS_COARSE_LOCATION}, new PermissionResultCallBack() {
            @Override
            public void onPermissionGranted() {
                // isBluetoothSupport();
                checkBlueStatus();
            }

            @Override
            public void onPermissionGranted(String... strings) {

            }

            @Override
            public void onPermissionDenied(String... strings) {
                //  Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                //  intent.setData(Uri.fromParts("package", getApplication().getPackageName(), null));
                // startActivity(intent);
            }

            @Override
            public void onRationalShow(String... strings) {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.fromParts("package", getApplication().getPackageName(), null));
                startActivity(intent);
            }
        });
    }

    /**
     * 判断是否支持蓝牙
     */
    private void isBluetoothSupport() {
        if (BluetoothUtil.isSupportBle()) {
            if (!BluetoothUtil.isOpenBle()) {
                //打开蓝牙
                BluetoothUtil.OpenBluetooth(BluetoothSettings1Activity.this);
            } else {
                //获取蓝牙设备
                showBondDevice();
                showSearchDevice();
            }
        } else {
            ToastUtil.show(this, "设备不支持蓝牙");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //  btBroadcastReceiver = new BTBroadcastReceiver(mHandler);
        //   registerReceiver(btBroadcastReceiver, BluetoothUtil.makeFilters());
        wantBluetoothPermission();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //  if (BluetoothUtil.mBluetoothAdapter().isDiscovering()) {
        //     BluetoothUtil.mBluetoothAdapter().cancelDiscovery();
        // }
        //  unregisterReceiver(btBroadcastReceiver);
        assert ble != null;
        if (ble.isScanning()) {
            ble.stopScan();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Cancel();
    }

    private void Cancel() {
        assert ble != null;
        //取消扫描监听
        ble.cancelCallback(scanCallback);

        //取消连接监听
        ble.cancelCallback(connectCallback);
        if (Comment.bleDevice != null) {
            if (Comment.bleDevice.isConnecting()) {
                ble.cancelConnecting(Comment.bleDevice);
            } else if (Comment.bleDevice.isConnected()) {
                ble.disconnect(Comment.bleDevice);
            }
        }
    }

    //蓝牙回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_ENBLE_BT:
                if (resultCode == RESULT_OK) { //蓝牙已打开
                    //显示已配对的设备
                    showBondDevice();
                    showSearchDevice();
                }
                break;

            case REQUEST_ENABLE_VISIBILITY:
                if (resultCode == 600) {
                    ToastUtil.show(this, "蓝牙已设置可见");
                } else if (resultCode == RESULT_CANCELED) {
                    ToastUtil.show(this, "蓝牙设置可见失败,请重试");
                }
                break;
        }
    }

    //显示已配对的设备
    private void showBondDevice() {
        if (BluetoothUtil.isSupportBle() && BluetoothUtil.isOpenBle()) {
            BluetoothUtil.startGetBound();
            bluetoothBindAdapter.notifyDataSetChanged();
        }
    }

    //显示搜索的设备
    private void showSearchDevice() {
        if (BluetoothUtil.isSupportBle() && BluetoothUtil.isOpenBle()) {
            BluetoothUtil.startSearch(mHandler, 15000);
        }
    }


    //=============================================================
    //监听蓝牙开关状态
    private void initBleStatus() {
        ble.setBleStatusCallback(new BleStatusCallback() {
            @Override
            public void onBluetoothStatusChanged(boolean isOn) {
                if (isOn) {
                    BluetoothDatesEntity.bleDevices.clear();
                    BluetoothDatesEntity.bleDevices.addAll(ble.getConnectedDevices());
                    bluetoothBindAdapter.setNewData(BluetoothDatesEntity.bleDevices);
                    ble.startScan(scanCallback);
                } else {
                    if (ble.isScanning()) {
                        ble.stopScan();
                    }
                }
            }
        });
    }

    private void rescan() {
        if (ble != null && !ble.isScanning()) {
            ble.startScan(scanCallback);
        }
    }


    //检查蓝牙是否支持及打开
    private void checkBlueStatus() {
        Logutil.print("蓝牙", "开启....");
        if (!ble.isSupportBle(this)) {
            Logutil.print("蓝牙", "开启111....");
        }
        if (!ble.isBleEnable()) {
            Logutil.print("蓝牙", "开启2222....");
            ble.turnOnBlueTooth(this);
        } else {
            BluetoothDatesEntity.bleDevices.clear();
            BluetoothDatesEntity.bleDevices.addAll(ble.getConnectedDevices());
            bluetoothBindAdapter.setNewData(BluetoothDatesEntity.bleDevices);
            if (!ble.isScanning()) {
                Logutil.print("蓝牙", "开启3333....");
                ble.startScan(scanCallback);
            }
        }
    }

    //扫描回调
    private BleScanCallback<BleDevice> scanCallback = new BleScanCallback<BleDevice>() {

        @Override
        public void onLeScan(BleDevice device, int rssi, byte[] scanRecord) {
            Logutil.print("蓝牙扫描", device.getBleAddress());
            message = new Message();
            message.what = Comment.FOUND;
            message.obj = device;
            mHandler.sendMessage(message);
        }

        @Override
        public void onStart() {
            super.onStart();
            BluetoothDatesEntity.bleDeviceList.clear();
           // BluetoothDatesEntity.bleDevices.clear();
            mHandler.sendEmptyMessage(Comment.DISCOVERY_STARTED);
        }

        @Override
        public void onStop() {
            super.onStop();
            mHandler.sendEmptyMessage(Comment.FINISHED);
        }

        @Override
        public void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
        }
    };

    private BleConnectCallback<BleDevice> connectCallback = new BleConnectCallback<BleDevice>() {
        @Override
        public void onConnectionChanged(BleDevice device) {
            bluetoothBindAdapter.notifyDataSetChanged();
            bluetoothNewAdapter.notifyDataSetChanged();
        }

        @Override
        public void onConnectCancel(BleDevice device) {
            super.onConnectCancel(device);
            ToastUtil.show(BluetoothSettings1Activity.this, "连接取消");
        }

        @Override
        public void onConnectTimeOut(BleDevice device) {
            super.onConnectTimeOut(device);
            ToastUtil.show(BluetoothSettings1Activity.this, "连接超时");
        }

        @Override
        public void onReady(BleDevice device) {
            super.onReady(device);
            ble.enableNotify(device, true, new BleNotifyCallback<BleDevice>() {
                @Override
                public void onChanged(BleDevice device, final BluetoothGattCharacteristic characteristic) {
                    UUID uuid = characteristic.getUuid();
                    BleLog.e("蓝牙", "onChanged==uuid:" + uuid.toString());
                    BleLog.e("蓝牙", "onChanged==data:" + ByteUtils.toHexString(characteristic.getValue()));
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ToastUtil.show(BluetoothSettings1Activity.this, "蓝牙接收" + ByteUtils.toHexString(characteristic.getValue()));
                        }
                    });
                }

                @Override
                public void onNotifySuccess(BleDevice device) {
                    super.onNotifySuccess(device);
                }
            });
        }
    };

    /**
     * 判断搜索的设备是新蓝牙设备，且不重复
     *
     * @param device
     * @return
     */
    private boolean isNewDevice(BleDevice device) {
        boolean repeatFlag = false;
        for (BleDevice d : BluetoothDatesEntity.bleDeviceList) {
            if (d.getBleAddress().equals(device.getBleAddress())) {
                repeatFlag = true;
            }
        }
        //不是已绑定状态，且列表中不重复
        return device.isDisconnected() && !repeatFlag;
    }

}
