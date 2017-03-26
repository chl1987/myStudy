package com.chl.demo.rest.server.student.service;

import com.chl.demo.rest.server.student.domain.StudentInfo;

import java.util.List;

/**
 * 查询逻辑处理
 * Created by caodongdong on 2017-03-26.
 */
public interface QueryStudentService {
    List<StudentInfo> query(StudentInfo info);

    List<StudentInfo> findByName(String name);

    List<StudentInfo> findByCondition(StudentInfo info);
}
