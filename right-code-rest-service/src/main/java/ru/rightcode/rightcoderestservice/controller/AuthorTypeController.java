package ru.rightcode.rightcoderestservice.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.rightcode.rightcoderestservice.repository.AuthorTypeRepository;

@RestController
public class AuthorTypeController {
    private final AuthorTypeRepository repository;

    public AuthorTypeController(AuthorTypeRepository repository) {
        this.repository = repository;
    }
}
