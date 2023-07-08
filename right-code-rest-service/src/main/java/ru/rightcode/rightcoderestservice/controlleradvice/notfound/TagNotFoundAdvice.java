package ru.rightcode.rightcoderestservice.controlleradvice.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.rightcode.rightcoderestservice.exception.notfound.TagNotFoundException;

@ControllerAdvice
public class TagNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TagNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String tagNotFoundHandler(TagNotFoundException ex) {
        return ex.getMessage();
    }
}
