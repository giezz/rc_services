package ru.rightcode.rightcoderestservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.ExternalResource;
import ru.rightcode.rightcoderestservice.notfoundexception.ExternalResourceNotFoundException;
import ru.rightcode.rightcoderestservice.repository.ExternalResourceRepository;

import java.util.List;

@RestController
@RequestMapping("/external-resource")
@RequiredArgsConstructor
public class ExternalResourceController {
    private final ExternalResourceRepository repository;

    // ------------------------- GetMapping ExternalResource -----------------
    // Get all
    @GetMapping("/all")
    public List<ExternalResource> getAllExternalResources() {
        return repository.findAll();
    }

    // Get one by id
    @GetMapping("/{id}")
    public ExternalResource getExternalResourceById(@PathVariable(name="id") Integer id){
        return repository.findById(id).orElseThrow(() -> new ExternalResourceNotFoundException(id));
    }

    // ------------------------- PostMapping ExternalResource -----------------
    // PostMapping
    @PostMapping("/add")
    public ExternalResource addExternalResource(ExternalResource externalResource) {
        return repository.save(externalResource);
    }

    // ------------------------- PutMapping ExternalResource -----------------
    // TODO: PutMapping

    // ------------------------- DeleteMapping ExternalResource -----------------
}
