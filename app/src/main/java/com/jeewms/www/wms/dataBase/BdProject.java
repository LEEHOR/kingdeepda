package com.jeewms.www.wms.dataBase;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
/**
 * <p>
 * 项目库
 * </p>
 *
 * @author xufeng
 * @since 2020-09-24
 */
public class BdProject extends LitePalSupport implements Serializable {


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
