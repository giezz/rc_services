package ru.rightcode.rightcoderestservice.exception.notfound;

public class ExternalResourceNotFoundException extends RuntimeException{
    public ExternalResourceNotFoundException(Integer id) {
        super("Could not find external resource " + id);
    }
}
