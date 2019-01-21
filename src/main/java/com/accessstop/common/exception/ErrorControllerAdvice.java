package com.accessstop.common.exception;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorControllerAdvice {
	
	@ExceptionHandler(PreconditionFailedException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ResponseBody
    public ErrorResponse handlePreconditions(Exception ex, HttpServletRequest request) {
        return ErrorResponse.builder()
        		.occurredAt(Calendar.getInstance().getTime())
        		.httpStatusCode(HttpStatus.PRECONDITION_FAILED.value())
        		.httpError(HttpStatus.PRECONDITION_FAILED.getReasonPhrase())
        		.message(ex.getMessage()).method(request.getMethod())
        		.path(request.getServletPath()).build();
    }
	
	@ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handleConflicts(Exception ex, HttpServletRequest request) {
        return ErrorResponse.builder()
        		.occurredAt(Calendar.getInstance().getTime())
        		.httpStatusCode(HttpStatus.CONFLICT.value())
        		.httpError(HttpStatus.CONFLICT.getReasonPhrase())
        		.message(ex.getMessage()).method(request.getMethod())
        		.path(request.getServletPath()).build();
    }

}
