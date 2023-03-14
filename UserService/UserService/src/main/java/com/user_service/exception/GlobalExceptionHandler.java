package com.user_service.exception;

import com.user_service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerEmployeeNotException(EmployeeNotFoundException ex) {
        String message = ex.getMessage();
//        ApiResponse.ApiResponseBuilder response = ApiResponse.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<ApiResponse>(response);
        ApiResponse apiResponse = ApiResponse.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResponse>(apiResponse.getHttpStatus());
    }
}
