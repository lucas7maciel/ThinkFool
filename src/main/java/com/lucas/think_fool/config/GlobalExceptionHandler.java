package com.lucas.think_fool.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
@EnableWebMvc
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
            HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        String message = "Ooops, this route does not exist!";

        if (requestUri.endsWith("/")) {
            message += " Try removing '/' final char";
        }

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}