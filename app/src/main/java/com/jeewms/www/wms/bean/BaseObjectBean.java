package com.jeewms.www.wms.bean;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean
 * @ClassName: BaseObjectBean
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/29 10:55
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/29 10:55
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class BaseObjectBean<T> {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
