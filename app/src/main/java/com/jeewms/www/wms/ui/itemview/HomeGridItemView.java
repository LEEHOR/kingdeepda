package com.jeewms.www.wms.ui.itemview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.HomeBtnBean;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.activity.ScanCodeCheckInventoryActivity;
import com.jeewms.www.wms.ui.activity.deliverNotice.DeliveryNoticeActivity;
import com.jeewms.www.wms.ui.activity.inventoryChecking.InventoryCheckingActivity;
import com.jeewms.www.wms.ui.activity.materialList.MaterialListActivity;
import com.jeewms.www.wms.ui.activity.otherStockOut.OtherStockOutActivity;
import com.jeewms.www.wms.ui.activity.processReport.ProcessReportListActivity;
import com.jeewms.www.wms.ui.activity.productionPicking.ProductionPickingActivity;
import com.jeewms.www.wms.ui.activity.productionWarehousing.ProductionWarehousingActivity;
import com.jeewms.www.wms.ui.activity.purchaseWarehousing.PurchaseWarehousingActivity;
import com.jeewms.www.wms.ui.activity.receive.ReceiveNoticeActivity;
import com.jeewms.www.wms.ui.activity.salesDelivery.SalesDeliveryActivity;
import com.jeewms.www.wms.ui.activity.warehouseOutApplication.WarehouseOutApplicationActivity;
import com.zhy.android.percent.support.PercentLinearLayout;

/**
 * Created by 13799 on 2018/6/2.
 */

public class HomeGridItemView {


    protected Activity mActivity;
    ImageView imgHomeitem;
    TextView tvHomename;
    PercentLinearLayout ll_root;
    private View mView;


    public HomeGridItemView(Activity act) {
        this.mActivity = act;

        LayoutInflater inflater = LayoutInflater.from(act);
        mView = inflater.inflate(R.layout.item_home, null);
        imgHomeitem = mView.findViewById(R.id.img_homeitem);
        tvHomename = mView.findViewById(R.id.tv_homename);
        ll_root = mView.findViewById(R.id.ll_root);
    }


    public View getView() {
        return mView;
    }

    public void bindView(final HomeBtnBean bean) {
        imgHomeitem.setImageResource(bean.getImaResId());
        tvHomename.setText(bean.getBtnName());
        ll_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jump2(bean.getBtnName());
            }
        });
    }

    private void Jump2(String btnName) {
        if (Constance.btnNameList[0].equals(btnName)) {
            ReceiveNoticeActivity.show(mActivity);  //收料清单
        } else if (Constance.btnNameList[1].equals(btnName)) {
            PurchaseWarehousingActivity.show(mActivity); //采购入库
        } else if (Constance.btnNameList[2].equals(btnName)) {
            ProcessReportListActivity.show(mActivity); //工序汇报
        } else if (Constance.btnNameList[3].equals(btnName)) {
            ProductionWarehousingActivity.show(mActivity);//生产入库
        } else if (Constance.btnNameList[4].equals(btnName)) {
            MaterialListActivity.show(mActivity); //用料清单
        } else if (Constance.btnNameList[5].equals(btnName)) {
            ProductionPickingActivity.show(mActivity);//生产领料
        } else if (Constance.btnNameList[6].equals(btnName)) {
            WarehouseOutApplicationActivity.show(mActivity);//出库申请
        } else if (Constance.btnNameList[7].equals(btnName)) {
            OtherStockOutActivity.show(mActivity); //其他出库
        } else if (Constance.btnNameList[8].equals(btnName)) {
            DeliveryNoticeActivity.show(mActivity); //发货通知
        } else if (Constance.btnNameList[9].equals(btnName)) {
            SalesDeliveryActivity.show(mActivity);//销售出库
        } else if (Constance.btnNameList[10].equals(btnName)) {
            InventoryCheckingActivity.show(mActivity); //库存盘点
        } else if (Constance.btnNameList[11].equals(btnName)) {
            ScanCodeCheckInventoryActivity.show(mActivity);//扫码查库存
        }
    }
}
