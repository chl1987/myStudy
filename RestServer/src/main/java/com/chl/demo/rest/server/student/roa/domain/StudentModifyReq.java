package com.chl.demo.rest.server.student.roa.domain;

import com.alibaba.fastjson.JSON;

import javax.validation.constraints.NotNull;

/**
 * 更新请求类
 * Created by caodongdong on 2017-04-26.
 */
public class StudentModifyReq {

    @NotNull
    private Integer id;

    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
