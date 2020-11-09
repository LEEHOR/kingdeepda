package com.kingdee.ah.pda.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;
import com.kingdee.ah.pda.App;
import com.kingdee.ah.pda.LoginActivity;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.bean.CurrencyBean;
import com.kingdee.ah.pda.bean.DepartmentBean;
import com.kingdee.ah.pda.bean.MaterialCategoryBean;
import com.kingdee.ah.pda.bean.MaterialListBean;
import com.kingdee.ah.pda.bean.OrganizationsBean;
import com.kingdee.ah.pda.bean.ProjectListBean;
import com.kingdee.ah.pda.bean.StockBean;
import com.kingdee.ah.pda.bean.SupplierBean;
import com.kingdee.ah.pda.bean.UnitBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.constance.Shared;
import com.kingdee.ah.pda.dataBase.BdCurrency;
import com.kingdee.ah.pda.dataBase.BdDepartment;
import com.kingdee.ah.pda.dataBase.BdMaterial;
import com.kingdee.ah.pda.dataBase.BdMaterialcategory;
import com.kingdee.ah.pda.dataBase.BdOrganizations;
import com.kingdee.ah.pda.dataBase.BdProject;
import com.kingdee.ah.pda.dataBase.BdStock;
import com.kingdee.ah.pda.dataBase.BdSupplier;
import com.kingdee.ah.pda.dataBase.BdUnit;
import com.kingdee.ah.pda.ui.dialog.UpdateBaseDataDialog;
import com.kingdee.ah.pda.util.GsonUtils;
import com.kingdee.ah.pda.util.SharedPreferencesUtil;
import com.kingdee.ah.pda.util.ToastUtil;
import com.kingdee.ah.pda.volley.MyHandler;
import com.kingdee.ah.pda.volley.NetworkUtil;
import com.kingdee.ah.pda.volley.VolleyListener;

