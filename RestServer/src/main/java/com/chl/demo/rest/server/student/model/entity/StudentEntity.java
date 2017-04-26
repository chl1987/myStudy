package com.chl.demo.rest.server.student.model.entity;

import com.chl.demo.rest.server.student.roa.domain.StudentInfo;

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
    private Integer id;

    private Integer age;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
