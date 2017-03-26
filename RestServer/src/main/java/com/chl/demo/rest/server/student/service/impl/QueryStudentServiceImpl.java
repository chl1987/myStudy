package com.chl.demo.rest.server.student.service.impl;

import com.chl.demo.rest.server.jersey.exception.common.CommonException;
import com.chl.demo.rest.server.student.dao.StudentDao;
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
    private StudentDao studentDao;

    @Override
    public List<StudentInfo> query(StudentInfo info) {
        List<StudentEntity> studentEntities = studentDao.findByName(info.getName());
        if (CollectionUtils.isEmpty(studentEntities)) {
            throw new CommonException("-1", "student with name " + info.getName() + " is not exist!");
        }

        return entitiesToInfos(studentEntities);
    }

    @Override
    public List<StudentInfo> findByName(String name) {
        StudentInfo info = new StudentInfo();
        info.setName(name);
        return query(info);
    }

    @Override
    public List<StudentInfo> findByCondition(StudentInfo info) {
        StudentEntity entity = new StudentEntity(info);
        return entitiesToInfos(studentDao.findByCondition(entity.getName(), entity.getAge()));
    }

    private List<StudentInfo> entitiesToInfos(List<StudentEntity> entities)
    {
        List<StudentInfo> infos = new ArrayList<>();
        for(StudentEntity entity : entities)
        {
            infos.add(new StudentInfo(entity));
        }
        return infos;
    }
}
