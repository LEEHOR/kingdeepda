package com.kingdee.ah.pda.ui.activity.materialList;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.MaterialBean;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;

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
public class MaterialListDetailActivity extends BaseActivity {

    @BindView(R.id.material_list_detail_title)
    TitleTopOrdersView materialListDetailTitle;
    @BindView(R.id.tv_fbillNo)
    EditText tvFbillNo;
    @BindView(R.id.tv_fmaterialNumber)
    EditText tvFmaterialNumber;
    @BindView(R.id.tv_fmaterialName)
    EditText tvFmaterialName;
    @BindView(R.id.tv_fmaterialSpecification)
    EditText tvFmaterialSpecification;
    @BindView(R.id.tv_fbomnumber)
    EditText tvFbomnumber;
    @BindView(R.id.tv_fprdOrgName)
    EditText tvFprdOrgName;
    @BindView(R.id.tv_fworkshopName)
    EditText tvFworkshopName;
    @BindView(R.id.tv_funitName)
    EditText tvFunitName;
    @BindView(R.id.tv_fmobillNO)
    EditText tvFmobillNO;
    @BindView(R.id.tv_fdocumentStatus)
    EditText tvFdocumentStatus;


    @Override
    protected int getContentResId() {
        return R.layout.activity_material_list_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        materialListDetailTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView tex_item = materialListDetailTitle.getTex_item();
        tex_item.setVisibility(View.VISIBLE);
        tex_item.setText("用料清单详情页");
    }

    @Override
    protected void initfun() {
        if (getIntent() != null) {
            Bundle materialHead = getIntent().getBundleExtra("materialHead");
            MaterialBean.DataEntity dataEntity = (MaterialBean.DataEntity) materialHead.get("material");
            tvFbillNo.setText(dataEntity.getFbillNo());
            tvFmaterialNumber.setText(dataEntity.getFmaterialNumber());
            tvFmaterialName.setText(dataEntity.getFmaterialName());
            tvFmaterialSpecification.setText(dataEntity.getFmaterialSpecification());
            tvFbomnumber.setText(dataEntity.getFbomnumber());
            tvFprdOrgName.setText(dataEntity.getFprdOrgName());
            tvFworkshopName.setText(dataEntity.getFworkshopName());
            tvFunitName.setText(dataEntity.getFunitName());
            tvFmobillNO.setText(dataEntity.getFmobillNO());
            tvFdocumentStatus.setText(dataEntity.getFdocumentStatus());
        }
    }

    //获取表体
    private void getDetail() {

    }


}
