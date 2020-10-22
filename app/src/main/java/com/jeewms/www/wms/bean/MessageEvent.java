package com.jeewms.www.wms.bean;

/**
 * Created by 13799 on 2018/4/3.
 */

public class MessageEvent {

    private String key;
    private String message;
    private String message2;
    private String message3;
    private String message5;
    private int message4;

    public MessageEvent(String key) {
        this.key = key;
    }

    public MessageEvent(String key, String message) {
        this.key=key;
        this.message = message;
    }public MessageEvent(String key, int message4) {
        this.key=key;
        this.message4 = message4;
    }
    public MessageEvent(String key, String message, String message2) {
        this.key=key;
        this.message = message;
        this.message2 = message2;
    }public MessageEvent(String key, String message, String message2, String message3) {
        this.key=key;
        this.message = message;
        this.message2 = message2;
        this.message3 = message3;
    }public MessageEvent(String key, String message, String message2, String message3, String message5) {
        this.key=key;
        this.message = message;
        this.message2 = message2;
        this.message3 = message3;
        this.message5 = message5;
    }

    public String getMessage5() {
        return message5;
    }

    public void setMessage5(String message5) {
        this.message5 = message5;
    }

    public int getMessage4() {
        return message4;
    }

    public void setMessage4(int message4) {
        this.message4 = message4;
    }

    public String getMessage3() {
        return message3;
    }

    public void setMessage3(String message3) {
        this.message3 = message3;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
