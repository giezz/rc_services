package ru.rightcode.rightcoderestservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.Tag;
import ru.rightcode.rightcoderestservice.notfoundexception.TagNotFoundException;
import ru.rightcode.rightcoderestservice.repository.TagRepository;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagRepository repository;

    // ------------------------- GetMapping Tags -----------------
    // Get all
    @GetMapping("/all")
    public List<Tag> getAllTags() {
        return repository.findAll();
    }

    // Get one by id
    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable(name = "id") Integer id) {
        return repository.findById(id).orElseThrow(() -> new TagNotFoundException(id));
    }

    // TODO: GetMapping by name

    // ------------------------- PostMapping Tags -----------------
    // Post add one
    @PostMapping("/add")
    public void addTag(Tag tag) {
        repository.save(tag);
    }

    // ------------------------- PutMapping Tags -----------------
    // TODO: PutMapping


    // ------------------------- DeleteMapping Tags -----------------
    // TODO: DeleteMapping
}
