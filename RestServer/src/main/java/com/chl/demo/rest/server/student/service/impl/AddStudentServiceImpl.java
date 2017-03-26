package com.chl.demo.rest.server.student.service.impl;

import com.chl.demo.rest.server.student.dao.StudentDao;
import com.chl.demo.rest.server.student.domain.StudentInfo;
import com.chl.demo.rest.server.student.entity.StudentEntity;
import com.chl.demo.rest.server.student.service.AddStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务实现
 * Created by caodongdong on 2017-03-15.
 */
@Service
public class AddStudentServiceImpl implements AddStudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public void saveStudent(StudentInfo studentInfo)
    {
        StudentEntity entity = new StudentEntity(studentInfo);
        studentDao.save(entity);
    }
}
