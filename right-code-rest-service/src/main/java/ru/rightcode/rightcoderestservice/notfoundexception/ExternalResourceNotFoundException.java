package ru.rightcode.rightcoderestservice.notfoundexception;

public class ExternalResourceNotFoundException extends RuntimeException{
    public ExternalResourceNotFoundException(Integer id) {
        super("Could not find external resource " + id);
    }
}
