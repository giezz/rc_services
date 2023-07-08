package ru.rightcode.rightcoderestservice.exception.notfound;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(Integer id) {
        super("Could not find author " + id);
    }
}
