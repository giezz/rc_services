package ru.rightcode.rightcoderestservice.exception.notfound;

public class ArticleNotFoundException extends RuntimeException{
    public ArticleNotFoundException(Integer id) {
        super("Could not find article " + id);
    }
}
