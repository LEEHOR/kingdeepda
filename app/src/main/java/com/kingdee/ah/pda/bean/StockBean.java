package com.kingdee.ah.pda.bean;

import com.kingdee.ah.pda.dataBase.BdStock;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean.vm
 * @ClassName: StockClass
 * @Description: java类作用描述
 * 仓库列表
 * @Author: 作者名
 * @CreateDate: 2020/10/14 21:51
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/14 21:51
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class StockBean implements Serializable {


    /**
     * msg : 操作成功
     * code : 0
     * data : [{"fname":"原材料仓库","faddress":" ","ftel":"0","fforbidstatus":"A","fprincipal":" ","fstockid":165767,"fnumber":null,"fdescription":"DQ001"},{"fname":"成品仓","faddress":" ","ftel":"0","fforbidstatus":"A","fprincipal":" ","fstockid":165768,"fnumber":null,"fdescription":"DQ002"}]
     */
    private String msg;
    private int code;
    private List<BdStock> data;

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

    public List<BdStock> getData() {
        return data;
    }

    public void setData(List<BdStock> data) {
        this.data = data;
    }
}
