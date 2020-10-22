package com.jeewms.www.wms.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity1;
import com.jeewms.www.wms.ui.fragment1.PurchaseOrderFragment;
import com.jeewms.www.wms.ui.activity.receive.ReceiveNoticeActivity;
import com.jeewms.www.wms.ui.view.TitleTopOrdersView;
import com.jeewms.www.wms.util.Logutil;

import butterknife.BindView;


/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.activity1
 * @ClassName: PurchaseOrderActivity
 * 采购订单,出库订单,入库订单,库存盘点的公共首页首页
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/9/28 10:58
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/9/28 10:58
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class HomeOrderActivity extends BaseActivity1 {
    @BindView(R.id.purchase_title)
    TitleTopOrdersView purchaseTitle;
    private String[] stringArray;
    //spinner标签
    private int spinnerType = 0;
    private Spinner spinner;
    private ArrayAdapter arrayAdapter;
    private FragmentManager supportFragmentManager;
    private Fragment currentFragment=new Fragment();
    //收料通知
    private ReceiveNoticeActivity receiveNoticeActivity =new ReceiveNoticeActivity();
    //采购订单
    private PurchaseOrderFragment purchaseOrderFragment=new PurchaseOrderFragment();

    private int pageNumber=0;

    public static void show(Context context,int pageNumber) {
        Intent intent = new Intent(context, HomeOrderActivity.class);
        intent.putExtra("pageNumber",pageNumber);
        context.startActivity(intent);
    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_home_order;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (getIntent() != null) {
            pageNumber = getIntent().getIntExtra("pageNumber", 0);
        }
        //设置显示的控件
        purchaseTitle.setViewVisibility(View.VISIBLE, View.GONE, View.VISIBLE, View.GONE, View.GONE, View.GONE,View.GONE);
        //返回
        purchaseTitle.getBtn_back().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        spinner = purchaseTitle.getSpinner();
        if (savedInstanceState != null) {
            spinnerType = savedInstanceState.getInt("spinnerType");
        }
    }

    @Override
    protected void initfun() {
        //选择列表
        SetSpinner();
        spinner.setSelection(pageNumber);
        supportFragmentManager = getSupportFragmentManager();
    }

    private void SetSpinner() {
        stringArray = getResources().getStringArray(R.array.order_item);
        arrayAdapter = new ArrayAdapter(this, R.layout.item_spinner_select, stringArray);
        arrayAdapter.setDropDownViewResource(R.layout.item_spinner_drop);
        spinner.setDropDownWidth(600); //下拉宽度
       // spinner.setDropDownHorizontalOffset(80); //下拉的横向偏移
        //spinner.setDropDownVerticalOffset(120); //下拉的纵向偏移
        spinner.setAdapter(arrayAdapter);
        spinner.setSelection(spinnerType);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Logutil.print("选择" + stringArray[i]);
                switch (i) {
                    case 0:
                        //清单管理
                        spinnerType = 0;
                     //   switchFragment(receivingNoticeActivity).commit();

                        break;
                    case 1:
                       //库存管理
                        spinnerType = 1;
                        break;
                    case 2:
                        //库存盘点
                        spinnerType = 2;
                        switchFragment(purchaseOrderFragment).commit();
                        break;
                    case 3:
                        //工序条码
                        spinnerType = 3;
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //页面状态缓存
        outState.putInt("spinnerType",spinnerType);
    }

    //优化fragment切换
    private FragmentTransaction switchFragment(Fragment targetFragment){
        assert (supportFragmentManager !=null);
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        if (!targetFragment.isAdded()){
            if (currentFragment != null) {
                fragmentTransaction.hide(currentFragment);
            }
            fragmentTransaction.add(R.id.root_fragment,targetFragment,targetFragment.getClass().getName());
        } else {
            fragmentTransaction.hide(currentFragment).show(targetFragment);
        }
        currentFragment=targetFragment;
        return  fragmentTransaction;
    }


//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
//            if (currentFragment instanceof StockScanSearchActivity) {
//                if (((StockScanSearchActivity) stockScanSearchActivity).cancleSelect()) {
//                    finish();
//                }
//                return true;
//            }
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
