package com.jeewms.www.wms.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: InStockHeadBean
 * @Description: java类作用描述
 * 采购入库表头
 * @Author: 作者名
 * @CreateDate: 2020/10/22 14:31
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/22 14:31
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class InStockHeadBean implements Serializable {


    /**
     * msg : 操作成功
     * code : 0
     * data : [{"fid":100006,"fdemandOrgName":"金锋馥（滁州）输送机械有限公司","fstockOrgName":null,"fpurchaserNumber":"0033","fpurchaseOrgName":"金锋馥（滁州）输送机械有限公司","fsupplierName":"SEW-传动设备（苏州）有限公司","fbillTypeName":"标准采购入库","limit":null,"fbusinessTypeNumber":"CG","fbusinessType":"标准采购","fstockDeptNumber":null,"fsettleOrgIdNumber":"200","fownerIdName":"金锋馥（滁州）输送机械有限公司","fpurchaseDeptName":"采购部","fsettleName":"SEW-传动设备（苏州）有限公司","fsettleCurrIdNumber":"PRE001","fownerIdNumber":"200","fstockDeptName":null,"fpurchaseDeptNumber":"JHF0005","fstockerNumber":null,"fdemandOrgNumber":"200","fsupplyName":"SEW-传动设备（苏州）有限公司","page":null,"fstockerGroupName":null,"fproviderContactNumber":null,"fpurchaseOrgNumber":"200","fsettleNumber":"1010152","fstockerName":null,"fsupplierNumber":"1010152","fchargeNumber":"1010152","fproviderContactName":null,"fpurchaserGroupName":null,"fsupplyNumber":"1010152","stkInStockEntryVoList":null,"fdate":"2020-09-11T00:00:00","fsettleOrgIdName":"金锋馥（滁州）输送机械有限公司","fownerTypeIdHeadNumber":"BD_OwnerOrg","fstockerGroupNumber":null,"fpurchaserName":"冯晓盼","fstockOrgNumber":null,"fchargeName":"SEW-传动设备（苏州）有限公司","fsupplyAddress":" ","fdocumentStatusNumber":"C","fdocumentStatus":"已审核","fpurchaserGroupNumber":null,"billNoLike":null,"fownerTypeIdHead":"业务组织","fbillTypeNumber":"RKD01_SYS","fsettleCurrIdName":"人民币","fbillNo":"CGRK00001"},{"fid":100007,"fdemandOrgName":"金锋馥（滁州）输送机械有限公司","fstockOrgName":null,"fpurchaserNumber":null,"fpurchaseOrgName":"金锋馥（滁州）输送机械有限公司","fsupplierName":"怡稳自动化科技（上海）有限公司","fbillTypeName":"标准采购入库","limit":null,"fbusinessTypeNumber":"CG","fbusinessType":"标准采购","fstockDeptNumber":null,"fsettleOrgIdNumber":"200","fownerIdName":"金锋馥（滁州）输送机械有限公司","fpurchaseDeptName":null,"fsettleName":"怡稳自动化科技（上海）有限公司","fsettleCurrIdNumber":"PRE001","fownerIdNumber":"200","fstockDeptName":null,"fpurchaseDeptNumber":null,"fstockerNumber":null,"fdemandOrgNumber":"200","fsupplyName":"怡稳自动化科技（上海）有限公司","page":null,"fstockerGroupName":null,"fproviderContactNumber":null,"fpurchaseOrgNumber":"200","fsettleNumber":"1010156","fstockerName":null,"fsupplierNumber":"1010156","fchargeNumber":"1010156","fproviderContactName":null,"fpurchaserGroupName":null,"fsupplyNumber":"1010156","stkInStockEntryVoList":null,"fdate":"2020-09-11T00:00:00","fsettleOrgIdName":"金锋馥（滁州）输送机械有限公司","fownerTypeIdHeadNumber":"BD_OwnerOrg","fstockerGroupNumber":null,"fpurchaserName":null,"fstockOrgNumber":null,"fchargeName":"怡稳自动化科技（上海）有限公司","fsupplyAddress":" ","fdocumentStatusNumber":"C","fdocumentStatus":"已审核","fpurchaserGroupNumber":null,"billNoLike":null,"fownerTypeIdHead":"业务组织","fbillTypeNumber":"RKD01_SYS","fsettleCurrIdName":"人民币","fbillNo":"CGRK00002"},{"fid":100008,"fdemandOrgName":"金锋馥（滁州）输送机械有限公司","fstockOrgName":null,"fpurchaserNumber":null,"fpurchaseOrgName":"金锋馥（滁州）输送机械有限公司","fsupplierName":"滁州市琦瀚商贸有限公司","fbillTypeName":"标准采购入库","limit":null,"fbusinessTypeNumber":"CG","fbusinessType":"标准采购","fstockDeptNumber":null,"fsettleOrgIdNumber":"200","fownerIdName":"金锋馥（滁州）输送机械有限公司","fpurchaseDeptName":null,"fsettleName":"滁州市琦瀚商贸有限公司","fsettleCurrIdNumber":"PRE001","fownerIdNumber":"200","fstockDeptName":null,"fpurchaseDeptNumber":null,"fstockerNumber":null,"fdemandOrgNumber":"200","fsupplyName":"滁州市琦瀚商贸有限公司","page":null,"fstockerGroupName":null,"fproviderContactNumber":null,"fpurchaseOrgNumber":"200","fsettleNumber":"1010011","fstockerName":null,"fsupplierNumber":"1010011","fchargeNumber":"1010011","fproviderContactName":null,"fpurchaserGroupName":null,"fsupplyNumber":"1010011","stkInStockEntryVoList":null,"fdate":"2020-09-11T00:00:00","fsettleOrgIdName":"金锋馥（滁州）输送机械有限公司","fownerTypeIdHeadNumber":"BD_OwnerOrg","fstockerGroupNumber":null,"fpurchaserName":null,"fstockOrgNumber":null,"fchargeName":"滁州市琦瀚商贸有限公司","fsupplyAddress":" ","fdocumentStatusNumber":"C","fdocumentStatus":"已审核","fpurchaserGroupNumber":null,"billNoLike":null,"fownerTypeIdHead":"业务组织","fbillTypeNumber":"RKD01_SYS","fsettleCurrIdName":"人民币","fbillNo":"CGRK00003"},{"fid":100009,"fdemandOrgName":"金锋馥（滁州）输送机械有限公司","fstockOrgName":null,"fpurchaserNumber":null,"fpurchaseOrgName":"金锋馥（滁州）输送机械有限公司","fsupplierName":"滁州创伟聚氨酯科技有限公司","fbillTypeName":"标准采购入库","limit":null,"fbusinessTypeNumber":"CG","fbusinessType":"标准采购","fstockDeptNumber":null,"fsettleOrgIdNumber":"200","fownerIdName":"金锋馥（滁州）输送机械有限公司","fpurchaseDeptName":null,"fsettleName":"滁州创伟聚氨酯科技有限公司","fsettleCurrIdNumber":"PRE001","fownerIdNumber":"200","fstockDeptName":null,"fpurchaseDeptNumber":null,"fstockerNumber":null,"fdemandOrgNumber":"200","fsupplyName":"滁州创伟聚氨酯科技有限公司","page":null,"fstockerGroupName":null,"fproviderContactNumber":null,"fpurchaseOrgNumber":"200","fsettleNumber":"1010008","fstockerName":null,"fsupplierNumber":"1010008","fchargeNumber":"1010008","fproviderContactName":null,"fpurchaserGroupName":null,"fsupplyNumber":"1010008","stkInStockEntryVoList":null,"fdate":"2020-09-11T00:00:00","fsettleOrgIdName":"金锋馥（滁州）输送机械有限公司","fownerTypeIdHeadNumber":"BD_OwnerOrg","fstockerGroupNumber":null,"fpurchaserName":null,"fstockOrgNumber":null,"fchargeName":"滁州创伟聚氨酯科技有限公司","fsupplyAddress":" ","fdocumentStatusNumber":"C","fdocumentStatus":"已审核","fpurchaserGroupNumber":null,"billNoLike":null,"fownerTypeIdHead":"业务组织","fbillTypeNumber":"RKD01_SYS","fsettleCurrIdName":"人民币","fbillNo":"CGRK00004"},{"fid":100010,"fdemandOrgName":"金锋馥（滁州）输送机械有限公司","fstockOrgName":null,"fpurchaserNumber":null,"fpurchaseOrgName":"金锋馥（滁州）输送机械有限公司","fsupplierName":"SEW-传动设备（苏州）有限公司","fbillTypeName":"标准采购入库","limit":null,"fbusinessTypeNumber":"CG","fbusinessType":"标准采购","fstockDeptNumber":null,"fsettleOrgIdNumber":"200","fownerIdName":"金锋馥（滁州）输送机械有限公司","fpurchaseDeptName":null,"fsettleName":"SEW-传动设备（苏州）有限公司","fsettleCurrIdNumber":"PRE001","fownerIdNumber":"200","fstockDeptName":null,"fpurchaseDeptNumber":null,"fstockerNumber":null,"fdemandOrgNumber":"200","fsupplyName":"SEW-传动设备（苏州）有限公司","page":null,"fstockerGroupName":null,"fproviderContactNumber":null,"fpurchaseOrgNumber":"200","fsettleNumber":"1010152","fstockerName":null,"fsupplierNumber":"1010152","fchargeNumber":"1010152","fproviderContactName":null,"fpurchaserGroupName":null,"fsupplyNumber":"1010152","stkInStockEntryVoList":null,"fdate":"2020-09-11T00:00:00","fsettleOrgIdName":"金锋馥（滁州）输送机械有限公司","fownerTypeIdHeadNumber":"BD_OwnerOrg","fstockerGroupNumber":null,"fpurchaserName":null,"fstockOrgNumber":null,"fchargeName":"SEW-传动设备（苏州）有限公司","fsupplyAddress":" ","fdocumentStatusNumber":"C","fdocumentStatus":"已审核","fpurchaserGroupNumber":null,"billNoLike":null,"fownerTypeIdHead":"业务组织","fbillTypeNumber":"RKD01_SYS","fsettleCurrIdName":"人民币","fbillNo":"CGRK00005"},{"fid":100011,"fdemandOrgName":"金锋馥（滁州）输送机械有限公司","fstockOrgName":null,"fpurchaserNumber":null,"fpurchaseOrgName":"金锋馥（滁州）输送机械有限公司","fsupplierName":"滁州市琦瀚商贸有限公司","fbillTypeName":"标准采购入库","limit":null,"fbusinessTypeNumber":"CG","fbusinessType":"标准采购","fstockDeptNumber":null,"fsettleOrgIdNumber":"200","fownerIdName":"金锋馥（滁州）输送机械有限公司","fpurchaseDeptName":null,"fsettleName":"滁州市琦瀚商贸有限公司","fsettleCurrIdNumber":"PRE001","fownerIdNumber":"200","fstockDeptName":null,"fpurchaseDeptNumber":null,"fstockerNumber":null,"fdemandOrgNumber":"200","fsupplyName":"滁州市琦瀚商贸有限公司","page":null,"fstockerGroupName":null,"fproviderContactNumber":null,"fpurchaseOrgNumber":"200","fsettleNumber":"1010011","fstockerName":null,"fsupplierNumber":"1010011","fchargeNumber":"1010011","fproviderContactName":null,"fpurchaserGroupName":null,"fsupplyNumber":"1010011","stkInStockEntryVoList":null,"fdate":"2020-09-11T00:00:00","fsettleOrgIdName":"金锋馥（滁州）输送机械有限公司","fownerTypeIdHeadNumber":"BD_OwnerOrg","fstockerGroupNumber":null,"fpurchaserName":null,"fstockOrgNumber":null,"fchargeName":"滁州市琦瀚商贸有限公司","fsupplyAddress":" ","fdocumentStatusNumber":"C","fdocumentStatus":"已审核","fpurchaserGroupNumber":null,"billNoLike":null,"fownerTypeIdHead":"业务组织","fbillTypeNumber":"RKD01_SYS","fsettleCurrIdName":"人民币","fbillNo":"CGRK00006"},{"fid":100012,"fdemandOrgName":"金锋馥（滁州）输送机械有限公司","fstockOrgName":null,"fpurchaserNumber":null,"fpurchaseOrgName":"金锋馥（滁州）输送机械有限公司","fsupplierName":"滁州创伟聚氨酯科技有限公司","fbillTypeName":"标准采购入库","limit":null,"fbusinessTypeNumber":"CG","fbusinessType":"标准采购","fstockDeptNumber":null,"fsettleOrgIdNumber":"200","fownerIdName":"金锋馥（滁州）输送机械有限公司","fpurchaseDeptName":null,"fsettleName":"滁州创伟聚氨酯科技有限公司","fsettleCurrIdNumber":"PRE001","fownerIdNumber":"200","fstockDeptName":null,"fpurchaseDeptNumber":null,"fstockerNumber":null,"fdemandOrgNumber":"200","fsupplyName":"滁州创伟聚氨酯科技有限公司","page":null,"fstockerGroupName":null,"fproviderContactNumber":null,"fpurchaseOrgNumber":"200","fsettleNumber":"1010008","fstockerName":null,"fsupplierNumber":"1010008","fchargeNumber":"1010008","fproviderContactName":null,"fpurchaserGroupName":null,"fsupplyNumber":"1010008","stkInStockEntryVoList":null,"fdate":"2020-09-11T00:00:00","fsettleOrgIdName":"金锋馥（滁州）输送机械有限公司","fownerTypeIdHeadNumber":"BD_OwnerOrg","fstockerGroupNumber":null,"fpurchaserName":null,"fstockOrgNumber":null,"fchargeName":"滁州创伟聚氨酯科技有限公司","fsupplyAddress":" ","fdocumentStatusNumber":"C","fdocumentStatus":"已审核","fpurchaserGroupNumber":null,"billNoLike":null,"fownerTypeIdHead":"业务组织","fbillTypeNumber":"RKD01_SYS","fsettleCurrIdName":"人民币","fbillNo":"CGRK00007"},{"fid":100013,"fdemandOrgName":"金锋馥（滁州）输送机械有限公司","fstockOrgName":null,"fpurchaserNumber":null,"fpurchaseOrgName":"金锋馥（滁州）输送机械有限公司","fsupplierName":"滁州创伟聚氨酯科技有限公司","fbillTypeName":"标准采购入库","limit":null,"fbusinessTypeNumber":"CG","fbusinessType":"标准采购","fstockDeptNumber":null,"fsettleOrgIdNumber":"200","fownerIdName":"金锋馥（滁州）输送机械有限公司","fpurchaseDeptName":null,"fsettleName":"滁州创伟聚氨酯科技有限公司","fsettleCurrIdNumber":"PRE001","fownerIdNumber":"200","fstockDeptName":null,"fpurchaseDeptNumber":null,"fstockerNumber":null,"fdemandOrgNumber":"200","fsupplyName":"滁州创伟聚氨酯科技有限公司","page":null,"fstockerGroupName":null,"fproviderContactNumber":null,"fpurchaseOrgNumber":"200","fsettleNumber":"1010008","fstockerName":null,"fsupplierNumber":"1010008","fchargeNumber":"1010008","fproviderContactName":null,"fpurchaserGroupName":null,"fsupplyNumber":"1010008","stkInStockEntryVoList":null,"fdate":"2020-09-11T00:00:00","fsettleOrgIdName":"金锋馥（滁州）输送机械有限公司","fownerTypeIdHeadNumber":"BD_OwnerOrg","fstockerGroupNumber":null,"fpurchaserName":null,"fstockOrgNumber":null,"fchargeName":"滁州创伟聚氨酯科技有限公司","fsupplyAddress":" ","fdocumentStatusNumber":"C","fdocumentStatus":"已审核","fpurchaserGroupNumber":null,"billNoLike":null,"fownerTypeIdHead":"业务组织","fbillTypeNumber":"RKD01_SYS","fsettleCurrIdName":"人民币","fbillNo":"CGRK00008"},{"fid":100014,"fdemandOrgName":"金锋馥（滁州）输送机械有限公司","fstockOrgName":null,"fpurchaserNumber":null,"fpurchaseOrgName":"金锋馥（滁州）输送机械有限公司","fsupplierName":"滁州市琦瀚商贸有限公司","fbillTypeName":"标准采购入库","limit":null,"fbusinessTypeNumber":"CG","fbusinessType":"标准采购","fstockDeptNumber":"JHF0009","fsettleOrgIdNumber":"200","fownerIdName":"金锋馥（滁州）输送机械有限公司","fpurchaseDeptName":null,"fsettleName":"滁州市琦瀚商贸有限公司","fsettleCurrIdNumber":"PRE001","fownerIdNumber":"200","fstockDeptName":"仓库","fpurchaseDeptNumber":null,"fstockerNumber":"0040","fdemandOrgNumber":"200","fsupplyName":"滁州市琦瀚商贸有限公司","page":null,"fstockerGroupName":null,"fproviderContactNumber":null,"fpurchaseOrgNumber":"200","fsettleNumber":"1010011","fstockerName":"方园园","fsupplierNumber":"1010011","fchargeNumber":"1010011","fproviderContactName":null,"fpurchaserGroupName":null,"fsupplyNumber":"1010011","stkInStockEntryVoList":null,"fdate":"2020-09-17T00:00:00","fsettleOrgIdName":"金锋馥（滁州）输送机械有限公司","fownerTypeIdHeadNumber":"BD_OwnerOrg","fstockerGroupNumber":null,"fpurchaserName":null,"fstockOrgNumber":null,"fchargeName":"滁州市琦瀚商贸有限公司","fsupplyAddress":" ","fdocumentStatusNumber":"C","fdocumentStatus":"已审核","fpurchaserGroupNumber":null,"billNoLike":null,"fownerTypeIdHead":"业务组织","fbillTypeNumber":"RKD01_SYS","fsettleCurrIdName":"人民币","fbillNo":"CGRK00009"},{"fid":100015,"fdemandOrgName":"金锋馥（滁州）输送机械有限公司","fstockOrgName":null,"fpurchaserNumber":"0033","fpurchaseOrgName":"金锋馥（滁州）输送机械有限公司","fsupplierName":"SEW-传动设备（苏州）有限公司","fbillTypeName":"标准采购入库","limit":null,"fbusinessTypeNumber":"CG","fbusinessType":"标准采购","fstockDeptNumber":"JHF0005","fsettleOrgIdNumber":"200","fownerIdName":"金锋馥（滁州）输送机械有限公司","fpurchaseDeptName":"采购部","fsettleName":"SEW-传动设备（苏州）有限公司","fsettleCurrIdNumber":"PRE001","fownerIdNumber":"200","fstockDeptName":"采购部","fpurchaseDeptNumber":"JHF0005","fstockerNumber":null,"fdemandOrgNumber":"200","fsupplyName":"SEW-传动设备（苏州）有限公司","page":null,"fstockerGroupName":null,"fproviderContactNumber":null,"fpurchaseOrgNumber":"200","fsettleNumber":"1010152","fstockerName":null,"fsupplierNumber":"1010152","fchargeNumber":"1010152","fproviderContactName":null,"fpurchaserGroupName":null,"fsupplyNumber":"1010152","stkInStockEntryVoList":null,"fdate":"2020-09-17T00:00:00","fsettleOrgIdName":"金锋馥（滁州）输送机械有限公司","fownerTypeIdHeadNumber":"BD_OwnerOrg","fstockerGroupNumber":null,"fpurchaserName":"冯晓盼","fstockOrgNumber":null,"fchargeName":"SEW-传动设备（苏州）有限公司","fsupplyAddress":" ","fdocumentStatusNumber":"C","fdocumentStatus":"已审核","fpurchaserGroupNumber":null,"billNoLike":null,"fownerTypeIdHead":"业务组织","fbillTypeNumber":"RKD01_SYS","fsettleCurrIdName":"人民币","fbillNo":"CGRK00010"}]
     */
    private String msg;
    private int code;
    private List<DataEntity> data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public class DataEntity {
        /**
         * fid : 100006
         * fdemandOrgName : 金锋馥（滁州）输送机械有限公司
         * fstockOrgName : null
         * fpurchaserNumber : 0033
         * fpurchaseOrgName : 金锋馥（滁州）输送机械有限公司
         * fsupplierName : SEW-传动设备（苏州）有限公司
         * fbillTypeName : 标准采购入库
         * limit : null
         * fbusinessTypeNumber : CG
         * fbusinessType : 标准采购
         * fstockDeptNumber : null
         * fsettleOrgIdNumber : 200
         * fownerIdName : 金锋馥（滁州）输送机械有限公司
         * fpurchaseDeptName : 采购部
         * fsettleName : SEW-传动设备（苏州）有限公司
         * fsettleCurrIdNumber : PRE001
         * fownerIdNumber : 200
         * fstockDeptName : null
         * fpurchaseDeptNumber : JHF0005
         * fstockerNumber : null
         * fdemandOrgNumber : 200
         * fsupplyName : SEW-传动设备（苏州）有限公司
         * page : null
         * fstockerGroupName : null
         * fproviderContactNumber : null
         * fpurchaseOrgNumber : 200
         * fsettleNumber : 1010152
         * fstockerName : null
         * fsupplierNumber : 1010152
         * fchargeNumber : 1010152
         * fproviderContactName : null
         * fpurchaserGroupName : null
         * fsupplyNumber : 1010152
         * stkInStockEntryVoList : null
         * fdate : 2020-09-11T00:00:00
         * fsettleOrgIdName : 金锋馥（滁州）输送机械有限公司
         * fownerTypeIdHeadNumber : BD_OwnerOrg
         * fstockerGroupNumber : null
         * fpurchaserName : 冯晓盼
         * fstockOrgNumber : null
         * fchargeName : SEW-传动设备（苏州）有限公司
         * fsupplyAddress :
         * fdocumentStatusNumber : C
         * fdocumentStatus : 已审核
         * fpurchaserGroupNumber : null
         * billNoLike : null
         * fownerTypeIdHead : 业务组织
         * fbillTypeNumber : RKD01_SYS
         * fsettleCurrIdName : 人民币
         * fbillNo : CGRK00001
         */
        private int fid;
        private String fdemandOrgName;
        private String fstockOrgName;
        private String fpurchaserNumber;
        private String fpurchaseOrgName;
        private String fsupplierName;
        private String fbillTypeName;
        private String limit;
        private String fbusinessTypeNumber;
        private String fbusinessType;
        private String fstockDeptNumber;
        private String fsettleOrgIdNumber;
        private String fownerIdName;
        private String fpurchaseDeptName;
        private String fsettleName;
        private String fsettleCurrIdNumber;
        private String fownerIdNumber;
        private String fstockDeptName;
        private String fpurchaseDeptNumber;
        private String fstockerNumber;
        private String fdemandOrgNumber;
        private String fsupplyName;
        private String page;
        private String fstockerGroupName;
        private String fproviderContactNumber;
        private String fpurchaseOrgNumber;
        private String fsettleNumber;
        private String fstockerName;
        private String fsupplierNumber;
        private String fchargeNumber;
        private String fproviderContactName;
        private String fpurchaserGroupName;
        private String fsupplyNumber;
        private String fdate;
        private String fsettleOrgIdName;
        private String fownerTypeIdHeadNumber;
        private String fstockerGroupNumber;
        private String fpurchaserName;
        private String fstockOrgNumber;
        private String fchargeName;
        private String fsupplyAddress;
        private String fdocumentStatusNumber;
        private String fdocumentStatus;
        private String fpurchaserGroupNumber;
        private String billNoLike;
        private String fownerTypeIdHead;
        private String fbillTypeNumber;
        private String fsettleCurrIdName;
        private String fbillNo;
        private List<InStockEntryBean.DataEntity> stkInStockEntryVo=new ArrayList<>();

        public List<InStockEntryBean.DataEntity> getStkInStockEntryVo() {
            return stkInStockEntryVo;
        }

        public void setStkInStockEntryVo(List<InStockEntryBean.DataEntity> stkInStockEntryVo) {
            this.stkInStockEntryVo = stkInStockEntryVo;
        }

        public void setFid(int fid) {
            this.fid = fid;
        }

        public void setFdemandOrgName(String fdemandOrgName) {
            this.fdemandOrgName = fdemandOrgName;
        }

        public void setFstockOrgName(String fstockOrgName) {
            this.fstockOrgName = fstockOrgName;
        }

        public void setFpurchaserNumber(String fpurchaserNumber) {
            this.fpurchaserNumber = fpurchaserNumber;
        }

        public void setFpurchaseOrgName(String fpurchaseOrgName) {
            this.fpurchaseOrgName = fpurchaseOrgName;
        }

        public void setFsupplierName(String fsupplierName) {
            this.fsupplierName = fsupplierName;
        }

        public void setFbillTypeName(String fbillTypeName) {
            this.fbillTypeName = fbillTypeName;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public void setFbusinessTypeNumber(String fbusinessTypeNumber) {
            this.fbusinessTypeNumber = fbusinessTypeNumber;
        }

        public void setFbusinessType(String fbusinessType) {
            this.fbusinessType = fbusinessType;
        }

        public void setFstockDeptNumber(String fstockDeptNumber) {
            this.fstockDeptNumber = fstockDeptNumber;
        }

        public void setFsettleOrgIdNumber(String fsettleOrgIdNumber) {
            this.fsettleOrgIdNumber = fsettleOrgIdNumber;
        }

        public void setFownerIdName(String fownerIdName) {
            this.fownerIdName = fownerIdName;
        }

        public void setFpurchaseDeptName(String fpurchaseDeptName) {
            this.fpurchaseDeptName = fpurchaseDeptName;
        }

        public void setFsettleName(String fsettleName) {
            this.fsettleName = fsettleName;
        }

        public void setFsettleCurrIdNumber(String fsettleCurrIdNumber) {
            this.fsettleCurrIdNumber = fsettleCurrIdNumber;
        }

        public void setFownerIdNumber(String fownerIdNumber) {
            this.fownerIdNumber = fownerIdNumber;
        }

        public void setFstockDeptName(String fstockDeptName) {
            this.fstockDeptName = fstockDeptName;
        }

        public void setFpurchaseDeptNumber(String fpurchaseDeptNumber) {
            this.fpurchaseDeptNumber = fpurchaseDeptNumber;
        }

        public void setFstockerNumber(String fstockerNumber) {
            this.fstockerNumber = fstockerNumber;
        }

        public void setFdemandOrgNumber(String fdemandOrgNumber) {
            this.fdemandOrgNumber = fdemandOrgNumber;
        }

        public void setFsupplyName(String fsupplyName) {
            this.fsupplyName = fsupplyName;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public void setFstockerGroupName(String fstockerGroupName) {
            this.fstockerGroupName = fstockerGroupName;
        }

        public void setFproviderContactNumber(String fproviderContactNumber) {
            this.fproviderContactNumber = fproviderContactNumber;
        }

        public void setFpurchaseOrgNumber(String fpurchaseOrgNumber) {
            this.fpurchaseOrgNumber = fpurchaseOrgNumber;
        }

        public void setFsettleNumber(String fsettleNumber) {
            this.fsettleNumber = fsettleNumber;
        }

        public void setFstockerName(String fstockerName) {
            this.fstockerName = fstockerName;
        }

        public void setFsupplierNumber(String fsupplierNumber) {
            this.fsupplierNumber = fsupplierNumber;
        }

        public void setFchargeNumber(String fchargeNumber) {
            this.fchargeNumber = fchargeNumber;
        }

        public void setFproviderContactName(String fproviderContactName) {
            this.fproviderContactName = fproviderContactName;
        }

        public void setFpurchaserGroupName(String fpurchaserGroupName) {
            this.fpurchaserGroupName = fpurchaserGroupName;
        }

        public void setFsupplyNumber(String fsupplyNumber) {
            this.fsupplyNumber = fsupplyNumber;
        }


        public void setFdate(String fdate) {
            this.fdate = fdate;
        }

        public void setFsettleOrgIdName(String fsettleOrgIdName) {
            this.fsettleOrgIdName = fsettleOrgIdName;
        }

        public void setFownerTypeIdHeadNumber(String fownerTypeIdHeadNumber) {
            this.fownerTypeIdHeadNumber = fownerTypeIdHeadNumber;
        }

        public void setFstockerGroupNumber(String fstockerGroupNumber) {
            this.fstockerGroupNumber = fstockerGroupNumber;
        }

        public void setFpurchaserName(String fpurchaserName) {
            this.fpurchaserName = fpurchaserName;
        }

        public void setFstockOrgNumber(String fstockOrgNumber) {
            this.fstockOrgNumber = fstockOrgNumber;
        }

        public void setFchargeName(String fchargeName) {
            this.fchargeName = fchargeName;
        }

        public void setFsupplyAddress(String fsupplyAddress) {
            this.fsupplyAddress = fsupplyAddress;
        }

        public void setFdocumentStatusNumber(String fdocumentStatusNumber) {
            this.fdocumentStatusNumber = fdocumentStatusNumber;
        }

        public void setFdocumentStatus(String fdocumentStatus) {
            this.fdocumentStatus = fdocumentStatus;
        }

        public void setFpurchaserGroupNumber(String fpurchaserGroupNumber) {
            this.fpurchaserGroupNumber = fpurchaserGroupNumber;
        }

        public void setBillNoLike(String billNoLike) {
            this.billNoLike = billNoLike;
        }

        public void setFownerTypeIdHead(String fownerTypeIdHead) {
            this.fownerTypeIdHead = fownerTypeIdHead;
        }

        public void setFbillTypeNumber(String fbillTypeNumber) {
            this.fbillTypeNumber = fbillTypeNumber;
        }

        public void setFsettleCurrIdName(String fsettleCurrIdName) {
            this.fsettleCurrIdName = fsettleCurrIdName;
        }

        public void setFbillNo(String fbillNo) {
            this.fbillNo = fbillNo;
        }

        public int getFid() {
            return fid;
        }

        public String getFdemandOrgName() {
            return fdemandOrgName;
        }

        public String getFstockOrgName() {
            return fstockOrgName;
        }

        public String getFpurchaserNumber() {
            return fpurchaserNumber;
        }

        public String getFpurchaseOrgName() {
            return fpurchaseOrgName;
        }

        public String getFsupplierName() {
            return fsupplierName;
        }

        public String getFbillTypeName() {
            return fbillTypeName;
        }

        public String getLimit() {
            return limit;
        }

        public String getFbusinessTypeNumber() {
            return fbusinessTypeNumber;
        }

        public String getFbusinessType() {
            return fbusinessType;
        }

        public String getFstockDeptNumber() {
            return fstockDeptNumber;
        }

        public String getFsettleOrgIdNumber() {
            return fsettleOrgIdNumber;
        }

        public String getFownerIdName() {
            return fownerIdName;
        }

        public String getFpurchaseDeptName() {
            return fpurchaseDeptName;
        }

        public String getFsettleName() {
            return fsettleName;
        }

        public String getFsettleCurrIdNumber() {
            return fsettleCurrIdNumber;
        }

        public String getFownerIdNumber() {
            return fownerIdNumber;
        }

        public String getFstockDeptName() {
            return fstockDeptName;
        }

        public String getFpurchaseDeptNumber() {
            return fpurchaseDeptNumber;
        }

        public String getFstockerNumber() {
            return fstockerNumber;
        }

        public String getFdemandOrgNumber() {
            return fdemandOrgNumber;
        }

        public String getFsupplyName() {
            return fsupplyName;
        }

        public String getPage() {
            return page;
        }

        public String getFstockerGroupName() {
            return fstockerGroupName;
        }

        public String getFproviderContactNumber() {
            return fproviderContactNumber;
        }

        public String getFpurchaseOrgNumber() {
            return fpurchaseOrgNumber;
        }

        public String getFsettleNumber() {
            return fsettleNumber;
        }

        public String getFstockerName() {
            return fstockerName;
        }

        public String getFsupplierNumber() {
            return fsupplierNumber;
        }

        public String getFchargeNumber() {
            return fchargeNumber;
        }

        public String getFproviderContactName() {
            return fproviderContactName;
        }

        public String getFpurchaserGroupName() {
            return fpurchaserGroupName;
        }

        public String getFsupplyNumber() {
            return fsupplyNumber;
        }

        public String getFdate() {
            return fdate;
        }

        public String getFsettleOrgIdName() {
            return fsettleOrgIdName;
        }

        public String getFownerTypeIdHeadNumber() {
            return fownerTypeIdHeadNumber;
        }

        public String getFstockerGroupNumber() {
            return fstockerGroupNumber;
        }

        public String getFpurchaserName() {
            return fpurchaserName;
        }

        public String getFstockOrgNumber() {
            return fstockOrgNumber;
        }

        public String getFchargeName() {
            return fchargeName;
        }

        public String getFsupplyAddress() {
            return fsupplyAddress;
        }

        public String getFdocumentStatusNumber() {
            return fdocumentStatusNumber;
        }

        public String getFdocumentStatus() {
            return fdocumentStatus;
        }

        public String getFpurchaserGroupNumber() {
            return fpurchaserGroupNumber;
        }

        public String getBillNoLike() {
            return billNoLike;
        }

        public String getFownerTypeIdHead() {
            return fownerTypeIdHead;
        }

        public String getFbillTypeNumber() {
            return fbillTypeNumber;
        }

        public String getFsettleCurrIdName() {
            return fsettleCurrIdName;
        }

        public String getFbillNo() {
            return fbillNo;
        }
    }
}
