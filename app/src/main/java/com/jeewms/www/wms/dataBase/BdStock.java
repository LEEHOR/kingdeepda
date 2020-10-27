package com.jeewms.www.wms.dataBase;
import org.litepal.crud.LitePalSupport;

import java.io.Serializable;

/**
 * <p>
 * 仓库
 * </p>
 *
 * @author xufeng
 * @since 2020-09-24
 */

public class BdStock extends LitePalSupport implements Serializable {


    /**
     * fname : 原材料仓库
     * faddress :
     * ftel : 0
     * fforbidstatus : A
     * fprincipal :
     * fstockid : 165767
     * fnumber : null
     * fdescription : DQ001
     */
    private String fname;
    private String faddress;
    private String ftel;
    private String fforbidstatus;
    private String fprincipal;
    private int fstockid;
    private String fnumber;
    private String fdescription;

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setFaddress(String faddress) {
        this.faddress = faddress;
    }

    public void setFtel(String ftel) {
        this.ftel = ftel;
    }

    public void setFforbidstatus(String fforbidstatus) {
        this.fforbidstatus = fforbidstatus;
    }

    public void setFprincipal(String fprincipal) {
        this.fprincipal = fprincipal;
    }

    public void setFstockid(int fstockid) {
        this.fstockid = fstockid;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber;
    }

    public void setFdescription(String fdescription) {
        this.fdescription = fdescription;
    }

    public String getFname() {
        return fname;
    }

    public String getFaddress() {
        return faddress;
    }

    public String getFtel() {
        return ftel;
    }

    public String getFforbidstatus() {
        return fforbidstatus;
    }

    public String getFprincipal() {
        return fprincipal;
    }

    public int getFstockid() {
        return fstockid;
    }

    public String getFnumber() {
        return fnumber;
    }

    public String getFdescription() {
        return fdescription;
    }
}
