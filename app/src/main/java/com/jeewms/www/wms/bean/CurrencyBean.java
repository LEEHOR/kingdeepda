package com.jeewms.www.wms.bean;

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
     * code : 0
     * data : [{"fname":"人民币","fnumber":"PRE001"},{"fname":"香港元","fnumber":"PRE002"},{"fname":"欧元","fnumber":"PRE003"},{"fname":"日本日元","fnumber":"PRE004"},{"fname":"新台币元","fnumber":"PRE005"}]
     * count : 7
     */
    private int code;
    private List<DataEntity> data;
    private int count;

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public class DataEntity {
        /**
         * fname : 人民币
         * fnumber : PRE001
         */
        private String fname;
        private String fnumber;

        public void setFname(String fname) {
            this.fname = fname;
        }

        public void setFnumber(String fnumber) {
            this.fnumber = fnumber;
        }

        public String getFname() {
            return fname;
        }

        public String getFnumber() {
            return fnumber;
        }
    }
}
