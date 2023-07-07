package ru.rightcode.rightcoderestservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.Tag;
import ru.rightcode.rightcoderestservice.service.TagService;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping
    public List<Tag> getAllTags() {
        return tagService.getAll();
    }

    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable(name = "id") Integer id) {
        return tagService.getById(id);
    }

    @GetMapping("/{name}")
    public Tag getByName(@PathVariable(name = "name") String name) {
        return tagService.getByName(name);
    }

    @PostMapping()
    public void addTag(Tag tag) {
        tagService.save(tag);
    }

    // TODO: PutMapping DeleteMapping
}
