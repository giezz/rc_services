package ru.rightcode.rightcoderestservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.Author;
import ru.rightcode.rightcoderestservice.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/authors")
@Tag(name = "Author Controller", description = "Контроллер авторов")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable(name = "id") Integer id) {
        return authorService.getById(id);
    }

    @PostMapping
    public void addAuthor(@RequestBody Author author) {
        authorService.add(author);
    }

    @PutMapping("/{id}")
    public void updateAuthor(@PathVariable("id") Author authorFromDb,
                             @RequestBody Author author) {
        BeanUtils.copyProperties(author, authorFromDb, "id");
        authorService.update(authorFromDb);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable("id") Author author) {
        authorService.delete(author);
    }
}

