package com.chl.demo.rest.server.student.service.impl;

import com.chl.demo.rest.server.jersey.exception.IllegalInputException;
import com.chl.demo.rest.server.student.dao.StudentDao;
import com.chl.demo.rest.server.student.entity.StudentEntity;
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
    private StudentDao studentDao;

    @Override
    public void deleteById(int studentId) {
        StudentEntity entity = studentDao.findOne(studentId);
        if (entity == null) {
            throw new IllegalInputException("-1", "student with id " + studentId + " is not exist!");
        }

        studentDao.delete(studentId);
    }
}