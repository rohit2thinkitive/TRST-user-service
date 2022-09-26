package com.service.userservice.exception;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Logger;

@RestControllerAdvice
public class ExceptionHelper {



    @ExceptionHandler(value = UserNameAlreadyExistException.class)
    public ResponseEntity<String> exception(UserNameAlreadyExistException exception){
        return new ResponseEntity("username already exist!", HttpStatus.BAD_REQUEST);
    }

}
