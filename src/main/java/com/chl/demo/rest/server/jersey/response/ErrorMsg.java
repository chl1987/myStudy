package com.chl.demo.rest.server.jersey.response;

/**
 * 请求处理的错误消息
 * 用于返回给接口请求方
 * Created by caodongdong on 2017-02-07.
 */
public class ErrorMsg {

    private String retCode;

    private String retMsg;

    public ErrorMsg() {
    }

    public ErrorMsg(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
}
