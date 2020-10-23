package com.jeewms.www.wms.ui.fragment;

import android.view.View;
import android.widget.GridView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseTitlebarFragment;
import com.jeewms.www.wms.bean.HomeBtnBean;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.adapter.HomeGridAdapter;
import java.util.ArrayList;

/**
 * 首页
 */

public class HomeFragment  extends BaseTitlebarFragment {

    HomeGridAdapter adapter;
    GridView gvHome;
    private View mView;
    ArrayList<HomeBtnBean> list = new ArrayList<>();
    @Override
    protected int getContentResId() {
        return R.layout.fragment_home;
    }



    @Override
    protected void initView() {
        super.initView();
        mView=getContentView();
        adapter = new HomeGridAdapter();
        gvHome = getContentView().findViewById(R.id.gv_home);
        gvHome.setAdapter(adapter);
        addBtn();
    }
    //添加按钮
    private void addBtn() {
        list.clear();
        for (int i = 0; i < Constance.btnNameList.length; i++) {
            addBtn2List(Constance.btnNameList[i], Constance.btnImgList[i]);
        }
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }

    private void addBtn2List(String btnName, int imgResId) {
        HomeBtnBean btn1 = new HomeBtnBean();
        btn1.setBtnName(btnName);
        btn1.setImaResId(imgResId);
        list.add(btn1);
    }
}
