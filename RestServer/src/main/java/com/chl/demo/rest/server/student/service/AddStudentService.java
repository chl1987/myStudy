package com.chl.demo.rest.server.student.service;

import com.chl.demo.rest.server.student.roa.domain.StudentInfo;

/**
 * 业务定义：学生添加业务处理
 * Created by caodongdong on 2017-02-07.
 */
public interface AddStudentService {
    void saveStudent(StudentInfo studentInfo);
}
