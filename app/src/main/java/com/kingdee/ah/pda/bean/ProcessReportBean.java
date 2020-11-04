package com.kingdee.ah.pda.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.bean
 * @ClassName: ProcessReportBean
 * @Description: java类作用描述
 * @Author: 李浩
 * @CreateDate: 2020/11/3 10:45
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/3 10:45
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ProcessReportBean implements Serializable {


    /**
     * msg : 操作成功
     * code : 0
     * data : [{"date":"2020-09-10","prdOrgId":null,"workShopId":null,"prdOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","details":[],"id":100010,"billTypeName":"工序入库汇报","workShopName":"生管部","billNo":"GXHB000007","billTypeId":null,"totalRptQty":5},{"date":"2020-09-10","prdOrgId":null,"workShopId":null,"prdOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","details":[],"id":100007,"billTypeName":"工序入库汇报","workShopName":"生管部","billNo":"GXHB000004","billTypeId":null,"totalRptQty":5},{"date":"2020-09-10","prdOrgId":null,"workShopId":null,"prdOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","details":[],"id":100005,"billTypeName":"工序入库汇报","workShopName":"生管部","billNo":"GXHB000002","billTypeId":null,"totalRptQty":5},{"date":"2020-09-10","prdOrgId":null,"workShopId":null,"prdOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","details":[],"id":100004,"billTypeName":"工序入库汇报","workShopName":"生管部","billNo":"GXHB000001","billTypeId":null,"totalRptQty":5}]
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
         * date : 2020-09-10
         * prdOrgId : null
         * workShopId : null
         * prdOrgName : 金锋馥（滁州）输送机械有限公司
         * documentStatus : C
         * details : []
         * id : 100010
         * billTypeName : 工序入库汇报
         * workShopName : 生管部
         * billNo : GXHB000007
         * billTypeId : null
         * totalRptQty : 5
         */
        private String date;
        private String prdOrgId;
        private String workShopId;
        private String prdOrgName;
        private String documentStatus;
        private List<?> details;
        private int id;
        private String billTypeName;
        private String workShopName;
        private String billNo;
        private String billTypeId;
        private int totalRptQty;

        public void setDate(String date) {
            this.date = date;
        }

        public void setPrdOrgId(String prdOrgId) {
            this.prdOrgId = prdOrgId;
        }

        public void setWorkShopId(String workShopId) {
            this.workShopId = workShopId;
        }

        public void setPrdOrgName(String prdOrgName) {
            this.prdOrgName = prdOrgName;
        }

        public void setDocumentStatus(String documentStatus) {
            this.documentStatus = documentStatus;
        }

        public void setDetails(List<?> details) {
            this.details = details;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setBillTypeName(String billTypeName) {
            this.billTypeName = billTypeName;
        }

        public void setWorkShopName(String workShopName) {
            this.workShopName = workShopName;
        }

        public void setBillNo(String billNo) {
            this.billNo = billNo;
        }

        public void setBillTypeId(String billTypeId) {
            this.billTypeId = billTypeId;
        }

        public void setTotalRptQty(int totalRptQty) {
            this.totalRptQty = totalRptQty;
        }

        public String getDate() {
            return date;
        }

        public String getPrdOrgId() {
            return prdOrgId;
        }

        public String getWorkShopId() {
            return workShopId;
        }

        public String getPrdOrgName() {
            return prdOrgName;
        }

        public String getDocumentStatus() {
            return documentStatus;
        }

        public List<?> getDetails() {
            return details;
        }

        public int getId() {
            return id;
        }

        public String getBillTypeName() {
            return billTypeName;
        }

        public String getWorkShopName() {
            return workShopName;
        }

        public String getBillNo() {
            return billNo;
        }

        public String getBillTypeId() {
            return billTypeId;
        }

        public int getTotalRptQty() {
            return totalRptQty;
        }
    }
}
