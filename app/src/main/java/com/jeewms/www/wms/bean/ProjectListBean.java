package com.jeewms.www.wms.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: ProjectListBean
 * @Description: java类作用描述
 * 项目列表
 * @Author: 作者名
 * @CreateDate: 2020/10/22 9:06
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/22 9:06
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ProjectListBean implements Serializable {

    /**
     * msg : null
     * code : 0
     * data : [{"fid":184419,"fcreateorgid":"110779","fname":"京东物流转运中心（东南）","fprojectstageid":"0","fprojectmanagerid":"0","fpbxqprojectstatus":"0","fforbidstatus":"A","fdescription":" ","fpbxqproject":"0","fprojectproperty":" ","fnumber":"cs0001","fuseorgid":"110779","fcustomerid":"0","fcustomertel":" "}]
     * count : 7
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
         * fid : 184419
         * fcreateorgid : 110779
         * fname : 京东物流转运中心（东南）
         * fprojectstageid : 0
         * fprojectmanagerid : 0
         * fpbxqprojectstatus : 0
         * fforbidstatus : A
         * fdescription :
         * fpbxqproject : 0
         * fprojectproperty :
         * fnumber : cs0001
         * fuseorgid : 110779
         * fcustomerid : 0
         * fcustomertel :
         */
        private int fid;
        private String fcreateorgid;
        private String fname;
        private String fprojectstageid;
        private String fprojectmanagerid;
        private String fpbxqprojectstatus;
        private String fforbidstatus;
        private String fdescription;
        private String fpbxqproject;
        private String fprojectproperty;
        private String fnumber;
        private String fuseorgid;
        private String fcustomerid;
        private String fcustomertel;

        public void setFid(int fid) {
            this.fid = fid;
        }

        public void setFcreateorgid(String fcreateorgid) {
            this.fcreateorgid = fcreateorgid;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public void setFprojectstageid(String fprojectstageid) {
            this.fprojectstageid = fprojectstageid;
        }

        public void setFprojectmanagerid(String fprojectmanagerid) {
            this.fprojectmanagerid = fprojectmanagerid;
        }

        public void setFpbxqprojectstatus(String fpbxqprojectstatus) {
            this.fpbxqprojectstatus = fpbxqprojectstatus;
        }

        public void setFforbidstatus(String fforbidstatus) {
            this.fforbidstatus = fforbidstatus;
        }

        public void setFdescription(String fdescription) {
            this.fdescription = fdescription;
        }

        public void setFpbxqproject(String fpbxqproject) {
            this.fpbxqproject = fpbxqproject;
        }

        public void setFprojectproperty(String fprojectproperty) {
            this.fprojectproperty = fprojectproperty;
        }

        public void setFnumber(String fnumber) {
            this.fnumber = fnumber;
        }

        public void setFuseorgid(String fuseorgid) {
            this.fuseorgid = fuseorgid;
        }

        public void setFcustomerid(String fcustomerid) {
            this.fcustomerid = fcustomerid;
        }

        public void setFcustomertel(String fcustomertel) {
            this.fcustomertel = fcustomertel;
        }

        public int getFid() {
            return fid;
        }

        public String getFcreateorgid() {
            return fcreateorgid;
        }

        public String getFname() {
            return fname;
        }

        public String getFprojectstageid() {
            return fprojectstageid;
        }

        public String getFprojectmanagerid() {
            return fprojectmanagerid;
        }

        public String getFpbxqprojectstatus() {
            return fpbxqprojectstatus;
        }

        public String getFforbidstatus() {
            return fforbidstatus;
        }

        public String getFdescription() {
            return fdescription;
        }

        public String getFpbxqproject() {
            return fpbxqproject;
        }

        public String getFprojectproperty() {
            return fprojectproperty;
        }

        public String getFnumber() {
            return fnumber;
        }

        public String getFuseorgid() {
            return fuseorgid;
        }

        public String getFcustomerid() {
            return fcustomerid;
        }

        public String getFcustomertel() {
            return fcustomertel;
        }
    }
}
