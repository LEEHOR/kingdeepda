package com.jeewms.www.wms.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: ReceivingEntyBean
 * @Description: java类作用描述
 * 采购入库表体
 * @Author: 作者名
 * @CreateDate: 2020/10/19 19:53
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/19 19:53
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */

public class InStockEntryBean implements Serializable {


    /**
     * msg : 操作成功
     * code : 0
     * data : [{"fid":null,"flotNumber":null,"fremainInStockUnitNumber":"tai","ftaxNetPrice":110,"ff100001Mame":null,"fmaterialNumber":"04.01.001.00028","fnote":" ","ff100001Mumber":null,"fstockName":"电料仓库","funitNumber":"tai","fremainInStockQty":20,"fgiveAway":"false","fpriceUnitName":"台","fspecification":"RF/47/DRS/80S4/BE1/0.75KW/i=47.75/M2/0/VB:380V/低温合成油","limit":null,"funitName":"台","flotName":null,"fentryId":100005,"fwwinType":null,"fstockNumber":"DL005","fremainInStockUnitName":"台","projectNumber":null,"fmaterialName":"斜齿轮减速电机","frealQty":20,"fpriceUnitNumber":"tai","fstockStatusName":"可用","fmustQty":20,"fwwinTypeNumber":" ","fpriceUnitQty":20,"page":null,"projectName":null,"fstockStatusNumber":"KCZT01_SYS"},{"fid":null,"flotNumber":null,"fremainInStockUnitNumber":"tai","ftaxNetPrice":110,"ff100001Mame":null,"fmaterialNumber":"04.01.001.00029","fnote":" ","ff100001Mumber":null,"fstockName":"电料仓库","funitNumber":"tai","fremainInStockQty":20,"fgiveAway":"false","fpriceUnitName":"台","fspecification":"CH/18/200/10S/HO/G1/LB/轴端攻牙M6*25","limit":null,"funitName":"台","flotName":null,"fentryId":100006,"fwwinType":null,"fstockNumber":"DL005","fremainInStockUnitName":"台","projectNumber":null,"fmaterialName":"斜齿轮减速电机","frealQty":20,"fpriceUnitNumber":"tai","fstockStatusName":"可用","fmustQty":20,"fwwinTypeNumber":" ","fpriceUnitQty":20,"page":null,"projectName":null,"fstockStatusNumber":"KCZT01_SYS"},{"fid":null,"flotNumber":null,"fremainInStockUnitNumber":"tai","ftaxNetPrice":110,"ff100001Mame":null,"fmaterialNumber":"04.01.001.00030","fnote":" ","ff100001Mumber":null,"fstockName":"电料仓库","funitNumber":"tai","fremainInStockQty":20,"fgiveAway":"false","fpriceUnitName":"台","fspecification":"CH/22/B/400/10S/HO/G1/LB/轴端攻牙M6*25","limit":null,"funitName":"台","flotName":null,"fentryId":100007,"fwwinType":null,"fstockNumber":"DL005","fremainInStockUnitName":"台","projectNumber":null,"fmaterialName":"斜齿轮减速电机","frealQty":20,"fpriceUnitNumber":"tai","fstockStatusName":"可用","fmustQty":20,"fwwinTypeNumber":" ","fpriceUnitQty":20,"page":null,"projectName":null,"fstockStatusNumber":"KCZT01_SYS"},{"fid":null,"flotNumber":null,"fremainInStockUnitNumber":"tai","ftaxNetPrice":110,"ff100001Mame":null,"fmaterialNumber":"04.01.001.00031","fnote":" ","ff100001Mumber":null,"fstockName":"电料仓库","funitNumber":"tai","fremainInStockQty":20,"fgiveAway":"false","fpriceUnitName":"台","fspecification":"CH/22/400/10S/HO/G1/LB/轴端攻牙M6*25","limit":null,"funitName":"台","flotName":null,"fentryId":100008,"fwwinType":null,"fstockNumber":"DL005","fremainInStockUnitName":"台","projectNumber":null,"fmaterialName":"斜齿轮减速电机","frealQty":20,"fpriceUnitNumber":"tai","fstockStatusName":"可用","fmustQty":20,"fwwinTypeNumber":" ","fpriceUnitQty":20,"page":null,"projectName":null,"fstockStatusNumber":"KCZT01_SYS"},{"fid":null,"flotNumber":null,"fremainInStockUnitNumber":"tai","ftaxNetPrice":110,"ff100001Mame":null,"fmaterialNumber":"04.01.001.00032","fnote":" ","ff100001Mumber":null,"fstockName":"电料仓库","funitNumber":"tai","fremainInStockQty":20,"fgiveAway":"false","fpriceUnitName":"台","fspecification":"CH/22/B/400/6S/G1/轴端攻牙M6*15","limit":null,"funitName":"台","flotName":null,"fentryId":100009,"fwwinType":null,"fstockNumber":"DL005","fremainInStockUnitName":"台","projectNumber":null,"fmaterialName":"斜齿轮减速电机","frealQty":20,"fpriceUnitNumber":"tai","fstockStatusName":"可用","fmustQty":20,"fwwinTypeNumber":" ","fpriceUnitQty":20,"page":null,"projectName":null,"fstockStatusNumber":"KCZT01_SYS"},{"fid":null,"flotNumber":null,"fremainInStockUnitNumber":"tai","ftaxNetPrice":110,"ff100001Mame":null,"fmaterialNumber":"04.01.001.00033","fnote":" ","ff100001Mumber":null,"fstockName":"电料仓库","funitNumber":"tai","fremainInStockQty":20,"fgiveAway":"false","fpriceUnitName":"台","fspecification":"CH/28/400/15S/HO/G1/LB/轴端攻牙M6*25","limit":null,"funitName":"台","flotName":null,"fentryId":100010,"fwwinType":null,"fstockNumber":"DL005","fremainInStockUnitName":"台","projectNumber":null,"fmaterialName":"斜齿轮减速电机","frealQty":20,"fpriceUnitNumber":"tai","fstockStatusName":"可用","fmustQty":20,"fwwinTypeNumber":" ","fpriceUnitQty":20,"page":null,"projectName":null,"fstockStatusNumber":"KCZT01_SYS"},{"fid":null,"flotNumber":null,"fremainInStockUnitNumber":"tai","ftaxNetPrice":110,"ff100001Mame":null,"fmaterialNumber":"04.01.001.00034","fnote":" ","ff100001Mumber":null,"fstockName":"电料仓库","funitNumber":"tai","fremainInStockQty":20,"fgiveAway":"false","fpriceUnitName":"台","fspecification":"CH/28/400/35S/G2/RF/轴端攻牙M10*25","limit":null,"funitName":"台","flotName":null,"fentryId":100011,"fwwinType":null,"fstockNumber":"DL005","fremainInStockUnitName":"台","projectNumber":null,"fmaterialName":"斜齿轮减速电机","frealQty":20,"fpriceUnitNumber":"tai","fstockStatusName":"可用","fmustQty":20,"fwwinTypeNumber":" ","fpriceUnitQty":20,"page":null,"projectName":null,"fstockStatusNumber":"KCZT01_SYS"},{"fid":null,"flotNumber":null,"fremainInStockUnitNumber":"tai","ftaxNetPrice":110,"ff100001Mame":null,"fmaterialNumber":"04.01.001.00035","fnote":" ","ff100001Mumber":null,"fstockName":"电料仓库","funitNumber":"tai","fremainInStockQty":20,"fgiveAway":"false","fpriceUnitName":"台","fspecification":"CH/28/750/15S/HO/G1/LB/轴端攻牙M6*25","limit":null,"funitName":"台","flotName":null,"fentryId":100012,"fwwinType":null,"fstockNumber":"DL005","fremainInStockUnitName":"台","projectNumber":null,"fmaterialName":"斜齿轮减速电机","frealQty":20,"fpriceUnitNumber":"tai","fstockStatusName":"可用","fmustQty":20,"fwwinTypeNumber":" ","fpriceUnitQty":20,"page":null,"projectName":null,"fstockStatusNumber":"KCZT01_SYS"},{"fid":null,"flotNumber":null,"fremainInStockUnitNumber":"tai","ftaxNetPrice":110,"ff100001Mame":null,"fmaterialNumber":"04.01.001.00036","fnote":" ","ff100001Mumber":null,"fstockName":"电料仓库","funitNumber":"tai","fremainInStockQty":20,"fgiveAway":"false","fpriceUnitName":"台","fspecification":"CH/40/1500/35SB/G2/RF/轴端攻牙M12*25","limit":null,"funitName":"台","flotName":null,"fentryId":100013,"fwwinType":null,"fstockNumber":"DL005","fremainInStockUnitName":"台","projectNumber":null,"fmaterialName":"斜齿轮减速电机","frealQty":20,"fpriceUnitNumber":"tai","fstockStatusName":"可用","fmustQty":20,"fwwinTypeNumber":" ","fpriceUnitQty":20,"page":null,"projectName":null,"fstockStatusNumber":"KCZT01_SYS"},{"fid":null,"flotNumber":null,"fremainInStockUnitNumber":"tai","ftaxNetPrice":110,"ff100001Mame":null,"fmaterialNumber":"04.01.001.00037","fnote":" ","ff100001Mumber":null,"fstockName":"电料仓库","funitNumber":"tai","fremainInStockQty":20,"fgiveAway":"false","fpriceUnitName":"台","fspecification":"CH/40/2200/35S/G2/RF/轴端攻牙M10*25","limit":null,"funitName":"台","flotName":null,"fentryId":100014,"fwwinType":null,"fstockNumber":"DL005","fremainInStockUnitName":"台","projectNumber":null,"fmaterialName":"斜齿轮减速电机","frealQty":20,"fpriceUnitNumber":"tai","fstockStatusName":"可用","fmustQty":20,"fwwinTypeNumber":" ","fpriceUnitQty":20,"page":null,"projectName":null,"fstockStatusNumber":"KCZT01_SYS"}]
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
         * fid : null
         * flotNumber : null
         * fremainInStockUnitNumber : tai
         * ftaxNetPrice : 110
         * ff100001Mame : null
         * fmaterialNumber : 04.01.001.00028
         * fnote :
         * ff100001Mumber : null
         * fstockName : 电料仓库
         * funitNumber : tai
         * fremainInStockQty : 20
         * fgiveAway : false
         * fpriceUnitName : 台
         * fspecification : RF/47/DRS/80S4/BE1/0.75KW/i=47.75/M2/0/VB:380V/低温合成油
         * limit : null
         * funitName : 台
         * flotName : null
         * fentryId : 100005
         * fwwinType : null
         * fstockNumber : DL005
         * fremainInStockUnitName : 台
         * projectNumber : null
         * fmaterialName : 斜齿轮减速电机
         * frealQty : 20
         * fpriceUnitNumber : tai
         * fstockStatusName : 可用
         * fmustQty : 20
         * fwwinTypeNumber :
         * fpriceUnitQty : 20
         * page : null
         * projectName : null
         * fstockStatusNumber : KCZT01_SYS
         */
        private String fid;
        private String flotNumber;
        private String fremainInStockUnitNumber;
        private int ftaxNetPrice;
        private String ff100001Mame;
        private String fmaterialNumber;
        private String fnote;
        private String ff100001Mumber;
        private String fstockName;
        private String funitNumber;
        private int fremainInStockQty;
        private String fgiveAway;
        private String fpriceUnitName;
        private String fspecification;
        private String limit;
        private String funitName;
        private String flotName;
        private int fentryId;
        private String fwwinType;
        private String fstockNumber;
        private String fremainInStockUnitName;
        private String projectNumber;
        private String fmaterialName;
        private int frealQty;
        private String fpriceUnitNumber;
        private String fstockStatusName;
        private int fmustQty;
        private String fwwinTypeNumber;
        private int fpriceUnitQty;
        private String page;
        private String projectName;
        private String fstockStatusNumber;

