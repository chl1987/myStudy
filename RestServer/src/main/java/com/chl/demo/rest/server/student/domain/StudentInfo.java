package com.chl.demo.rest.server.student.domain;

import com.chl.demo.rest.server.student.entity.StudentEntity;

/**
 * 接口请求消息体，只用于返回给接口调用者
 * 与实体类（表的POJO）不一致，避免实体类的不必要信息返回给调用者
 * Created by caodongdong on 2017-02-07.
 */
public class StudentInfo {
    private int id;

    private int age;

    private String name;

    public StudentInfo() {
    }

    public StudentInfo(StudentEntity entity) {
        this.id = entity.getId();
        this.age = entity.getAge();
        this.name = entity.getName();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
