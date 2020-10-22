package com.jeewms.www.wms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.GridView;

import com.jeewms.www.wms.base.BaseActivity;
import com.jeewms.www.wms.bean.HomeBtnBean;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.adapter.HomeGridAdapter;
import com.jeewms.www.wms.util.SharedPreferencesUtil;

import java.util.ArrayList;

/**
 * Created by 13799 on 2018/7/2.
 */

public class HomeActivity extends BaseActivity {

    HomeGridAdapter adapter;
    GridView gvHome;
    ArrayList<HomeBtnBean> list = new ArrayList<>();

    public static void show(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        init();
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
        adapter = new HomeGridAdapter();
        gvHome =findViewById(R.id.gv_home);
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
