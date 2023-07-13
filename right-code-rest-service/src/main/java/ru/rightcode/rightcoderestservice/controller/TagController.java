package ru.rightcode.rightcoderestservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.Tag;
import ru.rightcode.rightcoderestservice.service.TagService;

@RestController
@RequestMapping("/tags")
@io.swagger.v3.oas.annotations.tags.Tag(name = "Tag Controller", description = "Контроллер тэгов")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping
    public ResponseEntity<?> getAllTags(@RequestParam(name = "name", required = false) String name) {
        if (name != null) {
            return ResponseEntity.status(HttpStatus.OK).body(tagService.getAllByName(name));
        }
        return ResponseEntity.status(HttpStatus.OK).body(tagService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTagById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(tagService.getById(id));
    }

    @GetMapping("/popular")
    public ResponseEntity<?> getPopularTag(@PageableDefault(sort = {"count"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(tagService.getPopular(pageable));
    }

    @PostMapping()
    public ResponseEntity<?> addTag(@RequestBody Tag tag) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tagService.add(tag));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTag(@PathVariable("id") Integer id,
                                       @RequestBody Tag tag) {
        Tag tagFromDb = tagService.getById(id);
        tagFromDb.setName(tag.getName());
        return ResponseEntity.status(HttpStatus.OK).body(tagService.update(tagFromDb));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTag(@PathVariable("id") Tag tag) {
        tagService.delete(tag);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }
}
