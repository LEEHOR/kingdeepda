package com.jeewms.www.wms.constance;

import com.jeewms.www.wms.App;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.util.SharedPreferencesUtil;

import java.util.UUID;

/**
 * Created by 13799 on 2018/6/2.
 */

public class Constance {
    public static String COMMON_PROTOCOL="http://";
    public static String COMMON_IP = "192.168.0.200:8081";
    public static UUID SPP_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    //主界面按钮图片   //R.drawable.home11,
    public static final int[] btnImgList = {R.drawable.home1, R.drawable.home2,
            R.drawable.home3, R.drawable.home4, R.drawable.home5,
            R.drawable.home6, R.drawable.home7, R.drawable.home8,
            R.drawable.home9, R.drawable.home10, R.drawable.home12,
            R.drawable.home13, R.drawable.home14, R.drawable.home15};
    //主界面按钮名字   //"库存盘点",
    public static final String[] btnNameList = {"收料通知", "采购入库", "工序汇报", "生产入库", "用料清单", "生产领料", "出库申请", "其他出库"
            , "发货通知", "销售出库", "扫码查库存", "工序计划", "转移单(委外发出)", "转移单(委外接收)"};

    //首页区域 采购管理图片
    public static final int[] home1 = {R.drawable.home1, R.drawable.home2, R.drawable.home3, R.drawable.home4};
    //首页区域 采购管理文字
    public static final String[] tv_home1 = {"收料通知", "采购入库", "退料申请", "采购退料"};

    //首页区域 销售管理图片
    public static final int[] home2 = {R.drawable.home5, R.drawable.home6, R.drawable.home7, R.drawable.home8};
    //首页区域 销售管理文字
    public static final String[] tv_home2 = {"发货通知", "销售出库", "退货通知", "销售退货"};

    //首页区域 仓存管理图片
    public static final int[] home3 = {R.drawable.home9, R.drawable.home10, R.drawable.home12, R.drawable.home11};
    //首页区域 仓存管理文字
    public static final String[] tv_home3 = {"出库申请", "其它出库", "扫码查库存", "库存盘点"};

    //首页区域 生产管理图片
    public static final int[] home4 = {R.drawable.home13, R.drawable.home14, R.drawable.home15, R.drawable.home16,
            R.drawable.home17, R.drawable.home18, R.drawable.home19, R.drawable.home20};
    //首页区域 生产管理文字
    public static final String[] tv_home4 = {"用料清单", "生产领料", "生产汇报", "生产入库","直接调拨单","生产退料","生产补料","生产退库"};

    //首页区域 工序管理图片
    public static final int[] home5 = {R.drawable.home21, R.drawable.home22, R.drawable.home23, R.drawable.home24,
            R.drawable.home25, R.drawable.home26};
    //首页区域 工序管理文字
    public static final String[] tv_home5 = {"工序计划", "转移单委外发出", "转移单委外接收", "工序汇报","工序转移","生产入库"};

    //设置baseip
    public static void setBaseIp(String baseIP) {
        SharedPreferencesUtil.getInstance(App.getmApplicationContext()).setKeyValue(Shared.BASEIP, baseIP);
    }
    //读取baseip
    public static String getBaseIp(){
       return SharedPreferencesUtil.getInstance(App.getmApplicationContext()).getKeyValue(Shared.BASEIP, COMMON_IP);
    }

    //读取baseurl
    public static String getBaseUrl() {
        return COMMON_PROTOCOL+SharedPreferencesUtil.getInstance(App.getmApplicationContext()).getKeyValue(Shared.BASEIP, COMMON_IP);
    }


    //登录
    public static final String LOGIN = "/api/pda/user/login";
    //登出
    public static final String SIGNOUT = "";
    //修改密码
    public static final String UPDATEPWD = "/api/pda/user/updatePwd";
    //库存管理
    public static final String INVENTORY = "/api/pda/inventory/getInventory";


    //版本更新
    public static final String NEWVersion = "/api/pda/app/newVersion";

