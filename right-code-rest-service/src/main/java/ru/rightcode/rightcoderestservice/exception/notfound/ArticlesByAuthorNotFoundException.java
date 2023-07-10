package ru.rightcode.rightcoderestservice.exception.notfound;

public class ArticlesByAuthorNotFoundException extends RuntimeException {

    private final String message;

    public ArticlesByAuthorNotFoundException(String message) {
        super(String.format("These authors does not have articles. Authors: %s", message));
        this.message = message;
    }
}
