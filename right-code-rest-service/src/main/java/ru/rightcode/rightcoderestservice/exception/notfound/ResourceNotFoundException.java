package ru.rightcode.rightcoderestservice.exception.notfound;

public class ResourceNotFoundException extends RuntimeException {

    private final String message;

    public ResourceNotFoundException(String message) {
        super(String.format("Resource not found by this id %s", message));
        this.message = message;
    }


}
