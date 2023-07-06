package ru.rightcode.rightcoderestservice.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.rightcode.rightcoderestservice.repository.TagRepository;

@RestController
public class TagController {
    private final TagRepository repository;

    public TagController(TagRepository repository) {
        this.repository = repository;
    }
}
