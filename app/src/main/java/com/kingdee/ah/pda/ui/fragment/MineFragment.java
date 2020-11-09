package com.kingdee.ah.pda.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.kingdee.ah.pda.App;
import com.kingdee.ah.pda.LoginActivity;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseFragment;
import com.kingdee.ah.pda.bean.NewVersionBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.constance.Shared;
import com.kingdee.ah.pda.ui.activity.mine.ChangePass;
import com.kingdee.ah.pda.ui.activity.mine.ServerAddressConfigActivity;
import com.kingdee.ah.pda.ui.activity.mine.SettingDefaultOrganActivity;
import com.kingdee.ah.pda.ui.dialog.UpdateDialog;
import com.kingdee.ah.pda.ui.view.CircleImageView;
import com.kingdee.ah.pda.util.GsonUtils;
import com.kingdee.ah.pda.util.SharedPreferencesUtil;
import com.kingdee.ah.pda.util.ToastUtil;
import com.kingdee.ah.pda.volley.MyHandler;
import com.kingdee.ah.pda.volley.NetworkUtil;
import com.kingdee.ah.pda.volley.VolleyListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

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
public class MineFragment extends BaseFragment implements MyHandler.OnReceiveMessageListener {
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
    @BindView(R.id.re_update_base)
    RelativeLayout reUpdateBase;
    Unbinder unbinder;
    private MyHandler myHandler=new MyHandler(this);

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
        if (!hidden) {
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
        SharedPreferencesUtil.getInstance(getContext()).remove(Shared.PASSWORD);
        SharedPreferencesUtil.getInstance(getContext()).remove(Shared.userAccount);
        SharedPreferencesUtil.getInstance(getContext()).remove(Shared.userPhone);
        SharedPreferencesUtil.getInstance(getContext()).remove(Shared.TOKEN);
        SharedPreferencesUtil.getInstance(getContext()).remove(Shared.userID);
        LoginActivity.show(getContext());
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext()).setIcon(R.mipmap.icon).setTitle(getResources().getString(R.string.mine_dialog_title))
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

    @OnClick({R.id.re_app_update, R.id.re_change_pass, R.id.re_default_option, R.id.re_server_option, R.id.re_sign_out, R.id.re_update_base})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.re_app_update:
                checkVersion();
                break;
            case R.id.re_change_pass:
                Intent intent = new Intent(getContext(), ChangePass.class);
                getContext().startActivity(intent);
                break;
            case R.id.re_default_option:
                SettingDefaultOrganActivity.show(getContext());
                break;
            case R.id.re_server_option:
                Intent intent1 = new Intent(getContext(), ServerAddressConfigActivity.class);
                getContext().startActivity(intent1);
                break;
            case R.id.re_sign_out:
                showDialog();
                break;
            case R.id.re_update_base:
                updateBaseData(2);
                break;
        }
    }

    /**
     * 检查新版本
     */
    private void checkVersion() {
        Map<String, String> params = new HashMap<>();
        String newVersionUrl = Constance.getNewVersion();
        ShowProgress(getActivity(),"加载中...",false);
        NetworkUtil.getInstance().post(getActivity(),newVersionUrl, params,0,myHandler);
    }

    private void DialogVersion(String versionName, int isForceUpdate, String remark, final String durl) {
        final UpdateDialog updateDialog = UpdateDialog.newInstance(versionName, isForceUpdate, remark);
        updateDialog.setOnUpdateListener(new UpdateDialog.OnUpdateListener() {
            @Override
            public void onConfirm() {
                if (durl == null) {
                    updateDialog.dismiss();
                }
            }
        });
        updateDialog.show(getChildFragmentManager(), "update");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        myHandler.removeCallbacksAndMessages(null);
    }

    @Override
    public void Success(Message message) {
        String response= (String) message.obj;
        NewVersionBean vm = GsonUtils.parseJSON(response, NewVersionBean.class);
        if (vm.getCode() == 0) {
            DialogVersion(vm.getVersion(), vm.getFocusUpdate(), vm.getRemark(), vm.getUrl());
        } else {
            ToastUtil.show(getActivity(), vm.getMsg());
        }
    }

    @Override
    public void Failure(int arg) {

    }

    @Override
    public void Complete(int arg) {
        CancelProgress();
    }
}
