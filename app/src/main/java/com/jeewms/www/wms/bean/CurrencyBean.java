package com.jeewms.www.wms.bean;

import com.jeewms.www.wms.dataBase.BdCurrency;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: CurrencyBean
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/24 14:56
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/24 14:56
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class CurrencyBean implements Serializable {

    /**
     * msg : 操作成功
     * code : 0
     * data : [{"fname":"人民币","froundType":1,"fforbidStatus":"A","famountdigits":2,"fpricedigits":6,"fnumber":"PRE001","fcurrencyid":1,"fcode":"CNY"},{"fname":"香港元","froundType":1,"fforbidStatus":"A","famountdigits":2,"fpricedigits":6,"fnumber":"PRE002","fcurrencyid":2,"fcode":"HKD"},{"fname":"欧元","froundType":1,"fforbidStatus":"A","famountdigits":2,"fpricedigits":6,"fnumber":"PRE003","fcurrencyid":3,"fcode":"EUR"}]
     */
    private String msg;
    private int code;
    private List<BdCurrency> data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public List<BdCurrency> getData() {
        return data;
    }

    public void setData(List<BdCurrency> data) {
        this.data = data;
    }
}