import org.litepal.LitePal;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.base
 * @ClassName: BaseFragment1
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/9/28 11:30
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/9/28 11:30
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public abstract class BaseFragment extends Fragment {

    private View mRootView;
    private Unbinder bind;
    private AlertDialog.Builder builder;

    protected abstract int getLayoutId();

    protected abstract void initView();

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
    //下载的数量
    private int hasDownload = 0;
    private Message messages;
    private UpdateBaseDataDialog updateDialog;

    /*** 初始化数据以及其他请求操作 ***/
    protected abstract void initFunc();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflaterView(inflater, container);
        bind = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
        initFunc();
    }

    /**
     * 设置View
     *
     * @param inflater
     * @param container
     */
    private void inflaterView(LayoutInflater inflater, @Nullable ViewGroup container) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), container, false);
        }
    }

    private void LoginDialog(final Context context, String msg) {
        builder = new AlertDialog.Builder(context).setIcon(R.mipmap.ic_launcher).setTitle("提示")
                .setMessage(msg).setPositiveButton("重新登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        LoginActivity.show(context);
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
    }

    public AlertDialog CreateDialog(Context context, String msg) {
        if (builder == null) {
            LoginDialog(context, msg);
        }
        return builder.create();
    }

    private class MyHandler extends Handler {
        private final WeakReference<BaseFragment> mTarget;

        public MyHandler(BaseFragment fragment) {
            mTarget = new WeakReference<BaseFragment>(fragment);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case currency_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_currency, (boolean) msg.obj);
                    closeDialog("币别", (boolean) msg.obj);
                    break;
                case department_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_department, (boolean) msg.obj);
                    closeDialog("部门", (boolean) msg.obj);
                    break;
                case material_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_material, (boolean) msg.obj);
                    closeDialog("物料", (boolean) msg.obj);
                    break;
                case materialCategory_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_materialCategory, (boolean) msg.obj);
                    closeDialog("存货类别", (boolean) msg.obj);
                    break;
                case organization_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_organization, (boolean) msg.obj);
                    closeDialog("组织机构", (boolean) msg.obj);
                    break;
                case project_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_project, (boolean) msg.obj);
                    closeDialog("项目", (boolean) msg.obj);
                    break;
                case stock_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_stock, (boolean) msg.obj);
                    closeDialog("仓库", (boolean) msg.obj);
                    break;
                case supplier_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_supplier, (boolean) msg.obj);
                    closeDialog("供应商", (boolean) msg.obj);
                    break;
                case unit_finish:
                    SharedPreferencesUtil.getInstance(getActivity()).setKeyValue(Shared.key_unit, (boolean) msg.obj);
                    closeDialog("单位表", (boolean) msg.obj);
                    break;
            }
        }
    }

    private void viewLoading() {
        updateDialog = UpdateBaseDataDialog.newInstance("更新基础数据...");
        updateDialog.show(getChildFragmentManager(), "更新");
    }

    //更新基础数据
    public void updateBaseData(int type) {

        // 创建基本线程池
        threadPoolExecutor = new ThreadPoolExecutor(1, 2, 1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(30));
        //  ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        viewLoading();
        if (type == 1) {
            DownloadCount = 0;
            hasDownload = 0;
            startUpdateHome();
        } else {
            DownloadCount = 9;
            hasDownload = 0;
            startUpdateMine();
        }
    }

    private void startUpdateHome() {
        boolean booleanKeyValue = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_currency);
        if (!booleanKeyValue) {
            DownloadCount++;
            getBdCurrency(1);
        }
        boolean booleanKeyValue1 = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_department);
        if (!booleanKeyValue1) {
            DownloadCount++;
            getBdDepartment(1);

        }
        boolean booleanKeyValue2 = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_material);
        if (!booleanKeyValue2) {
            DownloadCount++;
            getBdMaterial(1);
        }
        boolean booleanKeyValue3 = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_materialCategory);
        if (!booleanKeyValue3) {
            DownloadCount++;
            getBdMaterialCategory(1);
        }
        boolean booleanKeyValue4 = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_organization);
        if (!booleanKeyValue4) {
            DownloadCount++;
            getBdOrganization(1);
        }
        boolean booleanKeyValue5 = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_project);
        if (!booleanKeyValue5) {
            DownloadCount++;
            getBdProject(1);
        }
        boolean booleanKeyValue6 = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_stock);
        if (!booleanKeyValue6) {
            DownloadCount++;
            getBdStock(1);
        }
        boolean booleanKeyValue7 = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_supplier);
        if (!booleanKeyValue7) {
            DownloadCount++;
            getBdSupplier(1);
        }
        boolean booleanKeyValue8 = SharedPreferencesUtil.getInstance(getActivity()).getBooleanKeyValue(Shared.key_unit);
        if (!booleanKeyValue8) {
            DownloadCount++;
            getBdUnit(1);
        }
        if (DownloadCount == 0) {
            updateDialog.Close();
        }
    }

    private void startUpdateMine() {
        getBdCurrency(2);
        getBdDepartment(2);
        getBdMaterial(2);
        getBdMaterialCategory(2);
        getBdOrganization(2);
        getBdProject(2);
        getBdStock(2);
        getBdSupplier(2);
        getBdUnit(2);
    }

    //请求币别代码
    private void getBdCurrency(final int type) {
        String current = Constance.getCurrent();
        NetworkUtil.getInstance().get(getActivity(), current, 0, new com.kingdee.ah.pda.volley.MyHandler(new com.kingdee.ah.pda.volley.MyHandler.OnReceiveMessageListener() {
            @Override
            public void Success(Message message) {
                String response = (String) message.obj;
                CurrencyBean currencyBean = GsonUtils.parseJSON(response, CurrencyBean.class);
                int code = currencyBean.getCode();
                if (code == 0) {
                    final List<BdCurrency> data = currencyBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                if (type == 2) {
                                    LitePal.deleteAll(BdCurrency.class);
                                }
                                boolean save = LitePal.saveAll(data);
                                messages = new Message();
                                messages.what = currency_finish;
                                messages.obj = save;
                                myHandler.sendMessage(messages);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        messages = new Message();
                        messages.what = currency_finish;
                        messages.obj = false;
                        myHandler.sendMessage(messages);
                    }
                } else {
                    messages = new Message();
                    messages.what = currency_finish;
                    messages.obj = false;
                    myHandler.sendMessage(messages);
                }
            }

            @Override
            public void Failure(int arg) {
                messages = new Message();
                messages.what = currency_finish;
                messages.obj = false;
                myHandler.sendMessage(messages);
            }

            @Override
            public void Complete(int arg) {

            }
        }));
    }

    //请求部门
    private void getBdDepartment(final int type) {
        String department = Constance.getDepartment();
        NetworkUtil.getInstance().get(getActivity(), department, 1, new com.kingdee.ah.pda.volley.MyHandler(new com.kingdee.ah.pda.volley.MyHandler.OnReceiveMessageListener() {
            @Override
            public void Success(Message message) {
                String response = (String) message.obj;
                DepartmentBean departmentBean = GsonUtils.parseJSON(response, DepartmentBean.class);
                if (departmentBean.getCode() == 0) {
                    final List<BdDepartment> data = departmentBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                if (type == 2) {
                                    LitePal.deleteAll(BdDepartment.class);
                                }
                                boolean save = LitePal.saveAll(data);
                                messages = new Message();
                                messages.what = department_finish;
                                messages.obj = save;
                                myHandler.sendMessage(messages);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        messages = new Message();
                        messages.what = department_finish;
                        messages.obj = false;
                        myHandler.sendMessage(messages);
                    }
                } else {
                    messages = new Message();
                    messages.what = department_finish;
                    messages.obj = false;
                    myHandler.sendMessage(messages);
                }
            }

            @Override
            public void Failure(int arg) {
                messages = new Message();
                messages.what = department_finish;
                messages.obj = false;
                myHandler.sendMessage(messages);
            }

            @Override
            public void Complete(int arg) {

            }
        }));
    }

    //请求金蝶物料表
    private void getBdMaterial(final int type) {
        String materriallist = Constance.getMaterial();
        NetworkUtil.getInstance().get(getActivity(), materriallist, 2, new com.kingdee.ah.pda.volley.MyHandler(new com.kingdee.ah.pda.volley.MyHandler.OnReceiveMessageListener() {
            @Override
            public void Success(Message message) {
                String response = (String) message.obj;
                MaterialListBean materialListBean = GsonUtils.parseJSON(response, MaterialListBean.class);
                if (materialListBean.getCode() == 0) {
                    final List<BdMaterial> data = materialListBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                if (type == 2) {
                                    LitePal.deleteAll(BdMaterial.class);
                                }
                                boolean save = LitePal.saveAll(data);
                                messages = new Message();
                                messages.what = material_finish;
                                messages.obj = save;
                                myHandler.sendMessage(messages);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        messages = new Message();
                        messages.what = material_finish;
                        messages.obj = false;
                        myHandler.sendMessage(messages);
                    }
                } else {
                    messages = new Message();
                    messages.what = material_finish;
                    messages.obj = false;
                    myHandler.sendMessage(messages);
                }
            }

            @Override
            public void Failure(int arg) {
                messages = new Message();
                messages.what = material_finish;
                messages.obj = false;
                myHandler.sendMessage(messages);
            }

            @Override
            public void Complete(int arg) {

            }
        }));
    }


    //请求存货类别
    private void getBdMaterialCategory(final int type) {
        final String materialcategory = Constance.getMaterialcategory();
        NetworkUtil.getInstance().get(getActivity(), materialcategory, 3, new com.kingdee.ah.pda.volley.MyHandler( new com.kingdee.ah.pda.volley.MyHandler.OnReceiveMessageListener() {
            @Override
            public void Success(Message message) {
                String response = (String) message.obj;
                MaterialCategoryBean materialCategoryBean = GsonUtils.parseJSON(response, MaterialCategoryBean.class);
                if (materialCategoryBean.getCode() == 0) {
                    final List<BdMaterialcategory> data = materialCategoryBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                if (type == 2) {
                                    LitePal.deleteAll(BdMaterialcategory.class);
                                }
                                boolean save = LitePal.saveAll(data);
                                messages = new Message();
                                messages.what = materialCategory_finish;
                                messages.obj = save;
                                myHandler.sendMessage(messages);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        messages = new Message();
                        messages.what = materialCategory_finish;
                        messages.obj = false;
                        myHandler.sendMessage(messages);
                    }
                } else {
                    messages = new Message();
                    messages.what = materialCategory_finish;
                    messages.obj = false;
                    myHandler.sendMessage(messages);
                }
            }

            @Override
            public void Failure(int arg) {
                messages = new Message();
                messages.what = materialCategory_finish;
                messages.obj = false;
                myHandler.sendMessage(messages);
            }

            @Override
            public void Complete(int arg) {

            }
        }));
    }

    //请求组织机构类别
    private void getBdOrganization(final int type) {
        final String organization = Constance.getOrganization();
        NetworkUtil.getInstance().get(getActivity(), organization, 4, new com.kingdee.ah.pda.volley.MyHandler( new com.kingdee.ah.pda.volley.MyHandler.OnReceiveMessageListener() {
            @Override
            public void Success(Message message) {
                String response = (String) message.obj;
                OrganizationsBean organizationsBean = GsonUtils.parseJSON(response, OrganizationsBean.class);
                if (organizationsBean.getCode() == 0) {
                    final List<BdOrganizations> data = organizationsBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                if (type == 2) {
                                    LitePal.deleteAll(BdOrganizations.class);
                                }
                                boolean save = LitePal.saveAll(data);
                                messages = new Message();
                                messages.what = organization_finish;
                                messages.obj = save;
                                myHandler.sendMessage(messages);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        messages = new Message();
                        messages.what = organization_finish;
                        messages.obj = false;
                        myHandler.sendMessage(messages);
                    }
                } else {
                    messages = new Message();
                    messages.what = organization_finish;
                    messages.obj = false;
                    myHandler.sendMessage(messages);
                }
            }

            @Override
            public void Failure(int arg) {
                messages = new Message();
                messages.what = organization_finish;
                messages.obj = false;
                myHandler.sendMessage(messages);
            }

            @Override
            public void Complete(int arg) {

            }
        }));
    }


    //请求项目
    private void getBdProject(final int type) {
        String projectlist = Constance.getProjectlist();
        NetworkUtil.getInstance().get(getActivity(), projectlist,5,new com.kingdee.ah.pda.volley.MyHandler( new com.kingdee.ah.pda.volley.MyHandler.OnReceiveMessageListener() {
            @Override
            public void Success(Message message) {
                String response= (String) message.obj;
                ProjectListBean projectListBean = GsonUtils.parseJSON(response, ProjectListBean.class);
                if (projectListBean.getCode() == 0) {
                    final List<BdProject> data = projectListBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                if (type == 2) {
                                    LitePal.deleteAll(BdProject.class);
                                }
                                boolean save = LitePal.saveAll(data);
                                messages = new Message();
                                messages.what = project_finish;
                                messages.obj = save;
                                myHandler.sendMessage(messages);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        messages = new Message();
                        messages.what = project_finish;
                        messages.obj = false;
                        myHandler.sendMessage(messages);
                    }
                } else {
                    messages = new Message();
                    messages.what = project_finish;
                    messages.obj = false;
                    myHandler.sendMessage(messages);
                }
            }

            @Override
            public void Failure(int arg) {
                messages = new Message();
                messages.what = project_finish;
                messages.obj = false;
                myHandler.sendMessage(messages);
            }

            @Override
            public void Complete(int arg) {

            }
        }));
    }

    //请求仓库
    private void getBdStock(final int type) {
        String stockList = Constance.getStockList();
        NetworkUtil.getInstance().get(getActivity(), stockList,6,new com.kingdee.ah.pda.volley.MyHandler(new com.kingdee.ah.pda.volley.MyHandler.OnReceiveMessageListener() {
            @Override
            public void Success(Message message) {
                String response= (String) message.obj;
                StockBean stockBean = GsonUtils.parseJSON(response, StockBean.class);
                if (stockBean.getCode() == 0) {
                    final List<BdStock> data = stockBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                if (type == 2) {
                                    LitePal.deleteAll(BdStock.class);
                                }
                                boolean save = LitePal.saveAll(data);
                                messages = new Message();
                                messages.what = stock_finish;
                                messages.obj = save;
                                myHandler.sendMessage(messages);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        messages = new Message();
                        messages.what = stock_finish;
                        messages.obj = false;
                        myHandler.sendMessage(messages);
                    }
                } else {
                    messages = new Message();
                    messages.what = stock_finish;
                    messages.obj = false;
                    myHandler.sendMessage(messages);
                }
            }

            @Override
            public void Failure(int arg) {
                messages = new Message();
                messages.what = stock_finish;
                messages.obj = false;
                myHandler.sendMessage(messages);
            }

            @Override
            public void Complete(int arg) {

            }
        }));
    }

    //请求供应商
    private void getBdSupplier(final int type) {
        String supplier = Constance.getSupplier();
        NetworkUtil.getInstance().get(getActivity(), supplier,7,new com.kingdee.ah.pda.volley.MyHandler(new com.kingdee.ah.pda.volley.MyHandler.OnReceiveMessageListener() {
            @Override
            public void Success(Message message) {
                String response= (String) message.obj;
                SupplierBean supplierBean = GsonUtils.parseJSON(response, SupplierBean.class);
                if (supplierBean.getCode() == 0) {
                    final List<BdSupplier> data = supplierBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                if (type == 2) {
                                    LitePal.deleteAll(BdSupplier.class);
                                }
                                boolean save = LitePal.saveAll(data);
                                messages = new Message();
                                messages.what = supplier_finish;
                                messages.obj = save;
                                myHandler.sendMessage(messages);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        messages = new Message();
                        messages.what = supplier_finish;
                        messages.obj = false;
                        myHandler.sendMessage(messages);
                    }
                } else {
                    messages = new Message();
                    messages.what = supplier_finish;
                    messages.obj = false;
                    myHandler.sendMessage(messages);
                }
            }

            @Override
            public void Failure(int arg) {
                messages = new Message();
                messages.what = supplier_finish;
                messages.obj = false;
                myHandler.sendMessage(messages);
            }

            @Override
            public void Complete(int arg) {

            }
        }));
    }

    //请求计量单位代码
    private void getBdUnit(final int type) {
        String unit = Constance.getUnit();
        NetworkUtil.getInstance().get(getActivity(), unit,8,new com.kingdee.ah.pda.volley.MyHandler(new com.kingdee.ah.pda.volley.MyHandler.OnReceiveMessageListener() {
            @Override
            public void Success(Message message) {
                String response= (String) message.obj;
                UnitBean unitBean = GsonUtils.parseJSON(response, UnitBean.class);
                if (unitBean.getCode() == 0) {
                    final List<BdUnit> data = unitBean.getData();
                    if (data != null && data.size() > 0) {
                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                if (type == 2) {
                                    LitePal.deleteAll(BdUnit.class);
                                }
                                boolean save = LitePal.saveAll(data);
                                messages = new Message();
                                messages.what = unit_finish;
                                messages.obj = save;
                                myHandler.sendMessage(messages);
                            }
                        };
                        threadPoolExecutor.execute(runnable);
                    } else {
                        messages = new Message();
                        messages.what = unit_finish;
                        messages.obj = false;
                        myHandler.sendMessage(messages);
                    }
                } else {
                    messages = new Message();
                    messages.what = unit_finish;
                    messages.obj = false;
                    myHandler.sendMessage(messages);
                }
            }

            @Override
            public void Failure(int arg) {

            }

            @Override
            public void Complete(int arg) {

            }
        }));
    }


    private void closeDialog(String msg, boolean b) {
        ToastUtil.show(getActivity(), String.format("%s%s%s", msg, "基础数据同步", b ? "成功" : "失败"));
        hasDownload++;
        if (DownloadCount == hasDownload) {
            if (updateDialog != null) {
                updateDialog.Close();
            }
        }
    }

    private static ProgressDialog progressDialog;

    //进度条
    public static void ShowProgress(Context context, String message, boolean Cancelable) {
        if (progressDialog != null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage(message);
            progressDialog.setCancelable(Cancelable);
        }
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }

    }

    //关闭进度条
    public static void CancelProgress() {
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                progressDialog.cancel();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }


}
