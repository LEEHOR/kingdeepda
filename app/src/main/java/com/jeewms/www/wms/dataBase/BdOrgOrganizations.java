package com.jeewms.www.wms.dataBase;
import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
/**
 * <p>
 * 组织机构
 * </p>
 *
 * @author weilun
 * @since 2020-10-01
 */
public class BdOrgOrganizations extends LitePalSupport implements Serializable {


    /**
     * 实体主键
     */
    private Long forgid;

    /**
     * 禁用状态
     */
    private String fforbidstatus;

    /**
     * 数据状态：
     */
    private String fdocumentstatus;

    /**
     * 名称(必填项)
     */
    private String fname;

    /**
     * 编码(必填项)
     */
    private String fnumber;

    /**
     * 形态(必填项)
     */
    private String forgformid;

    /**
     * 所属法人
     */
    private String fparentid;

    /**
     * 业务组织
     */
    private String fisbusinessorg;

    /**
     * 描述
     */
    private String fdescription;

    /**
     * 采购职能
     */
    private String fpurchasebox;

    /**
     * 库存职能
     */
    private String fstockbox;

    /**
     * 工厂职能
     */
    private String ffactorybox;

    /**
     * 组织职能
     */
    private String forgfunctions;

}
