package ru.rightcode.rightcoderestservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rightcode.rightcoderestservice.model.ExternalResource;
import ru.rightcode.rightcoderestservice.notfoundexception.ExternalResourceNotFoundException;
import ru.rightcode.rightcoderestservice.repository.ExternalResourceRepository;

import java.util.List;

@RestController("/external-resource")
@RequiredArgsConstructor
public class ExternalResourceController {
    private final ExternalResourceRepository repository;

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

    // PostMapping
    @PostMapping("/add")
    public ExternalResource addExternalResource(ExternalResource externalResource) {
        return repository.save(externalResource);
    }

    // PutMapping

}
