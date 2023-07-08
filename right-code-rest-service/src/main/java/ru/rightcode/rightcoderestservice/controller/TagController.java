package ru.rightcode.rightcoderestservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public List<Tag> getAllTags(@RequestParam(name = "name", required = false) String name) {
        if (name != null) {
            return tagService.getAllByName(name);
        }
        return tagService.getAll();
    }

    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable("id") Integer id) {
        return tagService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addTag(@RequestBody Tag tag) {
//        tag.setArticles(null);
        tagService.add(tag);
    }

    @PutMapping("/{id}")
    public void updateTag(@PathVariable("id") Tag tagFromDb,
                       @RequestBody Tag tag) {
        tagFromDb.setName(tag.getName());
        tagService.update(tagFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteTag(@PathVariable("id") Tag tag) {
        tagService.delete(tag);
    }
}
