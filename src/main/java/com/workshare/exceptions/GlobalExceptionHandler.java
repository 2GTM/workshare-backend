package com.workshare.exceptions;

import com.workshare.exceptions.type.ClientNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    public interface ErrorCode {
        int CLIENT_NOT_FOUND = 3033;
    }

    @ExceptionHandler(ClientNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public int handleClientNotFound(ClientNotFound e) {
        System.out.println(e.getMessage());
        return ErrorCode.CLIENT_NOT_FOUND;
    }
}
