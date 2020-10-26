package com.jeewms.www.wms.ui.activity.materialList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity;
import com.jeewms.www.wms.ui.view.TitleTopOrdersView;

import butterknife.BindView;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity.materialList
 * @ClassName: MaterialListActivity
 * @Description: java类作用描述
 * 用料清单列表页
 * @Author: 作者名
 * @CreateDate: 2020/10/23 14:13
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 14:13
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MaterialListActivity extends BaseActivity {
    @BindView(R.id.material_list_title)
    TitleTopOrdersView materialListTitle;

    @Override
    protected int getContentResId() {
        return R.layout.activity_material_list;
    }
    public static void show(Context context) {
        Intent intent = new Intent(context, MaterialListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        materialListTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TextView tex_item = materialListTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("用料清单列表页");
    }

    @Override
    protected void initfun() {

    }

}
