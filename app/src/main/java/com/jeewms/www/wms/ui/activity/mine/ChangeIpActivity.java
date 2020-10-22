package com.jeewms.www.wms.ui.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity1;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.view.TitleTopOrdersView;
import com.jeewms.www.wms.util.StringUtil;
import com.jeewms.www.wms.util.ToastUtil;

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
public class ChangeIpActivity extends BaseActivity1 {
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

    @Override
    protected void initView(Bundle savedInstanceState) {
        changeIpTitle.setViewVisibility(View.VISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE,View.INVISIBLE);
        changeIpTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initfun() {
        String baseUrl = Constance.getBaseUrl();
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
        Constance.setBaseUrl(app_id.getText().toString().trim());
        ToastUtil.show(this,"修改ip地址成功");
    }
}
