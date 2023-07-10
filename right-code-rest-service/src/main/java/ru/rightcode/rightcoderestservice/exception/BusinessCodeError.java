package ru.rightcode.rightcoderestservice.exception;

public enum BusinessCodeError {
    E001("Не заполнены обязательные поля"),
    E011("Дата окончания публикации должна быть позже даты начала публикации"),
    E012("Дата окончания публикации должна быть указана если указана дата начала публикации"),
    E040("Указанный ресурс не найден"),
    E050("Сбой при обращении к сервису");

    private final String message;
    BusinessCodeError(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
