package ru.rightcode.rightcoderestservice.controlleradvice.logic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.rightcode.rightcoderestservice.controlleradvice.ApiErrorResponse;
import ru.rightcode.rightcoderestservice.controlleradvice.BusinessCodeError;
import ru.rightcode.rightcoderestservice.exception.data.PublicationEndDateNotSpecifiedException;

@ControllerAdvice
public class PublicationEndDateNotSpecifiedAdvice {

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
}
