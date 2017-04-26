package com.chl.demo.rest.server.student.model.dao;

import com.chl.demo.rest.server.student.model.entity.StudentEntity;

import java.util.List;

/**
 * Dao层实现
 * Created by caodongdong on 2017-04-08.
 */
public interface StudentDao {
    List<StudentEntity> queryByCondition(StudentEntity condition);
}
