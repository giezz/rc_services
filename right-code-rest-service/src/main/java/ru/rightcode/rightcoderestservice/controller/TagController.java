package ru.rightcode.rightcoderestservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.Tag;
import ru.rightcode.rightcoderestservice.service.TagService;

import java.util.List;

@RestController("/tag")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("/tags")
    public List<Tag> getAll() {
        return tagService.getAll();
    }
    @GetMapping("/tags/{id}")
    public Tag getTag(@PathVariable(name = "id") Integer id) {
        return tagService.get(id);
    }

    @PostMapping("/tags")
    public Tag saveTag(@RequestBody Tag tag) {
        return tagService.save(tag);
    }

    @DeleteMapping("/tags/{id}")
    public void deleteTag(@PathVariable(name = "id") Integer id) {
        tagService.delete(id);
    }

    @PutMapping("/tags/{id}")
    public Tag updateTag(@PathVariable(name = "id") Integer id){
        return null;
    }

}
