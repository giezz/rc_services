package ru.rightcode.rightcoderestservice.exception.notfound;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(Integer id) {
        super("Could not find category " + id);
    }
}
