package com.chl.demo.rest.server.student.service.impl;

import com.chl.demo.rest.server.jersey.exception.IllegalInputException;
import com.chl.demo.rest.server.student.dao.StudentRepository;
import com.chl.demo.rest.server.student.domain.StudentInfo;
import com.chl.demo.rest.server.student.entity.StudentEntity;
import com.chl.demo.rest.server.student.service.UpdateStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务更新
 * Created by caodongdong on 2017-04-05.
 */
@Service
public class UpdateStudentServiceImpl implements UpdateStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void updateName(StudentInfo studentInfo) {
        StudentEntity entity = studentRepository.findOne(studentInfo.getId());
        if (entity == null) {
            throw new IllegalInputException("-1", "student with id " + studentInfo.getId() + " is not exist!");
        }

        studentRepository.update(studentInfo.getId(), studentInfo.getName());
    }
}
