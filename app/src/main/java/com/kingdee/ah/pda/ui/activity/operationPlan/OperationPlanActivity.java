package com.kingdee.ah.pda.ui.activity.operationPlan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity.operationPlan
 * @ClassName: OperationPlanActivity
 * @Description: java类作用描述
 * 工序计划列表
 * @Author: 作者名
 * @CreateDate: 2020/10/24 12:55
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/24 12:55
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class OperationPlanActivity extends BaseActivity {
    @BindView(R.id.operation_plan_title)
    TitleTopOrdersView operationPlanTitle;

    @Override
    protected int getContentResId() {
        return R.layout.activity_operation_plant;
    }
    public static void show(Context context) {
        Intent intent = new Intent(context, OperationPlanActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void initView(Bundle savedInstanceState) {
        operationPlanTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = operationPlanTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("工序计划列表");
    }

    @Override
    protected void initfun() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
