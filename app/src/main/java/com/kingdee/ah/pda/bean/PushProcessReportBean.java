package com.kingdee.ah.pda.bean;

import android.content.Intent;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.bean
 * @ClassName: PushProcessReport
 * @Description: java类作用描述
 * @Author: 李浩
 * @CreateDate: 2020/11/3 15:24
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/3 15:24
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class PushProcessReportBean implements Serializable {

    /**
     * msg :
     * code : 0
     * data : {"date":"","fid":0,"prdOrgId":0,"approverid":0,"workshopName":"","ownertypeid":"","ownerId":0,"approverName":"","stockName":"","ownerName":"","approvedate":"","paezProjectId":"","prdOrgName":"","stockId":0,"stockOrgId":0,"stockOrgName":"","workshopid":0,"details":[{"stockLocId":0,"mobillno":"","stockLocName":"","unitName":"","inStockType":"","specification":"","materialId":"","producttype":"","lot":"","materialName":"","realQty":0,"stockName":"","mustQty":0,"stockId":0,"unitId":0,"id":0}],"documentStatus":"","billTypeName":"","billNo":"","paezProjectName":"","billTypeId":""}
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
         * fid : 0
         * prdOrgId : 0
         * approverid : 0
         * workshopName :
         * ownertypeid :
         * ownerId : 0
         * approverName :
         * stockName :
         * ownerName :
         * approvedate :
         * paezProjectId :
         * prdOrgName :
         * stockId : 0
         * stockOrgId : 0
         * stockOrgName :
         * workshopid : 0
         * details : [{"stockLocId":0,"mobillno":"","stockLocName":"","unitName":"","inStockType":"","specification":"","materialId":"","producttype":"","lot":"","materialName":"","realQty":0,"stockName":"","mustQty":0,"stockId":0,"unitId":0,"id":0}]
         * documentStatus :
         * billTypeName :
         * billNo :
         * paezProjectName :
         * billTypeId :
         */
        private String date;
        private int fid;
        private int prdOrgId;
        private int approverid;
        private String workshopName;
        private String ownertypeid;
        private int ownerId;
        private String approverName;
        private String stockName;
        private String ownerName;
        private String approvedate;
        private String paezProjectId;
        private String prdOrgName;
        private int stockId;
        private int stockOrgId;
        private String stockOrgName;
        private int workshopid;
        private List<DetailsEntity> details;
        private String documentStatus;
        private String billTypeName;
        private String billNo;
        private String paezProjectName;
        private String billTypeId;

        public void setDate(String date) {
            this.date = date;
        }

        public void setFid(int fid) {
            this.fid = fid;
        }

        public void setPrdOrgId(int prdOrgId) {
            this.prdOrgId = prdOrgId;
        }

        public void setApproverid(int approverid) {
            this.approverid = approverid;
        }

        public void setWorkshopName(String workshopName) {
            this.workshopName = workshopName;
        }

        public void setOwnertypeid(String ownertypeid) {
            this.ownertypeid = ownertypeid;
        }

        public void setOwnerId(int ownerId) {
            this.ownerId = ownerId;
        }

        public void setApproverName(String approverName) {
            this.approverName = approverName;
        }

        public void setStockName(String stockName) {
            this.stockName = stockName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public void setApprovedate(String approvedate) {
            this.approvedate = approvedate;
        }

        public void setPaezProjectId(String paezProjectId) {
            this.paezProjectId = paezProjectId;
        }

        public void setPrdOrgName(String prdOrgName) {
            this.prdOrgName = prdOrgName;
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

        public void setWorkshopid(int workshopid) {
            this.workshopid = workshopid;
        }

        public void setDetails(List<DetailsEntity> details) {
            this.details = details;
        }

        public void setDocumentStatus(String documentStatus) {
            this.documentStatus = documentStatus;
        }

        public void setBillTypeName(String billTypeName) {
            this.billTypeName = billTypeName;
        }

        public void setBillNo(String billNo) {
            this.billNo = billNo;
        }

        public void setPaezProjectName(String paezProjectName) {
            this.paezProjectName = paezProjectName;
        }

        public void setBillTypeId(String billTypeId) {
            this.billTypeId = billTypeId;
        }

        public String getDate() {
            return date;
        }

        public int getFid() {
            return fid;
        }

        public int getPrdOrgId() {
            return prdOrgId;
        }

        public int getApproverid() {
            return approverid;
        }

        public String getWorkshopName() {
            return workshopName;
        }

        public String getOwnertypeid() {
            return ownertypeid;
        }

        public int getOwnerId() {
            return ownerId;
        }

        public String getApproverName() {
            return approverName;
        }

        public String getStockName() {
            return stockName;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public String getApprovedate() {
            return approvedate;
        }

        public String getPaezProjectId() {
            return paezProjectId;
        }

        public String getPrdOrgName() {
            return prdOrgName;
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

        public int getWorkshopid() {
            return workshopid;
        }

        public List<DetailsEntity> getDetails() {
            return details;
        }

        public String getDocumentStatus() {
            return documentStatus;
        }

        public String getBillTypeName() {
            return billTypeName;
        }

        public String getBillNo() {
            return billNo;
        }

        public String getPaezProjectName() {
            return paezProjectName;
        }

        public String getBillTypeId() {
            return billTypeId;
        }

        public class DetailsEntity {
            /**
             * stockLocId : 0
             * mobillno :
             * stockLocName :
             * unitName :
             * inStockType :
             * specification :
             * materialId :
             * producttype :
             * lot :
             * materialName :
             * realQty : 0
             * stockName :
             * mustQty : 0
             * stockId : 0
             * unitId : 0
             * id : 0
             */
            private int stockLocId;
            private String mobillno;
            private String stockLocName;
            private String unitName;
            private String inStockType;
            private String specification;
            private String materialId;
            private String producttype;
            private String lot;
            private String materialName;
            private int realQty;
            private String stockName;
            private int mustQty;
            private Integer stockId;
            private Integer unitId;
            private int id;

            public void setStockLocId(int stockLocId) {
                this.stockLocId = stockLocId;
            }

            public void setMobillno(String mobillno) {
                this.mobillno = mobillno;
            }

            public void setStockLocName(String stockLocName) {
                this.stockLocName = stockLocName;
            }

            public void setUnitName(String unitName) {
                this.unitName = unitName;
            }

            public void setInStockType(String inStockType) {
                this.inStockType = inStockType;
            }

            public void setSpecification(String specification) {
                this.specification = specification;
            }

            public void setMaterialId(String materialId) {
                this.materialId = materialId;
            }

            public void setProducttype(String producttype) {
                this.producttype = producttype;
            }

            public void setLot(String lot) {
                this.lot = lot;
            }

            public void setMaterialName(String materialName) {
                this.materialName = materialName;
            }


            public void setId(int id) {
                this.id = id;
            }

            public int getStockLocId() {
                return stockLocId;
            }

            public String getMobillno() {
                return mobillno;
            }

            public String getStockLocName() {
                return stockLocName;
            }

            public String getUnitName() {
                return unitName;
            }

            public String getInStockType() {
                return inStockType;
            }

            public String getSpecification() {
                return specification;
            }

            public String getMaterialId() {
                return materialId;
            }

            public String getProducttype() {
                return producttype;
            }

            public String getLot() {
                return lot;
            }

            public String getMaterialName() {
                return materialName;
            }

            public String getStockName() {
                return stockName;
            }

            public int getId() {
                return id;
            }

            public int getRealQty() {
                return realQty;
            }

            public void setRealQty(int realQty) {
                this.realQty = realQty;
            }

            public void setStockName(String stockName) {
                this.stockName = stockName;
            }

            public int getMustQty() {
                return mustQty;
            }

            public void setMustQty(int mustQty) {
                this.mustQty = mustQty;
            }

            public Integer getStockId() {
                return stockId;
            }

            public void setStockId(Integer stockId) {
                this.stockId = stockId;
            }

            public Integer getUnitId() {
                return unitId;
            }

            public void setUnitId(Integer unitId) {
                this.unitId = unitId;
            }
        }
    }
}
