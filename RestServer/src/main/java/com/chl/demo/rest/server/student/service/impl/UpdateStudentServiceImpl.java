package com.chl.demo.rest.server.student.service.impl;

import com.chl.demo.rest.server.jersey.exception.IllegalInputException;
import com.chl.demo.rest.server.student.dao.StudentDao;
import com.chl.demo.rest.server.student.entity.StudentEntity;
import com.chl.demo.rest.server.student.service.UpdateStudentService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by caodongdong on 2017-04-05.
 */
public class UpdateStudentServiceImpl implements UpdateStudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public void updateName(Integer studentId, String name) {
        StudentEntity entity = studentDao.findOne(studentId);
        if (entity == null) {
            throw new IllegalInputException("-1", "student with id " + studentId + " is not exist!");
        }

        studentDao.update(studentId, name);
    }
}
