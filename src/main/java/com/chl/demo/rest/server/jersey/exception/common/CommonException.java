package com.chl.demo.rest.server.jersey.exception.common;

import com.chl.demo.rest.server.jersey.annotation.ResponseStatus;

import javax.ws.rs.core.Response;


/**
 * 公共异常类
 * Created by caodongdong on 2017-02-07.
 */
@ResponseStatus(Response.Status.BAD_REQUEST)
public class CommonException extends RuntimeException {

    private String retCode;

    private String retMsg;

    public CommonException() {
    }

    public CommonException(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public CommonException(int retCode, String retMsg) {
        this.retCode = "" + retCode;
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
