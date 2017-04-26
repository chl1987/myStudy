package com.chl.demo.rest.server.student.model.dao;

import com.chl.demo.rest.server.student.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * StudentEntity 持久层
 * Created by caodongdong on 2017-03-24.
 */
public interface StudentRepository extends CrudRepository<StudentEntity, Integer>, JpaSpecificationExecutor {
    @Query("select s from StudentEntity s where s.name = ?1 and s.age = ?2")
    List<StudentEntity> find(String name, Integer age);

    @Query("select s from StudentEntity s where s.name = ?1")
    List<StudentEntity> find(String name);

    @Query("select s from StudentEntity s where s.age = ?1")
    List<StudentEntity> find(Integer age);

    @Modifying
    @Query("update StudentEntity bean set bean.name=?2 where bean.id=?1")
    void update(Integer id, String name);
}
