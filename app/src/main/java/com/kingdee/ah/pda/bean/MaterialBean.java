package com.kingdee.ah.pda.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.bean
 * @ClassName: MaterialBean
 * @Description: java类作用描述
 * 用料清单列表
 * @Author: 李浩
 * @CreateDate: 2020/11/3 21:50
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/3 21:50
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MaterialBean implements Serializable {

    /**
     * msg : 操作成功
     * code : 0
     * data : [{"fqty":20,"fid":100037,"fmaterialSpecification":"2000L*1567W*379H","fmaterialNumber":"02.001.0245.000025","fprdOrgName":"金锋馥（滁州）输送机械有限公司","fbillNoLike":null,"fmaterialName":"单驱动段","fdocumentStatus":"已审核","fworkshopName":"生管部","limit":null,"funitName":"台","page":null,"fbomnumber":null,"fmobillNO":"MO000007","fbillNo":"PPBOM00000014"},{"fqty":40,"fid":100038,"fmaterialSpecification":"1260L*3000W*120H/Q235A/喷塑","fmaterialNumber":"02.001.0245.000064","fprdOrgName":"金锋馥（滁州）输送机械有限公司","fbillNoLike":null,"fmaterialName":"中间机身组件","fdocumentStatus":"已审核","fworkshopName":"生管部","limit":null,"funitName":"件","page":null,"fbomnumber":"02.001.001.000064_V1.0","fmobillNO":"MO000007","fbillNo":"PPBOM00000015"},{"fqty":20,"fid":100039,"fmaterialSpecification":"1260L*208W*135H","fmaterialNumber":"02.001.0245.000067","fprdOrgName":"金锋馥（滁州）输送机械有限公司","fbillNoLike":null,"fmaterialName":"头尾过渡板组件","fdocumentStatus":"已审核","fworkshopName":"生管部","limit":null,"funitName":"件","page":null,"fbomnumber":"02.001.001.000067_V1.0","fmobillNO":"MO000007","fbillNo":"PPBOM00000016"},{"fqty":120,"fid":100040,"fmaterialSpecification":"1268L*150W*586H","fmaterialNumber":"02.001.0245.000077","fprdOrgName":"金锋馥（滁州）输送机械有限公司","fbillNoLike":null,"fmaterialName":"脚架组件","fdocumentStatus":"已审核","fworkshopName":"生管部","limit":null,"funitName":"件","page":null,"fbomnumber":"02.001.001.000077_V1.0","fmobillNO":"MO000007","fbillNo":"PPBOM00000017"},{"fqty":80,"fid":100041,"fmaterialSpecification":"70L*70W*3T/Q235A/喷塑","fmaterialNumber":"02.001.0245.000079","fprdOrgName":"金锋馥（滁州）输送机械有限公司","fbillNoLike":null,"fmaterialName":"驱动机身连接垫片","fdocumentStatus":"已审核","fworkshopName":"生管部","limit":null,"funitName":"件","page":null,"fbomnumber":"02.001.001.000079_V1.0","fmobillNO":"MO000007","fbillNo":"PPBOM00000018"},{"fqty":40,"fid":100042,"fmaterialSpecification":"1260L*3000W*120H/Q235A/喷塑","fmaterialNumber":"02.001.0245.000065","fprdOrgName":"金锋馥（滁州）输送机械有限公司","fbillNoLike":null,"fmaterialName":"中间机身","fdocumentStatus":"已审核","fworkshopName":"生管部","limit":null,"funitName":"件","page":null,"fbomnumber":"02.001.001.000065_V1.0","fmobillNO":"MO000007","fbillNo":"PPBOM00000019"},{"fqty":80,"fid":100043,"fmaterialSpecification":"1250L*130W*40H/Q235A","fmaterialNumber":"02.001.0245.000005","fprdOrgName":"金锋馥（滁州）输送机械有限公司","fbillNoLike":null,"fmaterialName":"滚筒托架","fdocumentStatus":"已审核","fworkshopName":"生管部","limit":null,"funitName":"件","page":null,"fbomnumber":"02.001.001.000005_V1.1","fmobillNO":"MO000007","fbillNo":"PPBOM00000020"},{"fqty":80,"fid":100044,"fmaterialSpecification":"3000L*40W*420H/3T/Q235A/喷塑","fmaterialNumber":"02.001.0245.000075","fprdOrgName":"金锋馥（滁州）输送机械有限公司","fbillNoLike":null,"fmaterialName":"中间机身护边","fdocumentStatus":"已审核","fworkshopName":"生管部","limit":null,"funitName":"件","page":null,"fbomnumber":"02.001.001.000075_V1.0","fmobillNO":"MO000007","fbillNo":"PPBOM00000021"},{"fqty":240,"fid":100045,"fmaterialSpecification":"1220L*498W*15H/Q235A/喷塑","fmaterialNumber":"02.001.0245.000062","fprdOrgName":"金锋馥（滁州）输送机械有限公司","fbillNoLike":null,"fmaterialName":"下封网","fdocumentStatus":"已审核","fworkshopName":"生管部","limit":null,"funitName":"件","page":null,"fbomnumber":"02.001.001.000062_V1.1","fmobillNO":"MO000007","fbillNo":"PPBOM00000022"},{"fqty":20,"fid":100046,"fmaterialSpecification":"1260L*100W*40H/Q235A/喷塑","fmaterialNumber":"02.001.0245.000068","fprdOrgName":"金锋馥（滁州）输送机械有限公司","fbillNoLike":null,"fmaterialName":"头尾过渡板（左）","fdocumentStatus":"已审核","fworkshopName":"生管部","limit":null,"funitName":"件","page":null,"fbomnumber":"02.001.001.000068_V1.0","fmobillNO":"MO000007","fbillNo":"PPBOM00000023"}]
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

    public class DataEntity implements Serializable {
        /**
         * fqty : 20
         * fid : 100037
         * fmaterialSpecification : 2000L*1567W*379H
         * fmaterialNumber : 02.001.0245.000025
         * fprdOrgName : 金锋馥（滁州）输送机械有限公司
         * fbillNoLike : null
         * fmaterialName : 单驱动段
         * fdocumentStatus : 已审核
         * fworkshopName : 生管部
         * limit : null
         * funitName : 台
         * page : null
         * fbomnumber : null
         * fmobillNO : MO000007
         * fbillNo : PPBOM00000014
         */
        private int fqty;
        private int fid;
        private String fmaterialSpecification;
        private String fmaterialNumber;
        private String fprdOrgName;
        private String fbillNoLike;
        private String fmaterialName;
        private String fdocumentStatus;
        private String fworkshopName;
        private String limit;
        private String funitName;
        private String page;
        private String fbomnumber;
        private String fmobillNO;
        private String fbillNo;

        public void setFqty(int fqty) {
            this.fqty = fqty;
        }

        public void setFid(int fid) {
            this.fid = fid;
        }

        public void setFmaterialSpecification(String fmaterialSpecification) {
            this.fmaterialSpecification = fmaterialSpecification;
        }

        public void setFmaterialNumber(String fmaterialNumber) {
            this.fmaterialNumber = fmaterialNumber;
        }

        public void setFprdOrgName(String fprdOrgName) {
            this.fprdOrgName = fprdOrgName;
        }

        public void setFbillNoLike(String fbillNoLike) {
            this.fbillNoLike = fbillNoLike;
        }

        public void setFmaterialName(String fmaterialName) {
            this.fmaterialName = fmaterialName;
        }

        public void setFdocumentStatus(String fdocumentStatus) {
            this.fdocumentStatus = fdocumentStatus;
        }

        public void setFworkshopName(String fworkshopName) {
            this.fworkshopName = fworkshopName;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public void setFunitName(String funitName) {
            this.funitName = funitName;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public void setFbomnumber(String fbomnumber) {
            this.fbomnumber = fbomnumber;
        }

        public void setFmobillNO(String fmobillNO) {
            this.fmobillNO = fmobillNO;
        }

        public void setFbillNo(String fbillNo) {
            this.fbillNo = fbillNo;
        }

        public int getFqty() {
            return fqty;
        }

        public int getFid() {
            return fid;
        }

        public String getFmaterialSpecification() {
            return fmaterialSpecification;
        }

        public String getFmaterialNumber() {
            return fmaterialNumber;
        }

        public String getFprdOrgName() {
            return fprdOrgName;
        }

        public String getFbillNoLike() {
            return fbillNoLike;
        }

        public String getFmaterialName() {
            return fmaterialName;
        }

        public String getFdocumentStatus() {
            return fdocumentStatus;
        }

        public String getFworkshopName() {
            return fworkshopName;
        }

        public String getLimit() {
            return limit;
        }

        public String getFunitName() {
            return funitName;
        }

        public String getPage() {
            return page;
        }

        public String getFbomnumber() {
            return fbomnumber;
        }

        public String getFmobillNO() {
            return fmobillNO;
        }

        public String getFbillNo() {
            return fbillNo;
        }
    }
}
