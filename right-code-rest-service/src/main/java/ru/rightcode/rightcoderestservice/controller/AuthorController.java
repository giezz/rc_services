package ru.rightcode.rightcoderestservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.Author;
import ru.rightcode.rightcoderestservice.service.AuthorService;

@RestController
@RequestMapping("/authors")
@Tag(name = "Author Controller", description = "Контроллер авторов")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<?> getAllAuthors() {
        return ResponseEntity.status(HttpStatus.OK).body(authorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(authorService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> addAuthor(@RequestBody Author author) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.add(author));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable("id") Integer id,
                                          @RequestBody Author author) {
        Author authorFromDb = authorService.getById(id);
        BeanUtils.copyProperties(author, authorFromDb, "id");
        return ResponseEntity.status(HttpStatus.OK).body(authorService.update(authorFromDb));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") Author author) {
        authorService.delete(author);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }
}
