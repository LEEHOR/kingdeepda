package com.jeewms.www.wms.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: SupplierBean
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/24 15:00
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/24 15:00
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class SupplierBean implements Serializable {

    /**
     * code : 0
     * data : [{"fname":"滁州市伟达模具设备制造有限公司","fnumber":"1010001"},{"fname":"滁州运德机械制造有限公司","fnumber":"1010002"},{"fname":"上海市金山区良盛氟塑泵厂","fnumber":"1010003"}]
     * count : 276
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
         * fname : 滁州市伟达模具设备制造有限公司
         * fnumber : 1010001
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
