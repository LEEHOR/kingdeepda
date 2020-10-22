package com.jeewms.www.wms.bean;

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
public class StockClass implements Serializable {

    /**
     * msg :
     * code : 0
     * stock : [{"fname":"原材料仓库","fnumber":null},{"fname":"成品仓","fnumber":null},{"fname":"车间仓库","fnumber":null},{"fname":"市购件仓库","fnumber":null},{"fname":"钢材仓库","fnumber":null},{"fname":"板材仓库","fnumber":null},{"fname":"铝材仓库","fnumber":null},{"fname":"电料仓库","fnumber":null},{"fname":"半成品仓库","fnumber":null},{"fname":"成品仓库","fnumber":null},{"fname":"电气部车间仓","fnumber":null}]
     */
    private String msg;
    private int code;
    private List<StockEntity> stock;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setStock(List<StockEntity> stock) {
        this.stock = stock;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public List<StockEntity> getStock() {
        return stock;
    }

    public class StockEntity {
        /**
         * fname : 原材料仓库
         * fnumber : null
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
