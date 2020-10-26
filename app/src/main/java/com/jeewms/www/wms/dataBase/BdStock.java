package com.jeewms.www.wms.dataBase;
import org.litepal.crud.LitePalSupport;

import java.io.Serializable;

/**
 * <p>
 * 仓库
 * </p>
 *
 * @author xufeng
 * @since 2020-09-24
 */

public class BdStock extends LitePalSupport implements Serializable {


    /**
     * 实体主键
     */
    private Long fstockid;

    /**
     * 禁用状态
     */
    private String fforbidstatus;

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

    /**
     * 仓库负责人
     */
    private String fprincipal;

    /**
     * 联系电话
     */
    private String ftel;

    /**
     * 仓库地址：
     */
    private String faddress;

}
