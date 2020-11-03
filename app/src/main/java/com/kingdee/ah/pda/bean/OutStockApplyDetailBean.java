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
     * msg :
     * code : 0
     * data : {"applyType":"","date":"","deptName":"","bizType":"","deptId":0,"custName":"","entitys":[{"stockLocId":0,"stockLocName":"","unitName":"","paezProject":"","specification":"","materialId":"","ownerId":0,"materialName":"","stockName":"","ownerName":"","qty":0,"stockId":0,"stockOrgId":0,"stockOrgName":"","unitId":0,"id":0,"paezProjectName":""}],"custId":0,"stockOrgId":0,"stockOrgName":"","documentStatus":"","id":0,"billTypeName":"","billNo":"","ownerTypeIdHead":"","billTypeId":""}
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
         * applyType :
         * date :
         * deptName :
         * bizType :
         * deptId : 0
         * custName :
         * entitys : [{"stockLocId":0,"stockLocName":"","unitName":"","paezProject":"","specification":"","materialId":"","ownerId":0,"materialName":"","stockName":"","ownerName":"","qty":0,"stockId":0,"stockOrgId":0,"stockOrgName":"","unitId":0,"id":0,"paezProjectName":""}]
         * custId : 0
         * stockOrgId : 0
         * stockOrgName :
         * documentStatus :
         * id : 0
         * billTypeName :
         * billNo :
         * ownerTypeIdHead :
         * billTypeId :
         */
        private String applyType;
        private String date;
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

        public void setApplyType(String applyType) {
            this.applyType = applyType;
        }

        public void setDate(String date) {
            this.date = date;
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

        public String getApplyType() {
            return applyType;
        }

        public String getDate() {
            return date;
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
             * unitName :
             * paezProject :
             * specification :
             * materialId :
             * ownerId : 0
             * materialName :
             * stockName :
             * ownerName :
             * qty : 0
             * stockId : 0
             * stockOrgId : 0
             * stockOrgName :
             * unitId : 0
             * id : 0
             * paezProjectName :
             */
            private int stockLocId;
            private String stockLocName;
            private String unitName;
            private String paezProject;
            private String specification;
            private String materialId;
            private int ownerId;
            private String materialName;
            private String stockName;
            private String ownerName;
            private int qty;
            private int stockId;
            private int stockOrgId;
            private String stockOrgName;
            private int unitId;
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

            public void setPaezProject(String paezProject) {
                this.paezProject = paezProject;
            }

            public void setSpecification(String specification) {
                this.specification = specification;
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

            public void setStockOrgId(int stockOrgId) {
                this.stockOrgId = stockOrgId;
            }

            public void setStockOrgName(String stockOrgName) {
                this.stockOrgName = stockOrgName;
            }

            public void setUnitId(int unitId) {
                this.unitId = unitId;
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

            public String getPaezProject() {
                return paezProject;
            }

            public String getSpecification() {
                return specification;
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

            public int getStockOrgId() {
                return stockOrgId;
            }

            public String getStockOrgName() {
                return stockOrgName;
            }

            public int getUnitId() {
                return unitId;
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
