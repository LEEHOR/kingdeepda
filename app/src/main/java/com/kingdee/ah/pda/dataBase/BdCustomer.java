package com.kingdee.ah.pda.dataBase;
import org.litepal.crud.LitePalSupport;

import java.io.Serializable;
/**
 * <p>
 * 客户
 * </p>
 *
 * @author liujb
 * @since 2020-09-27
 */
public class BdCustomer extends LitePalSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实体主键
     */
    private Long fcustid;

    /**
     * 数据状态
     */
    private String FForbidStatus;

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
    private Long ftradingcurrid;

    /**
     * 客户类别
     */
    private String FCustTypeId;

    /**
     * 通讯地址：
     */
    private String faddress;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getFcustid() {
        return fcustid;
    }

    public void setFcustid(Long fcustid) {
        this.fcustid = fcustid;
    }

    public String getFForbidStatus() {
        return FForbidStatus;
    }

    public void setFForbidStatus(String FForbidStatus) {
        this.FForbidStatus = FForbidStatus;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getFNumber() {
        return FNumber;
    }

    public void setFNumber(String FNumber) {
        this.FNumber = FNumber;
    }

    public String getFDescription() {
        return FDescription;
    }

    public void setFDescription(String FDescription) {
        this.FDescription = FDescription;
    }

    public Long getFCreateOrgId() {
        return FCreateOrgId;
    }

    public void setFCreateOrgId(Long FCreateOrgId) {
        this.FCreateOrgId = FCreateOrgId;
    }

    public Long getFtradingcurrid() {
        return ftradingcurrid;
    }

    public void setFtradingcurrid(Long ftradingcurrid) {
        this.ftradingcurrid = ftradingcurrid;
    }

    public String getFCustTypeId() {
        return FCustTypeId;
    }

    public void setFCustTypeId(String FCustTypeId) {
        this.FCustTypeId = FCustTypeId;
    }

    public String getFaddress() {
        return faddress;
    }

    public void setFaddress(String faddress) {
        this.faddress = faddress;
    }
}
