package ru.rightcode.rightcoderestservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rightcode.rightcoderestservice.model.ResourceType;
import ru.rightcode.rightcoderestservice.notfoundexception.ResourceTypeNotFoundException;
import ru.rightcode.rightcoderestservice.repository.ResourceTypeRepository;

import java.util.List;

@RestController("/resourceType")
@RequiredArgsConstructor
public class ResourceTypeController {
    private final ResourceTypeRepository repository;

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

    // PostMapping
    @PostMapping("/add")
    public ResourceType addResourceType(ResourceType resourceType) {
        return repository.save(resourceType);
    }

    // PutMapping
}
