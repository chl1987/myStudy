package com.chl.demo.rest.server.student.dao.impl;

import com.chl.demo.rest.server.student.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by caodongdong on 2017-03-26.
 */
public class StudentDaoImpl {

//    @Autowired
//    private EntityManagerFactory entityManagerFactory;
//
//    public List<StudentEntity> queryByCondition(StudentEntity condition) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        // 命名查询
//        Query query = em.createQuery("select o from StudentEntity o where o.name = :name and o.age = :age");
//        query.setParameter("name", condition.getName());
//        query.setParameter("age", condition.getAge());
//        List<StudentEntity> entities = query.getResultList();
//        em.close();
//
//        return entities;
//    }
}
