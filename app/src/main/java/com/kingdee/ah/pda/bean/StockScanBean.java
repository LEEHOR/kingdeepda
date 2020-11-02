package com.kingdee.ah.pda.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean.bean
 * @ClassName: StockBean
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/14 11:39
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/14 11:39
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class StockScanBean implements Serializable {

    /**
     * msg : 操作成功
     * code : 0
     * data : [{"stockNumberLike":null,"materialName":"圆钢","stockNumber":null,"stockName":"钢材仓库","materialNumber":"04.04.015.00009","goodBarCode":null,"qty":0,"limit":null,"materialNumberLike":null,"specification":"热轧/Φ160/45#","page":null,"goodBarCodeLike":null},{"stockNumberLike":null,"materialName":"圆钢","stockNumber":null,"stockName":"钢材仓库","materialNumber":"04.04.015.00010","goodBarCode":null,"qty":0,"limit":null,"materialNumberLike":null,"specification":"热轧/Φ95/45#","page":null,"goodBarCodeLike":null},{"stockNumberLike":null,"materialName":"圆钢","stockNumber":null,"stockName":"钢材仓库","materialNumber":"04.04.015.00011","goodBarCode":null,"qty":0,"limit":null,"materialNumberLike":null,"specification":"热轧/Φ220/45#","page":null,"goodBarCodeLike":null},{"stockNumberLike":null,"materialName":"圆钢","stockNumber":null,"stockName":"钢材仓库","materialNumber":"04.04.015.00012","goodBarCode":null,"qty":0,"limit":null,"materialNumberLike":null,"specification":"热轧/Φ250/45#","page":null,"goodBarCodeLike":null},{"stockNumberLike":null,"materialName":"圆钢","stockNumber":null,"stockName":"钢材仓库","materialNumber":"04.04.015.00013","goodBarCode":null,"qty":0,"limit":null,"materialNumberLike":null,"specification":"热轧/Φ85/45#","page":null,"goodBarCodeLike":null},{"stockNumberLike":null,"materialName":"圆钢","stockNumber":null,"stockName":"钢材仓库","materialNumber":"04.04.015.00014","goodBarCode":null,"qty":0,"limit":null,"materialNumberLike":null,"specification":"热轧/Φ80/45#","page":null,"goodBarCodeLike":null},{"stockNumberLike":null,"materialName":"圆钢","stockNumber":null,"stockName":"钢材仓库","materialNumber":"04.04.015.00015","goodBarCode":null,"qty":0,"limit":null,"materialNumberLike":null,"specification":"热轧/Φ105/45#","page":null,"goodBarCodeLike":null},{"stockNumberLike":null,"materialName":"圆钢","stockNumber":null,"stockName":"钢材仓库","materialNumber":"04.04.015.00016","goodBarCode":null,"qty":0,"limit":null,"materialNumberLike":null,"specification":"热轧/Φ150/45#","page":null,"goodBarCodeLike":null},{"stockNumberLike":null,"materialName":"圆钢","stockNumber":null,"stockName":"钢材仓库","materialNumber":"04.04.015.00017","goodBarCode":null,"qty":0,"limit":null,"materialNumberLike":null,"specification":"热轧/Φ120/45#","page":null,"goodBarCodeLike":null},{"stockNumberLike":null,"materialName":"圆钢","stockNumber":null,"stockName":"钢材仓库","materialNumber":"04.04.015.00018","goodBarCode":null,"qty":0,"limit":null,"materialNumberLike":null,"specification":"热轧/Φ140/45#","page":null,"goodBarCodeLike":null}]
     */
    private String msg;
    private int code;
    private List<DataEntity> data;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
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

    public class DataEntity {
        /**
         * stockNumberLike : null
         * materialName : 圆钢
         * stockNumber : null
         * stockName : 钢材仓库
         * materialNumber : 04.04.015.00009
         * goodBarCode : null
         * qty : 0
         * limit : null
         * materialNumberLike : null
         * specification : 热轧/Φ160/45#
         * page : null
         * goodBarCodeLike : null
         */
        private String stockNumberLike;
        private String materialName;
        private String stockNumber;
        private String stockName;
        private String materialNumber;
        private String goodBarCode;
        private int qty;
        private String limit;
        private String materialNumberLike;
        private String specification;
        private String page;
        private String goodBarCodeLike;

        public void setStockNumberLike(String stockNumberLike) {
            this.stockNumberLike = stockNumberLike;
        }

        public void setMaterialName(String materialName) {
            this.materialName = materialName;
        }

        public void setStockNumber(String stockNumber) {
            this.stockNumber = stockNumber;
        }

        public void setStockName(String stockName) {
            this.stockName = stockName;
        }

        public void setMaterialNumber(String materialNumber) {
            this.materialNumber = materialNumber;
        }

        public void setGoodBarCode(String goodBarCode) {
            this.goodBarCode = goodBarCode;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public void setMaterialNumberLike(String materialNumberLike) {
            this.materialNumberLike = materialNumberLike;
        }

        public void setSpecification(String specification) {
            this.specification = specification;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public void setGoodBarCodeLike(String goodBarCodeLike) {
            this.goodBarCodeLike = goodBarCodeLike;
        }

        public String getStockNumberLike() {
            return stockNumberLike;
        }

        public String getMaterialName() {
            return materialName;
        }

        public String getStockNumber() {
            return stockNumber;
        }

        public String getStockName() {
            return stockName;
        }

        public String getMaterialNumber() {
            return materialNumber;
        }

        public String getGoodBarCode() {
            return goodBarCode;
        }

        public int getQty() {
            return qty;
        }

        public String getLimit() {
            return limit;
        }

        public String getMaterialNumberLike() {
            return materialNumberLike;
        }

        public String getSpecification() {
            return specification;
        }

        public String getPage() {
            return page;
        }

        public String getGoodBarCodeLike() {
            return goodBarCodeLike;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "stockNumberLike='" + stockNumberLike + '\'' +
                    ", materialName='" + materialName + '\'' +
                    ", stockNumber='" + stockNumber + '\'' +
                    ", stockName='" + stockName + '\'' +
                    ", materialNumber='" + materialNumber + '\'' +
                    ", goodBarCode='" + goodBarCode + '\'' +
                    ", qty=" + qty +
                    ", limit='" + limit + '\'' +
                    ", materialNumberLike='" + materialNumberLike + '\'' +
                    ", specification='" + specification + '\'' +
                    ", page='" + page + '\'' +
                    ", goodBarCodeLike='" + goodBarCodeLike + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "StockBean{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data.toString() +
                '}';
    }
}
