package com.kingdee.ah.pda.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.bean
 * @ClassName: ProcessReportDetailBean
 * @Description: java类作用描述
 * @Author: 李浩
 * @CreateDate: 2020/11/3 12:55
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/3 12:55
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ProcessReportDetailBean implements Serializable {

    /**
     * msg : 操作成功
     * code : 0
     * data : {"date":"2020-09-19","prdOrgId":110779,"workShopId":153613,"prdOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","details":[{"materialName":"摆轮分拣机","processFailQty":0,"operNumber":"20","unitName":"Pcs","prdType":"1","quaQty":4,"specification":"1200L*1260W*600H","moNumber":"MO000032","seqNumber":"0","id":100138,"materialId":"01.002.00001","finishQty":4}],"id":100021,"billTypeName":"工序入库汇报","workShopName":"生管部","billNo":"GXHB000017","billTypeId":"001f29d2c9af844211e342cba3aaa38c","totalRptQty":4}
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
         * date : 2020-09-19
         * prdOrgId : 110779
         * workShopId : 153613
         * prdOrgName : 金锋馥（滁州）输送机械有限公司
         * documentStatus : C
         * details : [{"materialName":"摆轮分拣机","processFailQty":0,"operNumber":"20","unitName":"Pcs","prdType":"1","quaQty":4,"specification":"1200L*1260W*600H","moNumber":"MO000032","seqNumber":"0","id":100138,"materialId":"01.002.00001","finishQty":4}]
         * id : 100021
         * billTypeName : 工序入库汇报
         * workShopName : 生管部
         * billNo : GXHB000017
         * billTypeId : 001f29d2c9af844211e342cba3aaa38c
         * totalRptQty : 4
         */
        private String date;
        private int prdOrgId;
        private int workShopId;
        private String prdOrgName;
        private String documentStatus;
        private List<DetailsEntity> details;
        private int id;
        private String billTypeName;
        private String workShopName;
        private String billNo;
        private String billTypeId;
        private int totalRptQty;

        public void setDate(String date) {
            this.date = date;
        }

        public void setPrdOrgId(int prdOrgId) {
            this.prdOrgId = prdOrgId;
        }

        public void setWorkShopId(int workShopId) {
            this.workShopId = workShopId;
        }

        public void setPrdOrgName(String prdOrgName) {
            this.prdOrgName = prdOrgName;
        }

        public void setDocumentStatus(String documentStatus) {
            this.documentStatus = documentStatus;
        }

        public void setDetails(List<DetailsEntity> details) {
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

        public int getPrdOrgId() {
            return prdOrgId;
        }

        public int getWorkShopId() {
            return workShopId;
        }

        public String getPrdOrgName() {
            return prdOrgName;
        }

        public String getDocumentStatus() {
            return documentStatus;
        }

        public List<DetailsEntity> getDetails() {
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

        public class DetailsEntity {
            /**
             * materialName : 摆轮分拣机
             * processFailQty : 0
             * operNumber : 20
             * unitName : Pcs
             * prdType : 1
             * quaQty : 4
             * specification : 1200L*1260W*600H
             * moNumber : MO000032
             * seqNumber : 0
             * id : 100138
             * materialId : 01.002.00001
             * finishQty : 4
             */
            private String materialName;
            private int processFailQty;
            private String operNumber;
            private String unitName;
            private String prdType;
            private int quaQty;
            private String specification;
            private String moNumber;
            private String seqNumber;
            private int id;
            private String materialId;
            private int finishQty;

            public void setMaterialName(String materialName) {
                this.materialName = materialName;
            }

            public void setProcessFailQty(int processFailQty) {
                this.processFailQty = processFailQty;
            }

            public void setOperNumber(String operNumber) {
                this.operNumber = operNumber;
            }

            public void setUnitName(String unitName) {
                this.unitName = unitName;
            }

            public void setPrdType(String prdType) {
                this.prdType = prdType;
            }

            public void setQuaQty(int quaQty) {
                this.quaQty = quaQty;
            }

            public void setSpecification(String specification) {
                this.specification = specification;
            }

            public void setMoNumber(String moNumber) {
                this.moNumber = moNumber;
            }

            public void setSeqNumber(String seqNumber) {
                this.seqNumber = seqNumber;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setMaterialId(String materialId) {
                this.materialId = materialId;
            }

            public void setFinishQty(int finishQty) {
                this.finishQty = finishQty;
            }

            public String getMaterialName() {
                return materialName;
            }

            public int getProcessFailQty() {
                return processFailQty;
            }

            public String getOperNumber() {
                return operNumber;
            }

            public String getUnitName() {
                return unitName;
            }

            public String getPrdType() {
                return prdType;
            }

            public int getQuaQty() {
                return quaQty;
            }

            public String getSpecification() {
                return specification;
            }

            public String getMoNumber() {
                return moNumber;
            }

            public String getSeqNumber() {
                return seqNumber;
            }

            public int getId() {
                return id;
            }

            public String getMaterialId() {
                return materialId;
            }

            public int getFinishQty() {
                return finishQty;
            }
        }
    }
}
