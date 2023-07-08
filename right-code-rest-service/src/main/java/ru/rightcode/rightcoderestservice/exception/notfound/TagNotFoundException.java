package ru.rightcode.rightcoderestservice.exception.notfound;

public class TagNotFoundException extends RuntimeException{
    public TagNotFoundException(Integer id) {
        super("Could not find tag " + id);
    }
}
