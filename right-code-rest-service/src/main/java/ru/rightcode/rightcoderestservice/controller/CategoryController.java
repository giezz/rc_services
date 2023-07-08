package ru.rightcode.rightcoderestservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.Category;
import ru.rightcode.rightcoderestservice.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Tag(name = "Category Controller", description = "Контроллер категорий")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable(name = "id") Integer id) {
        return categoryService.get(id);
    }

    @PostMapping()
    public void addCategory(@RequestBody Category category) {
        categoryService.add(category);
    }

    @PutMapping("/{id}")
    public void updateCategory(@PathVariable("id") Category categoryFromDb,
                               @RequestBody Category category) {
        categoryFromDb.setType(category.getType());
        categoryService.update(categoryFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteCategory(@PathVariable("id") Category category) {
        categoryService.delete(category);
    }
}
