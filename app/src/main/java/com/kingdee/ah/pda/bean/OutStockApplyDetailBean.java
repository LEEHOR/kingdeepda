package com.kingdee.ah.pda.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.bean
 * @ClassName: OutStockApplyDetailBean
 * @Description: java类作用描述
 * @Author: 李浩
 * @CreateDate: 2020/11/3 17:59
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/3 17:59
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class OutStockApplyDetailBean implements Serializable {


    /**
     * msg : 操作成功
     * code : 0
     * data : {"date":"2020-09-22","applyType":" ","deptName":"工程部","bizType":"0","deptId":153619,"custName":"","entitys":[{"stockLocId":0,"stockLocName":"","unitName":"台","specification":"1200L*（1800H+200H）*400D","paezProject":"cs002","materialId":"03.01.01.01.0003","ownerId":110779,"materialName":"主控柜","stockName":"","ownerName":"金锋馥（滁州）输送机械有限公司","qty":15,"stockId":0,"unitId":10148,"stockOrgId":110779,"stockOrgName":"金锋馥（滁州）输送机械有限公司","id":100005,"paezProjectName":"京邦达物流转运中心"}],"custId":0,"stockOrgId":110779,"stockOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","id":100006,"billTypeName":"标准出库申请","billNo":"CKSQD000002","ownerTypeIdHead":"BD_OwnerOrg","billTypeId":"59dc3f1c46d65a"}
     */
    private String msg;
    private int code;
    private DataEntity data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public DataEntity getData() {
        return data;
    }

    public class DataEntity {
        /**
         * date : 2020-09-22
         * applyType :
         * deptName : 工程部
         * bizType : 0
         * deptId : 153619
         * custName :
         * entitys : [{"stockLocId":0,"stockLocName":"","unitName":"台","specification":"1200L*（1800H+200H）*400D","paezProject":"cs002","materialId":"03.01.01.01.0003","ownerId":110779,"materialName":"主控柜","stockName":"","ownerName":"金锋馥（滁州）输送机械有限公司","qty":15,"stockId":0,"unitId":10148,"stockOrgId":110779,"stockOrgName":"金锋馥（滁州）输送机械有限公司","id":100005,"paezProjectName":"京邦达物流转运中心"}]
         * custId : 0
         * stockOrgId : 110779
         * stockOrgName : 金锋馥（滁州）输送机械有限公司
         * documentStatus : C
         * id : 100006
         * billTypeName : 标准出库申请
         * billNo : CKSQD000002
         * ownerTypeIdHead : BD_OwnerOrg
         * billTypeId : 59dc3f1c46d65a
         */
        private String date;
        private String applyType;
        private String deptName;
        private String bizType;
        private int deptId;
        private String custName;
        private List<EntitysEntity> entitys;
        private int custId;
        private int stockOrgId;
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

        public void setDeptId(int deptId) {
            this.deptId = deptId;
        }

        public void setCustName(String custName) {
            this.custName = custName;
        }

        public void setEntitys(List<EntitysEntity> entitys) {
            this.entitys = entitys;
        }

        public void setCustId(int custId) {
            this.custId = custId;
        }

        public void setStockOrgId(int stockOrgId) {
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

        public int getDeptId() {
            return deptId;
        }

        public String getCustName() {
            return custName;
        }

        public List<EntitysEntity> getEntitys() {
            return entitys;
        }

        public int getCustId() {
            return custId;
        }

        public int getStockOrgId() {
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

        public class EntitysEntity {
            /**
             * stockLocId : 0
             * stockLocName :
             * unitName : 台
             * specification : 1200L*（1800H+200H）*400D
             * paezProject : cs002
             * materialId : 03.01.01.01.0003
             * ownerId : 110779
             * materialName : 主控柜
             * stockName :
             * ownerName : 金锋馥（滁州）输送机械有限公司
             * qty : 15
             * stockId : 0
             * unitId : 10148
             * stockOrgId : 110779
             * stockOrgName : 金锋馥（滁州）输送机械有限公司
             * id : 100005
             * paezProjectName : 京邦达物流转运中心
             */
            private int stockLocId;
            private String stockLocName;
            private String unitName;
            private String specification;
            private String paezProject;
            private String materialId;
            private int ownerId;
            private String materialName;
            private String stockName;
            private String ownerName;
            private int qty;
            private int stockId;
            private int unitId;
            private int stockOrgId;
            private String stockOrgName;
            private int id;
            private String paezProjectName;

            public void setStockLocId(int stockLocId) {
                this.stockLocId = stockLocId;
            }

            public void setStockLocName(String stockLocName) {
                this.stockLocName = stockLocName;
            }

            public void setUnitName(String unitName) {
                this.unitName = unitName;
            }

            public void setSpecification(String specification) {
                this.specification = specification;
            }

            public void setPaezProject(String paezProject) {
                this.paezProject = paezProject;
            }

            public void setMaterialId(String materialId) {
                this.materialId = materialId;
            }

            public void setOwnerId(int ownerId) {
                this.ownerId = ownerId;
            }

            public void setMaterialName(String materialName) {
                this.materialName = materialName;
            }

            public void setStockName(String stockName) {
                this.stockName = stockName;
            }

            public void setOwnerName(String ownerName) {
                this.ownerName = ownerName;
            }

            public void setQty(int qty) {
                this.qty = qty;
            }

            public void setStockId(int stockId) {
                this.stockId = stockId;
            }

            public void setUnitId(int unitId) {
                this.unitId = unitId;
            }

            public void setStockOrgId(int stockOrgId) {
                this.stockOrgId = stockOrgId;
            }

            public void setStockOrgName(String stockOrgName) {
                this.stockOrgName = stockOrgName;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setPaezProjectName(String paezProjectName) {
                this.paezProjectName = paezProjectName;
            }

            public int getStockLocId() {
                return stockLocId;
            }

            public String getStockLocName() {
                return stockLocName;
            }

            public String getUnitName() {
                return unitName;
            }

            public String getSpecification() {
                return specification;
            }

            public String getPaezProject() {
                return paezProject;
            }

            public String getMaterialId() {
                return materialId;
            }

            public int getOwnerId() {
                return ownerId;
            }

            public String getMaterialName() {
                return materialName;
            }

            public String getStockName() {
                return stockName;
            }

            public String getOwnerName() {
                return ownerName;
            }

            public int getQty() {
                return qty;
            }

            public int getStockId() {
                return stockId;
            }

            public int getUnitId() {
                return unitId;
            }

            public int getStockOrgId() {
                return stockOrgId;
            }

            public String getStockOrgName() {
                return stockOrgName;
            }

            public int getId() {
                return id;
            }

            public String getPaezProjectName() {
                return paezProjectName;
            }
        }
    }
}
