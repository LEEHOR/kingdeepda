package com.jeewms.www.wms.bean;

import com.jeewms.www.wms.dataBase.BdMaterialcategory;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: MaterialCategory
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/26 20:43
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/26 20:43
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MaterialCategoryBean implements Serializable {

    /**
     * msg : 操作成功
     * code : 0
     * data : [{"fname":"原材料","fcategoryid":237,"fnumber":"CHLB01_SYS","fdescription":" "},{"fname":"辅料","fcategoryid":238,"fnumber":"CHLB02_SYS","fdescription":" "}]
     */
    private String msg;
    private int code;
    private List<BdMaterialcategory> data;

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

    public List<BdMaterialcategory> getData() {
        return data;
    }

    public void setData(List<BdMaterialcategory> data) {
        this.data = data;
    }
}
