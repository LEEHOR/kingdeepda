package com.jeewms.www.wms.bean;

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
     * msg : null
     * code : 0
     * data : [{"fname":"斜齿轮减速电机","fmaterialid":133046,"fpurpricecmk":0,"fdescription":" ","fgoodbarcodecmk":"","categoryName":"原材料","fbarcode":null,"fvippricecmk":0,"fspecification":"R/17/DRS/71S4/0.37KW/i=5.76/M1/0/3","fpbxqbrand":"SEW","fcategoryid":237,"fnumber":"04.01.001.00001","fsalepricecmk":0,"funitidCmk":"0"}]
     * count : 19842
     */
    private String msg;
    private int code;
    private List<DataEntity> data;
    private int count;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
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
         * fname : 斜齿轮减速电机
         * fmaterialid : 133046
         * fpurpricecmk : 0
         * fdescription :
         * fgoodbarcodecmk :
         * categoryName : 原材料
         * fbarcode : null
         * fvippricecmk : 0
         * fspecification : R/17/DRS/71S4/0.37KW/i=5.76/M1/0/3
         * fpbxqbrand : SEW
         * fcategoryid : 237
         * fnumber : 04.01.001.00001
         * fsalepricecmk : 0
         * funitidCmk : 0
         */
        private String fname;
        private int fmaterialid;
        private int fpurpricecmk;
        private String fdescription;
        private String fgoodbarcodecmk;
        private String categoryName;
        private String fbarcode;
        private int fvippricecmk;
        private String fspecification;
        private String fpbxqbrand;
        private int fcategoryid;
        private String fnumber;
        private int fsalepricecmk;
        private String funitidCmk;

        public void setFname(String fname) {
            this.fname = fname;
        }

        public void setFmaterialid(int fmaterialid) {
            this.fmaterialid = fmaterialid;
        }

        public void setFpurpricecmk(int fpurpricecmk) {
            this.fpurpricecmk = fpurpricecmk;
        }

        public void setFdescription(String fdescription) {
            this.fdescription = fdescription;
        }

        public void setFgoodbarcodecmk(String fgoodbarcodecmk) {
            this.fgoodbarcodecmk = fgoodbarcodecmk;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public void setFbarcode(String fbarcode) {
            this.fbarcode = fbarcode;
        }

        public void setFvippricecmk(int fvippricecmk) {
            this.fvippricecmk = fvippricecmk;
        }

        public void setFspecification(String fspecification) {
            this.fspecification = fspecification;
        }

        public void setFpbxqbrand(String fpbxqbrand) {
            this.fpbxqbrand = fpbxqbrand;
        }

        public void setFcategoryid(int fcategoryid) {
            this.fcategoryid = fcategoryid;
        }

        public void setFnumber(String fnumber) {
            this.fnumber = fnumber;
        }

        public void setFsalepricecmk(int fsalepricecmk) {
            this.fsalepricecmk = fsalepricecmk;
        }

        public void setFunitidCmk(String funitidCmk) {
            this.funitidCmk = funitidCmk;
        }

        public String getFname() {
            return fname;
        }

        public int getFmaterialid() {
            return fmaterialid;
        }

        public int getFpurpricecmk() {
            return fpurpricecmk;
        }

        public String getFdescription() {
            return fdescription;
        }

        public String getFgoodbarcodecmk() {
            return fgoodbarcodecmk;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public String getFbarcode() {
            return fbarcode;
        }

        public int getFvippricecmk() {
            return fvippricecmk;
        }

        public String getFspecification() {
            return fspecification;
        }

        public String getFpbxqbrand() {
            return fpbxqbrand;
        }

        public int getFcategoryid() {
            return fcategoryid;
        }

        public String getFnumber() {
            return fnumber;
        }

        public int getFsalepricecmk() {
            return fsalepricecmk;
        }

        public String getFunitidCmk() {
            return funitidCmk;
        }
    }
}
