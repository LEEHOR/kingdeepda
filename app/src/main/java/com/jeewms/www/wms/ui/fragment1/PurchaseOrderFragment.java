package com.jeewms.www.wms.ui.fragment1;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseFragment1;
import com.jeewms.www.wms.ui.adapter.PurchaseOrderAdapter;
import com.jeewms.www.wms.util.Logutil;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.fragment1
 * @ClassName: PurchaseOrderFragment
 * 采购订单首页
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/13 12:03
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/13 12:03
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class PurchaseOrderFragment extends BaseFragment1 {
    @BindView(R.id.purchase_search)
    SearchView purchaseSearch;
    @BindView(R.id.iv_purchase_add)
    ImageView ivPurchaseAdd;
    @BindView(R.id.purchase_tab)
    TabLayout purchaseTab;
    @BindView(R.id.purchaseViewpager)
    ViewPager purchaseViewpager;
    private PurchaseOrderAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_purchase_order;
    }

    @Override
    protected void initView() {
        adapter=new PurchaseOrderAdapter(getFragmentManager(),new String[]{"全部","已采购","草稿","撤销"});
        purchaseTab.setupWithViewPager(purchaseViewpager);
        purchaseViewpager.setAdapter(adapter);
        purchaseViewpager.setCurrentItem(0);

        purchaseSearch.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void initFunc() {
        delete_plate();
    }

    @OnClick(R.id.iv_purchase_add)
    public void onViewClicked() {

    }

    private void delete_plate() {
        //去掉searchview下划线 方法二
        try {        //--拿到字节码
            Class<?> argClass = purchaseSearch.getClass();
            //--指定某个私有属性,mSearchPlate是搜索框父布局的名字
            Field ownField = argClass.getDeclaredField("mSearchPlate");
            //--暴力反射,只有暴力反射才能拿到私有属性
            ownField.setAccessible(true);
            View mView = (View) ownField.get(purchaseSearch);
            //--设置背景
            mView.setBackgroundColor(Color.TRANSPARENT);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }
}
