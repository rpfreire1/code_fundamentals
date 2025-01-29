package com.rpfreire.git.test.error;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super("EMPLOYEEE ERROR"+message);
    }
}
