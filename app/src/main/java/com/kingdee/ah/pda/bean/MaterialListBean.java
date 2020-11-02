package com.kingdee.ah.pda.bean;

import com.kingdee.ah.pda.dataBase.BdMaterial;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: MaterialList
 * @Description: java类作用描述
 *   物料分类查询
 * @Author: 作者名
 * @CreateDate: 2020/10/22 9:04
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/22 9:04
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MaterialListBean implements Serializable {


    /**
     * msg : 操作成功
     * code : 0
     * data : [{"fname":"斜齿轮减速电机","fmaterialid":133046,"fpurpricecmk":0,"fdescription":" ","fgoodbarcodecmk":"","categoryName":null,"fbarcode":null,"fvippricecmk":0,"fspecification":"R/17/DRS/71S4/0.37KW/i=5.76/M1/0/3","fpbxqbrand":"SEW","fcategoryid":237,"fnumber":"04.01.001.00001","fsalepricecmk":0,"funitidCmk":"0"},{"fname":"斜齿轮减速电机","fmaterialid":133048,"fpurpricecmk":0,"fdescription":" ","fgoodbarcodecmk":"","categoryName":null,"fbarcode":null,"fvippricecmk":0,"fspecification":"R/27/DRS/71M4/0.55KW/i=9.41/M1/180/2","fpbxqbrand":"SEW","fcategoryid":237,"fnumber":"04.01.001.00002","fsalepricecmk":0,"funitidCmk":"0"}]
     */
    private String msg;
    private int code;
    private List<BdMaterial> data;

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

    public List<BdMaterial> getData() {
        return data;
    }

    public void setData(List<BdMaterial> data) {
        this.data = data;
    }
}
