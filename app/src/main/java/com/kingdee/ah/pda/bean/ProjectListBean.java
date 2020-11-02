package com.kingdee.ah.pda.bean;

import com.kingdee.ah.pda.dataBase.BdProject;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: ProjectListBean
 * @Description: java类作用描述
 * 项目列表
 * @Author: 作者名
 * @CreateDate: 2020/10/22 9:06
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/22 9:06
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ProjectListBean implements Serializable {

    /**
     * msg : 操作成功
     * code : 0
     * data : [{"fid":184419,"fcreateorgid":"110779","fname":"京东物流转运中心（东南）","fprojectstageid":"0","fprojectmanagerid":"0","fpbxqprojectstatus":"0","fforbidstatus":"A","fdescription":" ","fpbxqproject":"0","fprojectproperty":" ","fnumber":"cs0001","fuseorgid":"110779","fcustomerid":"0","fcustomertel":" "},{"fid":184420,"fcreateorgid":"110779","fname":"京邦达物流转运中心","fprojectstageid":"0","fprojectmanagerid":"0","fpbxqprojectstatus":"0","fforbidstatus":"A","fdescription":" ","fpbxqproject":"0","fprojectproperty":"Project","fnumber":"cs002","fuseorgid":"110779","fcustomerid":"182240","fcustomertel":" "}]
     */
    private String msg;
    private int code;
    private List<BdProject> data;

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

    public List<BdProject> getData() {
        return data;
    }

    public void setData(List<BdProject> data) {
        this.data = data;
    }
}
