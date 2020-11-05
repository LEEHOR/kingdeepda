package com.kingdee.ah.pda.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.bean
 * @ClassName: OutStockHeadBean
 * @Description: java类作用描述
 * 其他出库头部列表
 * @Author: 李浩
 * @CreateDate: 2020/11/5 18:48
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/5 18:48
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class OtherStockHeadBean implements Serializable {

    /**
     * msg :
     * code : 0
     * data : [{"fid":0,"fdeptid":0,"fcustid":0,"syncDate":"","fnote":"","entryDetails":[{"fstockstatusid":0,"fmodel":"","fentrynote":"","fsrcbillno":0,"fpaezproject":"","fmaterialid":"","famount":0,"fownertypeid":0,"fprice":0,"fsrcmisdelentryid":0,"fkeeperid":0,"fprojectno":"","fbaseunitid":0,"flot":"","id":0,"fsecqty":0,"fpaezprojectname":"","fqty":0,"funitid":0,"fstockid":0,"fkeepertypeid":0,"fstocklocid":0,"parentId":0,"fownerid":0,"fbaseqty":0,"fentryid":0,"fmaterialname":"","fsrcbilltypeid":0}],"fdocumentstatus":"","fownertypeidhead":"","fowneridhead":0,"fstockdirect":"","fbiztype":"","fcreatedate":"","fcreatorid":0,"fpickerid":0,"fdate":"","fpickorgid":0,"fbasecurrid":0,"id":0,"fstockorgid":0,"fbillno":"","syncStatus":0,"fbilltypeid":""}]
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
         * fid : 0
         * fdeptid : 0
         * fcustid : 0
         * syncDate :
         * fnote :
         * entryDetails : [{"fstockstatusid":0,"fmodel":"","fentrynote":"","fsrcbillno":0,"fpaezproject":"","fmaterialid":"","famount":0,"fownertypeid":0,"fprice":0,"fsrcmisdelentryid":0,"fkeeperid":0,"fprojectno":"","fbaseunitid":0,"flot":"","id":0,"fsecqty":0,"fpaezprojectname":"","fqty":0,"funitid":0,"fstockid":0,"fkeepertypeid":0,"fstocklocid":0,"parentId":0,"fownerid":0,"fbaseqty":0,"fentryid":0,"fmaterialname":"","fsrcbilltypeid":0}]
         * fdocumentstatus :
         * fownertypeidhead :
         * fowneridhead : 0
         * fstockdirect :
         * fbiztype :
         * fcreatedate :
         * fcreatorid : 0
         * fpickerid : 0
         * fdate :
         * fpickorgid : 0
         * fbasecurrid : 0
         * id : 0
         * fstockorgid : 0
         * fbillno :
         * syncStatus : 0
         * fbilltypeid :
         */
        private int fid;
        private int fdeptid;
        private int fcustid;
        private String syncDate;
        private String fnote;
        private List<EntryDetailsEntity> entryDetails;
        private String fdocumentstatus;
        private String fownertypeidhead;
        private int fowneridhead;
        private String fstockdirect;
        private String fbiztype;
        private String fcreatedate;
        private int fcreatorid;
        private int fpickerid;
        private String fdate;
        private int fpickorgid;
        private int fbasecurrid;
        private int id;
        private int fstockorgid;
        private String fbillno;
        private int syncStatus;
        private String fbilltypeid;

        public void setFid(int fid) {
            this.fid = fid;
        }

        public void setFdeptid(int fdeptid) {
            this.fdeptid = fdeptid;
        }

        public void setFcustid(int fcustid) {
            this.fcustid = fcustid;
        }

        public void setSyncDate(String syncDate) {
            this.syncDate = syncDate;
        }

        public void setFnote(String fnote) {
            this.fnote = fnote;
        }

        public void setEntryDetails(List<EntryDetailsEntity> entryDetails) {
            this.entryDetails = entryDetails;
        }

        public void setFdocumentstatus(String fdocumentstatus) {
            this.fdocumentstatus = fdocumentstatus;
        }

        public void setFownertypeidhead(String fownertypeidhead) {
            this.fownertypeidhead = fownertypeidhead;
        }

        public void setFowneridhead(int fowneridhead) {
            this.fowneridhead = fowneridhead;
        }

        public void setFstockdirect(String fstockdirect) {
            this.fstockdirect = fstockdirect;
        }

        public void setFbiztype(String fbiztype) {
            this.fbiztype = fbiztype;
        }

        public void setFcreatedate(String fcreatedate) {
            this.fcreatedate = fcreatedate;
        }

        public void setFcreatorid(int fcreatorid) {
            this.fcreatorid = fcreatorid;
        }

        public void setFpickerid(int fpickerid) {
            this.fpickerid = fpickerid;
        }

        public void setFdate(String fdate) {
            this.fdate = fdate;
        }

        public void setFpickorgid(int fpickorgid) {
            this.fpickorgid = fpickorgid;
        }

        public void setFbasecurrid(int fbasecurrid) {
            this.fbasecurrid = fbasecurrid;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setFstockorgid(int fstockorgid) {
            this.fstockorgid = fstockorgid;
        }

        public void setFbillno(String fbillno) {
            this.fbillno = fbillno;
        }

        public void setSyncStatus(int syncStatus) {
            this.syncStatus = syncStatus;
        }

        public void setFbilltypeid(String fbilltypeid) {
            this.fbilltypeid = fbilltypeid;
        }

        public int getFid() {
            return fid;
        }

        public int getFdeptid() {
            return fdeptid;
        }

        public int getFcustid() {
            return fcustid;
        }

        public String getSyncDate() {
            return syncDate;
        }

        public String getFnote() {
            return fnote;
        }

        public List<EntryDetailsEntity> getEntryDetails() {
            return entryDetails;
        }

        public String getFdocumentstatus() {
            return fdocumentstatus;
        }

        public String getFownertypeidhead() {
            return fownertypeidhead;
        }

        public int getFowneridhead() {
            return fowneridhead;
        }

        public String getFstockdirect() {
            return fstockdirect;
        }

        public String getFbiztype() {
            return fbiztype;
        }

        public String getFcreatedate() {
            return fcreatedate;
        }

        public int getFcreatorid() {
            return fcreatorid;
        }

        public int getFpickerid() {
            return fpickerid;
        }

        public String getFdate() {
            return fdate;
        }

        public int getFpickorgid() {
            return fpickorgid;
        }

        public int getFbasecurrid() {
            return fbasecurrid;
        }

        public int getId() {
            return id;
        }

        public int getFstockorgid() {
            return fstockorgid;
        }

        public String getFbillno() {
            return fbillno;
        }

        public int getSyncStatus() {
            return syncStatus;
        }

        public String getFbilltypeid() {
            return fbilltypeid;
        }

        public class EntryDetailsEntity {
            /**
             * fstockstatusid : 0
             * fmodel :
             * fentrynote :
             * fsrcbillno : 0
             * fpaezproject :
             * fmaterialid :
             * famount : 0
             * fownertypeid : 0
             * fprice : 0
             * fsrcmisdelentryid : 0
             * fkeeperid : 0
             * fprojectno :
             * fbaseunitid : 0
             * flot :
             * id : 0
             * fsecqty : 0
             * fpaezprojectname :
             * fqty : 0
             * funitid : 0
             * fstockid : 0
             * fkeepertypeid : 0
             * fstocklocid : 0
             * parentId : 0
             * fownerid : 0
             * fbaseqty : 0
             * fentryid : 0
             * fmaterialname :
             * fsrcbilltypeid : 0
             */
            private int fstockstatusid;
            private String fmodel;
            private String fentrynote;
            private int fsrcbillno;
            private String fpaezproject;
            private String fmaterialid;
            private int famount;
            private int fownertypeid;
            private int fprice;
            private int fsrcmisdelentryid;
            private int fkeeperid;
            private String fprojectno;
            private int fbaseunitid;
            private String flot;
            private int id;
            private int fsecqty;
            private String fpaezprojectname;
            private int fqty;
            private int funitid;
            private int fstockid;
            private int fkeepertypeid;
            private int fstocklocid;
            private int parentId;
            private int fownerid;
            private int fbaseqty;
            private int fentryid;
            private String fmaterialname;
            private int fsrcbilltypeid;

            public void setFstockstatusid(int fstockstatusid) {
                this.fstockstatusid = fstockstatusid;
            }

            public void setFmodel(String fmodel) {
                this.fmodel = fmodel;
            }

            public void setFentrynote(String fentrynote) {
                this.fentrynote = fentrynote;
            }

            public void setFsrcbillno(int fsrcbillno) {
                this.fsrcbillno = fsrcbillno;
            }

            public void setFpaezproject(String fpaezproject) {
                this.fpaezproject = fpaezproject;
            }

            public void setFmaterialid(String fmaterialid) {
                this.fmaterialid = fmaterialid;
            }

            public void setFamount(int famount) {
                this.famount = famount;
            }

            public void setFownertypeid(int fownertypeid) {
                this.fownertypeid = fownertypeid;
            }

            public void setFprice(int fprice) {
                this.fprice = fprice;
            }

            public void setFsrcmisdelentryid(int fsrcmisdelentryid) {
                this.fsrcmisdelentryid = fsrcmisdelentryid;
            }

            public void setFkeeperid(int fkeeperid) {
                this.fkeeperid = fkeeperid;
            }

            public void setFprojectno(String fprojectno) {
                this.fprojectno = fprojectno;
            }

            public void setFbaseunitid(int fbaseunitid) {
                this.fbaseunitid = fbaseunitid;
            }

            public void setFlot(String flot) {
                this.flot = flot;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setFsecqty(int fsecqty) {
                this.fsecqty = fsecqty;
            }

            public void setFpaezprojectname(String fpaezprojectname) {
                this.fpaezprojectname = fpaezprojectname;
            }

            public void setFqty(int fqty) {
                this.fqty = fqty;
            }

            public void setFunitid(int funitid) {
                this.funitid = funitid;
            }

            public void setFstockid(int fstockid) {
                this.fstockid = fstockid;
            }

            public void setFkeepertypeid(int fkeepertypeid) {
                this.fkeepertypeid = fkeepertypeid;
            }

            public void setFstocklocid(int fstocklocid) {
                this.fstocklocid = fstocklocid;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public void setFownerid(int fownerid) {
                this.fownerid = fownerid;
            }

            public void setFbaseqty(int fbaseqty) {
                this.fbaseqty = fbaseqty;
            }

            public void setFentryid(int fentryid) {
                this.fentryid = fentryid;
            }

            public void setFmaterialname(String fmaterialname) {
                this.fmaterialname = fmaterialname;
            }

            public void setFsrcbilltypeid(int fsrcbilltypeid) {
                this.fsrcbilltypeid = fsrcbilltypeid;
            }

            public int getFstockstatusid() {
                return fstockstatusid;
            }

            public String getFmodel() {
                return fmodel;
            }

            public String getFentrynote() {
                return fentrynote;
            }

            public int getFsrcbillno() {
                return fsrcbillno;
            }

            public String getFpaezproject() {
                return fpaezproject;
            }

            public String getFmaterialid() {
                return fmaterialid;
            }

            public int getFamount() {
                return famount;
            }

            public int getFownertypeid() {
                return fownertypeid;
            }

            public int getFprice() {
                return fprice;
            }

            public int getFsrcmisdelentryid() {
                return fsrcmisdelentryid;
            }

            public int getFkeeperid() {
                return fkeeperid;
            }

            public String getFprojectno() {
                return fprojectno;
            }

            public int getFbaseunitid() {
                return fbaseunitid;
            }

            public String getFlot() {
                return flot;
            }

            public int getId() {
                return id;
            }

            public int getFsecqty() {
                return fsecqty;
            }

            public String getFpaezprojectname() {
                return fpaezprojectname;
            }

            public int getFqty() {
                return fqty;
            }

            public int getFunitid() {
                return funitid;
            }

            public int getFstockid() {
                return fstockid;
            }

            public int getFkeepertypeid() {
                return fkeepertypeid;
            }

            public int getFstocklocid() {
                return fstocklocid;
            }

            public int getParentId() {
                return parentId;
            }

            public int getFownerid() {
                return fownerid;
            }

            public int getFbaseqty() {
                return fbaseqty;
            }

            public int getFentryid() {
                return fentryid;
            }

            public String getFmaterialname() {
                return fmaterialname;
            }

            public int getFsrcbilltypeid() {
                return fsrcbilltypeid;
            }
        }
    }
}
