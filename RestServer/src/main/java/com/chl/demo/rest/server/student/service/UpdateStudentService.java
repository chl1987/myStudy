package com.chl.demo.rest.server.student.service;

import com.chl.demo.rest.server.student.roa.domain.StudentModifyReq;

/**
 * 更新业务逻辑
 * Created by caodongdong on 2017-04-05.
 */
public interface UpdateStudentService {
    void modifyStudent(StudentModifyReq req);
}
