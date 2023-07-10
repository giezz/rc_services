package ru.rightcode.rightcoderestservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.AuthorType;
import ru.rightcode.rightcoderestservice.service.AuthorTypeService;

import java.util.List;

@RestController
@RequestMapping("/author-types")
@Tag(name = "AuthorType Controller", description = "Контроллер типов авторов")
@RequiredArgsConstructor
public class AuthorTypeController {

    private final AuthorTypeService authorTypeService;

    @GetMapping
    public List<AuthorType> getAllAuthorTypes() {
        return authorTypeService.getAll();
    }

    @GetMapping("/{id}")
    public AuthorType getAuthorTypeById(@PathVariable(name = "id") Integer id) {
        return authorTypeService.getById(id);
    }

    @PostMapping
    public void addAuthorType(@RequestBody AuthorType authorType) {
        authorTypeService.add(authorType);
    }

    @PutMapping("/{id}")
    public void updateAuthorType(@PathVariable("id") AuthorType authorTypeFromDb,
                                 @RequestBody AuthorType authorType) {
        authorTypeFromDb.setType(authorType.getType());
        authorTypeService.update(authorTypeFromDb);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthorType(@PathVariable("id") AuthorType authorType) {
        authorTypeService.delete(authorType);
    }
}
