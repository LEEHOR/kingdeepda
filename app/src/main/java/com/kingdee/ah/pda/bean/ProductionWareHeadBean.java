package com.kingdee.ah.pda.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.bean
 * @ClassName: ProductionWareDetailBean
 * @Description: java类作用描述
 * 生产入库详情
 * @Author: 李浩
 * @CreateDate: 2020/11/5 17:57
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/5 17:57
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ProductionWareHeadBean implements Serializable {

    /**
     * msg :
     * code : 0
     * data : [{"fapprovedate":"","fapproverid":"","fid":0,"fpaezproject":"","fprdorgid":"","fstockid0":"","syncDate":"","fdescription":"","fownertypeid0":"","fdocumentstatus":"","fownerid0":"","prdInstockentryList":[{"fstockstatusid":"","finstocktype":"","fbasemustqty":0,"fmaterialid":"","fbaserealqty":0,"funitid":"","fstockid":"","fkeepertypeid":"","fownertypeid":"","fstocklocid":"","fproducttype":"","parentId":0,"fownerid":"","frealqty":0,"fspecification":"","fmustqty":0,"fkeeperid":"","fbaseunitid":"","fproducedate":"","id":0,"fentryid":0,"fmobillno":"","fmaterialname":""}],"fcreatedate":"","fworkshopid":"","fcreatorid":0,"fdate":"","id":0,"fstockorgid":"","fbillno":"","fbilltype":"","syncStatus":0}]
     * count : 0
     */
    private String msg;
    private int code;
    private List<DataEntity> data;
    private int count;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public void setCount(int count) {
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public class DataEntity {
        /**
         * fapprovedate :
         * fapproverid :
         * fid : 0
         * fpaezproject :
         * fprdorgid :
         * fstockid0 :
         * syncDate :
         * fdescription :
         * fownertypeid0 :
         * fdocumentstatus :
         * fownerid0 :
         * prdInstockentryList : [{"fstockstatusid":"","finstocktype":"","fbasemustqty":0,"fmaterialid":"","fbaserealqty":0,"funitid":"","fstockid":"","fkeepertypeid":"","fownertypeid":"","fstocklocid":"","fproducttype":"","parentId":0,"fownerid":"","frealqty":0,"fspecification":"","fmustqty":0,"fkeeperid":"","fbaseunitid":"","fproducedate":"","id":0,"fentryid":0,"fmobillno":"","fmaterialname":""}]
         * fcreatedate :
         * fworkshopid :
         * fcreatorid : 0
         * fdate :
         * id : 0
         * fstockorgid :
         * fbillno :
         * fbilltype :
         * syncStatus : 0
         */
        private String fapprovedate;
        private String fapproverid;
        private int fid;
        private String fpaezproject;
        private String fprdorgid;
        private String fstockid0;
        private String syncDate;
        private String fdescription;
        private String fownertypeid0;
        private String fdocumentstatus;
        private String fownerid0;
        private List<PrdInstockentryListEntity> prdInstockentryList;
        private String fcreatedate;
        private String fworkshopid;
        private int fcreatorid;
        private String fdate;
        private int id;
        private String fstockorgid;
        private String fbillno;
        private String fbilltype;
        private int syncStatus;

        public void setFapprovedate(String fapprovedate) {
            this.fapprovedate = fapprovedate;
        }

        public void setFapproverid(String fapproverid) {
            this.fapproverid = fapproverid;
        }

        public void setFid(int fid) {
            this.fid = fid;
        }

        public void setFpaezproject(String fpaezproject) {
            this.fpaezproject = fpaezproject;
        }

        public void setFprdorgid(String fprdorgid) {
            this.fprdorgid = fprdorgid;
        }

        public void setFstockid0(String fstockid0) {
            this.fstockid0 = fstockid0;
        }

        public void setSyncDate(String syncDate) {
            this.syncDate = syncDate;
        }

        public void setFdescription(String fdescription) {
            this.fdescription = fdescription;
        }

        public void setFownertypeid0(String fownertypeid0) {
            this.fownertypeid0 = fownertypeid0;
        }

        public void setFdocumentstatus(String fdocumentstatus) {
            this.fdocumentstatus = fdocumentstatus;
        }

        public void setFownerid0(String fownerid0) {
            this.fownerid0 = fownerid0;
        }

        public void setPrdInstockentryList(List<PrdInstockentryListEntity> prdInstockentryList) {
            this.prdInstockentryList = prdInstockentryList;
        }

        public void setFcreatedate(String fcreatedate) {
            this.fcreatedate = fcreatedate;
        }

        public void setFworkshopid(String fworkshopid) {
            this.fworkshopid = fworkshopid;
        }

        public void setFcreatorid(int fcreatorid) {
            this.fcreatorid = fcreatorid;
        }

        public void setFdate(String fdate) {
            this.fdate = fdate;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setFstockorgid(String fstockorgid) {
            this.fstockorgid = fstockorgid;
        }

        public void setFbillno(String fbillno) {
            this.fbillno = fbillno;
        }

        public void setFbilltype(String fbilltype) {
            this.fbilltype = fbilltype;
        }

        public void setSyncStatus(int syncStatus) {
            this.syncStatus = syncStatus;
        }

        public String getFapprovedate() {
            return fapprovedate;
        }

        public String getFapproverid() {
            return fapproverid;
        }

        public int getFid() {
            return fid;
        }

        public String getFpaezproject() {
            return fpaezproject;
        }

        public String getFprdorgid() {
            return fprdorgid;
        }

        public String getFstockid0() {
            return fstockid0;
        }

        public String getSyncDate() {
            return syncDate;
        }

        public String getFdescription() {
            return fdescription;
        }

        public String getFownertypeid0() {
            return fownertypeid0;
        }

        public String getFdocumentstatus() {
            return fdocumentstatus;
        }

        public String getFownerid0() {
            return fownerid0;
        }

        public List<PrdInstockentryListEntity> getPrdInstockentryList() {
            return prdInstockentryList;
        }

        public String getFcreatedate() {
            return fcreatedate;
        }

        public String getFworkshopid() {
            return fworkshopid;
        }

        public int getFcreatorid() {
            return fcreatorid;
        }

        public String getFdate() {
            return fdate;
        }

        public int getId() {
            return id;
        }

        public String getFstockorgid() {
            return fstockorgid;
        }

        public String getFbillno() {
            return fbillno;
        }

        public String getFbilltype() {
            return fbilltype;
        }

        public int getSyncStatus() {
            return syncStatus;
        }

        public class PrdInstockentryListEntity {
            /**
             * fstockstatusid :
             * finstocktype :
             * fbasemustqty : 0
             * fmaterialid :
             * fbaserealqty : 0
             * funitid :
             * fstockid :
             * fkeepertypeid :
             * fownertypeid :
             * fstocklocid :
             * fproducttype :
             * parentId : 0
             * fownerid :
             * frealqty : 0
             * fspecification :
             * fmustqty : 0
             * fkeeperid :
             * fbaseunitid :
             * fproducedate :
             * id : 0
             * fentryid : 0
             * fmobillno :
             * fmaterialname :
             */
            private String fstockstatusid;
            private String finstocktype;
            private int fbasemustqty;
            private String fmaterialid;
            private int fbaserealqty;
            private String funitid;
            private String fstockid;
            private String fkeepertypeid;
            private String fownertypeid;
            private String fstocklocid;
            private String fproducttype;
            private int parentId;
            private String fownerid;
            private int frealqty;
            private String fspecification;
            private int fmustqty;
            private String fkeeperid;
            private String fbaseunitid;
            private String fproducedate;
            private int id;
            private int fentryid;
            private String fmobillno;
            private String fmaterialname;

            public void setFstockstatusid(String fstockstatusid) {
                this.fstockstatusid = fstockstatusid;
            }

            public void setFinstocktype(String finstocktype) {
                this.finstocktype = finstocktype;
            }

            public void setFbasemustqty(int fbasemustqty) {
                this.fbasemustqty = fbasemustqty;
            }

            public void setFmaterialid(String fmaterialid) {
                this.fmaterialid = fmaterialid;
            }

            public void setFbaserealqty(int fbaserealqty) {
                this.fbaserealqty = fbaserealqty;
            }

            public void setFunitid(String funitid) {
                this.funitid = funitid;
            }

            public void setFstockid(String fstockid) {
                this.fstockid = fstockid;
            }

            public void setFkeepertypeid(String fkeepertypeid) {
                this.fkeepertypeid = fkeepertypeid;
            }

            public void setFownertypeid(String fownertypeid) {
                this.fownertypeid = fownertypeid;
            }

            public void setFstocklocid(String fstocklocid) {
                this.fstocklocid = fstocklocid;
            }

            public void setFproducttype(String fproducttype) {
                this.fproducttype = fproducttype;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public void setFownerid(String fownerid) {
                this.fownerid = fownerid;
            }

            public void setFrealqty(int frealqty) {
                this.frealqty = frealqty;
            }

            public void setFspecification(String fspecification) {
                this.fspecification = fspecification;
            }

            public void setFmustqty(int fmustqty) {
                this.fmustqty = fmustqty;
            }

            public void setFkeeperid(String fkeeperid) {
                this.fkeeperid = fkeeperid;
            }

            public void setFbaseunitid(String fbaseunitid) {
                this.fbaseunitid = fbaseunitid;
            }

            public void setFproducedate(String fproducedate) {
                this.fproducedate = fproducedate;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setFentryid(int fentryid) {
                this.fentryid = fentryid;
            }

            public void setFmobillno(String fmobillno) {
                this.fmobillno = fmobillno;
            }

            public void setFmaterialname(String fmaterialname) {
                this.fmaterialname = fmaterialname;
            }

            public String getFstockstatusid() {
                return fstockstatusid;
            }

            public String getFinstocktype() {
                return finstocktype;
            }

            public int getFbasemustqty() {
                return fbasemustqty;
            }

            public String getFmaterialid() {
                return fmaterialid;
            }

            public int getFbaserealqty() {
                return fbaserealqty;
            }

            public String getFunitid() {
                return funitid;
            }

            public String getFstockid() {
                return fstockid;
            }

            public String getFkeepertypeid() {
                return fkeepertypeid;
            }

            public String getFownertypeid() {
                return fownertypeid;
            }

            public String getFstocklocid() {
                return fstocklocid;
            }

            public String getFproducttype() {
                return fproducttype;
            }

            public int getParentId() {
                return parentId;
            }

            public String getFownerid() {
                return fownerid;
            }

            public int getFrealqty() {
                return frealqty;
            }

            public String getFspecification() {
                return fspecification;
            }

            public int getFmustqty() {
                return fmustqty;
            }

            public String getFkeeperid() {
                return fkeeperid;
            }

            public String getFbaseunitid() {
                return fbaseunitid;
            }

            public String getFproducedate() {
                return fproducedate;
            }

            public int getId() {
                return id;
            }

            public int getFentryid() {
                return fentryid;
            }

            public String getFmobillno() {
                return fmobillno;
            }

            public String getFmaterialname() {
                return fmaterialname;
            }
        }
    }
}
