package com.jeewms.www.wms.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jeewms.www.wms.ui.fragment1.PurchaseFragment;


/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.adapter
 * @ClassName: PurchaseOrderAdapter
 * @Description: java类作用描述
 * 采购订单 adapter
 * @Author: 作者名
 * @CreateDate: 2020/9/28 11:42
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/9/28 11:42
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class PurchaseOrderAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{};

    public PurchaseOrderAdapter(FragmentManager fm) {
        super(fm);
    }
    public PurchaseOrderAdapter(FragmentManager fm,String[] Titles) {
        super(fm);
        this.mTitles=Titles;
    }
     public  void setDate(String[] Titles){
         this.mTitles=Titles;
    }
    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public Fragment getItem(int i) {
        return PurchaseFragment.instance(i);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
