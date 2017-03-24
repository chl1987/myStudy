package com.chl.demo.rest.server.student.entity;

import com.chl.demo.rest.server.student.domain.StudentInfo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 实体类，与表结构对应（POJO）
 * Created by caodongdong on 2017-02-07.
 */
@Table(name = "t_student")
@Entity
public class StudentEntity extends StudentInfo {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
