package com.yash.dev.controller;

import com.yash.dev.entity.Student;
import com.yash.dev.exception.StudentErrorResponse;
import com.yash.dev.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
        if((studentId >= theStudents.size()) || (studentId <0)) {
            throw new StudentNotFoundException("Student Id is not found - "+studentId);
        }
        return theStudents.get(studentId);
    }

}
