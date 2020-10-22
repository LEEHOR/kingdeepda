package com.jeewms.www.wms;

import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jeewms.www.wms.base.BaseActivity;
import com.jeewms.www.wms.bean.LoginVm;
import com.jeewms.www.wms.bean.PurchaseOrderAddBean;
import com.jeewms.www.wms.bean.SignOut;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.constance.Shared;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.Logutil;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.StringUtil;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 13799 on 2018/6/7.
 */

public class WelComeActivity extends BaseActivity {


    @BindView(R.id.welcome_root)
    ConstraintLayout llRoot;
    private int status;

    @Override
    protected int getTitleBarResId() {
        return -1;
    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
       // llRoot.setBackgroundResource(R.drawable.welcome);
        if (!StringUtil.isEmpty(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.PASSWORD))) {
            doLogin(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME), SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.PASSWORD));
        }else {
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
        SignOut signOut=new SignOut();
        signOut.setAge(16);
        signOut.setHeight("180");
        signOut.setName("leehor");
        PurchaseOrderAddBean bean=new PurchaseOrderAddBean();
        JsonObject jsonObject = new Gson().toJsonTree(bean).getAsJsonObject();
        Logutil.print("数据",jsonObject.toString());

    }

    public void doLogin(String username, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

        Constance.setBaseUrl(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.HTTPADDRESS));
        HTTPUtils.post(this, Constance.getLoginURL(), params, new VolleyListener<String>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                LoginActivity.show(getActivity());
                finish();
            }

            @Override
            public void onResponse(String response) {
                LoginVm vm = GsonUtils.parseJSON(response, LoginVm.class);
                if (vm.getCode()==0) {
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
                    LoginActivity.show(getActivity());
                    finish();
                }
            }
        });
    }

}
