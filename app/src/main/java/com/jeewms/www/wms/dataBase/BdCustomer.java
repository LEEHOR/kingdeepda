package com.jeewms.www.wms.dataBase;
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

}
