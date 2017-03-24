package com.chl.demo.rest.server.student.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 接口请求消息体，只用于返回给接口调用者
 * 与实体类（表的POJO）不一致，避免实体类的不必要信息返回给调用者
 * Created by caodongdong on 2017-02-07.
 */
public class StudentInfo {
    @GeneratedValue
    @Id
    private int id;

    private String name;

    public StudentInfo() {
    }

    public StudentInfo(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
