package com.chl.demo.rest.server.jersey.exceptionmapper;

import com.chl.demo.rest.server.jersey.annotation.ResponseStatus;
import com.chl.demo.rest.server.jersey.exception.common.CommonException;
import com.chl.demo.rest.server.jersey.response.ErrorMsg;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 异常映射处理
 * Created by caodongdong on 2017-02-07.
 */
@Provider
public class CommonExceptionMapper implements ExceptionMapper<CommonException> {
    @Override
    public Response toResponse(CommonException e) {

        ResponseStatus status = e.getClass().getAnnotation(ResponseStatus.class);
        int code = status != null ? status.value().getStatusCode() : Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();

        return Response.status(code).entity(new ErrorMsg(e.getRetCode(), e.getRetMsg())).build();
    }
}
