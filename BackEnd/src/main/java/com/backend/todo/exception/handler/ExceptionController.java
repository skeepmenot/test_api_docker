package com.backend.todo.exception.handler;

import com.backend.todo.constant.ErrorMessages;
import com.backend.todo.dto.ExceptionResponse;
import com.backend.todo.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @NonNull
    protected Object handleInternalException(Exception e, @Nullable Object body, HttpStatus status, WebRequest request) {
        e.printStackTrace();
        if (body == null) {
            body = new ExceptionResponse(e.getMessage());
        }
        return super.handleExceptionInternal(e,body,new HttpHeaders(),status,request);
    }

    @ExceptionHandler(Exception.class)
    public Object handleGlobalException(Exception e, WebRequest request){
        return this.handleInternalException(e,new ExceptionResponse(ErrorMessages.UNEXPECTED_EXCEPTION),HttpStatus.INTERNAL_SERVER_ERROR,request);
    }

    @ExceptionHandler(NotFoundException.class)
    public Object handleNotFoundException(NotFoundException e, WebRequest request){
        return this.handleInternalException(e,new ExceptionResponse(e.getMessage()),HttpStatus.NOT_FOUND,request);
    }

}
