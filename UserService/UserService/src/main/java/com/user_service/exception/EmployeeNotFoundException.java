package com.user_service.exception;

public class EmployeeNotFoundException extends RuntimeException{

    EmployeeNotFoundException (long id) {
        super ("employee not found" + id);
    }

    EmployeeNotFoundException (String message) {
        super("employee not found");
    }
}
