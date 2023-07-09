package ru.rightcode.rightcoderestservice.controlleradvice.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.rightcode.rightcoderestservice.controlleradvice.ApiResponse;
import ru.rightcode.rightcoderestservice.controlleradvice.BusinessCode;
import ru.rightcode.rightcoderestservice.exception.notfound.ArticleNotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ArticleNotFoundAdvice {

    @ExceptionHandler(ArticleNotFoundException.class)
    ResponseEntity<Object> articleNotFoundHandler(ArticleNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiResponse apiResponse = new ApiResponse(
                httpStatus,
                BusinessCode.E040,
                BusinessCode.E040.getMessage(),
                LocalDateTime.now(),
                e.getMessage()
        );
        return new ResponseEntity<>(apiResponse, httpStatus);
    }
}
