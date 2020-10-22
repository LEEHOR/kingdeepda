package com.jeewms.www.wms.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: ReceivingBillBean
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/16 15:05
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/16 15:05
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ReceiveBillBean implements Serializable {


    /**
     * msg : 操作成功
     * code : 0
     * data : [{"fid":100027,"date":"2020-10-15T00:00:00","freceiveDeptName":null,"fdemandOrgName":"金锋馥（滁州）输送机械有限公司","fstockOrgName":"金锋馥（滁州）输送机械有限公司","fbillType":"标准收料单","billNoLike":null,"fsupplierName":"滁州创伟聚氨酯科技有限公司","limit":null,"documentStatus":"C","fpurOrgName":"金锋馥（滁州）输送机械有限公司","page":null,"fbusinessType":"CG","billNo":"CGSL000020"},{"fid":100028,"date":"2020-10-19T00:00:00","freceiveDeptName":"董事办","fdemandOrgName":"金锋馥（滁州）输送机械有限公司","fstockOrgName":"金锋馥（滁州）输送机械有限公司","fbillType":"标准收料单","billNoLike":null,"fsupplierName":"滁州创伟聚氨酯科技有限公司","limit":null,"documentStatus":"C","fpurOrgName":"金锋馥（滁州）输送机械有限公司","page":null,"fbusinessType":"CG","billNo":"CGSL000021"}]
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

    public class DataEntity implements Serializable {
        /**
         * fid : 100027
         * date : 2020-10-15T00:00:00
         * freceiveDeptName : null
         * fdemandOrgName : 金锋馥（滁州）输送机械有限公司
         * fstockOrgName : 金锋馥（滁州）输送机械有限公司
         * fbillType : 标准收料单
         * billNoLike : null
         * fsupplierName : 滁州创伟聚氨酯科技有限公司
         * limit : null
         * documentStatus : C
         * fpurOrgName : 金锋馥（滁州）输送机械有限公司
         * page : null
         * fbusinessType : CG
         * billNo : CGSL000020
         */
        private int fid;
        private String date;
        private String freceiveDeptName;
        private String fdemandOrgName;
        private String fstockOrgName;
        private String fbillType;
        private String billNoLike;
        private String fsupplierName;
        private String limit;
        private String documentStatus;
        private String fpurOrgName;
        private String page;
        private String fbusinessType;
        private String billNo;

        public void setFid(int fid) {
            this.fid = fid;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setFreceiveDeptName(String freceiveDeptName) {
            this.freceiveDeptName = freceiveDeptName;
        }

        public void setFdemandOrgName(String fdemandOrgName) {
            this.fdemandOrgName = fdemandOrgName;
        }

        public void setFstockOrgName(String fstockOrgName) {
            this.fstockOrgName = fstockOrgName;
        }

        public void setFbillType(String fbillType) {
            this.fbillType = fbillType;
        }

        public void setBillNoLike(String billNoLike) {
            this.billNoLike = billNoLike;
        }

        public void setFsupplierName(String fsupplierName) {
            this.fsupplierName = fsupplierName;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public void setDocumentStatus(String documentStatus) {
            this.documentStatus = documentStatus;
        }

        public void setFpurOrgName(String fpurOrgName) {
            this.fpurOrgName = fpurOrgName;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public void setFbusinessType(String fbusinessType) {
            this.fbusinessType = fbusinessType;
        }

        public void setBillNo(String billNo) {
            this.billNo = billNo;
        }

        public int getFid() {
            return fid;
        }

        public String getDate() {
            return date;
        }

        public String getFreceiveDeptName() {
            return freceiveDeptName;
        }

        public String getFdemandOrgName() {
            return fdemandOrgName;
        }

        public String getFstockOrgName() {
            return fstockOrgName;
        }

        public String getFbillType() {
            return fbillType;
        }

        public String getBillNoLike() {
            return billNoLike;
        }

        public String getFsupplierName() {
            return fsupplierName;
        }

        public String getLimit() {
            return limit;
        }

        public String getDocumentStatus() {
            return documentStatus;
        }

        public String getFpurOrgName() {
            return fpurOrgName;
        }

        public String getPage() {
            return page;
        }

        public String getFbusinessType() {
            return fbusinessType;
        }

        public String getBillNo() {
            return billNo;
        }
    }
}
