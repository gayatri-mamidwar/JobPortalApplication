package com.jobportal.exception;

public class EmployerNotFoundException extends RuntimeException {
    public EmployerNotFoundException(Long id){
        super("Employer not found with id: " + id);
    }
}
