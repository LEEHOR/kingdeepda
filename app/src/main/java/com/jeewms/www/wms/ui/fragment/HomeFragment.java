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

    private ThreadPoolExecutor threadPoolExecutor;
    private MyHandler myHandler = new MyHandler(this);
    //币别数据
    private final int currency_finish = 100;
    //部门
    private final int department_finish = 101;
    //物料
    private final int material_finish = 102;
    //存货类别
    private final int materialCategory_finish = 103;
    //组织
    private final int organization_finish = 104;
    //项目
    private final int project_finish = 105;
    //仓库
    private final int stock_finish = 106;
    //供应商
    private final int supplier_finish = 107;
    //单位
    private final int unit_finish = 108;
    //计数
    private final int COUNT = 109;

    //需要下载基础数据的数量
    private int DownloadCount = 0;
    //已经下载的基础数据数量
    private int HasDownloadCount = 0;
    private Message message;
    private UpdateBaseDataDialog updateDialog;

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
        updateBaseData();
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

    private class MyHandler extends Handler {
        private final WeakReference<HomeFragment> mTarget;

        public MyHandler(HomeFragment fragment) {
            mTarget = new WeakReference<HomeFragment>(fragment);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case currency_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_currency, (boolean) msg.obj);
                    break;
                case department_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_department, (boolean) msg.obj);
                    break;
                case material_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_material, (boolean) msg.obj);
                    break;
                case materialCategory_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_materialCategory, (boolean) msg.obj);
                    break;
                case organization_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_organization, (boolean) msg.obj);
                    break;
                case project_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_project, (boolean) msg.obj);
                    break;
                case stock_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_stock, (boolean) msg.obj);
                    break;
                case supplier_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_supplier, (boolean) msg.obj);
                    break;
                case unit_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_unit, (boolean) msg.obj);
                    break;
                case COUNT:
                    HasDownloadCount++;
                    if (DownloadCount == HasDownloadCount) {
                        updateDialog.Close();
                    }
                    break;
            }
        }
    }

    private void viewLoading() {
        updateDialog = UpdateBaseDataDialog.newInstance("更新基础数据...");
        updateDialog.show(getActivity().getFragmentManager(), "更新");
    }

    //更新基础数据
    private void updateBaseData() {
        // 创建基本线程池
        threadPoolExecutor = new ThreadPoolExecutor(1, 2, 1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(30));
        //  ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        viewLoading();
        boolean booleanKeyValue = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_currency);
        if (!booleanKeyValue) {
            DownloadCount++;
            getBdCurrency();
        }
        boolean booleanKeyValue1 = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_department);
        if (!booleanKeyValue1) {
            DownloadCount++;
            getBdDepartment();

        }
        boolean booleanKeyValue2 = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_material);
        if (!booleanKeyValue2) {
            DownloadCount++;
            getBdMaterial();
        }
        boolean booleanKeyValue3 = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_materialCategory);
        if (!booleanKeyValue3) {
            DownloadCount++;
            getBdMaterialCategory();
        }
        boolean booleanKeyValue4 = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_organization);
        if (!booleanKeyValue4) {
            DownloadCount++;
            getBdOrganization();
        }
        boolean booleanKeyValue5 = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_project);
        if (!booleanKeyValue5) {
            DownloadCount++;
            getBdProject();
        }
        boolean booleanKeyValue6 = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_stock);
        if (!booleanKeyValue6) {
            DownloadCount++;
            getBdStock();
        }
        boolean booleanKeyValue7 = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_supplier);
        if (!booleanKeyValue7) {
            DownloadCount++;
            getBdSupplier();
        }
        boolean booleanKeyValue8 = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_unit);
        if (!booleanKeyValue8) {
            DownloadCount++;
            getBdUnit();
        }
    }

    //请求币别代码
    private void getBdCurrency() {
        String current = Constance.getCurrent();

        HTTPUtils.getInstance(getActivity()).get(getActivity(), current, new VolleyListener<String>() {
            @Override
            public void requestComplete() {
                myHandler.sendEmptyMessage(COUNT);
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                message = new Message();
                message.what = currency_finish;
                message.obj = false;
                myHandler.sendMessage(message);
            }

            @Override
            public void onResponse(String response) {
                CurrencyBean currencyBean = GsonUtils.parseJSON(response, CurrencyBean.class);
                if (currencyBean.getCode() == 0) {
                    final List<BdCurrency> data = currencyBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                boolean save = LitePal.saveAll(data);
                                message = new Message();
                                message.what = currency_finish;
                                message.obj = save;
                                myHandler.sendMessage(message);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        message = new Message();
                        message.what = currency_finish;
                        message.obj = false;
                        myHandler.sendMessage(message);
                    }
                } else {
                    message = new Message();
                    message.what = currency_finish;
                    message.obj = false;
                    myHandler.sendMessage(message);
                }
            }
        });
    }

    //请求部门
    private void getBdDepartment() {
        String department = Constance.getDepartment();
        HTTPUtils.getInstance(getActivity()).get(getActivity(), department, new VolleyListener<String>() {
            @Override
            public void requestComplete() {
                myHandler.sendEmptyMessage(COUNT);
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                message = new Message();
                message.what = department_finish;
                message.obj = false;
                myHandler.sendMessage(message);
            }

            @Override
            public void onResponse(String response) {
                DepartmentBean departmentBean = GsonUtils.parseJSON(response, DepartmentBean.class);
                if (departmentBean.getCode() == 0) {
                    final List<BdDepartment> data = departmentBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                boolean save = LitePal.saveAll(data);
                                message = new Message();
                                message.what = department_finish;
                                message.obj = save;
                                myHandler.sendMessage(message);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        message = new Message();
                        message.what = department_finish;
                        message.obj = false;
                        myHandler.sendMessage(message);
                    }
                } else {
                    message = new Message();
                    message.what = department_finish;
                    message.obj = false;
                    myHandler.sendMessage(message);
                }


            }
        });
    }


    //请求金蝶物料表
    private void getBdMaterial() {
        String materriallist = Constance.getMaterial();
        HTTPUtils.getInstance(getActivity()).get(getActivity(), materriallist, new VolleyListener<String>() {
            @Override
            public void requestComplete() {
                myHandler.sendEmptyMessage(COUNT);
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                message = new Message();
                message.what = material_finish;
                message.obj = false;
                myHandler.sendMessage(message);
            }

            @Override
            public void onResponse(String response) {
                MaterialListBean materialListBean = GsonUtils.parseJSON(response, MaterialListBean.class);
                if (materialListBean.getCode() == 0) {
                    final List<BdMaterial> data = materialListBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                boolean save = LitePal.saveAll(data);
                                message = new Message();
                                message.what = material_finish;
                                message.obj = save;
                                myHandler.sendMessage(message);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        message = new Message();
                        message.what = material_finish;
                        message.obj = false;
                        myHandler.sendMessage(message);
                    }
                } else {
                    message = new Message();
                    message.what = material_finish;
                    message.obj = false;
                    myHandler.sendMessage(message);
                }
            }
        });
    }

    //请求存货类别
    private void getBdMaterialCategory() {
        String materialcategory = Constance.getMaterialcategory();
        HTTPUtils.getInstance(getActivity()).get(getActivity(), materialcategory, new VolleyListener<String>() {
            @Override
            public void requestComplete() {
                myHandler.sendEmptyMessage(COUNT);
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                message = new Message();
                message.what = materialCategory_finish;
                message.obj = false;
                myHandler.sendMessage(message);
            }

            @Override
            public void onResponse(String response) {
                MaterialCategoryBean materialCategoryBean = GsonUtils.parseJSON(response, MaterialCategoryBean.class);
                if (materialCategoryBean.getCode() == 0) {
                    final List<BdMaterialcategory> data = materialCategoryBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                boolean save = LitePal.saveAll(data);
                                message = new Message();
                                message.what = materialCategory_finish;
                                message.obj = save;
                                myHandler.sendMessage(message);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        message = new Message();
                        message.what = materialCategory_finish;
                        message.obj = false;
                        myHandler.sendMessage(message);
                    }
                } else {
                    message = new Message();
                    message.what = materialCategory_finish;
                    message.obj = false;
                    myHandler.sendMessage(message);
                }


            }
        });
    }

    //请求组织机构类别
    private void getBdOrganization() {
        final String organization = Constance.getOrganization();
        HTTPUtils.getInstance(getActivity()).get(getActivity(), organization, new VolleyListener<String>() {
            @Override
            public void requestComplete() {
                myHandler.sendEmptyMessage(COUNT);
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                message = new Message();
                message.what = organization_finish;
                message.obj = false;
                myHandler.sendMessage(message);
            }

            @Override
            public void onResponse(String response) {
                OrganizationsBean organizationsBean = GsonUtils.parseJSON(response, OrganizationsBean.class);
                if (organizationsBean.getCode() == 0) {
                    final List<BdOrganizations> data = organizationsBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                boolean save = LitePal.saveAll(data);
                                message = new Message();
                                message.what = organization_finish;
                                message.obj = save;
                                myHandler.sendMessage(message);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        message = new Message();
                        message.what = organization_finish;
                        message.obj = false;
                        myHandler.sendMessage(message);
                    }
                } else {
                    message = new Message();
                    message.what = organization_finish;
                    message.obj = false;
                    myHandler.sendMessage(message);
                }
            }
        });
    }

    //请求项目
    private void getBdProject() {
        String projectlist = Constance.getProjectlist();
        HTTPUtils.getInstance(getActivity()).get(getActivity(), projectlist, new VolleyListener<String>() {
            @Override
            public void requestComplete() {
                myHandler.sendEmptyMessage(COUNT);
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                message = new Message();
                message.what = project_finish;
                message.obj = false;
                myHandler.sendMessage(message);
            }

            @Override
            public void onResponse(String response) {
                ProjectListBean projectListBean = GsonUtils.parseJSON(response, ProjectListBean.class);
                if (projectListBean.getCode() == 0) {
                    final List<BdProject> data = projectListBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                boolean save = LitePal.saveAll(data);
                                message = new Message();
                                message.what = project_finish;
                                message.obj = save;
                                myHandler.sendMessage(message);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        message = new Message();
                        message.what = project_finish;
                        message.obj = false;
                        myHandler.sendMessage(message);
                    }
                } else {
                    message = new Message();
                    message.what = project_finish;
                    message.obj = false;
                    myHandler.sendMessage(message);
                }

            }
        });
    }

    //请求仓库
    private void getBdStock() {
        String stockList = Constance.getStockList();
        HTTPUtils.getInstance(getActivity()).get(getActivity(), stockList, new VolleyListener<String>() {
            @Override
            public void requestComplete() {
                myHandler.sendEmptyMessage(COUNT);
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                message = new Message();
                message.what = stock_finish;
                message.obj = false;
                myHandler.sendMessage(message);
            }

            @Override
            public void onResponse(String response) {
                StockBean stockBean = GsonUtils.parseJSON(response, StockBean.class);
                if (stockBean.getCode() == 0) {
                    final List<BdStock> data = stockBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                boolean save = LitePal.saveAll(data);
                                message = new Message();
                                message.what = stock_finish;
                                message.obj = save;
                                myHandler.sendMessage(message);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        message = new Message();
                        message.what = stock_finish;
                        message.obj = false;
                        myHandler.sendMessage(message);
                    }
                } else {
                    message = new Message();
                    message.what = stock_finish;
                    message.obj = false;
                    myHandler.sendMessage(message);
                }
            }
        });
    }

    //请求供应商
    private void getBdSupplier() {
        String supplier = Constance.getSupplier();
        HTTPUtils.getInstance(getActivity()).get(getActivity(), supplier, new VolleyListener<String>() {
            @Override
            public void requestComplete() {
                myHandler.sendEmptyMessage(COUNT);
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                message = new Message();
                message.what = supplier_finish;
                message.obj = false;
                myHandler.sendMessage(message);
            }

            @Override
            public void onResponse(String response) {
                SupplierBean supplierBean = GsonUtils.parseJSON(response, SupplierBean.class);
                if (supplierBean.getCode() == 0) {
                    final List<BdSupplier> data = supplierBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                boolean save = LitePal.saveAll(data);
                                message = new Message();
                                message.what = supplier_finish;
                                message.obj = save;
                                myHandler.sendMessage(message);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        message = new Message();
                        message.what = supplier_finish;
                        message.obj = false;
                        myHandler.sendMessage(message);
                    }
                } else {
                    message = new Message();
                    message.what = supplier_finish;
                    message.obj = false;
                    myHandler.sendMessage(message);
                }


            }
        });
    }


    //请求计量单位代码
    private void getBdUnit() {
        String unit = Constance.getUnit();
        HTTPUtils.getInstance(getActivity()).get(getActivity(), unit, new VolleyListener<String>() {
            @Override
            public void requestComplete() {
                myHandler.sendEmptyMessage(COUNT);
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                message = new Message();
                message.what = unit_finish;
                message.obj = false;
                myHandler.sendMessage(message);
            }

            @Override
            public void onResponse(String response) {
                UnitBean unitBean = GsonUtils.parseJSON(response, UnitBean.class);
                if (unitBean.getCode() == 0) {
                    final List<BdUnit> data = unitBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                boolean save = LitePal.saveAll(data);
                                message = new Message();
                                message.what = unit_finish;
                                message.obj = save;
                                myHandler.sendMessage(message);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        message = new Message();
                        message.what = unit_finish;
                        message.obj = false;
                        myHandler.sendMessage(message);
                    }
                } else {
                    message = new Message();
                    message.what = unit_finish;
                    message.obj = false;
                    myHandler.sendMessage(message);
                }


            }
        });
    }
}
