package com.jeewms.www.wms.dataBase;
import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
/**
 * <p>
 * 项目库
 * </p>
 *
 * @author xufeng
 * @since 2020-09-24
 */
public class BdProject extends LitePalSupport implements Serializable {

    /**
     * 实体主键
     */
    private Long fid;

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
     * 项目概况
     */
    private String fdescription;

    /**
     * 创建组织
     */
    private String fcreateorgid;

    /**
     * 使用组织
     */
    private String fuseorgid;

    /**
     * 项目阶段
     */
    private String fprojectstageid;

    /**
     * 客户
     */
    private String fcustomerid;

    /**
     * 负责人电话
     */
    private String fcustomertel;

    /**
     * 项目经理
     */
    private String fprojectmanagerid;

    /**
     * 项目性质
     */
    private String fprojectproperty;

    /**
     * 项目类别
     */
    private String fpbxqproject;

    /**
     * 项目状态
     */
    private String fpbxqprojectstatus;

}
