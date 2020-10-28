package com.jeewms.www.wms;

import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;

import com.android.volley.VolleyError;

import com.jeewms.www.wms.base.BaseActivity;
import com.jeewms.www.wms.bean.LoginVm;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.constance.Shared;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.Logutil;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.StringUtil;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;


/**
 * Created by 13799 on 2018/6/7.
 */

public class WelComeActivity extends BaseActivity {


    @BindView(R.id.welcome_root)
    ConstraintLayout llRoot;
    private int status;

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
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (status == 0) {
                    status++;
                } else {
                    // HomeActivity.show(WelComeActivity.this);
                    MainActivity.show(WelComeActivity.this);
                    finish();
                }
            }
        }, 3000);
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
                    if (status == 0) {
                        status++;
                    } else {
                        SharedPreferencesUtil.getInstance(WelComeActivity.this).setKeyValue(Shared.userPhone, vm.getData().getFphone());
                        SharedPreferencesUtil.getInstance(WelComeActivity.this).setKeyValue(Shared.userID, vm.getData().getFuserID());
                        SharedPreferencesUtil.getInstance(WelComeActivity.this).setKeyValue(Shared.TOKEN, vm.getAccess_token());
                        Logutil.print(vm.getAccess_token());
                        //HomeActivity.show(WelComeActivity.this);
                        MainActivity.show(WelComeActivity.this);
                        finish();
                    }
                } else {
                    LoginActivity.show(WelComeActivity.this);
                    finish();
                }
            }
        });

    }

}
