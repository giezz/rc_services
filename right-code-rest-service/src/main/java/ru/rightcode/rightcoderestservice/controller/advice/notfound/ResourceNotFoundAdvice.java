package ru.rightcode.rightcoderestservice.controller.advice.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.rightcode.rightcoderestservice.dto.ApiErrorResponse;
import ru.rightcode.rightcoderestservice.exception.BusinessCodeError;
import ru.rightcode.rightcoderestservice.exception.notfound.ResourceNotFoundException;

@ControllerAdvice
public class ResourceNotFoundAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<Object> tagNotFoundHandler(ResourceNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiErrorResponse apiResponse = new ApiErrorResponse(
                httpStatus,
                BusinessCodeError.E040,
                e.getMessage()
        );
        return new ResponseEntity<>(apiResponse, httpStatus);
    }
}
