package com.jeewms.www.wms.bean;

import com.jeewms.www.wms.dataBase.BdSupplier;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: SupplierBean
 * @Description: java类作用描述
 *  供应商
 * @Author: 作者名
 * @CreateDate: 2020/10/24 15:00
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/24 15:00
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class SupplierBean implements Serializable {


    /**
     * msg : 操作成功
     * code : 0
     * data : [{"fdocumentStatus":"C","fname":"滁州市伟达模具设备制造有限公司","fcreateOrgId":1,"fnumber":"1010001","fdescription":" ","fuseOrgId":1,"fsupplierId":152967},{"fdocumentStatus":"C","fname":"滁州运德机械制造有限公司","fcreateOrgId":1,"fnumber":"1010002","fdescription":" ","fuseOrgId":1,"fsupplierId":152968}]
     */
    private String msg;
    private int code;
    private List<BdSupplier> data;

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

    public List<BdSupplier> getData() {
        return data;
    }

    public void setData(List<BdSupplier> data) {
        this.data = data;
    }
}
