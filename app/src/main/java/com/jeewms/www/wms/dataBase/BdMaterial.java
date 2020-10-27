package com.jeewms.www.wms.dataBase;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
/**
 * <p>
 * 金蝶物料表
 * </p>
 *
 * @author tyl
 * @since 2020-09-21
 */
public class BdMaterial extends LitePalSupport implements Serializable {


    /**
     * fname : 斜齿轮减速电机
     * fmaterialid : 133046
     * fpurpricecmk : 0
     * fdescription :
     * fgoodbarcodecmk :
     * categoryName : null
     * fbarcode : null
     * fvippricecmk : 0
     * fspecification : R/17/DRS/71S4/0.37KW/i=5.76/M1/0/3
     * fpbxqbrand : SEW
     * fcategoryid : 237
     * fnumber : 04.01.001.00001
     * fsalepricecmk : 0
     * funitidCmk : 0
     */
    private String fname;
    private int fmaterialid;
    private int fpurpricecmk;
    private String fdescription;
    private String fgoodbarcodecmk;
    private String categoryName;
    private String fbarcode;
    private int fvippricecmk;
    private String fspecification;
    private String fpbxqbrand;
    private int fcategoryid;
    private String fnumber;
    private int fsalepricecmk;
    private String funitidCmk;

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setFmaterialid(int fmaterialid) {
        this.fmaterialid = fmaterialid;
    }

    public void setFpurpricecmk(int fpurpricecmk) {
        this.fpurpricecmk = fpurpricecmk;
    }

    public void setFdescription(String fdescription) {
        this.fdescription = fdescription;
    }

    public void setFgoodbarcodecmk(String fgoodbarcodecmk) {
        this.fgoodbarcodecmk = fgoodbarcodecmk;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setFbarcode(String fbarcode) {
        this.fbarcode = fbarcode;
    }

    public void setFvippricecmk(int fvippricecmk) {
        this.fvippricecmk = fvippricecmk;
    }

    public void setFspecification(String fspecification) {
        this.fspecification = fspecification;
    }

    public void setFpbxqbrand(String fpbxqbrand) {
        this.fpbxqbrand = fpbxqbrand;
    }

    public void setFcategoryid(int fcategoryid) {
        this.fcategoryid = fcategoryid;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber;
    }

    public void setFsalepricecmk(int fsalepricecmk) {
        this.fsalepricecmk = fsalepricecmk;
    }

    public void setFunitidCmk(String funitidCmk) {
        this.funitidCmk = funitidCmk;
    }

    public String getFname() {
        return fname;
    }

    public int getFmaterialid() {
        return fmaterialid;
    }

    public int getFpurpricecmk() {
        return fpurpricecmk;
    }

    public String getFdescription() {
        return fdescription;
    }

    public String getFgoodbarcodecmk() {
        return fgoodbarcodecmk;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getFbarcode() {
        return fbarcode;
    }

    public int getFvippricecmk() {
        return fvippricecmk;
    }

    public String getFspecification() {
        return fspecification;
    }

    public String getFpbxqbrand() {
        return fpbxqbrand;
    }

    public int getFcategoryid() {
        return fcategoryid;
    }

    public String getFnumber() {
        return fnumber;
    }

    public int getFsalepricecmk() {
        return fsalepricecmk;
    }

    public String getFunitidCmk() {
        return funitidCmk;
    }
}
