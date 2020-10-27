package com.jeewms.www.wms.dataBase;
import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 币别
 * </p>
 *
 * @author liujb
 * @since 2020-09-29
 */
public class BdCurrency extends LitePalSupport implements Serializable {
    private String fname;
    private int froundType;
    private String fforbidStatus;
    private int famountdigits;
    private int fpricedigits;
    private String fnumber;
    private int fcurrencyid;
    private String fcode;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getFroundType() {
        return froundType;
    }

    public void setFroundType(int froundType) {
        this.froundType = froundType;
    }

    public String getFforbidStatus() {
        return fforbidStatus;
    }

    public void setFforbidStatus(String fforbidStatus) {
        this.fforbidStatus = fforbidStatus;
    }

    public int getFamountdigits() {
        return famountdigits;
    }

    public void setFamountdigits(int famountdigits) {
        this.famountdigits = famountdigits;
    }

    public int getFpricedigits() {
        return fpricedigits;
    }

    public void setFpricedigits(int fpricedigits) {
        this.fpricedigits = fpricedigits;
    }

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber;
    }

    public int getFcurrencyid() {
        return fcurrencyid;
    }

    public void setFcurrencyid(int fcurrencyid) {
        this.fcurrencyid = fcurrencyid;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }
}
