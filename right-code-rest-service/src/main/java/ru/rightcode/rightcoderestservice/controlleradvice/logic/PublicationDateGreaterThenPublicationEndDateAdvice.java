package ru.rightcode.rightcoderestservice.controlleradvice.logic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.rightcode.rightcoderestservice.controlleradvice.ApiErrorResponse;
import ru.rightcode.rightcoderestservice.controlleradvice.BusinessCodeError;
import ru.rightcode.rightcoderestservice.exception.data.PublicationDateGreaterThenPublicationEndDateException;

@ControllerAdvice
public class PublicationDateGreaterThenPublicationEndDateAdvice {

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
