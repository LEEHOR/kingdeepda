package com.kingdee.ah.pda.bean;

import com.kingdee.ah.pda.dataBase.BdOrganizations;

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
     * msg : 操作成功
     * code : 0
     * data : [{"fname":"金锋馥（滁州）输送机械有限公司（管理）","fpurchasebox":null,"forgfunctions":"103,104","fparentid":"1","fisbusinessorg":"true","forgid":1,"ffactorybox":null,"fforbidstatus":"A","forgformid":"101","fdescription":" ","fdocumentstatus":"C","fstockbox":null,"fnumber":"100"},{"fname":"金锋馥（滁州）输送机械有限公司","fpurchasebox":null,"forgfunctions":"101,102,103,104,107,108,109,110,111,112,113,115","fparentid":"110779","fisbusinessorg":"true","forgid":110779,"ffactorybox":null,"fforbidstatus":"A","forgformid":"102","fdescription":" ","fdocumentstatus":"C","fstockbox":null,"fnumber":"200"}]
     */
    private String msg;
    private int code;
    private List<BdOrganizations> data;

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

    public List<BdOrganizations> getData() {
        return data;
    }

    public void setData(List<BdOrganizations> data) {
        this.data = data;
    }
}
