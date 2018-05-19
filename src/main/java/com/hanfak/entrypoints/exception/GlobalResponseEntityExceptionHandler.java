package com.hanfak.entrypoints.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.lang.String.format;

@ControllerAdvice
public class GlobalResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalResponseEntityExceptionHandler.class);

    @ExceptionHandler(value = Exception.class) // State specific exceptions for it to catch and handle
    public ResponseEntity<Object> defaultErrorHandler(Exception exception, WebRequest request) throws Exception {
        String errorMessage = exception.getMessage();
        String errorResponseBody = format("The response encountered an exception, with message '%s', at uri '%s',", errorMessage, getRequestUri(request));
        return handleExceptionInternal(exception, errorResponseBody, new HttpHeaders(), HttpStatus.I_AM_A_TEAPOT, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOGGER.error(String.format("Exception processing request: %s", getRequestUri(request)), ex);

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private String getRequestUri(final WebRequest request) {
        if(request instanceof ServletWebRequest){
            return ((ServletWebRequest) request).getRequest().getRequestURI();
        }
        return request.toString();
    }
}