package ru.rightcode.rightcoderestservice.controlleradvice.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.rightcode.rightcoderestservice.exception.notfound.AuthorArticleNotFoundException;
import ru.rightcode.rightcoderestservice.exception.notfound.AuthorTypeNotFoundException;

@ControllerAdvice
public class AuthorArticleNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AuthorTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String authorArticleNotFoundHandler(AuthorArticleNotFoundException ex){
        return ex.getMessage();
    }
}
