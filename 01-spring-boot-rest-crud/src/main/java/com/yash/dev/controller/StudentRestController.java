package com.yash.dev.controller;

import com.yash.dev.entity.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yashwanthanands
 */

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //define endpoint for "/student" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> theStudents=new ArrayList<>();
        theStudents.add(new Student("Yashwanth","Anand"));
        theStudents.add(new Student("Hari","Anand"));
        theStudents.add(new Student("Sourav","Ganguly"));
        return theStudents;
    }
}
