package ru.rightcode.rightcoderestservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.ResourceType;
import ru.rightcode.rightcoderestservice.service.ResourceTypeService;

@RestController
@RequestMapping("/resource-types")
@Tag(name = "ResourceType Controller", description = "Контроллер типов ресурсов")
@RequiredArgsConstructor
public class ResourceTypeController {

    private final ResourceTypeService resourceTypeService;

    @GetMapping()
    public ResponseEntity<?> getAllResourceTypes() {
        return ResponseEntity.status(HttpStatus.OK).body(resourceTypeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getResourceTypeById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(resourceTypeService.get(id));
    }

    @PostMapping
    public ResponseEntity<?> addResourceType(@RequestBody ResourceType resourceType) {
        return ResponseEntity.status(HttpStatus.CREATED).body(resourceTypeService.add(resourceType));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateResourceType(@PathVariable("id") Integer id,
                                                @RequestBody ResourceType resourceType) {
        ResourceType resourceTypeFromDb = resourceTypeService.get(id);
        resourceTypeFromDb.setName(resourceType.getName());
        return ResponseEntity.status(HttpStatus.OK).body(resourceTypeService.update(resourceTypeFromDb));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResourceType(@PathVariable("id") ResourceType resourceType) {
        resourceTypeService.delete(resourceType);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }
}
