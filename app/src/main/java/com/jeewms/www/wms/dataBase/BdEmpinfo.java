package com.jeewms.www.wms.dataBase;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
/**
 * <p>
 * 金蝶用户表
 * </p>
 *
 * @author tyl
 * @since 2020-09-21
 */
public class BdEmpinfo extends LitePalSupport implements Serializable {


    /**
     * ID
     */
    private Long fid;

    /**
     * 禁用状态
     */
    private String fforbidstatus;

    /**
     * 员工姓名
     */
    private String fname;

    /**
     * 编码
     */
    private String fnumber;

    /**
     * 员工编号
     */
    private String fstaffnumber;

    /**
     * 移动电话
     */
    private String fmobile;

    /**
     * 电子邮箱
     */
    private String femail;

    /**
     * 固定电话
     */
    private String ftel;

    /**
     * 描述
     */
    private String fdescription;

    /**
     * 是否启用PDA(1启用0禁用)
     */
    private Integer pdaFlag;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 启用1/禁用0
     */
    private Integer status;

}
