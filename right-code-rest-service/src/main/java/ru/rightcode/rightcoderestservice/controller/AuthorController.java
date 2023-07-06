package ru.rightcode.rightcoderestservice.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.rightcode.rightcoderestservice.repository.AuthorRepository;

@RestController
public class AuthorController {
    private final AuthorRepository repository;

    public AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }
}
