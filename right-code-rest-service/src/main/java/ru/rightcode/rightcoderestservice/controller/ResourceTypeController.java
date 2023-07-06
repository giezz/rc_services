package ru.rightcode.rightcoderestservice.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.rightcode.rightcoderestservice.repository.ResourceTypeRepository;

@RestController
public class ResourceTypeController {
    private final ResourceTypeRepository repository;

    public ResourceTypeController(ResourceTypeRepository repository) {
        this.repository = repository;
    }
}
