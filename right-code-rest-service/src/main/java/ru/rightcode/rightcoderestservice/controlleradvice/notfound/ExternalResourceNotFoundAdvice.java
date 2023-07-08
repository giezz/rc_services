package ru.rightcode.rightcoderestservice.controlleradvice.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.rightcode.rightcoderestservice.exception.notfound.ExternalResourceNotFoundException;

@ControllerAdvice
public class ExternalResourceNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ExternalResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String externalResourceNotFoundHandler(Exception ex) {
        return ex.getMessage();
    }
}
