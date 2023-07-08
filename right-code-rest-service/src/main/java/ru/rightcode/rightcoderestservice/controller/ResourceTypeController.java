package ru.rightcode.rightcoderestservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.ResourceType;
import ru.rightcode.rightcoderestservice.service.ResourceTypeService;

import java.util.List;

@RestController
@RequestMapping("/resource-types")
@Tag(name = "ResourceType Controller", description = "Контроллер типов ресурсов")
@RequiredArgsConstructor
public class ResourceTypeController {

    private final ResourceTypeService resourceTypeService;

    @GetMapping()
    public List<ResourceType> getAllResourceTypes() {
        return resourceTypeService.getAll();
    }

    @GetMapping("/{id}")
    public void getResourceTypeById(@PathVariable("id") Integer id) {
        resourceTypeService.get(id);
    }

    @PostMapping
    public void addResourceType(@RequestBody ResourceType resourceType) {
        resourceTypeService.add(resourceType);
    }

    @PutMapping("/{id}")
    public void updateResourceType(@PathVariable("id") ResourceType resourceTypeFromDb,
                                   @RequestBody ResourceType resourceType) {
        resourceTypeFromDb.setName(resourceType.getName());
        resourceTypeService.update(resourceTypeFromDb);
    }

    @DeleteMapping("/{id}")
    public void deleteResourceType(@PathVariable("id") ResourceType resourceType) {
        resourceTypeService.delete(resourceType);
    }
}
