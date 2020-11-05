package com.kingdee.ah.pda;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.GridView;


import com.kingdee.ah.pda.base.BaseActivity;
import com.kingdee.ah.pda.bean.HomeBtnBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.adapter.HomeGridAdapter1;
import com.kingdee.ah.pda.util.SharedPreferencesUtil;

import java.util.ArrayList;

/**
 * Created by 13799 on 2018/7/2.
 */

public class HomeActivity extends BaseActivity {

    HomeGridAdapter1 adapter;
    GridView gvHome;
    ArrayList<HomeBtnBean> list = new ArrayList<>();

    public static void show(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getContentResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        init();
    }

    @Override
    protected void initfun() {

    }

    private void init() {
        findViewById(R.id.btn_titlebar_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesUtil.getInstance(HomeActivity.this).setKeyValue(Constance.SHAREP.PASSWORD,"");
                LoginActivity.show(HomeActivity.this);
                finish();
            }
        });
        adapter = new HomeGridAdapter1();
        gvHome.setAdapter(adapter);
        addBtn();

    }
    //添加按钮
    private void addBtn() {
        list.clear();
//        for (int i = 0; i < Constance.btnNameList.length; i++) {
//            addBtn2List(Constance.btnNameList[i], Constance.btnImgList[i]);
//        }
        adapter.setList(list,1);
        adapter.notifyDataSetChanged();
    }

    private void addBtn2List(String btnName, int imgResId) {
        HomeBtnBean btn1 = new HomeBtnBean();
        btn1.setBtnName(btnName);
        btn1.setImaResId(imgResId);
        list.add(btn1);
    }
}
