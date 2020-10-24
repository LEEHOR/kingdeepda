package com.jeewms.www.wms.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: OrganizationsBean
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/24 15:05
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/24 15:05
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class OrganizationsBean implements Serializable {

    /**
     * code : 0
     * data : [{"fname":"金锋馥（滁州）输送机械有限公司（管理）","fnumber":"100"},{"fname":"金锋馥（滁州）输送机械有限公司","fnumber":"200"},{"fname":"上海和进物流机械有限公司","fnumber":"300"}]
     * count : 5
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
         * fname : 金锋馥（滁州）输送机械有限公司（管理）
         * fnumber : 100
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
