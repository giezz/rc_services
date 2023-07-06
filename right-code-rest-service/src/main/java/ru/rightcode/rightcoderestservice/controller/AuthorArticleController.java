package ru.rightcode.rightcoderestservice.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.rightcode.rightcoderestservice.repository.AuthorArticleRepository;

@RestController
public class AuthorArticleController {
    private final AuthorArticleRepository repository;

    public AuthorArticleController(AuthorArticleRepository repository) {
        this.repository = repository;
    }
}
