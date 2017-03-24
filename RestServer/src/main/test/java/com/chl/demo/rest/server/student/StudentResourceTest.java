package com.chl.demo.rest.server.student;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 接口UT
 * Created by caodongdong on 2017-03-24.
 */
public class StudentResourceTest {

    private ApplicationContext context;

    public StudentResourceTest() {
        context = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
    }

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void list() throws Exception {

    }

    @org.junit.Test
    public void save() throws Exception {

    }

    @Test
    public void testCreateTable() {

    }

}