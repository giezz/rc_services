package ru.rightcode.rightcoderestservice.notfoundexception;

public class AuthorArticleNotFoundException extends RuntimeException{
    public AuthorArticleNotFoundException(Integer authorId, Integer articleId) {
        super("Could not find author " + authorId + " and article " + articleId);
    }
}
