package com.jeewms.www.wms.dataBase;
import org.litepal.crud.LitePalSupport;

import java.math.BigDecimal;
import java.io.Serializable;
/**
 * <p>
 * 金蝶物料表
 * </p>
 *
 * @author tyl
 * @since 2020-09-21
 */
public class BdMaterial extends LitePalSupport implements Serializable {

    /**
     * 物料ID
     */
    private Long fmaterialid;

    /**
     * 编码
     */
    private String fnumber;

    /**
     * 名称
     */
    private String fname;

    /**
     * 描述
     */
    private String fdescription;

    /**
     * 规格型号
     */
    private String fspecification;

    /**
     * 品牌
     */
    private String fpbxqbrand;

    /**
     * 主条形码
     */
    private String fgoodbarcodecmk;

    /**
     * 采购单价
     */
    private BigDecimal fpurpricecmk;

    /**
     * 零售价
     */
    private BigDecimal fsalepricecmk;

    /**
     * 会员价
     */
    private BigDecimal fvippricecmk;

    /**
     * 计量单位
     */
    private String funitidCmk;

    /**
     * 存货类别
     */
    private Long fcategoryid;

    private String categoryName;

    /**
     * 主条码
     */
    private String fbarcode;


}
