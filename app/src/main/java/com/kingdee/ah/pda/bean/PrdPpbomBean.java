package com.kingdee.ah.pda.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.bean
 * @ClassName: PrdPpbomBean
 * @Description: java类作用描述
 * @Author: 李浩
 * @CreateDate: 2020/11/3 19:42
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/3 19:42
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class PrdPpbomBean implements Serializable {

    /**
     * msg : 操作成功
     * code : 0
     * data : [{"fid":100005,"funitID2Number":"jian","fmaterialNumber":"01.001.00003","fnumerator":2,"fmaterialTypeNumber":"1","fmaterialID2_FErpClsNumber":"自制","fstockName":null,"fmoentrySeq":1,"fdenominator":1,"fmaterialTypeName":"标准件","limit":null,"documentStatus":null,"fdocumentStatusName":"C","fpickedQty":0,"billNo":"PPBOM00000003","fmaterialID2Specification":"155L*110W*43H/3T/Q235A/喷塑","fstockNumber":null,"fmaterialID2_FErpClsName":"2","fdocumentStatusNumber":"已审核","fmaterialID2Number":"02.001.0245.000020","funitID2Name":"件","billNoLike":null,"fmaterialID2Name":"头尾护罩(左)","fmustQty":10,"page":null,"fmobillNO":"MO000002"},{"fid":100005,"funitID2Number":"jian","fmaterialNumber":"01.001.00003","fnumerator":2,"fmaterialTypeNumber":"1","fmaterialID2_FErpClsNumber":"自制","fstockName":null,"fmoentrySeq":1,"fdenominator":1,"fmaterialTypeName":"标准件","limit":null,"documentStatus":null,"fdocumentStatusName":"C","fpickedQty":0,"billNo":"PPBOM00000003","fmaterialID2Specification":"155L*110W*43H/3T/Q235A/喷塑","fstockNumber":null,"fmaterialID2_FErpClsName":"2","fdocumentStatusNumber":"已审核","fmaterialID2Number":"02.001.0245.000022","funitID2Name":"件","billNoLike":null,"fmaterialID2Name":"头尾护罩(右)","fmustQty":10,"page":null,"fmobillNO":"MO000002"},{"fid":100005,"funitID2Number":"jian","fmaterialNumber":"01.001.00003","fnumerator":2,"fmaterialTypeNumber":"1","fmaterialID2_FErpClsNumber":"自制","fstockName":null,"fmoentrySeq":1,"fdenominator":1,"fmaterialTypeName":"标准件","limit":null,"documentStatus":null,"fdocumentStatusName":"C","fpickedQty":0,"billNo":"PPBOM00000003","fmaterialID2Specification":"1040L*120W*52H/3T/Q235A/喷塑","fstockNumber":null,"fmaterialID2_FErpClsName":"2","fdocumentStatusNumber":"已审核","fmaterialID2Number":"02.001.0229.000014","funitID2Name":"件","billNoLike":null,"fmaterialID2Name":"滚筒托架","fmustQty":10,"page":null,"fmobillNO":"MO000002"},{"fid":100005,"funitID2Number":"jian","fmaterialNumber":"01.001.00003","fnumerator":2,"fmaterialTypeNumber":"1","fmaterialID2_FErpClsNumber":"自制","fstockName":null,"fmoentrySeq":1,"fdenominator":1,"fmaterialTypeName":"标准件","limit":null,"documentStatus":null,"fdocumentStatusName":"C","fpickedQty":0,"billNo":"PPBOM00000003","fmaterialID2Specification":"1082L*320W*40H/Q235A/喷塑","fstockNumber":null,"fmaterialID2_FErpClsName":"2","fdocumentStatusNumber":"已审核","fmaterialID2Number":"02.001.0229.000035","funitID2Name":"件","billNoLike":null,"fmaterialID2Name":"下封网","fmustQty":10,"page":null,"fmobillNO":"MO000002"},{"fid":100005,"funitID2Number":"jian","fmaterialNumber":"01.001.00003","fnumerator":2,"fmaterialTypeNumber":"1","fmaterialID2_FErpClsNumber":"自制","fstockName":null,"fmoentrySeq":1,"fdenominator":1,"fmaterialTypeName":"标准件","limit":null,"documentStatus":null,"fdocumentStatusName":"C","fpickedQty":0,"billNo":"PPBOM00000003","fmaterialID2Specification":"1850L*40W*420H","fstockNumber":null,"fmaterialID2_FErpClsName":"2","fdocumentStatusNumber":"已审核","fmaterialID2Number":"02.001.0073.000029","funitID2Name":"件","billNoLike":null,"fmaterialID2Name":"头尾护边（左）","fmustQty":10,"page":null,"fmobillNO":"MO000002"},{"fid":100005,"funitID2Number":"jian","fmaterialNumber":"01.001.00003","fnumerator":2,"fmaterialTypeNumber":"1","fmaterialID2_FErpClsNumber":"自制","fstockName":null,"fmoentrySeq":1,"fdenominator":1,"fmaterialTypeName":"标准件","limit":null,"documentStatus":null,"fdocumentStatusName":"C","fpickedQty":0,"billNo":"PPBOM00000003","fmaterialID2Specification":"1850L*40W*420H","fstockNumber":null,"fmaterialID2_FErpClsName":"2","fdocumentStatusNumber":"已审核","fmaterialID2Number":"02.001.0073.000030","funitID2Name":"件","billNoLike":null,"fmaterialID2Name":"头尾护边（右）","fmustQty":10,"page":null,"fmobillNO":"MO000002"},{"fid":100005,"funitID2Number":"zhi","fmaterialNumber":"01.001.00003","fnumerator":4,"fmaterialTypeNumber":"1","fmaterialID2_FErpClsNumber":"外购","fstockName":null,"fmoentrySeq":1,"fdenominator":1,"fmaterialTypeName":"标准件","limit":null,"documentStatus":null,"fdocumentStatusName":"C","fpickedQty":0,"billNo":"PPBOM00000003","fmaterialID2Specification":"M8*80/8.8级/镀锌","fstockNumber":null,"fmaterialID2_FErpClsName":"1","fdocumentStatusNumber":"已审核","fmaterialID2Number":"04.05.012.00119","funitID2Name":"只","billNoLike":null,"fmaterialID2Name":"外六角螺栓","fmustQty":20,"page":null,"fmobillNO":"MO000002"},{"fid":100005,"funitID2Number":"zhi","fmaterialNumber":"01.001.00003","fnumerator":8,"fmaterialTypeNumber":"1","fmaterialID2_FErpClsNumber":"外购","fstockName":null,"fmoentrySeq":1,"fdenominator":1,"fmaterialTypeName":"标准件","limit":null,"documentStatus":null,"fdocumentStatusName":"C","fpickedQty":0,"billNo":"PPBOM00000003","fmaterialID2Specification":"M10*25/8.8级/镀锌","fstockNumber":null,"fmaterialID2_FErpClsName":"1","fdocumentStatusNumber":"已审核","fmaterialID2Number":"04.05.012.00135","funitID2Name":"只","billNoLike":null,"fmaterialID2Name":"外六角螺栓","fmustQty":40,"page":null,"fmobillNO":"MO000002"},{"fid":100005,"funitID2Number":"zhi","fmaterialNumber":"01.001.00003","fnumerator":72,"fmaterialTypeNumber":"1","fmaterialID2_FErpClsNumber":"外购","fstockName":null,"fmoentrySeq":1,"fdenominator":1,"fmaterialTypeName":"标准件","limit":null,"documentStatus":null,"fdocumentStatusName":"C","fpickedQty":0,"billNo":"PPBOM00000003","fmaterialID2Specification":"M8*25/8.8级/镀锌","fstockNumber":null,"fmaterialID2_FErpClsName":"1","fdocumentStatusNumber":"已审核","fmaterialID2Number":"04.05.012.00151","funitID2Name":"只","billNoLike":null,"fmaterialID2Name":"外六角螺栓","fmustQty":360,"page":null,"fmobillNO":"MO000002"},{"fid":100005,"funitID2Number":"zhi2","fmaterialNumber":"01.001.00003","fnumerator":4,"fmaterialTypeNumber":"1","fmaterialID2_FErpClsNumber":"外购","fstockName":null,"fmoentrySeq":1,"fdenominator":1,"fmaterialTypeName":"标准件","limit":null,"documentStatus":null,"fdocumentStatusName":"C","fpickedQty":0,"billNo":"PPBOM00000003","fmaterialID2Specification":"M10*30/8.8级/Q235/镀锌/粗牙/右旋","fstockNumber":null,"fmaterialID2_FErpClsName":"1","fdocumentStatusNumber":"已审核","fmaterialID2Number":"04.05.012.00157","funitID2Name":"支","billNoLike":null,"fmaterialID2Name":"外六角螺栓","fmustQty":20,"page":null,"fmobillNO":"MO000002"}]
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
         * fid : 100005
         * funitID2Number : jian
         * fmaterialNumber : 01.001.00003
         * fnumerator : 2
         * fmaterialTypeNumber : 1
         * fmaterialID2_FErpClsNumber : 自制
         * fstockName : null
         * fmoentrySeq : 1
         * fdenominator : 1
         * fmaterialTypeName : 标准件
         * limit : null
         * documentStatus : null
         * fdocumentStatusName : C
         * fpickedQty : 0
         * billNo : PPBOM00000003
         * fmaterialID2Specification : 155L*110W*43H/3T/Q235A/喷塑
         * fstockNumber : null
         * fmaterialID2_FErpClsName : 2
         * fdocumentStatusNumber : 已审核
         * fmaterialID2Number : 02.001.0245.000020
         * funitID2Name : 件
         * billNoLike : null
         * fmaterialID2Name : 头尾护罩(左)
         * fmustQty : 10
         * page : null
         * fmobillNO : MO000002
         */
        private int fid;
        private String funitID2Number;
        private String fmaterialNumber;
        private int fnumerator;
        private String fmaterialTypeNumber;
        private String fmaterialID2_FErpClsNumber;
        private String fstockName;
        private int fmoentrySeq;
        private int fdenominator;
        private String fmaterialTypeName;
        private String limit;
        private String documentStatus;
        private String fdocumentStatusName;
        private int fpickedQty;
        private String billNo;
        private String fmaterialID2Specification;
        private String fstockNumber;
        private String fmaterialID2_FErpClsName;
        private String fdocumentStatusNumber;
        private String fmaterialID2Number;
        private String funitID2Name;
        private String billNoLike;
        private String fmaterialID2Name;
        private int fmustQty;
        private String page;
        private String fmobillNO;

        public void setFid(int fid) {
            this.fid = fid;
        }

        public void setFunitID2Number(String funitID2Number) {
            this.funitID2Number = funitID2Number;
        }

        public void setFmaterialNumber(String fmaterialNumber) {
            this.fmaterialNumber = fmaterialNumber;
        }

        public void setFnumerator(int fnumerator) {
            this.fnumerator = fnumerator;
        }

        public void setFmaterialTypeNumber(String fmaterialTypeNumber) {
            this.fmaterialTypeNumber = fmaterialTypeNumber;
        }

        public void setFmaterialID2_FErpClsNumber(String fmaterialID2_FErpClsNumber) {
            this.fmaterialID2_FErpClsNumber = fmaterialID2_FErpClsNumber;
        }

        public void setFstockName(String fstockName) {
            this.fstockName = fstockName;
        }

        public void setFmoentrySeq(int fmoentrySeq) {
            this.fmoentrySeq = fmoentrySeq;
        }

        public void setFdenominator(int fdenominator) {
            this.fdenominator = fdenominator;
        }

        public void setFmaterialTypeName(String fmaterialTypeName) {
            this.fmaterialTypeName = fmaterialTypeName;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public void setDocumentStatus(String documentStatus) {
            this.documentStatus = documentStatus;
        }

        public void setFdocumentStatusName(String fdocumentStatusName) {
            this.fdocumentStatusName = fdocumentStatusName;
        }

        public void setFpickedQty(int fpickedQty) {
            this.fpickedQty = fpickedQty;
        }

        public void setBillNo(String billNo) {
            this.billNo = billNo;
        }

        public void setFmaterialID2Specification(String fmaterialID2Specification) {
            this.fmaterialID2Specification = fmaterialID2Specification;
        }

        public void setFstockNumber(String fstockNumber) {
            this.fstockNumber = fstockNumber;
        }

        public void setFmaterialID2_FErpClsName(String fmaterialID2_FErpClsName) {
            this.fmaterialID2_FErpClsName = fmaterialID2_FErpClsName;
        }

        public void setFdocumentStatusNumber(String fdocumentStatusNumber) {
            this.fdocumentStatusNumber = fdocumentStatusNumber;
        }

        public void setFmaterialID2Number(String fmaterialID2Number) {
            this.fmaterialID2Number = fmaterialID2Number;
        }

        public void setFunitID2Name(String funitID2Name) {
            this.funitID2Name = funitID2Name;
        }

        public void setBillNoLike(String billNoLike) {
            this.billNoLike = billNoLike;
        }

        public void setFmaterialID2Name(String fmaterialID2Name) {
            this.fmaterialID2Name = fmaterialID2Name;
        }

        public void setFmustQty(int fmustQty) {
            this.fmustQty = fmustQty;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public void setFmobillNO(String fmobillNO) {
            this.fmobillNO = fmobillNO;
        }

        public int getFid() {
            return fid;
        }

        public String getFunitID2Number() {
            return funitID2Number;
        }

        public String getFmaterialNumber() {
            return fmaterialNumber;
        }

        public int getFnumerator() {
            return fnumerator;
        }

        public String getFmaterialTypeNumber() {
            return fmaterialTypeNumber;
        }

        public String getFmaterialID2_FErpClsNumber() {
            return fmaterialID2_FErpClsNumber;
        }

        public String getFstockName() {
            return fstockName;
        }

        public int getFmoentrySeq() {
            return fmoentrySeq;
        }

        public int getFdenominator() {
            return fdenominator;
        }

        public String getFmaterialTypeName() {
            return fmaterialTypeName;
        }

        public String getLimit() {
            return limit;
        }

        public String getDocumentStatus() {
            return documentStatus;
        }

        public String getFdocumentStatusName() {
            return fdocumentStatusName;
        }

        public int getFpickedQty() {
            return fpickedQty;
        }

        public String getBillNo() {
            return billNo;
        }

        public String getFmaterialID2Specification() {
            return fmaterialID2Specification;
        }

        public String getFstockNumber() {
            return fstockNumber;
        }

        public String getFmaterialID2_FErpClsName() {
            return fmaterialID2_FErpClsName;
        }

        public String getFdocumentStatusNumber() {
            return fdocumentStatusNumber;
        }

        public String getFmaterialID2Number() {
            return fmaterialID2Number;
        }

        public String getFunitID2Name() {
            return funitID2Name;
        }

        public String getBillNoLike() {
            return billNoLike;
        }

        public String getFmaterialID2Name() {
            return fmaterialID2Name;
        }

        public int getFmustQty() {
            return fmustQty;
        }

        public String getPage() {
            return page;
        }

        public String getFmobillNO() {
            return fmobillNO;
        }
    }
}
