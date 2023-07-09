package ru.rightcode.rightcoderestservice.controlleradvice.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.rightcode.rightcoderestservice.controlleradvice.ApiErrorResponse;
import ru.rightcode.rightcoderestservice.controlleradvice.BusinessCodeError;
import ru.rightcode.rightcoderestservice.exception.notfound.AuthorNotFoundException;

@ControllerAdvice
public class AuthorNotFoundAdvice {

    @ExceptionHandler(AuthorNotFoundException.class)
    ResponseEntity<Object> authorNotFoundHandler(AuthorNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiErrorResponse apiResponse = new ApiErrorResponse(
                httpStatus,
                BusinessCodeError.E040,
                e.getMessage()
        );
        return new ResponseEntity<>(apiResponse, httpStatus);
    }
}
