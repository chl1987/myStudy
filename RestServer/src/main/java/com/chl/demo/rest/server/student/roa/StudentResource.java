package com.chl.demo.rest.server.student.roa;

import com.chl.demo.rest.server.student.roa.domain.StudentInfo;
import com.chl.demo.rest.server.student.roa.domain.StudentModifyReq;
import com.chl.demo.rest.server.student.service.AddStudentService;
import com.chl.demo.rest.server.student.service.DeleteStudentService;
import com.chl.demo.rest.server.student.service.query.QueryStudentService;
import com.chl.demo.rest.server.student.service.UpdateStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Student业务接口定义
 * Created by caodongdong on 2017-02-07.
 */

@Path("/students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {
    static final private Logger LOG = LoggerFactory.getLogger(StudentResource.class);

    @Autowired
    private AddStudentService addStudentService;

    @Autowired
    private QueryStudentService queryStudentService;

    @Autowired
    private DeleteStudentService deleteStudentService;

    @Autowired
    private UpdateStudentService updateStudentService;

    @GET
    @Path("/{id}")
    public StudentInfo get(@PathParam("id") Integer id) {
        return queryStudentService.getById(id);
    }

    @GET
    public List<StudentInfo> list(@QueryParam("name") String name, @QueryParam("age") Integer age) {
        return queryStudentService.find(name, age);
    }

    @PUT
    public void update(StudentModifyReq req) {
        LOG.debug("receive student, {}", req);
        updateStudentService.modifyStudent(req);
    }

    @POST
    @Path("/add")
    public void save(StudentInfo studentInfo) {
        LOG.debug("receive student, {}", studentInfo);
        addStudentService.saveStudent(studentInfo);
    }

    @DELETE
    @Path("/{id}")
    public void list(@PathParam("id") int id) {
        deleteStudentService.deleteById(id);
    }
}
