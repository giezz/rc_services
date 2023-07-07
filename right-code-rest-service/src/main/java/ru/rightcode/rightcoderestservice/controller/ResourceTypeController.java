package ru.rightcode.rightcoderestservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.ResourceType;
import ru.rightcode.rightcoderestservice.notfoundexception.ResourceTypeNotFoundException;
import ru.rightcode.rightcoderestservice.repository.ResourceTypeRepository;

import java.util.List;

@RestController
@RequestMapping("/resourceType")
@RequiredArgsConstructor
public class ResourceTypeController {
    private final ResourceTypeRepository repository;

    // ------------------------- GetMapping ResourceType -----------------
    // Get all
    @GetMapping("/all")
    public List<ResourceType> getAllResourceTypes() {
        return repository.findAll();
    }

    // Get one by id
    @GetMapping("/{id}")
    public ResourceType getResourceTypeById(@PathVariable(name="id") Integer id){
        return repository.findById(id).orElseThrow(() -> new ResourceTypeNotFoundException(id));
    }

    // ------------------------- PostMapping ResourceType -----------------
    // PostMapping
    @PostMapping("/add")
    public ResourceType addResourceType(ResourceType resourceType) {
        return repository.save(resourceType);
    }

    // ------------------------- PutMapping ResourceType -----------------
    // TODO: PutMapping


    // ------------------------- DeleteMapping ResourceType -----------------
    // TODO: DeleteMapping
}
