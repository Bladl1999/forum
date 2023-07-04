package com.forum.exceptions;

import com.sun.istack.NotNull;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    @NonNull
    protected ResponseEntity<Object> handleHttpMessageNotReadable
            (@NotNull HttpMessageNotReadableException ex, @NonNull HttpHeaders headers, @NonNull HttpStatus status, @NonNull WebRequest re) {
        Response response = new Response("JSON is not correct", ex.getMessage());
        return new ResponseEntity<>(response, status);
    }

    @NonNull
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(@NonNull TypeMismatchException ex, @NonNull HttpHeaders headers, @NonNull HttpStatus status, @NonNull WebRequest request) {
        Response response = new Response("ID employee is not correct", ex.getMessage());
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler
    protected ResponseEntity<Response> handleNoSuchEntityException(@NotNull NoSuchEntity ex) {
        Response response = new Response("Key is not exist in table", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}