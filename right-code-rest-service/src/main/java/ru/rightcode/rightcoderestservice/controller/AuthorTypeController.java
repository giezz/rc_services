package ru.rightcode.rightcoderestservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.AuthorType;
import ru.rightcode.rightcoderestservice.notfoundexception.AuthorNotFoundException;
import ru.rightcode.rightcoderestservice.repository.AuthorTypeRepository;

import java.util.List;

@RestController
@RequestMapping("/author-type")
@RequiredArgsConstructor
public class AuthorTypeController {
    private final AuthorTypeRepository repository;

    @GetMapping("/all")
    public List<AuthorType> getAllAuthorTypes() {
        return repository.findAll();
    }

    // Get one by id
    @GetMapping("/{id}")
    public AuthorType getAuthorTypeById(@PathVariable(name = "id") Integer id){
        return repository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
    }

    // PostMapping
    @PostMapping("/add")
    public AuthorType addAuthorType(AuthorType authorType) {
        return repository.save(authorType);
    }

    // PutMapping

}
