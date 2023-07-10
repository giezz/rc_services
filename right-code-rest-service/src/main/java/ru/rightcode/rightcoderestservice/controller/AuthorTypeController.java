package ru.rightcode.rightcoderestservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.AuthorType;
import ru.rightcode.rightcoderestservice.service.AuthorTypeService;

@RestController
@RequestMapping("/author-types")
@Tag(name = "AuthorType Controller", description = "Контроллер типов авторов")
@RequiredArgsConstructor
public class AuthorTypeController {

    private final AuthorTypeService authorTypeService;

    @GetMapping
    public ResponseEntity<?> getAllAuthorTypes() {
        return ResponseEntity.status(HttpStatus.OK).body(authorTypeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorTypeById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(authorTypeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> addAuthorType(@RequestBody AuthorType authorType) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorTypeService.add(authorType));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthorType(@PathVariable("id") Integer id,
                                 @RequestBody AuthorType authorType) {
        AuthorType authorTypeFromDb = authorTypeService.getById(id);
        authorTypeFromDb.setType(authorType.getType());
        return ResponseEntity.status(HttpStatus.OK).body(authorTypeService.update(authorTypeFromDb));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthorType(@PathVariable("id") AuthorType authorType) {
        authorTypeService.delete(authorType);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }
}
