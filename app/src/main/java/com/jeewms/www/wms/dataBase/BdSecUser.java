package com.jeewms.www.wms.dataBase;
import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 金蝶用户表
 * </p>
 *
 * @author tyl
 * @since 2020-09-22
 */

public class BdSecUser extends LitePalSupport implements Serializable {

    /**
     * 实体主键
     */

    private Long FUserID;

    /**
     * 用户说明
     */
    private String FDescription;

    /**
     * 用户名称
     */
    private String FName;

    /**
     * 禁用状态
     */
    private String FForbidStatus;

    /**
     * 用户帐号
     */
    private String FUserAccount;

    /**
     * 性别
     */
    private String FSex;

    /**
     * 用户类型
     */
    private String FUserType;

    /**
     * 邮箱
     */
    private String FEmail;

    /**
     * 移动电话
     */
    private String FPhone;

    /**
     * 移动电话
     */
    private String password;

    /**
     * 移动电话
     */
    private Date createTime;

}
