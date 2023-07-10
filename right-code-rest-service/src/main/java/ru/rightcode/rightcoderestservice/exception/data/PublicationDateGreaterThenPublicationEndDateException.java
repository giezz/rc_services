package ru.rightcode.rightcoderestservice.exception.data;

public class PublicationDateGreaterThenPublicationEndDateException extends RuntimeException {

    private final String message;

    public PublicationDateGreaterThenPublicationEndDateException(String message) {
        super(message);
        this.message = message;
    }
}
