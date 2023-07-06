package ru.rightcode.rightcoderestservice.notfoundexception;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(Integer id) {
        super("Could not find category " + id);
    }
}
