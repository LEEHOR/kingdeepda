package com.kingdee.ah.pda;

import android.os.Bundle;
import android.os.Message;
import android.support.constraint.ConstraintLayout;

import com.android.volley.VolleyError;

import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.base.BaseNormalActivity;
import com.kingdee.ah.pda.bean.LoginVm;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.constance.Shared;
import com.kingdee.ah.pda.util.GsonUtils;
import com.kingdee.ah.pda.util.Logutil;
import com.kingdee.ah.pda.util.SharedPreferencesUtil;
import com.kingdee.ah.pda.util.StringUtil;
import com.kingdee.ah.pda.volley.MyHandler;
import com.kingdee.ah.pda.volley.NetworkUtil;
import com.kingdee.ah.pda.volley.VolleyListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;


/**
 * Created by 13799 on 2018/6/7.
 */

public class WelComeActivity extends BaseNormalActivity implements MyHandler.OnReceiveMessageListener{


    @BindView(R.id.welcome_root)
    ConstraintLayout llRoot;
    private int count=0;
    private MyHandler myHandler=new MyHandler(this);
    @Override
    protected int getContentResId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initfun() {
        if (!StringUtil.isEmpty(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.PASSWORD))) {
            doLogin(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME), SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.PASSWORD));
        } else {
            LoginActivity.show(this);
            finish();
        }
    }

    public void doLogin(String username, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        NetworkUtil.getInstance().post(this,Constance.getLoginURL(), params,0,myHandler);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       myHandler.removeCallbacksAndMessages(null);
    }

    @Override
    public void Success(Message message) {
        String response= (String) message.obj;
        LoginVm vm = GsonUtils.parseJSON(response, LoginVm.class);
        if (vm.getCode() == 0) {
            SharedPreferencesUtil.getInstance(WelComeActivity.this).setKeyValue(Shared.userPhone, vm.getData().getFphone());
            SharedPreferencesUtil.getInstance(WelComeActivity.this).setKeyValue(Shared.userID, vm.getData().getFuserID());
            SharedPreferencesUtil.getInstance(WelComeActivity.this).setKeyValue(Shared.TOKEN, vm.getAccess_token());
            MainActivity.show(WelComeActivity.this);
            finish();
        } else {
            LoginActivity.show(WelComeActivity.this);
            finish();
        }
    }

    @Override
    public void Failure(int arg) {
        LoginActivity.show(WelComeActivity.this);
        finish();
    }

    @Override
    public void Complete(int arg) {

    }
}
