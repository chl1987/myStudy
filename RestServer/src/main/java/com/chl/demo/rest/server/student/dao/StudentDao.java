package com.chl.demo.rest.server.student.dao;

import com.chl.demo.rest.server.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * StudentEntity 持久层
 * Created by caodongdong on 2017-03-24.
 */
public interface StudentDao extends JpaRepository<StudentEntity, Integer> {

    List<StudentEntity> findByName(String name);

    @Query("SELECT s FROM StudentEntity s WHERE s.name = con.name and s.age = con.age")
    List<StudentEntity> findByCondition(StudentEntity con);

}
