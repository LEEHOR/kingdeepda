package com.jeewms.www.wms.dataBase;
import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
/**
 * <p>
 * 币别
 * </p>
 *
 * @author liujb
 * @since 2020-09-29
 */
public class BdCurrency extends LitePalSupport implements Serializable {

    /**
     * 实体主键
     */
    private Long fcurrencyid;

    /**
     * 禁用状态
     */
    private String FForbidStatus;

    /**
     * 名称(必填项)
     */
    private String FName;

    /**
     * 编码(必填项)
     */
    private String FNumber;

    /**
     * 货币代码(必填项)
     */
    private String fcode;

    /**
     * 舍入类型(必填项)
     */
    private Integer FRoundType;

    /**
     * 单价精度
     */
    private Integer fpricedigits;

    /**
     * 金额精度
     */
    private Integer famountdigits;

}
