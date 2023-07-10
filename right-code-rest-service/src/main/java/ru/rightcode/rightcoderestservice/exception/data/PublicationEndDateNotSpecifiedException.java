package ru.rightcode.rightcoderestservice.exception.data;

public class PublicationEndDateNotSpecifiedException extends RuntimeException {

    private final String message;

    public PublicationEndDateNotSpecifiedException(String message) {
        super(message);
        this.message = message;
    }
}
