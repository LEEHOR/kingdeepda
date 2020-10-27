package com.jeewms.www.wms.dataBase;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
/**
 * <p>
 * 单位表
 * </p>
 *
 * @author liujb
 * @since 2020-09-29
 */
public class BdUnit extends LitePalSupport implements Serializable {


    /**
     * fdocumentStatus : C
     * fname : 米
     * fforbidStatus : A
     * funitid : 10087
     * fnumber : m
     * funitGroupId : 10081
     */
    private String fdocumentStatus;
    private String fname;
    private String fforbidStatus;
    private int funitid;
    private String fnumber;
    private int funitGroupId;

    public void setFdocumentStatus(String fdocumentStatus) {
        this.fdocumentStatus = fdocumentStatus;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setFforbidStatus(String fforbidStatus) {
        this.fforbidStatus = fforbidStatus;
    }

    public void setFunitid(int funitid) {
        this.funitid = funitid;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber;
    }

    public void setFunitGroupId(int funitGroupId) {
        this.funitGroupId = funitGroupId;
    }

    public String getFdocumentStatus() {
        return fdocumentStatus;
    }

    public String getFname() {
        return fname;
    }

    public String getFforbidStatus() {
        return fforbidStatus;
    }

    public int getFunitid() {
        return funitid;
    }

    public String getFnumber() {
        return fnumber;
    }

    public int getFunitGroupId() {
        return funitGroupId;
    }
}
