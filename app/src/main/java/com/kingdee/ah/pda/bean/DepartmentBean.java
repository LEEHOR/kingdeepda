package com.kingdee.ah.pda.bean;

import com.kingdee.ah.pda.dataBase.BdDepartment;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: DepartmentBean
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/26 20:45
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/26 20:45
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class DepartmentBean implements Serializable {

    /**
     * msg : 操作成功
     * code : 0
     * data : [{"fname":"董事办","fisRoot":1,"fdeptid":153603,"fdepth":1,"fparentID":"0","flevelCode":".153603.","fnumber":"JHF0001","fdescription":" "},{"fname":"总经办","fisRoot":0,"fdeptid":153604,"fdepth":2,"fparentID":"153603","flevelCode":".153603.153604.","fnumber":"JHF0002","fdescription":" "}]
     */
    private String msg;
    private int code;
    private List<BdDepartment> data;

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

    public List<BdDepartment> getData() {
        return data;
    }

    public void setData(List<BdDepartment> data) {
        this.data = data;
    }
}
