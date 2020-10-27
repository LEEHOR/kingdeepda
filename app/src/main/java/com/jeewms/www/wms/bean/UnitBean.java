package com.jeewms.www.wms.bean;

import com.jeewms.www.wms.dataBase.BdUnit;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: UnitBean
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/24 15:02
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/24 15:02
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class UnitBean  implements Serializable {


    /**
     * msg : 操作成功
     * code : 0
     * data : [{"fdocumentStatus":"C","fname":"米","fforbidStatus":"A","funitid":10087,"fnumber":"m","funitGroupId":10081},{"fdocumentStatus":"C","fname":"千米","fforbidStatus":"A","funitid":10088,"fnumber":"km","funitGroupId":10081}]
     */
    private String msg;
    private int code;
    private List<BdUnit> data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<BdUnit> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public List<BdUnit> getData() {
        return data;
    }
}
