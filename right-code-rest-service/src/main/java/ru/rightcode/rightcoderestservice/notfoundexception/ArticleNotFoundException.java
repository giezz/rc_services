package ru.rightcode.rightcoderestservice.notfoundexception;

public class ArticleNotFoundException extends RuntimeException{
    public ArticleNotFoundException(Integer id) {
        super("Could not find article " + id);
    }
}
