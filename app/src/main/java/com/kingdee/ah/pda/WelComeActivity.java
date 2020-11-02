package com.kingdee.ah.pda;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;

import com.android.volley.VolleyError;

import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.LoginVm;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.constance.Shared;
import com.kingdee.ah.pda.util.GsonUtils;
import com.kingdee.ah.pda.util.Logutil;
import com.kingdee.ah.pda.util.SharedPreferencesUtil;
import com.kingdee.ah.pda.util.StringUtil;
import com.kingdee.ah.pda.volley.HTTPUtils;
import com.kingdee.ah.pda.volley.VolleyListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;


/**
 * Created by 13799 on 2018/6/7.
 */

public class WelComeActivity extends BaseActivity {


    @BindView(R.id.welcome_root)
    ConstraintLayout llRoot;
    @Override
    protected int getContentResId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (!StringUtil.isEmpty(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.PASSWORD))) {
            doLogin(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME), SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.PASSWORD));
        } else {
            LoginActivity.show(this);
            finish();
        }
    }

    @Override
    protected void initfun() {

    }

    public void doLogin(String username, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
       // Constance.setBaseIp(Constance.getBaseIp());
        HTTPUtils.getInstance(this).post(Constance.getLoginURL(), params, new VolleyListener<String>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                LoginActivity.show(WelComeActivity.this);
                finish();
            }

            @Override
            public void onResponse(String response) {
                LoginVm vm = GsonUtils.parseJSON(response, LoginVm.class);
                if (vm.getCode() == 0) {
                        SharedPreferencesUtil.getInstance(WelComeActivity.this).setKeyValue(Shared.userPhone, vm.getData().getFphone());
                        SharedPreferencesUtil.getInstance(WelComeActivity.this).setKeyValue(Shared.userID, vm.getData().getFuserID());
                        SharedPreferencesUtil.getInstance(WelComeActivity.this).setKeyValue(Shared.TOKEN, vm.getAccess_token());
                        Logutil.print(vm.getAccess_token());
                        MainActivity.show(WelComeActivity.this);
                        finish();
                } else {
                    LoginActivity.show(WelComeActivity.this);
                    finish();
                }
            }
        });

    }

}
