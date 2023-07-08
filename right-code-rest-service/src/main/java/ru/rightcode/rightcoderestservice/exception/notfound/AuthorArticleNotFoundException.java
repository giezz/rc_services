package ru.rightcode.rightcoderestservice.exception.notfound;

public class AuthorArticleNotFoundException extends RuntimeException{
    public AuthorArticleNotFoundException(Integer authorId, Integer articleId) {
        super("Could not find author " + authorId + " and article " + articleId);
    }
}
