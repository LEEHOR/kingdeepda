package com.kingdee.ah.pda.ui.itemview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.bean.HomeBtnBean;
import com.kingdee.ah.pda.constance.Constance;
import com.kingdee.ah.pda.ui.activity.ScanCodeCheckInventoryActivity;
import com.kingdee.ah.pda.ui.activity.deliverNotice.DeliveryNoticeActivity;
import com.kingdee.ah.pda.ui.activity.inventoryChecking.InventoryCheckingActivity;
import com.kingdee.ah.pda.ui.activity.materialList.MaterialListActivity;
import com.kingdee.ah.pda.ui.activity.operationPlan.OperationPlanActivity;
import com.kingdee.ah.pda.ui.activity.operationPlanTransfer.OperationPlanTransferInActivity;
import com.kingdee.ah.pda.ui.activity.operationPlanTransfer.OperationPlanTransferOutActivity;
import com.kingdee.ah.pda.ui.activity.otherStockOut.OtherStockOutActivity;
import com.kingdee.ah.pda.ui.activity.processReport.ProcessReportListActivity;
import com.kingdee.ah.pda.ui.activity.productionPicking.ProductionPickingActivity;
import com.kingdee.ah.pda.ui.activity.productionWarehousing.ProductionWarehousingActivity;
import com.kingdee.ah.pda.ui.activity.purchaseWarehousing.PurchaseWarehousingActivity;
import com.kingdee.ah.pda.ui.activity.receive.ReceiveNoticeActivity;
import com.kingdee.ah.pda.ui.activity.salesDelivery.SalesDeliveryActivity;
import com.kingdee.ah.pda.ui.activity.warehouseOutApplication.WarehouseOutApplicationActivity;
import com.zhy.android.percent.support.PercentLinearLayout;

/**
 * Created by 13799 on 2018/6/2.
 */

public class HomeGridItemView1 {


    protected Activity mActivity;
    ImageView imgHomeitem;
    TextView tvHomename;
    PercentLinearLayout ll_root;
    private View mView;


    public HomeGridItemView1(Activity act) {
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

    public void bindView(final HomeBtnBean bean, final int type) {

        imgHomeitem.setImageResource(bean.getImaResId());
        tvHomename.setText(bean.getBtnName());
        ll_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jump(bean.getBtnName(),type);
            }
        });
    }

    private void  jump(String btnName,int type){
        switch (type) {
            case 1:
                if (Constance.tv_home1[0].equals(btnName)) {
                    ReceiveNoticeActivity.show(mActivity);  //收料通知
                } else if (Constance.tv_home1[1].equals(btnName)) {
                    PurchaseWarehousingActivity.show(mActivity); //采购入库
                } else if (Constance.tv_home1[2].equals(btnName)) {

                } else if (Constance.tv_home1[3].equals(btnName)) {

                }
                break;
            case 2:
                if (Constance.tv_home2[0].equals(btnName)) {
                    DeliveryNoticeActivity.show(mActivity); //发货通知
                } else if (Constance.tv_home2[1].equals(btnName)) {
                    SalesDeliveryActivity.show(mActivity);//销售出库
                } else if (Constance.tv_home2[2].equals(btnName)) {

                } else if (Constance.tv_home2[3].equals(btnName)) {

                }
                break;
            case 3:
                if (Constance.tv_home3[0].equals(btnName)) {
                    WarehouseOutApplicationActivity.show(mActivity);//出库申请
                } else if (Constance.tv_home3[1].equals(btnName)) {
                    OtherStockOutActivity.show(mActivity); //其他出库
                } else if (Constance.tv_home3[2].equals(btnName)) {
                    ScanCodeCheckInventoryActivity.show(mActivity);//扫码查库存
                } else if (Constance.tv_home3[3].equals(btnName)) {
                    InventoryCheckingActivity.show(mActivity);
                }
                break;
            case 4:
                if (Constance.tv_home4[0].equals(btnName)) {
                    MaterialListActivity.show(mActivity); //用料清单
                } else if (Constance.tv_home4[1].equals(btnName)) {
                    ProductionPickingActivity.show(mActivity);//生产领料
                } else if (Constance.tv_home4[2].equals(btnName)) {
                     //生产汇报
                } else if (Constance.tv_home4[3].equals(btnName)) {

                }
                break;
            case 5:
                if (Constance.tv_home5[0].equals(btnName)) {
                    OperationPlanActivity.show(mActivity); //工序计划
                } else if (Constance.tv_home5[1].equals(btnName)) {
                    OperationPlanTransferOutActivity.show(mActivity);//转移单委外发出
                } else if (Constance.tv_home5[2].equals(btnName)) {
                    OperationPlanTransferInActivity.show(mActivity);//转移单委外接收
                } else if (Constance.tv_home5[3].equals(btnName)) {
                    ProcessReportListActivity.show(mActivity); //工序汇报                               //
                }else if (Constance.tv_home5[4].equals(btnName)) {
                    //工序转移
                }else if (Constance.tv_home5[5].equals(btnName)) {
                    ProductionWarehousingActivity.show(mActivity);//生产入库
                }
                break;
        }
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
            ScanCodeCheckInventoryActivity.show(mActivity);//扫码查库存
        } else if (Constance.btnNameList[11].equals(btnName)) {
            OperationPlanActivity.show(mActivity);//工序计划
        }else if (Constance.btnNameList[12].equals(btnName)) {
            OperationPlanTransferInActivity.show(mActivity);//转移单委外发出
        }else if (Constance.btnNameList[13].equals(btnName)) {
            OperationPlanTransferOutActivity.show(mActivity);//转移单委外接收
        }
    }
}
