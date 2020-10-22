package com.jeewms.www.wms.bean;

import java.io.Serializable;

/**
 * Created by 13799 on 2018/6/2.
 */

public class HomeBtnBean implements Serializable {
    private String btnName;
    private int imaResId;

    public String getBtnName() {
        return btnName;
    }

    public void setBtnName(String btnName) {
        this.btnName = btnName;
    }

    public int getImaResId() {
        return imaResId;
    }

    public void setImaResId(int imaResId) {
        this.imaResId = imaResId;
    }
}
