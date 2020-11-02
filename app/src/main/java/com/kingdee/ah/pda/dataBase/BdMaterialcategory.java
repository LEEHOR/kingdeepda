package com.kingdee.ah.pda.dataBase;
import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
/**
 * <p>
 * 存货类别
 * </p>
 *
 * @author tyl
 * @since 2020-09-21
 */
public class BdMaterialcategory extends LitePalSupport implements Serializable {

    /**
     * fname : 原材料
     * fcategoryid : 237
     * fnumber : CHLB01_SYS
     * fdescription :
     */
    private String fname;
    private int fcategoryid;
    private String fnumber;
    private String fdescription;

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setFcategoryid(int fcategoryid) {
        this.fcategoryid = fcategoryid;
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

    public int getFcategoryid() {
        return fcategoryid;
    }

    public String getFnumber() {
        return fnumber;
    }

    public String getFdescription() {
        return fdescription;
    }
}
