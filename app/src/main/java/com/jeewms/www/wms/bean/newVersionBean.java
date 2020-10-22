package com.jeewms.www.wms.bean;

import java.io.Serializable;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean.vm
 * @ClassName: newVersionBean
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/14 18:59
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/14 18:59
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class newVersionBean implements Serializable {

    /**
     * msg : 返回成功
     * code : 0
     * focusUpdate : 1
     * remark : 发布新应用3
     * version : V0.004
     * versionCode : 4
     * url : http://192.168.0.200:8081/app/V0.001.apk
     */
    private String msg;
    private int code;
    private int focusUpdate;
    private String remark;
    private String version;
    private int versionCode;
    private String url;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setFocusUpdate(int focusUpdate) {
        this.focusUpdate = focusUpdate;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public int getFocusUpdate() {
        return focusUpdate;
    }

    public String getRemark() {
        return remark;
    }

    public String getVersion() {
        return version;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public String getUrl() {
        return url;
    }
}
