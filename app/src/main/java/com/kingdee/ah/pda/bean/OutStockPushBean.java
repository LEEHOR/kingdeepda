package com.kingdee.ah.pda.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.bean
 * @ClassName: OutStockPushBean
 * @Description: java类作用描述
 * @Author: 李浩
 * @CreateDate: 2020/11/3 18:25
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/3 18:25
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class OutStockPushBean implements Serializable {

    /**
     * msg :
     * code : 0
     * data : {"date":"","deptName":"","bizType":"","pickOrgId":0,"pickOrgName":"","stockerGroupId":0,"custId":0,"stockOrgName":"","details":[{"materialName":"","unitName":"","qty":0,"paezProject":"","specification":"","unitId":0,"id":0,"materialId":"","paezProjectName":""}],"documentStatus":"","stockDirect":"","id":0,"billNo":"","billTypeId":"","stockerId":0,"stockerGroupName":"","deptId":0,"ownerIdHead":0,"custName":"","stockerName":"","stockOrgId":0,"ownerNameHead":"","billTypeName":"","pickerId":0,"ownerTypeIdHead":"","pickerName":""}
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
         * date :
         * deptName :
         * bizType :
         * pickOrgId : 0
         * pickOrgName :
         * stockerGroupId : 0
         * custId : 0
         * stockOrgName :
         * details : [{"materialName":"","unitName":"","qty":0,"paezProject":"","specification":"","unitId":0,"id":0,"materialId":"","paezProjectName":""}]
         * documentStatus :
         * stockDirect :
         * id : 0
         * billNo :
         * billTypeId :
         * stockerId : 0
         * stockerGroupName :
         * deptId : 0
         * ownerIdHead : 0
         * custName :
         * stockerName :
         * stockOrgId : 0
         * ownerNameHead :
         * billTypeName :
         * pickerId : 0
         * ownerTypeIdHead :
         * pickerName :
         */
        private String date;
        private String deptName;
        private String bizType;
        private int pickOrgId;
        private String pickOrgName;
        private int stockerGroupId;
        private int custId;
        private String stockOrgName;
        private List<DetailsEntity> details;
        private String documentStatus;
        private String stockDirect;
        private int id;
        private String billNo;
        private String billTypeId;
        private int stockerId;
        private String stockerGroupName;
        private int deptId;
        private int ownerIdHead;
        private String custName;
        private String stockerName;
        private int stockOrgId;
        private String ownerNameHead;
        private String billTypeName;
        private int pickerId;
        private String ownerTypeIdHead;
        private String pickerName;

        public void setDate(String date) {
            this.date = date;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public void setBizType(String bizType) {
            this.bizType = bizType;
        }

        public void setPickOrgId(int pickOrgId) {
            this.pickOrgId = pickOrgId;
        }

        public void setPickOrgName(String pickOrgName) {
            this.pickOrgName = pickOrgName;
        }

        public void setStockerGroupId(int stockerGroupId) {
            this.stockerGroupId = stockerGroupId;
        }

        public void setCustId(int custId) {
            this.custId = custId;
        }

        public void setStockOrgName(String stockOrgName) {
            this.stockOrgName = stockOrgName;
        }

        public void setDetails(List<DetailsEntity> details) {
            this.details = details;
        }

        public void setDocumentStatus(String documentStatus) {
            this.documentStatus = documentStatus;
        }

        public void setStockDirect(String stockDirect) {
            this.stockDirect = stockDirect;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setBillNo(String billNo) {
            this.billNo = billNo;
        }

        public void setBillTypeId(String billTypeId) {
            this.billTypeId = billTypeId;
        }

        public void setStockerId(int stockerId) {
            this.stockerId = stockerId;
        }

        public void setStockerGroupName(String stockerGroupName) {
            this.stockerGroupName = stockerGroupName;
        }

        public void setDeptId(int deptId) {
            this.deptId = deptId;
        }

        public void setOwnerIdHead(int ownerIdHead) {
            this.ownerIdHead = ownerIdHead;
        }

        public void setCustName(String custName) {
            this.custName = custName;
        }

        public void setStockerName(String stockerName) {
            this.stockerName = stockerName;
        }

        public void setStockOrgId(int stockOrgId) {
            this.stockOrgId = stockOrgId;
        }

        public void setOwnerNameHead(String ownerNameHead) {
            this.ownerNameHead = ownerNameHead;
        }

        public void setBillTypeName(String billTypeName) {
            this.billTypeName = billTypeName;
        }

        public void setPickerId(int pickerId) {
            this.pickerId = pickerId;
        }

        public void setOwnerTypeIdHead(String ownerTypeIdHead) {
            this.ownerTypeIdHead = ownerTypeIdHead;
        }

        public void setPickerName(String pickerName) {
            this.pickerName = pickerName;
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

        public int getPickOrgId() {
            return pickOrgId;
        }

        public String getPickOrgName() {
            return pickOrgName;
        }

        public int getStockerGroupId() {
            return stockerGroupId;
        }

        public int getCustId() {
            return custId;
        }

        public String getStockOrgName() {
            return stockOrgName;
        }

        public List<DetailsEntity> getDetails() {
            return details;
        }

        public String getDocumentStatus() {
            return documentStatus;
        }

        public String getStockDirect() {
            return stockDirect;
        }

        public int getId() {
            return id;
        }

        public String getBillNo() {
            return billNo;
        }

        public String getBillTypeId() {
            return billTypeId;
        }

        public int getStockerId() {
            return stockerId;
        }

        public String getStockerGroupName() {
            return stockerGroupName;
        }

        public int getDeptId() {
            return deptId;
        }

        public int getOwnerIdHead() {
            return ownerIdHead;
        }

        public String getCustName() {
            return custName;
        }

        public String getStockerName() {
            return stockerName;
        }

        public int getStockOrgId() {
            return stockOrgId;
        }

        public String getOwnerNameHead() {
            return ownerNameHead;
        }

        public String getBillTypeName() {
            return billTypeName;
        }

        public int getPickerId() {
            return pickerId;
        }

        public String getOwnerTypeIdHead() {
            return ownerTypeIdHead;
        }

        public String getPickerName() {
            return pickerName;
        }

        public class DetailsEntity {
            /**
             * materialName :
             * unitName :
             * qty : 0
             * paezProject :
             * specification :
             * unitId : 0
             * id : 0
             * materialId :
             * paezProjectName :
             */
            private String materialName;
            private String unitName;
            private int qty;
            private String paezProject;
            private String specification;
            private int unitId;
            private int id;
            private String materialId;
            private String paezProjectName;

            public void setMaterialName(String materialName) {
                this.materialName = materialName;
            }

            public void setUnitName(String unitName) {
                this.unitName = unitName;
            }

            public void setQty(int qty) {
                this.qty = qty;
            }

            public void setPaezProject(String paezProject) {
                this.paezProject = paezProject;
            }

            public void setSpecification(String specification) {
                this.specification = specification;
            }

            public void setUnitId(int unitId) {
                this.unitId = unitId;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setMaterialId(String materialId) {
                this.materialId = materialId;
            }

            public void setPaezProjectName(String paezProjectName) {
                this.paezProjectName = paezProjectName;
            }

            public String getMaterialName() {
                return materialName;
            }

            public String getUnitName() {
                return unitName;
            }

            public int getQty() {
                return qty;
            }

            public String getPaezProject() {
                return paezProject;
            }

            public String getSpecification() {
                return specification;
            }

            public int getUnitId() {
                return unitId;
            }

            public int getId() {
                return id;
            }

            public String getMaterialId() {
                return materialId;
            }

            public String getPaezProjectName() {
                return paezProjectName;
            }
        }
    }
}
