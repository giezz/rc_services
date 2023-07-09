package ru.rightcode.rightcoderestservice.controlleradvice.sql;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.rightcode.rightcoderestservice.controlleradvice.ApiResponse;
import ru.rightcode.rightcoderestservice.controlleradvice.BusinessCode;
import ru.rightcode.rightcoderestservice.exception.sql.PublicationDateGreaterThenPublicationEndDateException;

import java.time.LocalDateTime;

@ControllerAdvice
public class PublicationDateGreaterThenPublicationEndDateAdvice {

    @ExceptionHandler(PublicationDateGreaterThenPublicationEndDateException.class)
    ResponseEntity<Object> handlePublicationDateGreaterThenPublicationEndDateException(PublicationDateGreaterThenPublicationEndDateException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiResponse apiResponse = new ApiResponse(
                httpStatus,
                BusinessCode.E011,
                BusinessCode.E011.getMessage(),
                LocalDateTime.now(),
                e.getMessage()
        );
        return new ResponseEntity<>(apiResponse, httpStatus);
    }
}
