package com.chl.demo.rest.server.student.dao.impl;

import com.chl.demo.rest.server.student.dao.StudentRepository;
import com.chl.demo.rest.server.student.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态查询实现
 * Created by caodongdong on 2017-03-26.
 */
@Service
public class StudentDaoImpl extends CrudRepository<StudentEntity, Long>, JpaSpecificationExecutor {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> queryByCondition(StudentEntity condition) {
        List<StudentEntity> resultList = null;
        Specification querySpecifi = new Specification<StudentEntity>() {
            @Override
            public Predicate toPredicate(Root<StudentEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (null != condition.getId()) {
                    predicates.add(criteriaBuilder.equal(root.get("id"), condition.getId()));
                }
                if (null != condition.getAge()) {
                    predicates.add(criteriaBuilder.equal(root.get("age"), condition.getAge()));
                }
                if (null != condition.getName()) {
                    predicates.add(criteriaBuilder.like(root.get("name"), "%" + condition.getName() + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        resultList = studentRepository.findAll(querySpecifi);
        return resultList;
    }


}
