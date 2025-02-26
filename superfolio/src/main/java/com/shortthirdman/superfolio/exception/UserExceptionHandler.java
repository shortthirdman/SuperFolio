package com.shortthirdman.superfolio.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;

@Slf4j
@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = {InvalidFragmentException.class})
    public ProblemDetail handleRecordsNotFoundException(InvalidFragmentException ex, WebRequest request) {
        log.error("Invalid fragment for the request {}: {}", request.getContextPath(), ExceptionUtils.getFullStackTrace(ex));
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        problemDetail.setInstance(URI.create(request.getContextPath()));
        problemDetail.setTitle("Fragment Not Found");
        return problemDetail;
    }
}
