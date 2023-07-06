package ru.rightcode.rightcoderestservice.notfoundexception;

public class TagNotFoundException extends RuntimeException{
    public TagNotFoundException(Integer id) {
        super("Could not find tag " + id);
    }
}
