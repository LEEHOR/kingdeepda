package com.kingdee.ah.pda.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.bean
 * @ClassName: SalDeliverynoticeBean
 * @Description: java类作用描述
 * 发货通知
 * @Author: 李浩
 * @CreateDate: 2020/11/3 22:36
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/3 22:36
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class SalDeliverynoticeBean implements Serializable {

    /**
     * msg : 操作成功
     * code : 0
     * data : [{"date":"2020-09-17T00:00:00","billNoLike":null,"limit":null,"documentStatus":"C","page":null,"billNo":"CGSL000014"},{"date":"2020-09-22T00:00:00","billNoLike":null,"limit":null,"documentStatus":"C","page":null,"billNo":"CGSL000015"},{"date":"2020-09-24T00:00:00","billNoLike":null,"limit":null,"documentStatus":"C","page":null,"billNo":"CGSL000016"},{"date":"2020-09-24T00:00:00","billNoLike":null,"limit":null,"documentStatus":"C","page":null,"billNo":"CGSL000017"},{"date":"2020-09-24T00:00:00","billNoLike":null,"limit":null,"documentStatus":"C","page":null,"billNo":"CGSL000018"},{"date":"2020-10-15T00:00:00","billNoLike":null,"limit":null,"documentStatus":"C","page":null,"billNo":"CGSL000019"},{"date":"2020-10-15T00:00:00","billNoLike":null,"limit":null,"documentStatus":"C","page":null,"billNo":"CGSL000020"},{"date":"2020-10-19T00:00:00","billNoLike":null,"limit":null,"documentStatus":"C","page":null,"billNo":"CGSL000021"},{"date":"2020-10-23T00:00:00","billNoLike":null,"limit":null,"documentStatus":"C","page":null,"billNo":"CGSL000022"},{"date":"2020-10-23T00:00:00","billNoLike":null,"limit":null,"documentStatus":"C","page":null,"billNo":"CGSL000024"}]
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
         * date : 2020-09-17T00:00:00
         * billNoLike : null
         * limit : null
         * documentStatus : C
         * page : null
         * billNo : CGSL000014
         */
        private String date;
        private String billNoLike;
        private String limit;
        private String documentStatus;
        private String page;
        private String billNo;

        public void setDate(String date) {
            this.date = date;
        }

        public void setBillNoLike(String billNoLike) {
            this.billNoLike = billNoLike;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public void setDocumentStatus(String documentStatus) {
            this.documentStatus = documentStatus;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public void setBillNo(String billNo) {
            this.billNo = billNo;
        }

        public String getDate() {
            return date;
        }

        public String getBillNoLike() {
            return billNoLike;
        }

        public String getLimit() {
            return limit;
        }

        public String getDocumentStatus() {
            return documentStatus;
        }

        public String getPage() {
            return page;
        }

        public String getBillNo() {
            return billNo;
        }
    }
}
