package ru.rightcode.rightcoderestservice.exception.notfound;

public class ResourceTypeNotFoundException extends RuntimeException{
    public ResourceTypeNotFoundException(Integer id) {
        super("Could not find resource type " + id);
    }
}
