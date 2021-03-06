package com.chl.demo.rest.server.student.service.impl;

import com.chl.demo.rest.server.jersey.exception.IllegalInputException;
import com.chl.demo.rest.server.student.model.dao.StudentRepository;
import com.chl.demo.rest.server.student.model.entity.StudentEntity;
import com.chl.demo.rest.server.student.service.DeleteStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 删除学生逻辑实现
 * Created by caodongdong on 2017-03-26.
 */
@Service
public class DeleteStudentServiceImpl implements DeleteStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void deleteById(int studentId) {
        StudentEntity entity = studentRepository.findOne(studentId);
        if (entity == null) {
            throw new IllegalInputException("-1", "student with id " + studentId + " is not exist!");
        }

        studentRepository.delete(studentId);
    }
}