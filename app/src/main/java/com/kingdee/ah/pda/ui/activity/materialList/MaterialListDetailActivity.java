package com.kingdee.ah.pda.ui.activity.materialList;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.CellInfo;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.format.bg.BaseBackgroundFormat;
import com.bin.david.form.data.format.bg.BaseCellBackgroundFormat;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.table.TableData;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.MaterialBodyBean;
import com.kingdee.ah.pda.bean.MaterialHeadBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.view.TitleTopOrdersView;
import com.kingdee.ah.pda.volley.NetworkUtil;
import com.kingdee.ah.pda.volley.VolleyListener;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

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
    @BindView(R.id.material_list_table)
    SmartTable<MaterialBodyBean.DataEntity> materialListTable;
    private int fid;
    private Map<String, String> map = new HashMap<>();

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
        if (getIntent() != null) {
            Bundle materialHead = getIntent().getBundleExtra("materialBundle");
            MaterialHeadBean.DataEntity dataEntity = (MaterialHeadBean.DataEntity) materialHead.get("head");
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
            fid = dataEntity.getFid();
            tex_item.setText("用料清单详情");
        }


    }

    @Override
    protected void initfun() {
        CreateTable();
        if (fid != 0) {
            getDetailBody(fid);
        }

    }

    //获取表体
    private void getDetailBody(int fids) {
        map.clear();
        map.put("fid", String.valueOf(fids));
        String prdPpbom = Constance.getPrdPpbom();
        ShowProgress(this, "正在加载...", false);
        NetworkUtil.getInstance().postByJson(this,prdPpbom, MaterialBodyBean.class, map, new VolleyListener<MaterialBodyBean>() {
            @Override
            public void requestComplete() {
                CancelProgress();
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onResponse(MaterialBodyBean response) {
                int code = response.getCode();
                if (code == 0) {
                    List<MaterialBodyBean.DataEntity> data = response.getData();
                    materialListTable.addData(data, true);
                }
            }
        });
    }

    //创建表格
    private void CreateTable() {
        materialListTable.getConfig().setShowYSequence(true);
        materialListTable.getConfig().setShowXSequence(false);
        materialListTable.getConfig().setShowTableTitle(false);
        materialListTable.getConfig().setVerticalPadding(24);
        materialListTable.getConfig().setContentStyle(new FontStyle(45, Color.BLUE));
        materialListTable.getConfig().setColumnTitleStyle(new FontStyle(45, Color.WHITE));
        materialListTable.getConfig().setColumnTitleBackground(new BaseBackgroundFormat(getResources().getColor(R.color.titlebar_color)));
        materialListTable.getConfig().setContentCellBackgroundFormat(new BaseCellBackgroundFormat<CellInfo>() {
            @Override
            public int getBackGroundColor(CellInfo cellInfo) {
                if (cellInfo.row % 2 == 0) {
                    return ContextCompat.getColor(MaterialListDetailActivity.this, R.color.actions_background_light);
                } else {
                    return ContextCompat.getColor(MaterialListDetailActivity.this, R.color.yellowF23757);
                    // return TableConfig.INVALID_COLOR; //返回无效颜色，不会绘制
                }
            }
        });
        Column<String> c1 = new Column<>("子项物料编码", "fmaterialID2Number");

        Column<String> c2 = new Column<>("子项物料名称", "fmaterialID2Name");
        Column<String> c3 = new Column<>("规格型号", "fmaterialID2Specification");
        Column<String> c4 = new Column<>("子项类型", "fmaterialTypeName");
        Column<String> c5 = new Column<>("供应类型", "fmaterialID2_FErpClsNumber");
        Column<BigDecimal> c6 = new Column<>("使用比例(%)", "fuseRate");
        Column<String> c7 = new Column<>("子项单位", "funitID2Name");
        Column<BigDecimal> c8 = new Column<>("应发数量", "fmustQty");
        Column<BigDecimal> c9 = new Column<>("已申购数量", "ffixScrapQty");
        Column<BigDecimal> c10 = new Column<>("已领数量", "fscrapRate");
        Column<BigDecimal> c11 = new Column<>("未领数量", "f_PBXQ_SL1");

        TableData<MaterialBodyBean.DataEntity> tableData = new TableData<MaterialBodyBean.DataEntity>("出库申请", new ArrayList<MaterialBodyBean.DataEntity>()
                , c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11);
        materialListTable.setTableData(tableData);
    }

}
