package ru.rightcode.rightcoderestservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.ExternalResource;
import ru.rightcode.rightcoderestservice.service.ExternalResourceService;

@RestController
@RequestMapping("/external-resources")
@Tag(name = "External Resource Controller", description = "Контроллер типов внешних ресурсов")
@RequiredArgsConstructor
public class ExternalResourceController {

    private final ExternalResourceService externalResourceService;

    @GetMapping
    public ResponseEntity<?> getAllExternalResources() {
        return ResponseEntity.status(HttpStatus.OK).body(externalResourceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getExternalResourceById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(externalResourceService.get(id));
    }

    @PostMapping
    public ResponseEntity<?> addExternalResource(@RequestBody ExternalResource externalResource) {
        return ResponseEntity.status(HttpStatus.CREATED).body(externalResourceService.add(externalResource));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExternalResource(@PathVariable("id") Integer id,
                                                    @RequestBody ExternalResource externalResource) {
        ExternalResource externalResourceFromDb = externalResourceService.get(id);
        BeanUtils.copyProperties(externalResource, externalResourceFromDb, "id");
        return ResponseEntity.status(HttpStatus.OK).body(externalResourceService.update(externalResourceFromDb));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExternalResource(@PathVariable("id") ExternalResource externalResource) {
        externalResourceService.delete(externalResource);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }
}
