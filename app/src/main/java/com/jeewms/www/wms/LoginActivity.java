package com.jeewms.www.wms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jeewms.www.wms.base.BaseActivity;
import com.jeewms.www.wms.bean.LoginVm;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.constance.Shared;
import com.jeewms.www.wms.ui.dialog.UpdateBaseDataDialog;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.StringUtil;
import com.jeewms.www.wms.util.ToastUtil;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 13799 on 2018/5/29.
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.tv_userName)
    EditText tvUserName;
    @BindView(R.id.tv_password)
    EditText tvPassword;
    @BindView(R.id.forgetPassword)
    TextView forgetPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_regist)
    Button btnRegist;
    @BindView(R.id.tv_address)
    EditText tvAddress;
    String addressPer;
    private long exitTime = 0;
    public static void show(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected int getContentResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        String keyValue = SharedPreferencesUtil.getInstance(this).getKeyValue(Shared.BASEURL,Constance.getBaseUrl());
        tvAddress.setText(keyValue);
        if(!StringUtil.isEmpty(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME))&&tvUserName!=null){
            tvUserName.setText(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME));
            tvPassword.setFocusable(true);
            tvPassword.setFocusableInTouchMode(true);
            tvPassword.requestFocus();
            this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

        }
        tvAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                addressPer=charSequence+"";
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    @Override
    protected void initfun() {
    }


    @OnClick({R.id.forgetPassword, R.id.btn_login, R.id.btn_regist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forgetPassword:
                ToastUtil.show(this, "忘记密码");
                break;
            case R.id.btn_login:
                check();
                break;
            case R.id.btn_regist:
                ToastUtil.show(this, "注册");
                break;
        }
    }

    private void check() {
        setAddress();
        HTTPUtils.getInstance(this).cleanerCathe();
        if (StringUtil.isEmpty(tvUserName.getText().toString())) {
            ToastUtil.show(this, "请输入用户名");
            return;
        }
        if (StringUtil.isEmpty(tvPassword.getText().toString())) {
            ToastUtil.show(this, "请输入密码");
            return;
        }
        doLogin(tvUserName.getText().toString(), tvPassword.getText().toString());
    }

    public void doLogin(String username, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        String loginURL = Constance.getLoginURL();
        HTTPUtils.getInstance(this).post( loginURL, params, new VolleyListener<String>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtil.show(LoginActivity.this, "网络连接失败");
            }

            @Override
            public void onResponse(String response) {
                LoginVm vm = GsonUtils.parseJSON(response, LoginVm.class);
                if (vm.getCode()==0) {
                    savePassword(vm.getData().getFuserAccount(),vm.getData().getFuserID(),vm.getData().getFphone(),vm.getAccess_token());
                } else {
                    ToastUtil.show(LoginActivity.this, vm.getMsg());
                }
            }
        });
    }

    private void savePassword(String userAccount,int userId,String phone,String token) {
        ToastUtil.show(this, "登陆成功");
        if (!StringUtil.isEmpty(tvPassword.getText().toString())) {
            SharedPreferencesUtil.getInstance(this).setKeyValue(Shared.userAccount, userAccount);
            SharedPreferencesUtil.getInstance(this).setKeyValue(Shared.userPhone, phone);
            SharedPreferencesUtil.getInstance(this).setKeyValue(Shared.userID, userId);
            SharedPreferencesUtil.getInstance(this).setKeyValue(Shared.TOKEN, token);
            SharedPreferencesUtil.getInstance(this).setKeyValue(Constance.SHAREP.LOGINNAME, tvUserName.getText().toString());
            SharedPreferencesUtil.getInstance(this).setKeyValue(Constance.SHAREP.PASSWORD, tvPassword.getText().toString());
        }
        MainActivity.show(this);
        finish();
    }
    //初始化地址
    private void setAddress(){
        //如果为保存地址，则使用最初地址
        if (!StringUtil.isEmpty(addressPer)){
            SharedPreferencesUtil.getInstance(this).setKeyValue(Shared.BASEURL,addressPer);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ToastUtil.show(this, "再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}