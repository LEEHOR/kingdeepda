package com.jeewms.www.wms.dataBase;
import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
/**
 * <p>
 * 金蝶部门表
 * </p>
 *
 * @author tyl
 * @since 2020-09-21
 */
public class BdDepartment extends LitePalSupport implements Serializable {

    /**
     * 部门ID
     */
    private Long fdeptid;

    /**
     * 名称
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
     * 上级ID
     */
    private String FParentID;

    /**
     * 层级code
     */
    private String FLevelCode;

    /**
     * 深度
     */
    private Integer FDepth;

    /**
     * 是否根结点
     */
    private Integer FIsRoot;

}
