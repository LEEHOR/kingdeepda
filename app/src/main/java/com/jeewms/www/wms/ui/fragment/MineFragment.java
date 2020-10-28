package com.jeewms.www.wms.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jeewms.www.wms.LoginActivity;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseFragment;
import com.jeewms.www.wms.bean.CurrencyBean;
import com.jeewms.www.wms.bean.DepartmentBean;
import com.jeewms.www.wms.bean.MaterialCategoryBean;
import com.jeewms.www.wms.bean.MaterialListBean;
import com.jeewms.www.wms.bean.NewVersionBean;
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
import com.jeewms.www.wms.dataBase.BdSecUser;
import com.jeewms.www.wms.dataBase.BdStock;
import com.jeewms.www.wms.dataBase.BdSupplier;
import com.jeewms.www.wms.dataBase.BdUnit;
import com.jeewms.www.wms.ui.activity.mine.ChangePass;
import com.jeewms.www.wms.ui.activity.mine.ServerAddressConfigActivity;
import com.jeewms.www.wms.ui.activity.mine.SettingDefaultOrganActivity;
import com.jeewms.www.wms.ui.dialog.UpdateBaseDataDialog;
import com.jeewms.www.wms.ui.dialog.UpdateDialog;
import com.jeewms.www.wms.ui.view.CircleImageView;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.Logutil;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.ToastUtil;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import org.litepal.LitePal;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.fragment1
 * @ClassName: MineFragment
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/9 9:27
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/9 9:27
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MineFragment extends BaseFragment {
    @BindView(R.id.mine_head_portrait)
    CircleImageView mineHeadPortrait;
    @BindView(R.id.userID)
    TextView userID;
    @BindView(R.id.userAccount)
    TextView userAccount;
    @BindView(R.id.re_app_update)
    RelativeLayout reAppUpdate;
    @BindView(R.id.re_change_pass)
    RelativeLayout reChangePass;
    @BindView(R.id.re_default_option)
    RelativeLayout reDefaultOption;
    @BindView(R.id.re_server_option)
    RelativeLayout reServerOption;
    @BindView(R.id.re_sign_out)
    RelativeLayout reSignOut;
    @BindView(R.id.re_update_base)
    RelativeLayout reUpdateBase;
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
    //需要下载基础数据的数量
    private int DownloadCount = 0;
    private UpdateBaseDataDialog updateDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        String user_account = SharedPreferencesUtil.getInstance(getActivity()).getKeyValue(Shared.userAccount);
        String user_phone = SharedPreferencesUtil.getInstance(getActivity()).getKeyValue(Shared.userPhone);
        userAccount.setText(user_account);
        userID.setText(user_phone);
    }

    @Override
    protected void initFunc() {

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            String user_account = SharedPreferencesUtil.getInstance(getActivity()).getKeyValue(Shared.userAccount);
            String user_phone = SharedPreferencesUtil.getInstance(getActivity()).getKeyValue(Shared.userPhone);
            userAccount.setText(user_account);
            userID.setText(user_phone);
        }
    }

    /**
     * 清除用户信息
     */
    private void removeUerInfo() {
        SharedPreferencesUtil.getInstance(getActivity()).remove(Shared.PASSWORD);
        SharedPreferencesUtil.getInstance(getActivity()).remove(Shared.userAccount);
        SharedPreferencesUtil.getInstance(getActivity()).remove(Shared.userPhone);
        SharedPreferencesUtil.getInstance(getActivity()).remove(Shared.TOKEN);
        SharedPreferencesUtil.getInstance(getActivity()).remove(Shared.userID);
        LoginActivity.show(getActivity());
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()).setIcon(R.mipmap.icon).setTitle(getResources().getString(R.string.mine_dialog_title))
                .setMessage(getResources().getString(R.string.mine_dialog_msg)).setPositiveButton(getResources().getString(R.string.mine_dialog_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        removeUerInfo();
                    }
                }).setNegativeButton(getResources().getString(R.string.mine_dialog_cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });
        builder.create().show();
    }

    @OnClick({R.id.re_app_update, R.id.re_change_pass, R.id.re_default_option, R.id.re_server_option, R.id.re_sign_out, R.id.re_update_base})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.re_app_update:
                checkVersion();
                break;
            case R.id.re_change_pass:
                Intent intent = new Intent(this.getActivity(), ChangePass.class);
                getActivity().startActivity(intent);
                break;
            case R.id.re_default_option:
                SettingDefaultOrganActivity.show(getActivity());
                break;
            case R.id.re_server_option:
                Intent intent1 = new Intent(this.getActivity(), ServerAddressConfigActivity.class);
                getActivity().startActivity(intent1);
                break;
            case R.id.re_sign_out:
                showDialog();
                break;
            case R.id.re_update_base:
                DownloadCount = 0;
                updateBaseData();
                break;
        }
    }

    /**
     * 检查新版本
     */
    private void checkVersion() {
        Map<String, String> params = new HashMap<>();
        String newVersionUrl = Constance.getNewVersion();
        HTTPUtils.getInstance(getActivity()).post(newVersionUrl, params, new VolleyListener<String>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtil.show(getActivity(), error.getMessage());
            }

            @Override
            public void onResponse(String response) {
                NewVersionBean vm = GsonUtils.parseJSON(response, NewVersionBean.class);
                if (vm.getCode() == 0) {
                    DialogVersion(vm.getVersion(), vm.getFocusUpdate(), vm.getRemark(), vm.getUrl());
                } else {
                    ToastUtil.show(getActivity(), vm.getMsg());
                }
            }
        });
    }

    private void DialogVersion(String versionName, int isForceUpdate, String remark, final String durl) {
        final UpdateDialog updateDialog = UpdateDialog.newInstance(versionName, isForceUpdate, remark);
        updateDialog.setOnUpdateListener(new UpdateDialog.OnUpdateListener() {
            @Override
            public void onConfirm() {
                if (durl == null) {
                    updateDialog.dismiss();
                }
            }
        });
        updateDialog.show(getActivity().getFragmentManager(), "update");
    }

    private class MyHandler extends Handler {
        private final WeakReference<MineFragment> mTarget;

        public MyHandler(MineFragment fragment) {
            mTarget = new WeakReference<MineFragment>(fragment);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case currency_finish:
                case department_finish:
                case material_finish:
                case materialCategory_finish:
                case organization_finish:
                case project_finish:
                case stock_finish:
                case supplier_finish:
                case unit_finish:
                    DownloadCount++;
                    if (DownloadCount == 9) {
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
        viewLoading();
        getBdCurrency();
        getBdDepartment();
        getBdMaterial();
        getBdMaterialCategory();
        getBdOrganization();
        getBdProject();
        getBdStock();
        getBdSupplier();
        getBdUnit();
    }

    //请求币别代码
    private void getBdCurrency() {
        String current = Constance.getCurrent();
        HTTPUtils.getInstance(getActivity()).get(current, new VolleyListener<String>() {
            @Override
            public void requestComplete() {
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                myHandler.sendEmptyMessage(currency_finish);
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
                                LitePal.deleteAll(BdCurrency.class);
                                LitePal.saveAll(data);
                                myHandler.sendEmptyMessage(currency_finish);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        myHandler.sendEmptyMessage(currency_finish);
                    }
                } else {
                    myHandler.sendEmptyMessage(currency_finish);
                }
            }
        });
    }

    //请求部门
    private void getBdDepartment() {
        String department = Constance.getDepartment();
        HTTPUtils.getInstance(getActivity()).get(department, new VolleyListener<String>() {
            @Override
            public void requestComplete() {
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                myHandler.sendEmptyMessage(department_finish);
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
                                LitePal.deleteAll(BdDepartment.class);
                                LitePal.saveAll(data);
                                myHandler.sendEmptyMessage(department_finish);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        myHandler.sendEmptyMessage(department_finish);
                    }
                } else {
                    myHandler.sendEmptyMessage(department_finish);
                }
            }
        });
    }


    //请求金蝶物料表
    private void getBdMaterial() {
        String materriallist = Constance.getMaterial();
        HTTPUtils.getInstance(getActivity()).get(materriallist, new VolleyListener<String>() {
            @Override
            public void requestComplete() {
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                myHandler.sendEmptyMessage(material_finish);
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
                                LitePal.deleteAll(BdMaterial.class);
                                LitePal.saveAll(data);
                                myHandler.sendEmptyMessage(material_finish);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        myHandler.sendEmptyMessage(material_finish);
                    }
                } else {
                    myHandler.sendEmptyMessage(material_finish);
                }
            }
        });
    }

    //请求存货类别
    private void getBdMaterialCategory() {
        String materialcategory = Constance.getMaterialcategory();
        HTTPUtils.getInstance(getActivity()).get(materialcategory, new VolleyListener<String>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                myHandler.sendEmptyMessage(materialCategory_finish);
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
                                LitePal.deleteAll(BdMaterialcategory.class);
                                LitePal.saveAll(data);
                                myHandler.sendEmptyMessage(materialCategory_finish);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        myHandler.sendEmptyMessage(materialCategory_finish);
                    }
                } else {
                    myHandler.sendEmptyMessage(materialCategory_finish);
                }


            }
        });
    }

    //请求组织机构类别
    private void getBdOrganization() {
        final String organization = Constance.getOrganization();
        HTTPUtils.getInstance(getActivity()).get(organization, new VolleyListener<String>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                myHandler.sendEmptyMessage(organization_finish);
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
                                LitePal.deleteAll(BdOrganizations.class);
                                LitePal.saveAll(data);
                                myHandler.sendEmptyMessage(organization_finish);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        myHandler.sendEmptyMessage(organization_finish);
                    }
                } else {
                    myHandler.sendEmptyMessage(organization_finish);
                }
            }
        });
    }

    //请求项目
    private void getBdProject() {
        String projectlist = Constance.getProjectlist();
        HTTPUtils.getInstance(getActivity()).get(projectlist, new VolleyListener<String>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                myHandler.sendEmptyMessage(project_finish);
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
                                LitePal.deleteAll(BdProject.class);
                                LitePal.saveAll(data);
                                myHandler.sendEmptyMessage(project_finish);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        myHandler.sendEmptyMessage(project_finish);
                    }
                } else {
                    myHandler.sendEmptyMessage(project_finish);
                }
            }
        });
    }

    //请求仓库
    private void getBdStock() {
        String stockList = Constance.getStockList();
        HTTPUtils.getInstance(getActivity()).get(stockList, new VolleyListener<String>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                myHandler.sendEmptyMessage(stock_finish);
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
                                LitePal.deleteAll(BdStock.class);
                                LitePal.saveAll(data);
                                myHandler.sendEmptyMessage(stock_finish);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        myHandler.sendEmptyMessage(stock_finish);
                    }
                } else {
                    myHandler.sendEmptyMessage(stock_finish);
                }
            }
        });
    }

    //请求供应商
    private void getBdSupplier() {
        String supplier = Constance.getSupplier();
        HTTPUtils.getInstance(getActivity()).get(supplier, new VolleyListener<String>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                myHandler.sendEmptyMessage(supplier_finish);
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
                                LitePal.deleteAll(BdSupplier.class);
                                LitePal.saveAll(data);
                                myHandler.sendEmptyMessage(supplier_finish);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        myHandler.sendEmptyMessage(supplier_finish);
                    }
                } else {
                    myHandler.sendEmptyMessage(supplier_finish);
                }
            }
        });
    }


    //请求计量单位代码
    private void getBdUnit() {
        String unit = Constance.getUnit();
        HTTPUtils.getInstance(getActivity()).get(unit, new VolleyListener<String>() {
            @Override
            public void requestComplete() {

            }

            @Override
            public void onErrorResponse(VolleyError error) {
                myHandler.sendEmptyMessage(unit_finish);
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
                                LitePal.deleteAll(BdUnit.class);
                                LitePal.saveAll(data);
                                myHandler.sendEmptyMessage(unit_finish);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        myHandler.sendEmptyMessage(unit_finish);
                    }
                } else {
                    myHandler.sendEmptyMessage(unit_finish);
                }
            }
        });
    }

}
