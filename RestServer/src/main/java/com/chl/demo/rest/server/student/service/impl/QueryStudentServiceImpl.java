package com.chl.demo.rest.server.student.service.impl;

import com.chl.demo.rest.server.common.lang.StringUtils;
import com.chl.demo.rest.server.jersey.exception.common.CommonException;
import com.chl.demo.rest.server.student.dao.StudentRepository;
import com.chl.demo.rest.server.student.domain.StudentInfo;
import com.chl.demo.rest.server.student.entity.StudentEntity;
import com.chl.demo.rest.server.student.service.QueryStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询逻辑实现
 * Created by caodongdong on 2017-03-26.
 */
@Service
public class QueryStudentServiceImpl implements QueryStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentInfo> find(String name, Integer age) {
        List<StudentEntity> studentEntities;
        if (StringUtils.isEmpty(name)) {
            studentEntities = studentRepository.find(age);
            if (CollectionUtils.isEmpty(studentEntities)) {
                throw new CommonException("-1", "student with age " + age + " is not exist!");
            }
        } else if (StringUtils.isEmpty(age)) {
            studentEntities = studentRepository.find(name);
            if (CollectionUtils.isEmpty(studentEntities)) {
                throw new CommonException("-1", "student with name " + name + " is not exist!");
            }
        } else {
            studentEntities = studentRepository.find(name, age);
            if (CollectionUtils.isEmpty(studentEntities)) {
                throw new CommonException("-1", "student with name " + name + " and age " + age + " is not exist!");
            }
        }

        return entitiesToInfos(studentEntities);
    }

    @Override
    public StudentInfo getById(Integer id) {
        StudentEntity studentEntity = studentRepository.findOne(id);
        if (studentEntity == null) {
            throw new CommonException("-1", "student with name " + id + " is not exist!");
        }
        return new StudentInfo(studentEntity);
    }

    private List<StudentInfo> entitiesToInfos(List<StudentEntity> entities) {
        List<StudentInfo> infos = new ArrayList<>();
        for (StudentEntity entity : entities) {
            infos.add(new StudentInfo(entity));
        }
        return infos;
    }
}
