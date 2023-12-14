package com.by.studentapp.exceptions;

import com.by.studentapp.dto.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class StudentApiExceptionHandlers {


    @ExceptionHandler(value = {StudentNotFoundException.class})
    public ResponseEntity<ExceptionResponse> handleStudentNotFoundException(Exception ex, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;

        ExceptionResponse response = new ExceptionResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(response);
    }


    // TODO : Create an Exception Handler for Duplicate Student Entry
    // Status Code 409


//    @ResponseStatus(code = HttpStatus.NOT_FOUND)
//    @ExceptionHandler(value = StudentNotFoundException.class)
//    public ProblemDetail handleStudentNotFoundException(StudentNotFoundException ex){
//
//       ProblemDetail errorResponse = ProblemDetail.forStatus(404);
//
//       errorResponse.setDetail(ex.getMessage());
//       errorResponse.setTitle(HttpStatus.NOT_FOUND.getReasonPhrase());
//       errorResponse.setProperty("timestamp",LocalDateTime.now());
//
//       return errorResponse;
//    }


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionResponse> handleOtherErrors(Exception ex, HttpServletRequest request){

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        var response =  new ExceptionResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                "Something went wrong",
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(response);
    }


}
