package com.jeewms.www.wms.ui.fragment1;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseFragment1;

import butterknife.BindView;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.frag
 * @ClassName: PurchaseFragment
 * 采购订单fragment
 * 采购订单viewpager展示
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/9/28 11:49
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/9/28 11:49
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class PurchaseFragment extends BaseFragment1 {
    @BindView(R.id.purchase_recyclerView)
    RecyclerView purchaseRecyclerView;

    public static PurchaseFragment instance(int pageCount) {
        PurchaseFragment purchaseFragment = new PurchaseFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pageCount",pageCount);
        purchaseFragment.setArguments(bundle);
        return purchaseFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_purchase;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initFunc() {

    }
}
