package com.kingdee.ah.pda.ui.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.VolleyError;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.UpdatePwd;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.constance.Shared;
import com.kingdee.ah.pda.ui.view.LoadingView;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;
import com.kingdee.ah.pda.util.GsonUtils;
import com.kingdee.ah.pda.util.LoadingUtil;
import com.kingdee.ah.pda.util.SharedPreferencesUtil;
import com.kingdee.ah.pda.util.StringUtil;
import com.kingdee.ah.pda.util.ToastUtil;
import com.kingdee.ah.pda.volley.HTTPUtils;
import com.kingdee.ah.pda.volley.VolleyListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity1
 * @ClassName: ChangePass
 * @Description: java类作用描述
 * 修改密码
 * @Author: 作者名
 * @CreateDate: 2020/10/9 16:03
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/9 16:03
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ChangePass extends BaseActivity {
    @BindView(R.id.user_account)
    EditText userAccount;
    @BindView(R.id.user_oldpass)
    EditText userOldPass;
    @BindView(R.id.input_pass1)
    EditText inputPass1;
    @BindView(R.id.input_pass2)
    EditText inputPass2;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;
    @BindView(R.id.changePass_title)
    TitleTopOrdersView changePassTitle;

    @Override
    protected int getContentResId() {
        return R.layout.activity_change_pass;
    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        changePassTitle.setViewVisibility(View.VISIBLE, View.VISIBLE, View.GONE, View.GONE, View.GONE, View.GONE, View.GONE);
        changePassTitle.getTex_item().setText(R.string.mine09);
        changePassTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void initfun() {

    }

    private void check() {
        if (StringUtil.isEmpty(userOldPass.getText().toString().trim())) {
            ToastUtil.show(this, "请输入旧密码");
            return;
        }
        if (StringUtil.isEmpty(inputPass1.getText().toString().trim())) {
            ToastUtil.show(this, "请输入密码");
            return;
        }
        if (StringUtil.isEmpty(inputPass2.getText().toString().trim())) {
            ToastUtil.show(this, "再输入一次密码");
            return;
        }
        if (!inputPass1.getText().toString().trim().equals(inputPass2.getText().toString().trim())) {
            ToastUtil.show(this, "两次输入的密码不一致");
            return;
        }
        doChangePass(userOldPass.getText().toString(), inputPass2.getText().toString());
    }

    //修改密码
    public void doChangePass(String userOldPass, String password) {
        Map<String, String> params = new HashMap<>();
        LoadingUtil.ShowProgress(this,"正在修改...",true);
        params.put("username", SharedPreferencesUtil.getInstance(this).getKeyValue(Shared.userAccount));
        params.put("oldPwd", userOldPass);
        params.put("newPwd", password);
        String updatePwdUrl = Constance.getUpdatePwd();
        HTTPUtils.getInstance(this).post(updatePwdUrl, params, new VolleyListener<String>() {
            @Override
            public void requestComplete() {
                LoadingUtil.CancelProgress();
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtil.show(ChangePass.this, "网络连接失败");
            }

            @Override
            public void onResponse(String response) {
                UpdatePwd updatePwd = GsonUtils.parseJSON(response, UpdatePwd.class);
                int code = updatePwd.getCode();
                if (code == 0) {
                    ToastUtil.show(ChangePass.this, updatePwd.getMsg());
                    updateUserInfo(inputPass2.getText().toString().trim());
//                } else if (code == 900) {
//                    AlertDialog alertDialog = CreateDialog(ChangePass.this, updatePwd.getMsg());
//                    if (!alertDialog.isShowing()) {
//                        alertDialog.show();
//                    }
                } else {
                    ToastUtil.show(ChangePass.this, updatePwd.getMsg());
                }
            }
        });
    }

    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
        check();
    }


    private void updateUserInfo(String pwd) {
        SharedPreferencesUtil.getInstance(this).setKeyValue(Shared.PASSWORD, pwd);
    }
}
