package com.kingdee.ah.pda.ui.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.constance.Shared;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;
import com.kingdee.ah.pda.util.SharedPreferencesUtil;
import com.kingdee.ah.pda.util.StringUtil;
import com.kingdee.ah.pda.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity1.mine
 * @ClassName: ChangeIpActivity
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/13 9:33
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/13 9:33
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ChangeIpActivity extends BaseActivity {
    @BindView(R.id.changeIp_title)
    TitleTopOrdersView changeIpTitle;
    @BindView(R.id.app_ip)
    EditText app_id;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;

    @Override
    protected int getContentResId() {
        return R.layout.activity_change_ip;
    }

    public static void show(Context context) {
        Intent intent = new Intent(context, ChangeIpActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        TextView tex_item = changeIpTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("设置IP地址");
        changeIpTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void initfun() {
        String baseUrl = Constance.getBaseIp();
        app_id.setText(baseUrl);
    }


    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
        check();
    }

    private void check(){
        if (StringUtil.isEmpty(app_id.getText().toString())) {
            ToastUtil.show(this, "请输入有效的ip地址");
            return;
        }
        doChangeIp();
    }

    private void doChangeIp(){
        SharedPreferencesUtil.getInstance(this).setKeyValue(Shared.BASEIP,app_id.getText().toString());
        ToastUtil.show(this,"修改ip地址成功");
    }
}
