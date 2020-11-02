package com.kingdee.ah.pda.dataBase;
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

    public Long getFUserID() {
        return FUserID;
    }

    public void setFUserID(Long FUserID) {
        this.FUserID = FUserID;
    }

    public String getFDescription() {
        return FDescription;
    }

    public void setFDescription(String FDescription) {
        this.FDescription = FDescription;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getFForbidStatus() {
        return FForbidStatus;
    }

    public void setFForbidStatus(String FForbidStatus) {
        this.FForbidStatus = FForbidStatus;
    }

    public String getFUserAccount() {
        return FUserAccount;
    }

    public void setFUserAccount(String FUserAccount) {
        this.FUserAccount = FUserAccount;
    }

    public String getFSex() {
        return FSex;
    }

    public void setFSex(String FSex) {
        this.FSex = FSex;
    }

    public String getFUserType() {
        return FUserType;
    }

    public void setFUserType(String FUserType) {
        this.FUserType = FUserType;
    }

    public String getFEmail() {
        return FEmail;
    }

    public void setFEmail(String FEmail) {
        this.FEmail = FEmail;
    }

    public String getFPhone() {
        return FPhone;
    }

    public void setFPhone(String FPhone) {
        this.FPhone = FPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
