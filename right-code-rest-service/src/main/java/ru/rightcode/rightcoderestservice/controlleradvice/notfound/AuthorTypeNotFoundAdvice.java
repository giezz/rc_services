package ru.rightcode.rightcoderestservice.controlleradvice.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.rightcode.rightcoderestservice.exception.notfound.AuthorTypeNotFoundException;

@ResponseBody
public class AuthorTypeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AuthorTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String authorTypeNotFoundHandler(AuthorTypeNotFoundException ex) {
        return ex.getMessage();
    }
}
