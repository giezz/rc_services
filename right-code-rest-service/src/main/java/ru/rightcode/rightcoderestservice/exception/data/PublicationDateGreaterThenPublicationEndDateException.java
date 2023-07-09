package ru.rightcode.rightcoderestservice.exception.data;

public class PublicationDateGreaterThenPublicationEndDateException extends RuntimeException {
    public PublicationDateGreaterThenPublicationEndDateException(String message) {
        super(message);
    }
}
