package com.kingdee.ah.pda.dataBase;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;

/**
 * <p>
 * 供应商
 * </p>
 *
 * @author xufeng
 * @since 2020-09-25
 */

public class BdSupplier extends LitePalSupport implements Serializable {


    /**
     * fdocumentStatus : C
     * fname : 滁州市伟达模具设备制造有限公司
     * fcreateOrgId : 1
     * fnumber : 1010001
     * fdescription :
     * fuseOrgId : 1
     * fsupplierId : 152967
     */
    private String fdocumentStatus;
    private String fname;
    private int fcreateOrgId;
    private String fnumber;
    private String fdescription;
    private int fuseOrgId;
    private int fsupplierId;

    public void setFdocumentStatus(String fdocumentStatus) {
        this.fdocumentStatus = fdocumentStatus;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setFcreateOrgId(int fcreateOrgId) {
        this.fcreateOrgId = fcreateOrgId;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber;
    }

    public void setFdescription(String fdescription) {
        this.fdescription = fdescription;
    }

    public void setFuseOrgId(int fuseOrgId) {
        this.fuseOrgId = fuseOrgId;
    }

    public void setFsupplierId(int fsupplierId) {
        this.fsupplierId = fsupplierId;
    }

    public String getFdocumentStatus() {
        return fdocumentStatus;
    }

    public String getFname() {
        return fname;
    }

    public int getFcreateOrgId() {
        return fcreateOrgId;
    }

    public String getFnumber() {
        return fnumber;
    }

    public String getFdescription() {
        return fdescription;
    }

    public int getFuseOrgId() {
        return fuseOrgId;
    }

    public int getFsupplierId() {
        return fsupplierId;
    }
}
