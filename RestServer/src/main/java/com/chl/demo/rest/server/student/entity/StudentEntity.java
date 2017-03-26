package com.chl.demo.rest.server.student.entity;

import com.chl.demo.rest.server.student.domain.StudentInfo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体类，与表结构对应（POJO）
 * Created by caodongdong on 2017-02-07.
 */
@Table(name = "t_student")
@Entity
public class StudentEntity {

    @GeneratedValue
    @Id
    private int id;

    private int age;

    private String name;

    public StudentEntity() {
    }

    public StudentEntity(StudentInfo info) {
        this.age = info.getAge();
        this.name = info.getName();
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
