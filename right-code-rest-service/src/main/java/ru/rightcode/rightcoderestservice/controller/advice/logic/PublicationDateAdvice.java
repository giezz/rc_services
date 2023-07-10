package ru.rightcode.rightcoderestservice.controller.advice.logic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.rightcode.rightcoderestservice.dto.ApiErrorResponse;
import ru.rightcode.rightcoderestservice.exception.BusinessCodeError;
import ru.rightcode.rightcoderestservice.exception.data.PublicationDateGreaterThenPublicationEndDateException;
import ru.rightcode.rightcoderestservice.exception.data.PublicationEndDateNotSpecifiedException;

@ControllerAdvice
public class PublicationDateAdvice {
    @ExceptionHandler(PublicationEndDateNotSpecifiedException.class)
    ResponseEntity<Object> handlePublicationEndDateNotSpecifiedException(PublicationEndDateNotSpecifiedException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiErrorResponse apiResponse = new ApiErrorResponse(
                httpStatus,
                BusinessCodeError.E012,
                e.getMessage()
        );
        return new ResponseEntity<>(apiResponse, httpStatus);
    }

    @ExceptionHandler(PublicationDateGreaterThenPublicationEndDateException.class)
    ResponseEntity<Object> handlePublicationDateGreaterThenPublicationEndDateException(PublicationDateGreaterThenPublicationEndDateException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiErrorResponse apiResponse = new ApiErrorResponse(
                httpStatus,
                BusinessCodeError.E011,
                e.getMessage()
        );
        return new ResponseEntity<>(apiResponse, httpStatus);
    }
}
