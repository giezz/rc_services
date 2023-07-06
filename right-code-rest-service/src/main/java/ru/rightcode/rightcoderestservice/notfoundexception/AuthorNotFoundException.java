package ru.rightcode.rightcoderestservice.notfoundexception;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(Integer id) {
        super("Could not find author " + id);
    }
}
