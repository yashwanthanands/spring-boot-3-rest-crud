package com.yash.dev.controller;

import com.yash.dev.entity.Student;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yashwanthanands
 */

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //define @PostConstruct to load the student data
    @PostConstruct
    public void loadStudentData() {
        theStudents=new ArrayList<>();
        theStudents.add(new Student("Yashwanth","Anand"));
        theStudents.add(new Student("Hari","Anand"));
        theStudents.add(new Student("Sourav","Ganguly"));
    }

    //define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    //define endpoint for "/students/{studentId}" - retrieve the student details by studentId
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return theStudents.get(studentId);
    }

}
