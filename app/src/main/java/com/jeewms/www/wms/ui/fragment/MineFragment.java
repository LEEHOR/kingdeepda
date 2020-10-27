package com.jeewms.www.wms.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jeewms.www.wms.LoginActivity;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseFragment;
import com.jeewms.www.wms.bean.LoginVm;
import com.jeewms.www.wms.bean.NewVersionBean;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.constance.Shared;
import com.jeewms.www.wms.ui.activity.mine.ChangePass;
import com.jeewms.www.wms.ui.activity.mine.ServerAddressConfigActivity;
import com.jeewms.www.wms.ui.activity.mine.SettingDefaultOrganActivity;
import com.jeewms.www.wms.ui.dialog.UpdateDialog;
import com.jeewms.www.wms.ui.view.CircleImageView;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.ToastUtil;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.fragment1
 * @ClassName: MineFragment
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/9 9:27
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/9 9:27
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MineFragment extends BaseFragment {
    @BindView(R.id.mine_head_portrait)
    CircleImageView mineHeadPortrait;
    @BindView(R.id.userID)
    TextView userID;
    @BindView(R.id.userAccount)
    TextView userAccount;
    @BindView(R.id.re_app_update)
    RelativeLayout reAppUpdate;
    @BindView(R.id.re_change_pass)
    RelativeLayout reChangePass;
    @BindView(R.id.re_default_option)
    RelativeLayout reDefaultOption;
    @BindView(R.id.re_server_option)
    RelativeLayout reServerOption;
    @BindView(R.id.re_sign_out)
    RelativeLayout reSignOut;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        String user_account = SharedPreferencesUtil.getInstance(getActivity()).getKeyValue(Shared.userAccount);
        String user_phone = SharedPreferencesUtil.getInstance(getActivity()).getKeyValue(Shared.userPhone);
        userAccount.setText(user_account);
        userID.setText(user_phone);
    }

    @Override
    protected void initFunc() {

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            String user_account = SharedPreferencesUtil.getInstance(getActivity()).getKeyValue(Shared.userAccount);
            String user_phone = SharedPreferencesUtil.getInstance(getActivity()).getKeyValue(Shared.userPhone);
            userAccount.setText(user_account);
            userID.setText(user_phone);
        }
    }

    /**
     * 清除用户信息
     */
    private void removeUerInfo() {
        SharedPreferencesUtil.getInstance(getActivity()).remove(Shared.PASSWORD);
        SharedPreferencesUtil.getInstance(getActivity()).remove(Shared.userAccount);
        SharedPreferencesUtil.getInstance(getActivity()).remove(Shared.userPhone);
        SharedPreferencesUtil.getInstance(getActivity()).remove(Shared.TOKEN);
        SharedPreferencesUtil.getInstance(getActivity()).remove(Shared.userID);
        LoginActivity.show(getActivity());
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()).setIcon(R.mipmap.icon).setTitle(getResources().getString(R.string.mine_dialog_title))
                .setMessage(getResources().getString(R.string.mine_dialog_msg)).setPositiveButton(getResources().getString(R.string.mine_dialog_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        removeUerInfo();
                    }
                }).setNegativeButton(getResources().getString(R.string.mine_dialog_cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });
        builder.create().show();
    }

    @OnClick({R.id.re_app_update, R.id.re_change_pass, R.id.re_default_option, R.id.re_server_option, R.id.re_sign_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.re_app_update:
                checkVersion();
                break;
            case R.id.re_change_pass:
                Intent intent = new Intent(this.getActivity(), ChangePass.class);
                getActivity().startActivity(intent);
                break;
            case R.id.re_default_option:
                SettingDefaultOrganActivity.show(getActivity());
                break;
            case R.id.re_server_option:
                Intent intent1 = new Intent(this.getActivity(), ServerAddressConfigActivity.class);
                getActivity().startActivity(intent1);
                break;
            case R.id.re_sign_out:
                showDialog();
                break;
        }
    }

    /**
     * 检查新版本
     */
    private void checkVersion(){
        Map<String,String> params=new HashMap<>();
        String newVersionUrl = Constance.getNewVersion();
        HTTPUtils.getInstance(getActivity()).post(getActivity(), newVersionUrl, params, new VolleyListener<String>() {
            @Override
            public void requestComplete() {

            }
            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtil.show(getActivity(), error.getMessage());
            }

            @Override
            public void onResponse(String response) {
                NewVersionBean vm = GsonUtils.parseJSON(response, NewVersionBean.class);
                if (vm.getCode()==0){
                    DialogVersion(vm.getVersion(),vm.getFocusUpdate(),vm.getRemark(),vm.getUrl());
                }else {
                    ToastUtil.show(getActivity(), vm.getMsg());
                }
            }
        });
//        HTTPUtils.post(getActivity(), newVersionUrl, params, new VolleyListener<String>() {
//            @Override
//            public void requestComplete() {
//
//            }
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                ToastUtil.show(getActivity(), error.getMessage());
//            }
//
//            @Override
//            public void onResponse(String response) {
//                NewVersionBean vm = GsonUtils.parseJSON(response, NewVersionBean.class);
//                if (vm.getCode()==0){
//                    DialogVersion(vm.getVersion(),vm.getFocusUpdate(),vm.getRemark(),vm.getUrl());
//                }else {
//                    ToastUtil.show(getActivity(), vm.getMsg());
//                }
//            }
//        });

    }
    private void DialogVersion(String versionName, int isForceUpdate, String remark, final String durl){
        final UpdateDialog updateDialog = UpdateDialog.newInstance(versionName,isForceUpdate,remark);
        updateDialog.setOnUpdateListener(new UpdateDialog.OnUpdateListener() {
            @Override
            public void onConfirm() {
                if (durl==null){
                    updateDialog.dismiss();
                }
            }
        });
        updateDialog.show(getActivity().getFragmentManager(), "update");
    }
}
