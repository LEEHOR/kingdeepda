package com.jeewms.www.wms.dataBase;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;

/**
 * <p>
 * 供应商
 * </p>
 *
 * @author xufeng
 * @since 2020-09-25
 */

public class BdSupplier extends LitePalSupport implements Serializable {

    /**
     * 实体主键
     */
    private Long FSupplierId;

    /**
     * 数据状态
     */
    private String FDocumentStatus;

    /**
     * 名称(必填项)
     */
    private String FName;

    /**
     * 编码
     */
    private String FNumber;

    /**
     * 描述
     */
    private String FDescription;

    /**
     * 创建组织(必填项)
     */
    private Long FCreateOrgId;

    /**
     * 使用组织(必填项)
     */
    private Long FUseOrgId;

}
