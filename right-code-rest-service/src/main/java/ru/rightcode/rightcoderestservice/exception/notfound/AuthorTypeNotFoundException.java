package ru.rightcode.rightcoderestservice.exception.notfound;

public class AuthorTypeNotFoundException extends RuntimeException{
    public AuthorTypeNotFoundException(Integer id) {
        super("Could not find author type " + id);
    }
}
