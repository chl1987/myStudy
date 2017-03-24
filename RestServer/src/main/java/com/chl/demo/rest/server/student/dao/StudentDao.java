package com.chl.demo.rest.server.student.dao;

import com.chl.demo.rest.server.student.entity.StudentEntity;

/**
 * StudentEntity 持久层
 * Created by caodongdong on 2017-03-24.
 */
public interface StudentDao {
    void save(StudentEntity studentEntity);
}
