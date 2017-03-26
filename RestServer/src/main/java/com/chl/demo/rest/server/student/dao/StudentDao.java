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

   @Query("select s from StudentEntity s where s.name = ?1 and s.age = ?2")
   List<StudentEntity> findByCondition(String name,int age);

}
