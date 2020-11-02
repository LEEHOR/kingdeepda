package com.kingdee.ah.pda.dataBase;
import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
/**
 * <p>
 * 金蝶部门表
 * </p>
 *
 * @author tyl
 * @since 2020-09-21
 */
public class BdDepartment extends LitePalSupport implements Serializable {


    /**
     * fname : 董事办
     * fisRoot : 1
     * fdeptid : 153603
     * fdepth : 1
     * fparentID : 0
     * flevelCode : .153603.
     * fnumber : JHF0001
     * fdescription :
     */
    private String fname;
    private int fisRoot;
    private int fdeptid;
    private int fdepth;
    private String fparentID;
    private String flevelCode;
    private String fnumber;
    private String fdescription;

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setFisRoot(int fisRoot) {
        this.fisRoot = fisRoot;
    }

    public void setFdeptid(int fdeptid) {
        this.fdeptid = fdeptid;
    }

    public void setFdepth(int fdepth) {
        this.fdepth = fdepth;
    }

    public void setFparentID(String fparentID) {
        this.fparentID = fparentID;
    }

    public void setFlevelCode(String flevelCode) {
        this.flevelCode = flevelCode;
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

    public int getFisRoot() {
        return fisRoot;
    }

    public int getFdeptid() {
        return fdeptid;
    }

    public int getFdepth() {
        return fdepth;
    }

    public String getFparentID() {
        return fparentID;
    }

    public String getFlevelCode() {
        return flevelCode;
    }

    public String getFnumber() {
        return fnumber;
    }

    public String getFdescription() {
        return fdescription;
    }
}
