package ru.rightcode.rightcoderestservice.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.rightcode.rightcoderestservice.repository.ExternalResourceRepository;

@RestController
public class ExternalResourceController {
    private final ExternalResourceRepository repository;

    public ExternalResourceController(ExternalResourceRepository repository) {
        this.repository = repository;
    }
}
