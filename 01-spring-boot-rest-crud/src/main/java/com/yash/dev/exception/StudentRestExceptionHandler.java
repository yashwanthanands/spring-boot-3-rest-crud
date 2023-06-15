package com.yash.dev.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author yashwanthanands
 */

@ControllerAdvice
public class StudentRestExceptionHandler {

    //Add an exception handler for StudentIDNotFoundException using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        //create a StudentErrorResponse
        StudentErrorResponse stuErrResp=new StudentErrorResponse();
        stuErrResp.setStatus(HttpStatus.NOT_FOUND.value());
        stuErrResp.setMessage(exc.getMessage());
        stuErrResp.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity
        return new ResponseEntity<>(stuErrResp, HttpStatus.NOT_FOUND);
    }

    //Add exception handler for otherExceptions using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        //create a StudentErrorResponse
        StudentErrorResponse stuErrResp=new StudentErrorResponse();
        stuErrResp.setStatus(HttpStatus.BAD_REQUEST.value());
        stuErrResp.setMessage(exc.getMessage());
        stuErrResp.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity
        return new ResponseEntity<>(stuErrResp, HttpStatus.BAD_REQUEST);
    }
}
