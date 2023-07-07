package ru.rightcode.rightcoderestservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.Category;
import ru.rightcode.rightcoderestservice.notfoundexception.CategoryNotFoundException;
import ru.rightcode.rightcoderestservice.repository.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepository repository;

    // Get all
    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    // Get one by id
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable(name="id") Integer id){
        return repository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @PostMapping("/add")
    public Category addCategory(Category category) {
        return repository.save(category);
    }

    // PutMapping
}
