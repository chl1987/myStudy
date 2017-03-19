package com.chl.demo.rest.server.jersey.annotation;

import javax.ws.rs.core.Response;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义异常注释，用于把异常与响应码进行转换
 * Created by caodongdong on 2017-02-07.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseStatus {
    Response.Status value();
}
