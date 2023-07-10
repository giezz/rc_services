package ru.rightcode.rightcoderestservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.Category;
import ru.rightcode.rightcoderestservice.service.CategoryService;

@RestController
@RequestMapping("/categories")
@Tag(name = "Category Controller", description = "Контроллер категорий")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.get(id));
    }

    @PostMapping()
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.add(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable("id") Integer id,
                               @RequestBody Category category) {
        Category categoryFromDb = categoryService.get(id);
        categoryFromDb.setType(category.getType());
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.update(categoryFromDb));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Category category) {
        categoryService.delete(category);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }
}
