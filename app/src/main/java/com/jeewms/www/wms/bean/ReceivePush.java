package com.jeewms.www.wms.bean;

import java.io.Serializable;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: ReceivingPush
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/16 16:18
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/16 16:18
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ReceivePush implements Serializable {

    /**
     * msg : 操作成功
     * code : 0
     * data : {"Number":"CGRK00026","Id":100034,"DIndex":0}
     */
    private String msg;
    private int code;
    private DataEntity data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public DataEntity getData() {
        return data;
    }

    public class DataEntity {
        /**
         * Number : CGRK00026
         * Id : 100034
         * DIndex : 0
         */
        private String Number;
        private int Id;
        private int DIndex;

        public void setNumber(String Number) {
            this.Number = Number;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public void setDIndex(int DIndex) {
            this.DIndex = DIndex;
        }

        public String getNumber() {
            return Number;
        }

        public int getId() {
            return Id;
        }

        public int getDIndex() {
            return DIndex;
        }
    }
}
