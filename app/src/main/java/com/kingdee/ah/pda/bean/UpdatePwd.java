package com.kingdee.ah.pda.bean;

import java.io.Serializable;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.bean.vm
 * @ClassName: UpdatePwd
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/14 9:05
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/14 9:05
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class UpdatePwd implements Serializable {

    /**
     * msg : 查无此账号
     * code : 1
     * -------------
     * "msg": "密码修改成功",
     * "code": 0
     * ------------
     * "msg": "修改失败",
     * "code": 1
     * -----------
     * "msg": "旧密码错误",
     *  "code": 1
     */
    private String msg;
    private int code;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
