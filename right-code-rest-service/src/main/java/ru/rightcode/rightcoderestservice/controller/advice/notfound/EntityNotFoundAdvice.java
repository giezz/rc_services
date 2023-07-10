package ru.rightcode.rightcoderestservice.controller.advice.notfound;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.rightcode.rightcoderestservice.dto.ApiErrorResponse;
import ru.rightcode.rightcoderestservice.exception.BusinessCodeError;

@ControllerAdvice
public class EntityNotFoundAdvice {
    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<Object> tagNotFoundHandler(EntityNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiErrorResponse apiResponse = new ApiErrorResponse(
                httpStatus,
                BusinessCodeError.E050
        );
        return new ResponseEntity<>(apiResponse, httpStatus);
    }
}