    //仓库列表
    public static final String STOCKCLASS = "/api/pda/base/stockList";
    //物料分类列表
    public static final String material = "/api/pda/base/materialList";
    //项目列表
    public static final String PROJECTLIST = "/api/pda/base/projectList";
    //供应商列表
    public static final String SUPPLIER = "/api/pda/base/supplierList";
    //计量单位查询
    public static final String UNIT = "/api/pda/base/unitList";
    //币别查询
    public static final String CURRENT = "/api/pda/base/currencyList";
    //组织机构查询
    public static final String ORGANIZATION = "/api/pda/base/organizationsList";
    //部门
    public static final String DEPARMENT = "/api/pda/base/departmentList";
    //存货类别
    public static final String materialcategory = "/api/pda/base/materialcategoryList";
    //收料通知单列表
    public static final String GETRECEIVINGBILLLIST = "/api/pda/receiveBill/getReceiveBill";
    //收料通知单详情
    public static final String GETRECEIVINGBILLDETAIL = "/api/pda/receiveBill/getReceiveBillEntry";
    //收料通知单下推
    public static final String PUSHRECEIVING = "/api/pda/receiveBill/pushReceiveBill";


    //采购入库表头
    public static final String getstkInStock = "/api/pda/stkInStock/getstkInStock";
    //采购入库表体
    public static final String getstkInStockEntry = "/api/pda/stkInStock/getstkInStockEntry";
    //采购入库保存
    public static final String stkInStockAdd = "/api/pda/stkInStock/add";


    //登录
    public static String getLoginURL() {
        return getBaseUrl() + LOGIN;
    }

    //登出
    public static String getSignOutURL() {
        return getBaseUrl() + SIGNOUT;
    }

    //修改密码
    public static String getUpdatePwd() {
        return getBaseUrl() + UPDATEPWD;
    }

    //库存管理
    public static String getInventory() {
        return getBaseUrl() + INVENTORY;
    }

    //版本更新
    public static String getNewVersion() {
        return getBaseUrl() + NEWVersion;
    }

    //获取仓库列表
    public static String getStockList() {
        return getBaseUrl() + STOCKCLASS;
    }

    //获取物料分类列表
    public static String getMaterial() {
        return getBaseUrl() + material;
    }

    //获取收料通知单列表
    public static String getReceivingBillList() {
        return getBaseUrl() + GETRECEIVINGBILLLIST;
    }

    //获取收料通知详情
    public static String getGetReceivingBillDetail() {
        return getBaseUrl() + GETRECEIVINGBILLDETAIL;
    }

    //收料通知下推
    public static String getPushReceiving() {
        return getBaseUrl() + PUSHRECEIVING;
    }

    //项目列表
    public static String getProjectlist() {
        return getBaseUrl() + PROJECTLIST;
    }

    //供应商列表地址
    public static String getSupplier() {
        return getBaseUrl() + SUPPLIER;
    }

    //计量单位
    public static String getUnit() {
        return getBaseUrl() + UNIT;
    }

    //币别列表地址
    public static String getCurrent() {
        return getBaseUrl() + CURRENT;
    }

    //组织机构
    public static String getOrganization() {
        return getBaseUrl() + ORGANIZATION;
    }

    //部门
    public static String getDepartment() {
        return getBaseUrl() + DEPARMENT;
    }

    //存货类别
    public static String getMaterialcategory() {
        return getBaseUrl() + materialcategory;
    }

    //采购入库单据头信息
    public static String getGetstkInStock() {
        return getBaseUrl() + getstkInStock;
    }

    //采购入库单据体数据
    public static String getGetstkInStockEntry() {
        return getBaseUrl() + getstkInStockEntry;
    }

    public static String getStkInStockAdd() {
        return getBaseUrl() + stkInStockAdd;
    }

    public static class SHAREP {
        /**
         * SharedPreferences
         */
        public static final String SHAREDSAVE = "save";

        //登录名
        public static final String LOGINNAME = "userName";
        //登录密码
        public static final String PASSWORD = "passWord";

        //地址
        public static final String HTTPADDRESS = "httpAddress";
        public static final String HTTPADDRESS1 = "httpAddress1";

    }
}
