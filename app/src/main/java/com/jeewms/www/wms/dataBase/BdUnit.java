package com.jeewms.www.wms.dataBase;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
/**
 * <p>
 * 单位表
 * </p>
 *
 * @author liujb
 * @since 2020-09-29
 */
public class BdUnit extends LitePalSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实体主键
     */
    private Long funitid;

    /**
     * 数据状态
     */
    private String FDocumentStatus;

    /**
     * 禁用状态
     */
    private String FForbidStatus;

    /**
     * 名称 (必填项)
     */
    private String FName;

    /**
     * 编码
     */
    private String FNumber;

    /**
     * 所属组别(必填项)
     */
    private Long FUnitGroupId;

}
