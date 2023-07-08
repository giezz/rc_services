package ru.rightcode.rightcoderestservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.rightcode.rightcoderestservice.model.ExternalResource;
import ru.rightcode.rightcoderestservice.service.ExternalResourceService;

import java.util.List;

@RestController
@RequestMapping("/external-resources")
@Tag(name = "External Resource Controller", description = "Контроллер типов внешних ресурсов")
@RequiredArgsConstructor
public class ExternalResourceController {

    private final ExternalResourceService externalResourceService;

    @GetMapping
    public List<ExternalResource> getAllExternalResources() {
        return externalResourceService.getAll();
    }

    @GetMapping("/{id}")
    public ExternalResource getExternalResourceById(@PathVariable(name = "id") Integer id) {
        return externalResourceService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addExternalResource(@RequestBody ExternalResource externalResource) {
        externalResourceService.add(externalResource);
    }

    @PutMapping("/{id}")
    public void updateExternalResource(@PathVariable("id") ExternalResource externalResourceFromDb,
                                       @RequestBody ExternalResource externalResource) {
        BeanUtils.copyProperties(externalResource, externalResourceFromDb, "id");
        externalResourceService.update(externalResourceFromDb);
    }

    @DeleteMapping("/{id}")
    public void deleteExternalResource(@PathVariable("id") ExternalResource externalResource) {
        externalResourceService.delete(externalResource);
    }
}
