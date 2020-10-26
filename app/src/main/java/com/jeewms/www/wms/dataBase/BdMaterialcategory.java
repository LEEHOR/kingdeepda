package com.jeewms.www.wms.dataBase;
import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
/**
 * <p>
 * 存货类别
 * </p>
 *
 * @author tyl
 * @since 2020-09-21
 */
public class BdMaterialcategory extends LitePalSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 存货类别ID
     */
    private Long fcategoryid;

    /**
     * 名称
     */
    private String fname;

    /**
     * 编码
     */
    private String fnumber;

    /**
     * 描述
     */
    private String fdescription;

}
