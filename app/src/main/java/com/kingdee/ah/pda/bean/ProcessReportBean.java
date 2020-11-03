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
     * data : [{"date":"2020-09-19","prdOrgId":null,"workShopId":null,"prdOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","details":[],"id":100021,"billTypeName":"工序入库汇报","workShopName":"生管部","billNo":"GXHB000017","billTypeId":null,"totalRptQty":4},{"date":"2020-09-19","prdOrgId":null,"workShopId":null,"prdOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","details":[],"id":100020,"billTypeName":"工序入库汇报","workShopName":"生管部","billNo":"GXHB000016","billTypeId":null,"totalRptQty":5},{"date":"2020-09-18","prdOrgId":null,"workShopId":null,"prdOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","details":[],"id":100019,"billTypeName":"工序入库汇报","workShopName":"生管部","billNo":"GXHB000015","billTypeId":null,"totalRptQty":6},{"date":"2020-09-17","prdOrgId":null,"workShopId":null,"prdOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","details":[],"id":100018,"billTypeName":"工序入库汇报","workShopName":"生管部","billNo":"GXHB000014","billTypeId":null,"totalRptQty":4},{"date":"2020-09-17","prdOrgId":null,"workShopId":null,"prdOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","details":[],"id":100017,"billTypeName":"工序入库汇报","workShopName":"生管部","billNo":"GXHB000013","billTypeId":null,"totalRptQty":4},{"date":"2020-09-11","prdOrgId":null,"workShopId":null,"prdOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","details":[],"id":100015,"billTypeName":"工序入库汇报","workShopName":"生管部","billNo":"GXHB000012","billTypeId":null,"totalRptQty":164},{"date":"2020-09-11","prdOrgId":null,"workShopId":null,"prdOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","details":[],"id":100014,"billTypeName":"工序入库汇报","workShopName":"生管部","billNo":"GXHB000011","billTypeId":null,"totalRptQty":4349},{"date":"2020-09-11","prdOrgId":null,"workShopId":null,"prdOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","details":[],"id":100013,"billTypeName":"工序入库汇报","workShopName":"生管部","billNo":"GXHB000010","billTypeId":null,"totalRptQty":9},{"date":"2020-09-11","prdOrgId":null,"workShopId":null,"prdOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","details":[],"id":100012,"billTypeName":"工序入库汇报","workShopName":"生管部","billNo":"GXHB000009","billTypeId":null,"totalRptQty":10},{"date":"2020-09-10","prdOrgId":null,"workShopId":null,"prdOrgName":"金锋馥（滁州）输送机械有限公司","documentStatus":"C","details":[],"id":100011,"billTypeName":"工序入库汇报","workShopName":"生管部","billNo":"GXHB000008","billTypeId":null,"totalRptQty":1}]
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
         * date : 2020-09-19
         * prdOrgId : null
         * workShopId : null
         * prdOrgName : 金锋馥（滁州）输送机械有限公司
         * documentStatus : C
         * details : []
         * id : 100021
         * billTypeName : 工序入库汇报
         * workShopName : 生管部
         * billNo : GXHB000017
         * billTypeId : null
         * totalRptQty : 4
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
