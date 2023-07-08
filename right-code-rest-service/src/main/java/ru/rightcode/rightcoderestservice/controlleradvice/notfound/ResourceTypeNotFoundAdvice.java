package ru.rightcode.rightcoderestservice.controlleradvice.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.rightcode.rightcoderestservice.exception.notfound.ResourceTypeNotFoundException;

@ControllerAdvice
public class ResourceTypeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ResourceTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String resourceTypeNotFoundHandler(ResourceTypeNotFoundException ex) {
        return ex.getMessage();
    }
}
