package ru.rightcode.rightcoderestservice.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.rightcode.rightcoderestservice.repository.CategoryRepository;

@RestController
public class CategoryController {
    private final CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }
}
