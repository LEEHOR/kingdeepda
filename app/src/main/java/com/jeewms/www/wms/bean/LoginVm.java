package com.jeewms.www.wms.bean;

import java.io.Serializable;

/**
 * Created by 13799 on 2018/6/2.
 */

public class LoginVm implements Serializable {


    /**
     * msg : 登录成功
     * access_token : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLliJjkupEiLCJleHAiOjE2MDIzMTQxNDR9._sW468WXqIDhqQghPGdwFYAS7eOAeA9WgESivLsybfI
     * code : 0
     * data : {"fsex":null,"fname":"刘云","fphone":"18956074782","fuserAccount":"刘云","fuserType":null,"fuserID":139889,"fdescription":null}
     * token_type : Bearer
     */
    private String msg;
    private String access_token;
    private int code;
    private DataEntity data;
    private String token_type;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getMsg() {
        return msg;
    }

    public String getAccess_token() {
        return access_token;
    }

    public int getCode() {
        return code;
    }

    public DataEntity getData() {
        return data;
    }

    public String getToken_type() {
        return token_type;
    }

    public class DataEntity {
        /**
         * fsex : null
         * fname : 刘云
         * fphone : 18956074782
         * fuserAccount : 刘云
         * fuserType : null
         * fuserID : 139889
         * fdescription : null
         */
        private String fsex;
        private String fname;
        private String fphone;
        private String fuserAccount;
        private String fuserType;
        private int fuserID;
        private String fdescription;

        public void setFsex(String fsex) {
            this.fsex = fsex;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public void setFphone(String fphone) {
            this.fphone = fphone;
        }

        public void setFuserAccount(String fuserAccount) {
            this.fuserAccount = fuserAccount;
        }

        public void setFuserType(String fuserType) {
            this.fuserType = fuserType;
        }

        public void setFuserID(int fuserID) {
            this.fuserID = fuserID;
        }

        public void setFdescription(String fdescription) {
            this.fdescription = fdescription;
        }

        public String getFsex() {
            return fsex;
        }

        public String getFname() {
            return fname;
        }

        public String getFphone() {
            return fphone;
        }

        public String getFuserAccount() {
            return fuserAccount;
        }

        public String getFuserType() {
            return fuserType;
        }

        public int getFuserID() {
            return fuserID;
        }

        public String getFdescription() {
            return fdescription;
        }
    }
}