        public void setFid(String fid) {
            this.fid = fid;
        }

        public void setFlotNumber(String flotNumber) {
            this.flotNumber = flotNumber;
        }

        public void setFremainInStockUnitNumber(String fremainInStockUnitNumber) {
            this.fremainInStockUnitNumber = fremainInStockUnitNumber;
        }

        public void setFtaxNetPrice(int ftaxNetPrice) {
            this.ftaxNetPrice = ftaxNetPrice;
        }

        public void setFf100001Mame(String ff100001Mame) {
            this.ff100001Mame = ff100001Mame;
        }

        public void setFmaterialNumber(String fmaterialNumber) {
            this.fmaterialNumber = fmaterialNumber;
        }

        public void setFnote(String fnote) {
            this.fnote = fnote;
        }

        public void setFf100001Mumber(String ff100001Mumber) {
            this.ff100001Mumber = ff100001Mumber;
        }

        public void setFstockName(String fstockName) {
            this.fstockName = fstockName;
        }

        public void setFunitNumber(String funitNumber) {
            this.funitNumber = funitNumber;
        }

        public void setFremainInStockQty(int fremainInStockQty) {
            this.fremainInStockQty = fremainInStockQty;
        }

        public void setFgiveAway(String fgiveAway) {
            this.fgiveAway = fgiveAway;
        }

