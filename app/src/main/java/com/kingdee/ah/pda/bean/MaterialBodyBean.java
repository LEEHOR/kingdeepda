package com.kingdee.ah.pda.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.bean
 * @ClassName: MaterialBodyBean
 * @Description: java类作用描述
 * @Author: 李浩
 * @CreateDate: 2020/11/4 10:50
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/4 10:50
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MaterialBodyBean implements Serializable {

    /**
     * msg : 操作成功
     * code : 0
     * data : [{"fid":100042,"funitID2Number":"jian","fuseRate":100,"fmaterialNumber":"02.001.0245.000065","fnumerator":1,"fmaterialTypeNumber":"1","freplaceGroup":1,"ffixScrapQty":0,"fmaterialID2_FErpClsNumber":"自制","fstockName":null,"fmoentrySeq":7,"fdenominator":1,"fmaterialTypeName":"标准件","limit":null,"fscrapRate":0,"documentStatus":null,"fdocumentStatusName":"C","fpickedQty":0,"billNo":"PPBOM00000019","fmaterialID2Specification":"1260L*3000W*120H/Q235A","fstockNumber":null,"fmaterialID2_FErpClsName":"2","fdocumentStatusNumber":"已审核","f_PBXQ_SL1":0,"fmaterialID2Number":"02.001.0245.000066","funitID2Name":"件","billNoLike":null,"fmaterialID2Name":"中间机身主板","fmustQty":40,"page":null,"fmobillNO":"MO000007"},{"fid":100042,"funitID2Number":"m","fuseRate":100,"fmaterialNumber":"02.001.0245.000065","fnumerator":3.75,"fmaterialTypeNumber":"1","freplaceGroup":2,"ffixScrapQty":0,"fmaterialID2_FErpClsNumber":"外购","fstockName":null,"fmoentrySeq":7,"fdenominator":1,"fmaterialTypeName":"标准件","limit":null,"fscrapRate":0,"documentStatus":null,"fdocumentStatusName":"C","fpickedQty":0,"billNo":"PPBOM00000019","fmaterialID2Specification":"30*30*3/Q235","fstockNumber":null,"fmaterialID2_FErpClsName":"1","fdocumentStatusNumber":"已审核","f_PBXQ_SL1":0,"fmaterialID2Number":"04.04.019.00016","funitID2Name":"米","billNoLike":null,"fmaterialID2Name":"等边角铁","fmustQty":150,"page":null,"fmobillNO":"MO000007"}]
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
         * fid : 100042
         * funitID2Number : jian
         * fuseRate : 100
         * fmaterialNumber : 02.001.0245.000065
         * fnumerator : 1
         * fmaterialTypeNumber : 1
         * freplaceGroup : 1
         * ffixScrapQty : 0
         * fmaterialID2_FErpClsNumber : 自制
         * fstockName : null
         * fmoentrySeq : 7
         * fdenominator : 1
         * fmaterialTypeName : 标准件
         * limit : null
         * fscrapRate : 0
         * documentStatus : null
         * fdocumentStatusName : C
         * fpickedQty : 0
         * billNo : PPBOM00000019
         * fmaterialID2Specification : 1260L*3000W*120H/Q235A
         * fstockNumber : null
         * fmaterialID2_FErpClsName : 2
         * fdocumentStatusNumber : 已审核
         * f_PBXQ_SL1 : 0
         * fmaterialID2Number : 02.001.0245.000066
         * funitID2Name : 件
         * billNoLike : null
         * fmaterialID2Name : 中间机身主板
         * fmustQty : 40
         * page : null
         * fmobillNO : MO000007
         */
        private int fid;
        private String funitID2Number;
        private BigDecimal fuseRate;
        private String fmaterialNumber;
        private BigDecimal fnumerator;
        private String fmaterialTypeNumber;
        private int freplaceGroup;
        private BigDecimal ffixScrapQty;
        private String fmaterialID2_FErpClsNumber;
        private String fstockName;
        private BigDecimal fmoentrySeq;
        private BigDecimal fdenominator;
        private String fmaterialTypeName;
        private String limit;
        private BigDecimal fscrapRate;
        private String documentStatus;
        private String fdocumentStatusName;
        private BigDecimal fpickedQty;
        private String billNo;
        private String fmaterialID2Specification;
        private String fstockNumber;
        private String fmaterialID2_FErpClsName;
        private String fdocumentStatusNumber;
        private BigDecimal f_PBXQ_SL1;
        private String fmaterialID2Number;
        private String funitID2Name;
        private String billNoLike;
        private String fmaterialID2Name;
        private BigDecimal fmustQty;
        private String page;
        private String fmobillNO;

        public int getFid() {
            return fid;
        }

        public void setFid(int fid) {
            this.fid = fid;
        }

        public String getFunitID2Number() {
            return funitID2Number;
        }

        public void setFunitID2Number(String funitID2Number) {
            this.funitID2Number = funitID2Number;
        }

        public BigDecimal getFuseRate() {
            return fuseRate;
        }

        public void setFuseRate(BigDecimal fuseRate) {
            this.fuseRate = fuseRate;
        }

        public String getFmaterialNumber() {
            return fmaterialNumber;
        }

        public void setFmaterialNumber(String fmaterialNumber) {
            this.fmaterialNumber = fmaterialNumber;
        }

        public BigDecimal getFnumerator() {
            return fnumerator;
        }

        public void setFnumerator(BigDecimal fnumerator) {
            this.fnumerator = fnumerator;
        }

        public String getFmaterialTypeNumber() {
            return fmaterialTypeNumber;
        }

        public void setFmaterialTypeNumber(String fmaterialTypeNumber) {
            this.fmaterialTypeNumber = fmaterialTypeNumber;
        }

        public int getFreplaceGroup() {
            return freplaceGroup;
        }

        public void setFreplaceGroup(int freplaceGroup) {
            this.freplaceGroup = freplaceGroup;
        }

        public BigDecimal getFfixScrapQty() {
            return ffixScrapQty;
        }

        public void setFfixScrapQty(BigDecimal ffixScrapQty) {
            this.ffixScrapQty = ffixScrapQty;
        }

        public String getFmaterialID2_FErpClsNumber() {
            return fmaterialID2_FErpClsNumber;
        }

        public void setFmaterialID2_FErpClsNumber(String fmaterialID2_FErpClsNumber) {
            this.fmaterialID2_FErpClsNumber = fmaterialID2_FErpClsNumber;
        }

        public String getFstockName() {
            return fstockName;
        }

        public void setFstockName(String fstockName) {
            this.fstockName = fstockName;
        }

        public BigDecimal getFmoentrySeq() {
            return fmoentrySeq;
        }

        public void setFmoentrySeq(BigDecimal fmoentrySeq) {
            this.fmoentrySeq = fmoentrySeq;
        }

        public BigDecimal getFdenominator() {
            return fdenominator;
        }

        public void setFdenominator(BigDecimal fdenominator) {
            this.fdenominator = fdenominator;
        }

        public String getFmaterialTypeName() {
            return fmaterialTypeName;
        }

        public void setFmaterialTypeName(String fmaterialTypeName) {
            this.fmaterialTypeName = fmaterialTypeName;
        }

        public String getLimit() {
            return limit;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public BigDecimal getFscrapRate() {
            return fscrapRate;
        }

        public void setFscrapRate(BigDecimal fscrapRate) {
            this.fscrapRate = fscrapRate;
        }

        public String getDocumentStatus() {
            return documentStatus;
        }

        public void setDocumentStatus(String documentStatus) {
            this.documentStatus = documentStatus;
        }

        public String getFdocumentStatusName() {
            return fdocumentStatusName;
        }

        public void setFdocumentStatusName(String fdocumentStatusName) {
            this.fdocumentStatusName = fdocumentStatusName;
        }

        public BigDecimal getFpickedQty() {
            return fpickedQty;
        }

        public void setFpickedQty(BigDecimal fpickedQty) {
            this.fpickedQty = fpickedQty;
        }

        public String getBillNo() {
            return billNo;
        }

        public void setBillNo(String billNo) {
            this.billNo = billNo;
        }

        public String getFmaterialID2Specification() {
            return fmaterialID2Specification;
        }

        public void setFmaterialID2Specification(String fmaterialID2Specification) {
            this.fmaterialID2Specification = fmaterialID2Specification;
        }

        public String getFstockNumber() {
            return fstockNumber;
        }

        public void setFstockNumber(String fstockNumber) {
            this.fstockNumber = fstockNumber;
        }

        public String getFmaterialID2_FErpClsName() {
            return fmaterialID2_FErpClsName;
        }

        public void setFmaterialID2_FErpClsName(String fmaterialID2_FErpClsName) {
            this.fmaterialID2_FErpClsName = fmaterialID2_FErpClsName;
        }

        public String getFdocumentStatusNumber() {
            return fdocumentStatusNumber;
        }

        public void setFdocumentStatusNumber(String fdocumentStatusNumber) {
            this.fdocumentStatusNumber = fdocumentStatusNumber;
        }

        public BigDecimal getF_PBXQ_SL1() {
            return f_PBXQ_SL1;
        }

        public void setF_PBXQ_SL1(BigDecimal f_PBXQ_SL1) {
            this.f_PBXQ_SL1 = f_PBXQ_SL1;
        }

        public String getFmaterialID2Number() {
            return fmaterialID2Number;
        }

        public void setFmaterialID2Number(String fmaterialID2Number) {
            this.fmaterialID2Number = fmaterialID2Number;
        }

        public String getFunitID2Name() {
            return funitID2Name;
        }

        public void setFunitID2Name(String funitID2Name) {
            this.funitID2Name = funitID2Name;
        }

        public String getBillNoLike() {
            return billNoLike;
        }

        public void setBillNoLike(String billNoLike) {
            this.billNoLike = billNoLike;
        }

        public String getFmaterialID2Name() {
            return fmaterialID2Name;
        }

        public void setFmaterialID2Name(String fmaterialID2Name) {
            this.fmaterialID2Name = fmaterialID2Name;
        }

        public BigDecimal getFmustQty() {
            return fmustQty;
        }

        public void setFmustQty(BigDecimal fmustQty) {
            this.fmustQty = fmustQty;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getFmobillNO() {
            return fmobillNO;
        }

        public void setFmobillNO(String fmobillNO) {
            this.fmobillNO = fmobillNO;
        }
    }
}
