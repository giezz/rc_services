package ru.rightcode.rightcoderestservice.controlleradvice;

public enum BusinessCode {
    E001("Не заполнены обязательные поля"),
    E011("Дата окончания публикации должна быть позже даты публикации"),
    E012(""),
    E040("Указанный ресурс не найден"),
    E050("Сбой при обращении к сервису");

    final String message;
    BusinessCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
