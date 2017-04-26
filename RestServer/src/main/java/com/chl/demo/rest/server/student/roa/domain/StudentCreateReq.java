package com.chl.demo.rest.server.student.roa.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 创建model请求体
 * Created by caodongdong on 2017-04-26.
 */
public class StudentCreateReq {
    @NotNull
    @Min(value = 18, message = "the age of student must over {value}!")
    private int age;

    @NotNull
    @Size(min = 6, max = 32, message = "length of student's name must between {min} and {max}!")
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
