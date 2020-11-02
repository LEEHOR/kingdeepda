package com.kingdee.ah.pda.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: PurchaseAddBean
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/26 14:21
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/26 14:21
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class PurchaseAddBean implements Serializable {

    /**
     * msg : 操作失败
     * code : 1
     * data : [{"Message":"\u201cAdministrator\u201d使用业务单据：\u201c采购入库单\u201d业务操作-\u201c[采购入库单-CGRK00011-修改]\u201d冲突，请稍候再使用。","FieldName":null,"DIndex":0}]
     */
    private String msg;
    private int code;
    private List<DataEntity> data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public class DataEntity {
        /**
         * Message : “Administrator”使用业务单据：“采购入库单”业务操作-“[采购入库单-CGRK00011-修改]”冲突，请稍候再使用。
         * FieldName : null
         * DIndex : 0
         */
        private String Message;
        private String FieldName;
        private int DIndex;

        public void setMessage(String Message) {
            this.Message = Message;
        }

        public void setFieldName(String FieldName) {
            this.FieldName = FieldName;
        }

        public void setDIndex(int DIndex) {
            this.DIndex = DIndex;
        }

        public String getMessage() {
            return Message;
        }

        public String getFieldName() {
            return FieldName;
        }

        public int getDIndex() {
            return DIndex;
        }
    }
}
