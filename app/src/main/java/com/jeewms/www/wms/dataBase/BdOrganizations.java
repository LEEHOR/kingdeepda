package com.jeewms.www.wms.dataBase;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
/**
 * <p>
 * 组织机构
 * </p>
 *
 * @author weilun
 * @since 2020-10-01
 */
public class BdOrganizations extends LitePalSupport implements Serializable {

    /**
     * fname : 金锋馥（滁州）输送机械有限公司（管理）
     * fpurchasebox : null
     * forgfunctions : 103,104
     * fparentid : 1
     * fisbusinessorg : true
     * forgid : 1
     * ffactorybox : null
     * fforbidstatus : A
     * forgformid : 101
     * fdescription :
     * fdocumentstatus : C
     * fstockbox : null
     * fnumber : 100
     */
    private String fname;
    private String fpurchasebox;
    private String forgfunctions;
    private String fparentid;
    private String fisbusinessorg;
    private int forgid;
    private String ffactorybox;
    private String fforbidstatus;
    private String forgformid;
    private String fdescription;
    private String fdocumentstatus;
    private String fstockbox;
    private String fnumber;

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setFpurchasebox(String fpurchasebox) {
        this.fpurchasebox = fpurchasebox;
    }

    public void setForgfunctions(String forgfunctions) {
        this.forgfunctions = forgfunctions;
    }

    public void setFparentid(String fparentid) {
        this.fparentid = fparentid;
    }

    public void setFisbusinessorg(String fisbusinessorg) {
        this.fisbusinessorg = fisbusinessorg;
    }

    public void setForgid(int forgid) {
        this.forgid = forgid;
    }

    public void setFfactorybox(String ffactorybox) {
        this.ffactorybox = ffactorybox;
    }

    public void setFforbidstatus(String fforbidstatus) {
        this.fforbidstatus = fforbidstatus;
    }

    public void setForgformid(String forgformid) {
        this.forgformid = forgformid;
    }

    public void setFdescription(String fdescription) {
        this.fdescription = fdescription;
    }

    public void setFdocumentstatus(String fdocumentstatus) {
        this.fdocumentstatus = fdocumentstatus;
    }

    public void setFstockbox(String fstockbox) {
        this.fstockbox = fstockbox;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber;
    }

    public String getFname() {
        return fname;
    }

    public String getFpurchasebox() {
        return fpurchasebox;
    }

    public String getForgfunctions() {
        return forgfunctions;
    }

    public String getFparentid() {
        return fparentid;
    }

    public String getFisbusinessorg() {
        return fisbusinessorg;
    }

    public int getForgid() {
        return forgid;
    }

    public String getFfactorybox() {
        return ffactorybox;
    }

    public String getFforbidstatus() {
        return fforbidstatus;
    }

    public String getForgformid() {
        return forgformid;
    }

    public String getFdescription() {
        return fdescription;
    }

    public String getFdocumentstatus() {
        return fdocumentstatus;
    }

    public String getFstockbox() {
        return fstockbox;
    }

    public String getFnumber() {
        return fnumber;
    }
}
