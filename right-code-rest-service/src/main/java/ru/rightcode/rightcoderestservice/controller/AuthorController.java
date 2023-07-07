package ru.rightcode.rightcoderestservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rightcode.rightcoderestservice.model.Author;
import ru.rightcode.rightcoderestservice.notfoundexception.AuthorNotFoundException;
import ru.rightcode.rightcoderestservice.repository.AuthorRepository;

import java.util.List;

@RestController("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorRepository repository;

    // Get all
    @GetMapping("/all")
    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    // Get one by id
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable(name = "id") Integer author_id) {
        return repository.findById(author_id).orElseThrow(() -> new AuthorNotFoundException(author_id));
    }

    @PostMapping("/add")
    public Author addAuthor(Author author) {
        return repository.save(author);
    }

    // PutMapping

}
