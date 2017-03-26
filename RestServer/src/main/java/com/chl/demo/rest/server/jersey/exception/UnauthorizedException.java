package com.chl.demo.rest.server.jersey.exception;

import com.chl.demo.rest.server.jersey.annotation.ResponseStatus;
import com.chl.demo.rest.server.jersey.exception.common.CommonException;

import javax.ws.rs.core.Response;

/**
 * 未授权异常
 * Created by caodongdong on 2017-03-15.
 */
@ResponseStatus(Response.Status.FORBIDDEN)
public class UnauthorizedException extends CommonException {
    public UnauthorizedException() {
    }

    public UnauthorizedException(String retCode, String retMsg) {
        super(retCode, retMsg);
    }

    public UnauthorizedException(int retCode, String retMsg) {
        super(retCode, retMsg);
    }
}
