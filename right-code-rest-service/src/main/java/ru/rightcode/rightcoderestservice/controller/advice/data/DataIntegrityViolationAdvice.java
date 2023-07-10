package ru.rightcode.rightcoderestservice.controller.advice.data;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.rightcode.rightcoderestservice.dto.ApiErrorResponse;
import ru.rightcode.rightcoderestservice.exception.BusinessCodeError;

@ControllerAdvice
public class DataIntegrityViolationAdvice {

    @ExceptionHandler(DataIntegrityViolationException.class)
    ResponseEntity<Object> handlePropertyValueException(DataIntegrityViolationException e) {
        String errorMessage = e.getMessage();

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiErrorResponse apiResponse;

        if (errorMessage.contains("not-null property references a null or transient value")) {
            apiResponse = new ApiErrorResponse(
                    httpStatus,
                    BusinessCodeError.E001,
                    "not-null property references a null or transient value"
            );
            return new ResponseEntity<>(apiResponse, httpStatus);
        }

        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        apiResponse = new ApiErrorResponse(
                httpStatus,
                BusinessCodeError.E050
        );

        return new ResponseEntity<>(apiResponse, httpStatus);
    }
}
