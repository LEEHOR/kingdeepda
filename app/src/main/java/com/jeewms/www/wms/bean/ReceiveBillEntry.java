package com.jeewms.www.wms.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: ReceiveBillEntry
 * @Description: java类作用描述
 * 收料通知详情的表体
 * @Author: 作者名
 * @CreateDate: 2020/10/22 16:41
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/22 16:41
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ReceiveBillEntry implements Serializable {

    /**
     * msg : 操作成功
     * code : 0
     * data : [{"fid":100027,"fmaterialSpecification":"2000L*80W*350H","fmaterialNumber":"02.001.0073.000008","projectNumber":"ces003","priceUnitQty":8,"fstockName":null,"entryId":100097,"fmaterialName":"驱动侧板(左)","factreceiveQty":8,"fpredeliveryDate":"2020-10-15T00:00:00","fpurorgName":null,"fauxPropIdProjectName":null,"billNoLike":null,"limit":null,"fdate":null,"fprojectNo":null,"fsupdelQty":8,"documentStatus":null,"funitName":"件","page":null,"projectName":"测试项目003","billNo":null,"fpriceunitName":"件"},{"fid":100027,"fmaterialSpecification":"Ø60*（Ø13）*5T/Q235A/镀锌","fmaterialNumber":"02.001.0245.000013","projectNumber":"cs0001","priceUnitQty":5,"fstockName":null,"entryId":100098,"fmaterialName":"端盖","factreceiveQty":5,"fpredeliveryDate":"2020-10-15T00:00:00","fpurorgName":null,"fauxPropIdProjectName":null,"billNoLike":null,"limit":null,"fdate":null,"fprojectNo":null,"fsupdelQty":5,"documentStatus":null,"funitName":"件","page":null,"projectName":"京东物流转运中心（东南）","billNo":null,"fpriceunitName":"件"}]
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
         * fid : 100027
         * fmaterialSpecification : 2000L*80W*350H
         * fmaterialNumber : 02.001.0073.000008
         * projectNumber : ces003
         * priceUnitQty : 8
         * fstockName : null
         * entryId : 100097
         * fmaterialName : 驱动侧板(左)
         * factreceiveQty : 8
         * fpredeliveryDate : 2020-10-15T00:00:00
         * fpurorgName : null
         * fauxPropIdProjectName : null
         * billNoLike : null
         * limit : null
         * fdate : null
         * fprojectNo : null
         * fsupdelQty : 8
         * documentStatus : null
         * funitName : 件
         * page : null
         * projectName : 测试项目003
         * billNo : null
         * fpriceunitName : 件
         */
        private int fid;
        private String fmaterialSpecification;
        private String fmaterialNumber;
        private String projectNumber;
        private int priceUnitQty;
        private String fstockName;
        private int entryId;
        private String fmaterialName;
        private int factreceiveQty;
        private String fpredeliveryDate;
        private String fpurorgName;
        private String fauxPropIdProjectName;
        private String billNoLike;
        private String limit;
        private String fdate;
        private String fprojectNo;
        private int fsupdelQty;
        private String documentStatus;
        private String funitName;
        private String page;
        private String projectName;
        private String billNo;
        private String fpriceunitName;

        public void setFid(int fid) {
            this.fid = fid;
        }

        public void setFmaterialSpecification(String fmaterialSpecification) {
            this.fmaterialSpecification = fmaterialSpecification;
        }

        public void setFmaterialNumber(String fmaterialNumber) {
            this.fmaterialNumber = fmaterialNumber;
        }

        public void setProjectNumber(String projectNumber) {
            this.projectNumber = projectNumber;
        }

        public void setPriceUnitQty(int priceUnitQty) {
            this.priceUnitQty = priceUnitQty;
        }

        public void setFstockName(String fstockName) {
            this.fstockName = fstockName;
        }

        public void setEntryId(int entryId) {
            this.entryId = entryId;
        }

        public void setFmaterialName(String fmaterialName) {
            this.fmaterialName = fmaterialName;
        }

        public void setFactreceiveQty(int factreceiveQty) {
            this.factreceiveQty = factreceiveQty;
        }

        public void setFpredeliveryDate(String fpredeliveryDate) {
            this.fpredeliveryDate = fpredeliveryDate;
        }

        public void setFpurorgName(String fpurorgName) {
            this.fpurorgName = fpurorgName;
        }

        public void setFauxPropIdProjectName(String fauxPropIdProjectName) {
            this.fauxPropIdProjectName = fauxPropIdProjectName;
        }

        public void setBillNoLike(String billNoLike) {
            this.billNoLike = billNoLike;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public void setFdate(String fdate) {
            this.fdate = fdate;
        }

        public void setFprojectNo(String fprojectNo) {
            this.fprojectNo = fprojectNo;
        }

        public void setFsupdelQty(int fsupdelQty) {
            this.fsupdelQty = fsupdelQty;
        }

        public void setDocumentStatus(String documentStatus) {
            this.documentStatus = documentStatus;
        }

        public void setFunitName(String funitName) {
            this.funitName = funitName;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public void setBillNo(String billNo) {
            this.billNo = billNo;
        }

        public void setFpriceunitName(String fpriceunitName) {
            this.fpriceunitName = fpriceunitName;
        }

        public int getFid() {
            return fid;
        }

        public String getFmaterialSpecification() {
            return fmaterialSpecification;
        }

        public String getFmaterialNumber() {
            return fmaterialNumber;
        }

        public String getProjectNumber() {
            return projectNumber;
        }

        public int getPriceUnitQty() {
            return priceUnitQty;
        }

        public String getFstockName() {
            return fstockName;
        }

        public int getEntryId() {
            return entryId;
        }

        public String getFmaterialName() {
            return fmaterialName;
        }

        public int getFactreceiveQty() {
            return factreceiveQty;
        }

        public String getFpredeliveryDate() {
            return fpredeliveryDate;
        }

        public String getFpurorgName() {
            return fpurorgName;
        }

        public String getFauxPropIdProjectName() {
            return fauxPropIdProjectName;
        }

        public String getBillNoLike() {
            return billNoLike;
        }

        public String getLimit() {
            return limit;
        }

        public String getFdate() {
            return fdate;
        }

        public String getFprojectNo() {
            return fprojectNo;
        }

        public int getFsupdelQty() {
            return fsupdelQty;
        }

        public String getDocumentStatus() {
            return documentStatus;
        }

        public String getFunitName() {
            return funitName;
        }

        public String getPage() {
            return page;
        }

        public String getProjectName() {
            return projectName;
        }

        public String getBillNo() {
            return billNo;
        }

        public String getFpriceunitName() {
            return fpriceunitName;
        }
    }
}
