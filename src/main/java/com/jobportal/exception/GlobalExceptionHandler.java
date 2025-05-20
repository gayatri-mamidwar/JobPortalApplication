package com.jobportal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
You don’t need to catch exceptions in controller — Spring will route to @RestControllerAdvice.
if u r not using globalexception handler then u need try catch block in each controller
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationNotFoundException.class)
    public ResponseEntity<String> handleApplicationNotFound(ApplicationNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployerNotFoundException.class)
    public ResponseEntity<String> handleEmployerNotFound(EmployerNotFoundException ex){
        return  new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<String> handleJobNotFound(JobNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex){
        return  new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
