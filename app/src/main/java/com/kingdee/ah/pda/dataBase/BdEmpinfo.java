package com.kingdee.ah.pda.dataBase;

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

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getFforbidstatus() {
        return fforbidstatus;
    }

    public void setFforbidstatus(String fforbidstatus) {
        this.fforbidstatus = fforbidstatus;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber;
    }

    public String getFstaffnumber() {
        return fstaffnumber;
    }

    public void setFstaffnumber(String fstaffnumber) {
        this.fstaffnumber = fstaffnumber;
    }

    public String getFmobile() {
        return fmobile;
    }

    public void setFmobile(String fmobile) {
        this.fmobile = fmobile;
    }

    public String getFemail() {
        return femail;
    }

    public void setFemail(String femail) {
        this.femail = femail;
    }

    public String getFtel() {
        return ftel;
    }

    public void setFtel(String ftel) {
        this.ftel = ftel;
    }

    public String getFdescription() {
        return fdescription;
    }

    public void setFdescription(String fdescription) {
        this.fdescription = fdescription;
    }

    public Integer getPdaFlag() {
        return pdaFlag;
    }

    public void setPdaFlag(Integer pdaFlag) {
        this.pdaFlag = pdaFlag;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
