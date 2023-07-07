package ru.rightcode.rightcoderestservice.model;

public enum StatusEnum {
    DRAFT("Черновик"),
    ARCHIVED("Архивирован"),
    DELETED("Удален"),
    PUBLISHED("Опубликован");

    private final String status;
    StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