        public void setFpriceUnitName(String fpriceUnitName) {
            this.fpriceUnitName = fpriceUnitName;
        }

        public void setFspecification(String fspecification) {
            this.fspecification = fspecification;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public void setFunitName(String funitName) {
            this.funitName = funitName;
        }

        public void setFlotName(String flotName) {
            this.flotName = flotName;
        }

        public void setFentryId(int fentryId) {
            this.fentryId = fentryId;
        }

        public void setFwwinType(String fwwinType) {
            this.fwwinType = fwwinType;
        }

        public void setFstockNumber(String fstockNumber) {
            this.fstockNumber = fstockNumber;
        }

        public void setFremainInStockUnitName(String fremainInStockUnitName) {
            this.fremainInStockUnitName = fremainInStockUnitName;
        }

        public void setProjectNumber(String projectNumber) {
            this.projectNumber = projectNumber;
        }

        public void setFmaterialName(String fmaterialName) {
            this.fmaterialName = fmaterialName;
        }

        public void setFrealQty(int frealQty) {
            this.frealQty = frealQty;
        }

        public void setFpriceUnitNumber(String fpriceUnitNumber) {
            this.fpriceUnitNumber = fpriceUnitNumber;
        }

        public void setFstockStatusName(String fstockStatusName) {
            this.fstockStatusName = fstockStatusName;
        }

        public void setFmustQty(int fmustQty) {
            this.fmustQty = fmustQty;
        }

        public void setFwwinTypeNumber(String fwwinTypeNumber) {
            this.fwwinTypeNumber = fwwinTypeNumber;
        }

        public void setFpriceUnitQty(int fpriceUnitQty) {
            this.fpriceUnitQty = fpriceUnitQty;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public void setFstockStatusNumber(String fstockStatusNumber) {
            this.fstockStatusNumber = fstockStatusNumber;
        }

        public String getFid() {
            return fid;
        }

        public String getFlotNumber() {
            return flotNumber;
        }

        public String getFremainInStockUnitNumber() {
            return fremainInStockUnitNumber;
        }

        public int getFtaxNetPrice() {
            return ftaxNetPrice;
        }

        public String getFf100001Mame() {
            return ff100001Mame;
        }

        public String getFmaterialNumber() {
            return fmaterialNumber;
        }

        public String getFnote() {
            return fnote;
        }

        public String getFf100001Mumber() {
            return ff100001Mumber;
        }

        public String getFstockName() {
            return fstockName;
        }

        public String getFunitNumber() {
            return funitNumber;
        }

        public int getFremainInStockQty() {
            return fremainInStockQty;
        }

        public String getFgiveAway() {
            return fgiveAway;
        }

        public String getFpriceUnitName() {
            return fpriceUnitName;
        }

        public String getFspecification() {
            return fspecification;
        }

        public String getLimit() {
            return limit;
        }

        public String getFunitName() {
            return funitName;
        }

        public String getFlotName() {
            return flotName;
        }

        public int getFentryId() {
            return fentryId;
        }

        public String getFwwinType() {
            return fwwinType;
        }

        public String getFstockNumber() {
            return fstockNumber;
        }

        public String getFremainInStockUnitName() {
            return fremainInStockUnitName;
        }

        public String getProjectNumber() {
            return projectNumber;
        }

        public String getFmaterialName() {
            return fmaterialName;
        }

        public int getFrealQty() {
            return frealQty;
        }

        public String getFpriceUnitNumber() {
            return fpriceUnitNumber;
        }

        public String getFstockStatusName() {
            return fstockStatusName;
        }

        public int getFmustQty() {
            return fmustQty;
        }

        public String getFwwinTypeNumber() {
            return fwwinTypeNumber;
        }

        public int getFpriceUnitQty() {
            return fpriceUnitQty;
        }

        public String getPage() {
            return page;
        }

        public String getProjectName() {
            return projectName;
        }

        public String getFstockStatusNumber() {
            return fstockStatusNumber;
        }
    }
}
