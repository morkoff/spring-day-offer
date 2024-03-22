package com.onedayoffer.taskdistribution.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations= RestController.class)
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> getSQLError(Exception exception) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("HeaderKey", "HeaderDetails");
        return new ResponseEntity<String>("В процессе обработки запроса возникла ошибка",
                headers, HttpStatus.ACCEPTED);
    }
}
