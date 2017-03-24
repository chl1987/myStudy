package com.chl.demo.rest.server.student;

import com.chl.demo.rest.server.jersey.exception.IllegalInputException;
import com.chl.demo.rest.server.student.domain.StudentInfo;
import com.chl.demo.rest.server.student.service.AddStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Student业务接口定义
 * Created by caodongdong on 2017-02-07.
 */

@Path("/students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {
    static final private Logger log = LoggerFactory.getLogger(StudentResource.class);

    @Autowired
    private AddStudentService addStudentService;

    @GET
    @Path("/{id}")
    public StudentInfo list(@PathParam("id") int id) {
        if (id < 10) {
            throw new IllegalInputException(Response.Status.BAD_REQUEST.getStatusCode(), "id of student less than 0");
        }
        log.debug("Receive id = {}", id);
        return new StudentInfo(id, "Jack");
    }

    @POST
    @Path("/add")
    public void save(StudentInfo studentInfo) {
        log.debug("receive student, {}", studentInfo);
    }
}
