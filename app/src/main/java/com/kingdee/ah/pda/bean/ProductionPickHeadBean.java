package com.kingdee.ah.pda.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.bean
 * @ClassName: ProductionHeadBean
 * @Description: java类作用描述
 * @Author: 李浩
 * @CreateDate: 2020/11/5 14:01
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/5 14:01
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ProductionPickHeadBean implements Serializable {

    /**
     * msg : 操作成功
     * code : 0
     * data : [{"fid":100002,"fstockOrgNumber":"200","fprdOrgName":"金锋馥（滁州）输送机械有限公司","fprdOrgNumber":"200","fstockOrgName":"金锋馥（滁州）输送机械有限公司","fpickerNumber":null,"fdocumentStatusNumber":"C","fstockName":"成品仓库","fstockername":null,"fbillTypeNumber":"SCLLD02_SYS","fbillTypeName":"倒冲生产领料","fdate":"2020-09-17T00:00:00","fpickerName":null,"fdocumentStatusName":"已审核","fbillNo":"SBKF00000001","fstockFNumber":"CK007","fstockernumber":null}]
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
         * fid : 100002
         * fstockOrgNumber : 200
         * fprdOrgName : 金锋馥（滁州）输送机械有限公司
         * fprdOrgNumber : 200
         * fstockOrgName : 金锋馥（滁州）输送机械有限公司
         * fpickerNumber : null
         * fdocumentStatusNumber : C
         * fstockName : 成品仓库
         * fstockername : null
         * fbillTypeNumber : SCLLD02_SYS
         * fbillTypeName : 倒冲生产领料
         * fdate : 2020-09-17T00:00:00
         * fpickerName : null
         * fdocumentStatusName : 已审核
         * fbillNo : SBKF00000001
         * fstockFNumber : CK007
         * fstockernumber : null
         */
        private int fid;
        private String fstockOrgNumber;
        private String fprdOrgName;
        private String fprdOrgNumber;
        private String fstockOrgName;
        private String fpickerNumber;
        private String fdocumentStatusNumber;
        private String fstockName;
        private String fstockername;
        private String fbillTypeNumber;
        private String fbillTypeName;
        private String fdate;
        private String fpickerName;
        private String fdocumentStatusName;
        private String fbillNo;
        private String fstockFNumber;
        private String fstockernumber;

        public void setFid(int fid) {
            this.fid = fid;
        }

        public void setFstockOrgNumber(String fstockOrgNumber) {
            this.fstockOrgNumber = fstockOrgNumber;
        }

        public void setFprdOrgName(String fprdOrgName) {
            this.fprdOrgName = fprdOrgName;
        }

        public void setFprdOrgNumber(String fprdOrgNumber) {
            this.fprdOrgNumber = fprdOrgNumber;
        }

        public void setFstockOrgName(String fstockOrgName) {
            this.fstockOrgName = fstockOrgName;
        }

        public void setFpickerNumber(String fpickerNumber) {
            this.fpickerNumber = fpickerNumber;
        }

        public void setFdocumentStatusNumber(String fdocumentStatusNumber) {
            this.fdocumentStatusNumber = fdocumentStatusNumber;
        }

        public void setFstockName(String fstockName) {
            this.fstockName = fstockName;
        }

        public void setFstockername(String fstockername) {
            this.fstockername = fstockername;
        }

        public void setFbillTypeNumber(String fbillTypeNumber) {
            this.fbillTypeNumber = fbillTypeNumber;
        }

        public void setFbillTypeName(String fbillTypeName) {
            this.fbillTypeName = fbillTypeName;
        }

        public void setFdate(String fdate) {
            this.fdate = fdate;
        }

        public void setFpickerName(String fpickerName) {
            this.fpickerName = fpickerName;
        }

        public void setFdocumentStatusName(String fdocumentStatusName) {
            this.fdocumentStatusName = fdocumentStatusName;
        }

        public void setFbillNo(String fbillNo) {
            this.fbillNo = fbillNo;
        }

        public void setFstockFNumber(String fstockFNumber) {
            this.fstockFNumber = fstockFNumber;
        }

        public void setFstockernumber(String fstockernumber) {
            this.fstockernumber = fstockernumber;
        }

        public int getFid() {
            return fid;
        }

        public String getFstockOrgNumber() {
            return fstockOrgNumber;
        }

        public String getFprdOrgName() {
            return fprdOrgName;
        }

        public String getFprdOrgNumber() {
            return fprdOrgNumber;
        }

        public String getFstockOrgName() {
            return fstockOrgName;
        }

        public String getFpickerNumber() {
            return fpickerNumber;
        }

        public String getFdocumentStatusNumber() {
            return fdocumentStatusNumber;
        }

        public String getFstockName() {
            return fstockName;
        }

        public String getFstockername() {
            return fstockername;
        }

        public String getFbillTypeNumber() {
            return fbillTypeNumber;
        }

        public String getFbillTypeName() {
            return fbillTypeName;
        }

        public String getFdate() {
            return fdate;
        }

        public String getFpickerName() {
            return fpickerName;
        }

        public String getFdocumentStatusName() {
            return fdocumentStatusName;
        }

        public String getFbillNo() {
            return fbillNo;
        }

        public String getFstockFNumber() {
            return fstockFNumber;
        }

        public String getFstockernumber() {
            return fstockernumber;
        }
    }
}
