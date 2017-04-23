package com.chl.demo.rest.server.jersey.exceptionmapper;

import com.chl.demo.rest.server.jersey.response.ErrorMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 全局的异常处理，避免没有特殊处理的异常直接返回给了客户端
 * Created by caodongdong on 2017-04-08.
 */
@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    static final private Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionMapper.class);

    @Override
    public Response toResponse(Exception e) {
        LOGGER.error("Exception happened! {}", e.getMessage(), e);

        int code = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        return Response.status(code).entity(new ErrorMsg("-1", "Internal Error!")).build();
    }
}
