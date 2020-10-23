package com.jeewms.www.wms.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: InStockAdd
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/23 18:16
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/23 18:16
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class InStockAdd implements Serializable {

    /**
     * fid : 100043
     * fdemandOrgName : 金锋馥（滁州）输送机械有限公司
     * fstockOrgName : 金锋馥（滁州）输送机械有限公司
     * fpurchaserNumber : 0031
     * fpurchaseOrgName : 金锋馥（滁州）输送机械有限公司
     * fsupplierName : 滁州创伟聚氨酯科技有限公司
     * fbillTypeName : 标准采购入库
     * limit : null
     * fbusinessTypeNumber : CG
     * fbusinessType : 标准采购
     * fstockDeptNumber : JHF0009
     * fsettleOrgIdNumber : 200
     * fownerIdName : 金锋馥（滁州）输送机械有限公司
     * fpurchaseDeptName : 采购部
     * fsettleName : 滁州创伟聚氨酯科技有限公司
     * fsettleCurrIdNumber : PRE001
     * fownerIdNumber : 200
     * fstockDeptName : 仓库
     * fpurchaseDeptNumber : JHF0005
     * fstockerNumber : 0040
     * fdemandOrgNumber : 200
     * fsupplyName : 滁州创伟聚氨酯科技有限公司
     * page : null
     * fproviderContactNumber : null
     * fstockerGroupName : null
     * fpurchaseOrgNumber : 200
     * fsettleNumber : 1010008
     * fstockerName : 方园园
     * fsupplierNumber : 1010008
     * fchargeNumber : 1010008
     * fproviderContactName : null
     * fpurchaserGroupName : null
     * fsupplyNumber : 1010008
     * stkInStockEntryVoList : [{"fid":null,"flotNumber":null,"fremainInStockUnitNumber":"tai","ff100001Mame":"测试项目003","ftaxNetPrice":0,"fmaterialNumber":"01.001.00001","fnote":" ","ff100001Mumber":"ces003","fstockName":"钢材仓库","funitNumber":"tai","fremainInStockQty":10,"fgiveAway":"false","fpriceUnitName":"台","fspecification":"12000L*1260W*710H","limit":null,"funitName":"台","flotName":null,"fentryId":100124,"fremainInStockUnitName":"台","fstockNumber":"CK002","fwwinType":null,"projectNumber":"测试101501","fmaterialName":"平面皮带机","fpriceUnitNumber":"tai","frealQty":10,"fstockStatusName":"可用","fmustQty":10,"fwwinTypeNumber":" ","fpriceUnitQty":10,"page":null,"projectName":"测试101501","fstockStatusNumber":"KCZT01_SYS"}]
     * fdate : 2020-10-23T00:00:00
     * fsettleOrgIdName : 金锋馥（滁州）输送机械有限公司
     * fownerTypeIdHeadNumber : BD_OwnerOrg
     * fpurchaserName : 林美珍
     * fstockerGroupNumber : null
     * fchargeName : 滁州创伟聚氨酯科技有限公司
     * fstockOrgNumber : 200
     * fsupplyAddress :
     * fdocumentStatusNumber : A
     * fdocumentStatus : 创建
     * fpurchaserGroupNumber : null
     * billNoLike : null
     * fbillTypeNumber : RKD01_SYS
     * fownerTypeIdHead : 业务组织
     * fsettleCurrIdName : 人民币
     * fbillNo : CGRK00027
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
    private String fsettleCurrId;
    private String fownerIdNumber;
    private String fstockDeptName;
    private String fpurchaseDeptNumber;
    private String fstockerNumber;
    private String fdemandOrgNumber;
    private String fsupplyName;
    private String page;
    private String fproviderContactNumber;
    private String fstockerGroupName;
    private String fpurchaseOrgNumber;
    private String fsettleNumber;
    private String fstockerName;
    private String FSupplierId;
    private String fchargeNumber;
    private String fproviderContactName;
    private String fpurchaserGroupName;
    private String fsupplyNumber;
    private List<StkInStockEntryVoListEntity> stkInStockEntryVoList;
    private String fdate;
    private String fsettleOrgIdName;
    private String fownerTypeIdHeadNumber;
    private String fpurchaserName;
    private String fstockerGroupNumber;
    private String fchargeName;
    private String fstockOrgNumber;
    private String fsupplyAddress;
    private String fdocumentStatusNumber;
    private String fdocumentStatus;
    private String fpurchaserGroupNumber;
    private String billNoLike;
    private String fbillTypeNumber;
    private String fownerTypeIdHead;
    private String fsettleCurrIdName;
    private String fbillNo;
    List<InStockEntryBean.DataEntity> dataEntityList;

    public List<InStockEntryBean.DataEntity> getDataEntityList() {
        return dataEntityList;
    }

    public void setDataEntityList(List<InStockEntryBean.DataEntity> dataEntityList) {
        this.dataEntityList = dataEntityList;
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

    public void setFproviderContactNumber(String fproviderContactNumber) {
        this.fproviderContactNumber = fproviderContactNumber;
    }

    public void setFstockerGroupName(String fstockerGroupName) {
        this.fstockerGroupName = fstockerGroupName;
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

    public void setStkInStockEntryVoList(List<StkInStockEntryVoListEntity> stkInStockEntryVoList) {
        this.stkInStockEntryVoList = stkInStockEntryVoList;
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

    public void setFpurchaserName(String fpurchaserName) {
        this.fpurchaserName = fpurchaserName;
    }

    public void setFstockerGroupNumber(String fstockerGroupNumber) {
        this.fstockerGroupNumber = fstockerGroupNumber;
    }

    public void setFchargeName(String fchargeName) {
        this.fchargeName = fchargeName;
    }

    public void setFstockOrgNumber(String fstockOrgNumber) {
        this.fstockOrgNumber = fstockOrgNumber;
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

    public void setFbillTypeNumber(String fbillTypeNumber) {
        this.fbillTypeNumber = fbillTypeNumber;
    }

    public void setFownerTypeIdHead(String fownerTypeIdHead) {
        this.fownerTypeIdHead = fownerTypeIdHead;
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

    public String getFproviderContactNumber() {
        return fproviderContactNumber;
    }

    public String getFstockerGroupName() {
        return fstockerGroupName;
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

    public String getFchargeNumber() {
        return fchargeNumber;
    }

    public String getFsettleCurrId() {
        return fsettleCurrId;
    }

    public void setFsettleCurrId(String fsettleCurrId) {
        this.fsettleCurrId = fsettleCurrId;
    }

    public String getFSupplierId() {
        return FSupplierId;
    }

    public void setFSupplierId(String FSupplierId) {
        this.FSupplierId = FSupplierId;
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

    public List<StkInStockEntryVoListEntity> getStkInStockEntryVoList() {
        return stkInStockEntryVoList;
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

    public String getFpurchaserName() {
        return fpurchaserName;
    }

    public String getFstockerGroupNumber() {
        return fstockerGroupNumber;
    }

    public String getFchargeName() {
        return fchargeName;
    }

    public String getFstockOrgNumber() {
        return fstockOrgNumber;
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

    public String getFbillTypeNumber() {
        return fbillTypeNumber;
    }

    public String getFownerTypeIdHead() {
        return fownerTypeIdHead;
    }

    public String getFsettleCurrIdName() {
        return fsettleCurrIdName;
    }

    public String getFbillNo() {
        return fbillNo;
    }

    public class StkInStockEntryVoListEntity {
        /**
         * fid : null
         * flotNumber : null
         * fremainInStockUnitNumber : tai
         * ff100001Mame : 测试项目003
         * ftaxNetPrice : 0
         * fmaterialNumber : 01.001.00001
         * fnote :
         * ff100001Mumber : ces003
         * fstockName : 钢材仓库
         * funitNumber : tai
         * fremainInStockQty : 10
         * fgiveAway : false
         * fpriceUnitName : 台
         * fspecification : 12000L*1260W*710H
         * limit : null
         * funitName : 台
         * flotName : null
         * fentryId : 100124
         * fremainInStockUnitName : 台
         * fstockNumber : CK002
         * fwwinType : null
         * projectNumber : 测试101501
         * fmaterialName : 平面皮带机
         * fpriceUnitNumber : tai
         * frealQty : 10
         * fstockStatusName : 可用
         * fmustQty : 10
         * fwwinTypeNumber :
         * fpriceUnitQty : 10
         * page : null
         * projectName : 测试101501
         * fstockStatusNumber : KCZT01_SYS
         */
        private String fid;
        private String flotNumber;
        private String fremainInStockUnitNumber;
        private String ff100001Mame;
        private int ftaxNetPrice;
        private String fmaterialNumber;
        private String fnote;
        private String ff100001Mumber;
        private String fstockName;
        private String funitNumber;
        private int fremainInStockQty;
        private String fgiveAway;
        private String fpriceUnitName;
        private String fspecification;
        private String limit;
        private String funitName;
        private String flotName;
        private int fentryId;
        private String fremainInStockUnitName;
        private String fstockNumber;
        private String fwwinType;
        private String projectNumber;
        private String fmaterialName;
        private String fpriceUnitNumber;
        private int frealQty;
        private String fstockStatusName;
        private int fmustQty;
        private String fwwinTypeNumber;
        private int fpriceUnitQty;
        private String page;
        private String projectName;
        private String fstockStatusNumber;

        public void setFid(String fid) {
            this.fid = fid;
        }

        public void setFlotNumber(String flotNumber) {
            this.flotNumber = flotNumber;
        }

        public void setFremainInStockUnitNumber(String fremainInStockUnitNumber) {
            this.fremainInStockUnitNumber = fremainInStockUnitNumber;
        }

        public void setFf100001Mame(String ff100001Mame) {
            this.ff100001Mame = ff100001Mame;
        }

        public void setFtaxNetPrice(int ftaxNetPrice) {
            this.ftaxNetPrice = ftaxNetPrice;
        }

        public void setFmaterialNumber(String fmaterialNumber) {
            this.fmaterialNumber = fmaterialNumber;
        }

        public void setFnote(String fnote) {
            this.fnote = fnote;
        }

        public void setFf100001Mumber(String ff100001Mumber) {
            this.ff100001Mumber = ff100001Mumber;
        }

        public void setFstockName(String fstockName) {
            this.fstockName = fstockName;
        }

        public void setFunitNumber(String funitNumber) {
            this.funitNumber = funitNumber;
        }

        public void setFremainInStockQty(int fremainInStockQty) {
            this.fremainInStockQty = fremainInStockQty;
        }

        public void setFgiveAway(String fgiveAway) {
            this.fgiveAway = fgiveAway;
        }

        public void setFpriceUnitName(String fpriceUnitName) {
            this.fpriceUnitName = fpriceUnitName;
        }

        public void setFspecification(String fspecification) {
            this.fspecification = fspecification;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public void setFunitName(String funitName) {
            this.funitName = funitName;
        }

        public void setFlotName(String flotName) {
            this.flotName = flotName;
        }

        public void setFentryId(int fentryId) {
            this.fentryId = fentryId;
        }

        public void setFremainInStockUnitName(String fremainInStockUnitName) {
            this.fremainInStockUnitName = fremainInStockUnitName;
        }

        public void setFstockNumber(String fstockNumber) {
            this.fstockNumber = fstockNumber;
        }

        public void setFwwinType(String fwwinType) {
            this.fwwinType = fwwinType;
        }

        public void setProjectNumber(String projectNumber) {
            this.projectNumber = projectNumber;
        }

        public void setFmaterialName(String fmaterialName) {
            this.fmaterialName = fmaterialName;
        }

        public void setFpriceUnitNumber(String fpriceUnitNumber) {
            this.fpriceUnitNumber = fpriceUnitNumber;
        }

        public void setFrealQty(int frealQty) {
            this.frealQty = frealQty;
        }

        public void setFstockStatusName(String fstockStatusName) {
            this.fstockStatusName = fstockStatusName;
        }

        public void setFmustQty(int fmustQty) {
            this.fmustQty = fmustQty;
        }

        public void setFwwinTypeNumber(String fwwinTypeNumber) {
            this.fwwinTypeNumber = fwwinTypeNumber;
        }

        public void setFpriceUnitQty(int fpriceUnitQty) {
            this.fpriceUnitQty = fpriceUnitQty;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public void setFstockStatusNumber(String fstockStatusNumber) {
            this.fstockStatusNumber = fstockStatusNumber;
        }

        public String getFid() {
            return fid;
        }

        public String getFlotNumber() {
            return flotNumber;
        }

        public String getFremainInStockUnitNumber() {
            return fremainInStockUnitNumber;
        }

        public String getFf100001Mame() {
            return ff100001Mame;
        }

        public int getFtaxNetPrice() {
            return ftaxNetPrice;
        }

        public String getFmaterialNumber() {
            return fmaterialNumber;
        }

        public String getFnote() {
            return fnote;
        }

        public String getFf100001Mumber() {
            return ff100001Mumber;
        }

        public String getFstockName() {
            return fstockName;
        }

        public String getFunitNumber() {
            return funitNumber;
        }

        public int getFremainInStockQty() {
            return fremainInStockQty;
        }

        public String getFgiveAway() {
            return fgiveAway;
        }

        public String getFpriceUnitName() {
            return fpriceUnitName;
        }

        public String getFspecification() {
            return fspecification;
        }

        public String getLimit() {
            return limit;
        }

        public String getFunitName() {
            return funitName;
        }

        public String getFlotName() {
            return flotName;
        }

        public int getFentryId() {
            return fentryId;
        }

        public String getFremainInStockUnitName() {
            return fremainInStockUnitName;
        }

        public String getFstockNumber() {
            return fstockNumber;
        }

        public String getFwwinType() {
            return fwwinType;
        }

        public String getProjectNumber() {
            return projectNumber;
        }

        public String getFmaterialName() {
            return fmaterialName;
        }

        public String getFpriceUnitNumber() {
            return fpriceUnitNumber;
        }

        public int getFrealQty() {
            return frealQty;
        }

        public String getFstockStatusName() {
            return fstockStatusName;
        }

        public int getFmustQty() {
            return fmustQty;
        }

        public String getFwwinTypeNumber() {
            return fwwinTypeNumber;
        }

        public int getFpriceUnitQty() {
            return fpriceUnitQty;
        }

        public String getPage() {
            return page;
        }

        public String getProjectName() {
            return projectName;
        }

        public String getFstockStatusNumber() {
            return fstockStatusNumber;
        }
    }
}
