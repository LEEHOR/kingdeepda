package com.kingdee.ah.pda.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.bean
 * @ClassName: OutStockApplyBean
 * @Description: java类作用描述
 * @Author: 李浩
 * @CreateDate: 2020/11/3 17:30
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/3 17:30
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class OutStockApplyBean implements Serializable {

    /**
     * msg : 操作成功
     * code : 0
     * data : [{"date":"2020-09-22","applyType":null,"deptName":"工程部","bizType":null,"deptId":null,"custName":null,"entitys":[],"custId":null,"stockOrgId":null,"stockOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","id":100006,"billTypeName":"标准出库申请","billNo":"CKSQD000002","ownerTypeIdHead":null,"billTypeId":null},{"date":"2020-09-17","applyType":null,"deptName":null,"bizType":null,"deptId":null,"custName":"金锋馥（滁州）输送机械有限公司","entitys":[],"custId":null,"stockOrgId":null,"stockOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","id":100005,"billTypeName":"标准出库申请","billNo":"CKSQD000001","ownerTypeIdHead":null,"billTypeId":null}]
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
         * date : 2020-09-22
         * applyType : null
         * deptName : 工程部
         * bizType : null
         * deptId : null
         * custName : null
         * entitys : []
         * custId : null
         * stockOrgId : null
         * stockOrgName : 金锋馥（滁州）输送机械有限公司
         * documentStatus : C
         * id : 100006
         * billTypeName : 标准出库申请
         * billNo : CKSQD000002
         * ownerTypeIdHead : null
         * billTypeId : null
         */
        private String date;
        private String applyType;
        private String deptName;
        private String bizType;
        private String deptId;
        private String custName;
        private String custId;
        private String stockOrgId;
        private String stockOrgName;
        private String documentStatus;
        private int id;
        private String billTypeName;
        private String billNo;
        private String ownerTypeIdHead;
        private String billTypeId;

        public void setDate(String date) {
            this.date = date;
        }

        public void setApplyType(String applyType) {
            this.applyType = applyType;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public void setBizType(String bizType) {
            this.bizType = bizType;
        }

        public void setDeptId(String deptId) {
            this.deptId = deptId;
        }

        public void setCustName(String custName) {
            this.custName = custName;
        }


        public void setCustId(String custId) {
            this.custId = custId;
        }

        public void setStockOrgId(String stockOrgId) {
            this.stockOrgId = stockOrgId;
        }

        public void setStockOrgName(String stockOrgName) {
            this.stockOrgName = stockOrgName;
        }

        public void setDocumentStatus(String documentStatus) {
            this.documentStatus = documentStatus;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setBillTypeName(String billTypeName) {
            this.billTypeName = billTypeName;
        }

        public void setBillNo(String billNo) {
            this.billNo = billNo;
        }

        public void setOwnerTypeIdHead(String ownerTypeIdHead) {
            this.ownerTypeIdHead = ownerTypeIdHead;
        }

        public void setBillTypeId(String billTypeId) {
            this.billTypeId = billTypeId;
        }

        public String getDate() {
            return date;
        }

        public String getApplyType() {
            return applyType;
        }

        public String getDeptName() {
            return deptName;
        }

        public String getBizType() {
            return bizType;
        }

        public String getDeptId() {
            return deptId;
        }

        public String getCustName() {
            return custName;
        }
        public String getCustId() {
            return custId;
        }

        public String getStockOrgId() {
            return stockOrgId;
        }

        public String getStockOrgName() {
            return stockOrgName;
        }

        public String getDocumentStatus() {
            return documentStatus;
        }

        public int getId() {
            return id;
        }

        public String getBillTypeName() {
            return billTypeName;
        }

        public String getBillNo() {
            return billNo;
        }

        public String getOwnerTypeIdHead() {
            return ownerTypeIdHead;
        }

        public String getBillTypeId() {
            return billTypeId;
        }
    }
}
