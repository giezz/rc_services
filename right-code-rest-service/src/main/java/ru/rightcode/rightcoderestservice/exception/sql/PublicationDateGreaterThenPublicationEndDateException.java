package ru.rightcode.rightcoderestservice.exception.sql;

public class PublicationDateGreaterThenPublicationEndDateException extends RuntimeException {
    public PublicationDateGreaterThenPublicationEndDateException(String message) {
        super(message);
    }

    public PublicationDateGreaterThenPublicationEndDateException(String message, Throwable cause) {
        super(message, cause);
    }
}
