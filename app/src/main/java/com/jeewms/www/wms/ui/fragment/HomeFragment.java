package com.jeewms.www.wms.ui.fragment;

import android.os.Handler;
import android.os.Message;
import android.widget.GridView;

import com.android.volley.VolleyError;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseFragment;
import com.jeewms.www.wms.bean.CurrencyBean;
import com.jeewms.www.wms.bean.DepartmentBean;
import com.jeewms.www.wms.bean.HomeBtnBean;
import com.jeewms.www.wms.bean.MaterialCategoryBean;
import com.jeewms.www.wms.bean.MaterialListBean;
import com.jeewms.www.wms.bean.OrganizationsBean;
import com.jeewms.www.wms.bean.ProjectListBean;
import com.jeewms.www.wms.bean.StockBean;
import com.jeewms.www.wms.bean.SupplierBean;
import com.jeewms.www.wms.bean.UnitBean;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.constance.Shared;
import com.jeewms.www.wms.dataBase.BdCurrency;
import com.jeewms.www.wms.dataBase.BdDepartment;
import com.jeewms.www.wms.dataBase.BdMaterial;
import com.jeewms.www.wms.dataBase.BdMaterialcategory;
import com.jeewms.www.wms.dataBase.BdOrganizations;
import com.jeewms.www.wms.dataBase.BdProject;
import com.jeewms.www.wms.dataBase.BdStock;
import com.jeewms.www.wms.dataBase.BdSupplier;
import com.jeewms.www.wms.dataBase.BdUnit;
import com.jeewms.www.wms.ui.adapter.HomeGridAdapter1;
import com.jeewms.www.wms.ui.dialog.UpdateBaseDataDialog;
import com.jeewms.www.wms.ui.view.NonScrollGridView;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import org.litepal.LitePal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.Unbinder;


/**
 * 首页
 */

public class HomeFragment extends BaseFragment {

    HomeGridAdapter1 adapter1;
    HomeGridAdapter1 adapter2;
    HomeGridAdapter1 adapter3;
    HomeGridAdapter1 adapter4;
    HomeGridAdapter1 adapter5;
    ArrayList<HomeBtnBean> gvHome1List = new ArrayList<>();
    ArrayList<HomeBtnBean> gvHome2List = new ArrayList<>();
    ArrayList<HomeBtnBean> gvHome3List = new ArrayList<>();
    ArrayList<HomeBtnBean> gvHome4List = new ArrayList<>();
    ArrayList<HomeBtnBean> gvHome5List = new ArrayList<>();
    @BindView(R.id.gv_home1)
    GridView gvHome1;
    @BindView(R.id.gv_home2)
    GridView gvHome2;
    @BindView(R.id.gv_home3)
    GridView gvHome3;
    @BindView(R.id.gv_home4)
    NonScrollGridView gvHome4;
    @BindView(R.id.gv_home5)
    NonScrollGridView gvHome5;
    Unbinder unbinder;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        adapter1 = new HomeGridAdapter1();
        adapter2 = new HomeGridAdapter1();
        adapter3 = new HomeGridAdapter1();
        adapter4 = new HomeGridAdapter1();
        adapter5 = new HomeGridAdapter1();
        gvHome1.setAdapter(adapter1);
        gvHome2.setAdapter(adapter2);
        gvHome3.setAdapter(adapter3);
        gvHome4.setAdapter(adapter4);
        gvHome5.setAdapter(adapter5);
    }

    @Override
    protected void initFunc() {
        addBtn1();
        addBtn2();
        addBtn3();
        addBtn4();
        addBtn5();
        updateBaseData(1);
    }

    //添加1
    private void addBtn1() {
        gvHome1List.clear();
        for (int i = 0; i < Constance.home1.length; i++) {
            addBtn1List(Constance.tv_home1[i], Constance.home1[i]);
        }
        adapter1.setList(gvHome1List,1);
        adapter1.notifyDataSetChanged();
    }

    private void addBtn1List(String btnName, int imgResId) {
        HomeBtnBean btn1 = new HomeBtnBean();
        btn1.setBtnName(btnName);
        btn1.setImaResId(imgResId);
        gvHome1List.add(btn1);
    }

    //添加2
    private void addBtn2() {
        gvHome2List.clear();
        for (int i = 0; i < Constance.home2.length; i++) {
            addBtn2List(Constance.tv_home2[i], Constance.home2[i]);
        }
        adapter2.setList(gvHome2List,2);
        adapter2.notifyDataSetChanged();
    }

    private void addBtn2List(String btnName, int imgResId) {
        HomeBtnBean btn1 = new HomeBtnBean();
        btn1.setBtnName(btnName);
        btn1.setImaResId(imgResId);
        gvHome2List.add(btn1);
    }

    //添加3
    private void addBtn3() {
        gvHome3List.clear();
        for (int i = 0; i < Constance.home3.length; i++) {
            addBtn3List(Constance.tv_home3[i], Constance.home3[i]);
        }
        adapter3.setList(gvHome3List,3);
        adapter3.notifyDataSetChanged();
    }

    private void addBtn3List(String btnName, int imgResId) {
        HomeBtnBean btn1 = new HomeBtnBean();
        btn1.setBtnName(btnName);
        btn1.setImaResId(imgResId);
        gvHome3List.add(btn1);
    }

    //添加4
    private void addBtn4() {
        gvHome4List.clear();
        for (int i = 0; i < Constance.home4.length; i++) {
            addBtn4List(Constance.tv_home4[i], Constance.home4[i]);
        }
        adapter4.setList(gvHome4List,4);
        adapter4.notifyDataSetChanged();
    }

    private void addBtn4List(String btnName, int imgResId) {
        HomeBtnBean btn1 = new HomeBtnBean();
        btn1.setBtnName(btnName);
        btn1.setImaResId(imgResId);
        gvHome4List.add(btn1);
    }

    //添加4
    private void addBtn5() {
        gvHome5List.clear();
        for (int i = 0; i < Constance.home5.length; i++) {
            addBtn5List(Constance.tv_home5[i], Constance.home5[i]);
        }
        adapter5.setList(gvHome5List,5);
        adapter5.notifyDataSetChanged();
    }

    private void addBtn5List(String btnName, int imgResId) {
        HomeBtnBean btn1 = new HomeBtnBean();
        btn1.setBtnName(btnName);
        btn1.setImaResId(imgResId);
        gvHome5List.add(btn1);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
