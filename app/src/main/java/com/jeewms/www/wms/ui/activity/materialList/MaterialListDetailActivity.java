package com.jeewms.www.wms.ui.activity.materialList;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity1;
import com.jeewms.www.wms.ui.view.TitleTopOrdersView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity.materialList
 * @ClassName: MaterialListActivity
 * @Description: java类作用描述
 * 用料清单详情页
 * @Author: 作者名
 * @CreateDate: 2020/10/23 14:13
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 14:13
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MaterialListDetailActivity extends BaseActivity1 {

    @BindView(R.id.material_list_detail_title)
    TitleTopOrdersView materialListDetailTitle;

    @Override
    protected int getContentResId() {
        return R.layout.activity_material_list_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        materialListDetailTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TextView tex_item = materialListDetailTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("用料清单详情页");
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
