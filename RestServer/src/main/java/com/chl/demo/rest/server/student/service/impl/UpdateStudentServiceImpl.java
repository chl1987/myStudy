package com.chl.demo.rest.server.student.service.impl;

import com.chl.demo.rest.server.jersey.exception.IllegalInputException;
import com.chl.demo.rest.server.student.model.dao.StudentRepository;
import com.chl.demo.rest.server.student.model.entity.StudentEntity;
import com.chl.demo.rest.server.student.roa.domain.StudentModifyReq;
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
    public void modifyStudent(StudentModifyReq req) {
        StudentEntity entity = studentRepository.findOne(req.getId());
        if (entity == null) {
            throw new IllegalInputException("-1", "student with id " + req.getId() + " is not exist!");
        }

        studentRepository.update(req.getId(), req.getName());
    }
}
