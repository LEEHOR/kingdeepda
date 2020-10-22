package com.jeewms.www.wms.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: StkInStockBean
 * @Description: java类作用描述
 * 采购入库保存
 * @Author: 作者名
 * @CreateDate: 2020/10/22 18:32
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/22 18:32
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class StkInStockBean implements Serializable {
    /**
     *单据ID
     */
    private Long fid;
    /**
     *单据类型
     */
    private String fbillTypeName;
    private String FBillTypeNumber;
    /**
     *收料组织
     */
    private String fstockOrgName;
    private String fstockOrgNumber;
    /**
     *采购组织
     */
    private String fpurchaseOrgName;
    private String fpurchaseOrgNumber;
    /**
     *业务类型
     */
    private String fbusinessType;
    private String fbusinessTypeNumber;
    /**
     *收料部门
     */
    private String fstockDeptName;
    private String fstockDeptNumber;
    /**
     *采购部门
     */
    private String fpurchaseDeptName;
    private String fpurchaseDeptNumber;
    /**
     *单据编号
     */
    private String fbillNo;
    private String billNoLike;

    /**
     *库存组
     */
    private String fstockerGroupName;
    private String fstockerGroupNumber;
    /**
     *采购组
     */
    private String fpurchaserGroupName;
    private String fpurchaserGroupNumber;
    /**
     *入库日期
     */
    private String fdate;

    /**
     *仓管员
     */
    private String fstockerName;
    private String fstockerNumber;
    /**
     *仓管员
     */
    private String fpurchaserName;
    private String fpurchaserNumber;
    /**
     *单据状态（Z暂存,A创建,B审核中,C已审核,D重新审核）
     */
    private String fdocumentStatus;
    private String fdocumentStatusNumber;
    /**
     *供应商
     */
    private String fsupplierName;
    private String fsupplierNumber;
    /**
     *需求组织
     */
    private String fdemandOrgName;
    private String fdemandOrgNumber;
    /**
     *供货方
     */
    private String fsupplyName;
    private String fsupplyNumber;
    /**
     *供货方
     */
    private String fproviderContactName;
    private String fproviderContactNumber;
    /**
     *供货方地址
     */
    private String fsupplyAddress;
    /**
     *结算方
     */
    private String fsettleName;
    private String fsettleNumber;
    /**
     *收款方
     */
    private String fchargeName;
    private String fchargeNumber;
    /**
     *货主类型
     */
    private String fownerTypeIdHead;
    private String fownerTypeIdHeadNumber;
    /**
     *货主
     */
    private String fownerIdName;
    private String fownerIdNumber;
    /**
     *  结算组织
     */
    private String fsettleOrgIdName;
    private String fsettleOrgIdNumber;
    /**
     *  FSettleCurrId
     */
    private String fsettleCurrIdName;
    private String fsettleCurrIdNumber;

    private Integer page;

    private Integer limit;

    private List<InStockEntryBean> inStockEntryBeans;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getFbillTypeName() {
        return fbillTypeName;
    }

    public void setFbillTypeName(String fbillTypeName) {
        this.fbillTypeName = fbillTypeName;
    }

    public String getFBillTypeNumber() {
        return FBillTypeNumber;
    }

    public void setFBillTypeNumber(String FBillTypeNumber) {
        this.FBillTypeNumber = FBillTypeNumber;
    }

    public String getFstockOrgName() {
        return fstockOrgName;
    }

    public void setFstockOrgName(String fstockOrgName) {
        this.fstockOrgName = fstockOrgName;
    }

    public String getFstockOrgNumber() {
        return fstockOrgNumber;
    }

    public void setFstockOrgNumber(String fstockOrgNumber) {
        this.fstockOrgNumber = fstockOrgNumber;
    }

    public String getFpurchaseOrgName() {
        return fpurchaseOrgName;
    }

    public void setFpurchaseOrgName(String fpurchaseOrgName) {
        this.fpurchaseOrgName = fpurchaseOrgName;
    }

    public String getFpurchaseOrgNumber() {
        return fpurchaseOrgNumber;
    }

    public void setFpurchaseOrgNumber(String fpurchaseOrgNumber) {
        this.fpurchaseOrgNumber = fpurchaseOrgNumber;
    }

    public String getFbusinessType() {
        return fbusinessType;
    }

    public void setFbusinessType(String fbusinessType) {
        this.fbusinessType = fbusinessType;
    }

    public String getFbusinessTypeNumber() {
        return fbusinessTypeNumber;
    }

    public void setFbusinessTypeNumber(String fbusinessTypeNumber) {
        this.fbusinessTypeNumber = fbusinessTypeNumber;
    }

    public String getFstockDeptName() {
        return fstockDeptName;
    }

    public void setFstockDeptName(String fstockDeptName) {
        this.fstockDeptName = fstockDeptName;
    }

    public String getFstockDeptNumber() {
        return fstockDeptNumber;
    }

    public void setFstockDeptNumber(String fstockDeptNumber) {
        this.fstockDeptNumber = fstockDeptNumber;
    }

    public String getFpurchaseDeptName() {
        return fpurchaseDeptName;
    }

    public void setFpurchaseDeptName(String fpurchaseDeptName) {
        this.fpurchaseDeptName = fpurchaseDeptName;
    }

    public String getFpurchaseDeptNumber() {
        return fpurchaseDeptNumber;
    }

    public void setFpurchaseDeptNumber(String fpurchaseDeptNumber) {
        this.fpurchaseDeptNumber = fpurchaseDeptNumber;
    }

    public String getFbillNo() {
        return fbillNo;
    }

    public void setFbillNo(String fbillNo) {
        this.fbillNo = fbillNo;
    }

    public String getBillNoLike() {
        return billNoLike;
    }

    public void setBillNoLike(String billNoLike) {
        this.billNoLike = billNoLike;
    }

    public String getFstockerGroupName() {
        return fstockerGroupName;
    }

    public void setFstockerGroupName(String fstockerGroupName) {
        this.fstockerGroupName = fstockerGroupName;
    }

    public String getFstockerGroupNumber() {
        return fstockerGroupNumber;
    }

    public void setFstockerGroupNumber(String fstockerGroupNumber) {
        this.fstockerGroupNumber = fstockerGroupNumber;
    }

    public String getFpurchaserGroupName() {
        return fpurchaserGroupName;
    }

    public void setFpurchaserGroupName(String fpurchaserGroupName) {
        this.fpurchaserGroupName = fpurchaserGroupName;
    }

    public String getFpurchaserGroupNumber() {
        return fpurchaserGroupNumber;
    }

    public void setFpurchaserGroupNumber(String fpurchaserGroupNumber) {
        this.fpurchaserGroupNumber = fpurchaserGroupNumber;
    }

    public String getFdate() {
        return fdate;
    }

    public void setFdate(String fdate) {
        this.fdate = fdate;
    }

    public String getFstockerName() {
        return fstockerName;
    }

    public void setFstockerName(String fstockerName) {
        this.fstockerName = fstockerName;
    }

    public String getFstockerNumber() {
        return fstockerNumber;
    }

    public void setFstockerNumber(String fstockerNumber) {
        this.fstockerNumber = fstockerNumber;
    }

    public String getFpurchaserName() {
        return fpurchaserName;
    }

    public void setFpurchaserName(String fpurchaserName) {
        this.fpurchaserName = fpurchaserName;
    }

    public String getFpurchaserNumber() {
        return fpurchaserNumber;
    }

    public void setFpurchaserNumber(String fpurchaserNumber) {
        this.fpurchaserNumber = fpurchaserNumber;
    }

    public String getFdocumentStatus() {
        return fdocumentStatus;
    }

    public void setFdocumentStatus(String fdocumentStatus) {
        this.fdocumentStatus = fdocumentStatus;
    }

    public String getFdocumentStatusNumber() {
        return fdocumentStatusNumber;
    }

    public void setFdocumentStatusNumber(String fdocumentStatusNumber) {
        this.fdocumentStatusNumber = fdocumentStatusNumber;
    }

    public String getFsupplierName() {
        return fsupplierName;
    }

    public void setFsupplierName(String fsupplierName) {
        this.fsupplierName = fsupplierName;
    }

    public String getFsupplierNumber() {
        return fsupplierNumber;
    }

    public void setFsupplierNumber(String fsupplierNumber) {
        this.fsupplierNumber = fsupplierNumber;
    }

    public String getFdemandOrgName() {
        return fdemandOrgName;
    }

    public void setFdemandOrgName(String fdemandOrgName) {
        this.fdemandOrgName = fdemandOrgName;
    }

    public String getFdemandOrgNumber() {
        return fdemandOrgNumber;
    }

    public void setFdemandOrgNumber(String fdemandOrgNumber) {
        this.fdemandOrgNumber = fdemandOrgNumber;
    }

    public String getFsupplyName() {
        return fsupplyName;
    }

    public void setFsupplyName(String fsupplyName) {
        this.fsupplyName = fsupplyName;
    }

    public String getFsupplyNumber() {
        return fsupplyNumber;
    }

    public void setFsupplyNumber(String fsupplyNumber) {
        this.fsupplyNumber = fsupplyNumber;
    }

    public String getFproviderContactName() {
        return fproviderContactName;
    }

    public void setFproviderContactName(String fproviderContactName) {
        this.fproviderContactName = fproviderContactName;
    }

    public String getFproviderContactNumber() {
        return fproviderContactNumber;
    }

    public void setFproviderContactNumber(String fproviderContactNumber) {
        this.fproviderContactNumber = fproviderContactNumber;
    }

    public String getFsupplyAddress() {
        return fsupplyAddress;
    }

    public void setFsupplyAddress(String fsupplyAddress) {
        this.fsupplyAddress = fsupplyAddress;
    }

    public String getFsettleName() {
        return fsettleName;
    }

    public void setFsettleName(String fsettleName) {
        this.fsettleName = fsettleName;
    }

    public String getFsettleNumber() {
        return fsettleNumber;
    }

    public void setFsettleNumber(String fsettleNumber) {
        this.fsettleNumber = fsettleNumber;
    }

    public String getFchargeName() {
        return fchargeName;
    }

    public void setFchargeName(String fchargeName) {
        this.fchargeName = fchargeName;
    }

    public String getFchargeNumber() {
        return fchargeNumber;
    }

    public void setFchargeNumber(String fchargeNumber) {
        this.fchargeNumber = fchargeNumber;
    }

    public String getFownerTypeIdHead() {
        return fownerTypeIdHead;
    }

    public void setFownerTypeIdHead(String fownerTypeIdHead) {
        this.fownerTypeIdHead = fownerTypeIdHead;
    }

    public String getFownerTypeIdHeadNumber() {
        return fownerTypeIdHeadNumber;
    }

    public void setFownerTypeIdHeadNumber(String fownerTypeIdHeadNumber) {
        this.fownerTypeIdHeadNumber = fownerTypeIdHeadNumber;
    }

    public String getFownerIdName() {
        return fownerIdName;
    }

    public void setFownerIdName(String fownerIdName) {
        this.fownerIdName = fownerIdName;
    }

    public String getFownerIdNumber() {
        return fownerIdNumber;
    }

    public void setFownerIdNumber(String fownerIdNumber) {
        this.fownerIdNumber = fownerIdNumber;
    }

    public String getFsettleOrgIdName() {
        return fsettleOrgIdName;
    }

    public void setFsettleOrgIdName(String fsettleOrgIdName) {
        this.fsettleOrgIdName = fsettleOrgIdName;
    }

    public String getFsettleOrgIdNumber() {
        return fsettleOrgIdNumber;
    }

    public void setFsettleOrgIdNumber(String fsettleOrgIdNumber) {
        this.fsettleOrgIdNumber = fsettleOrgIdNumber;
    }

    public String getFsettleCurrIdName() {
        return fsettleCurrIdName;
    }

    public void setFsettleCurrIdName(String fsettleCurrIdName) {
        this.fsettleCurrIdName = fsettleCurrIdName;
    }

    public String getFsettleCurrIdNumber() {
        return fsettleCurrIdNumber;
    }

    public void setFsettleCurrIdNumber(String fsettleCurrIdNumber) {
        this.fsettleCurrIdNumber = fsettleCurrIdNumber;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<InStockEntryBean> getInStockEntryBeans() {
        return inStockEntryBeans;
    }

    public void setInStockEntryBeans(List<InStockEntryBean> inStockEntryBeans) {
        this.inStockEntryBeans = inStockEntryBeans;
    }
}
