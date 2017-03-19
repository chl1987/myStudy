package com.chl.demo.rest.server.jersey.exception;

import com.chl.demo.rest.server.jersey.annotation.ResponseStatus;
import com.chl.demo.rest.server.jersey.exception.common.CommonException;

import javax.ws.rs.core.Response;

/**
 * 输入非法异常
 * Created by caodongdong on 2017-02-07.
 */
@ResponseStatus(Response.Status.BAD_REQUEST)
public class IllegalInputException extends CommonException {
    public IllegalInputException() {
    }

    public IllegalInputException(String retCode, String retMsg) {
        super(retCode, retMsg);
    }

    public IllegalInputException(int retCode, String retMsg) {
        super(retCode, retMsg);
    }
}
